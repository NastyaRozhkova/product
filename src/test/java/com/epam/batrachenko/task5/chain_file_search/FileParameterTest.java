package com.epam.batrachenko.task5.chain_file_search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileParameterTest {
    private List<File> files = new ArrayList<>();

    @Before
    public void createDirectoryWithTestFiles() throws IOException, ParseException {
        File directory = new File("testDirectory");
        if (directory.mkdir()) {
            File file = new File("testDirectory/a.txt");
            file.createNewFile();
            files.add(file);

            file = new File("testDirectory/b.txt");
            file.createNewFile();
            files.add(file);

            file = new File("testDirectory/a.exe");
            file.createNewFile();
            files.add(file);

            file = new File("testDirectory/b.exe");
            file.createNewFile();
            files.add(file);

            file = new File("testDirectory/c.asap");
            file.createNewFile();
            files.add(file);

            file = new File("testDirectory/e.asa");
            file.createNewFile();
            files.add(file);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            file = new File("testDirectory/c.asa");
            file.createNewFile();
            file.setLastModified(dateFormat.parse("05-05-2020").getTime());
            files.add(file);

            file = new File("testDirectory/d.asa");
            file.createNewFile();
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.write("hello it is simple text to test this method to find by size".getBytes(StandardCharsets.UTF_8));
            files.add(file);
            raf.close();
        }
    }

    @After
    public void deleteDirectoryWithTestFiles() {
        for (File file : files) {
            file.delete();
        }
        File directory = new File("testDirectory");
        directory.delete();
    }

    @Test
    public void shouldCorrectlyFilterByName() {
        FileNameConstraint constraint = new FileNameConstraint("a.");

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/a.txt"), new File("testDirectory/a.exe")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyFilterByExtension() {
        FileExtensionConstraint constraint = new FileExtensionConstraint("exe");

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/a.exe"), new File("testDirectory/b.exe")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyFilterBySize() {
        FileSizeConstraint constraint = new FileSizeConstraint(20, 100);

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/d.asa")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyFilterByDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        FileDateConstraint constraint = new FileDateConstraint(dateFormat.parse("04-05-2020"), dateFormat.parse("06-05-2020"));

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/c.asa")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyChainFilter() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        FileSearch fileSearch = new FileSearch();

        fileSearch.add(new FileNameConstraint("c."));
        fileSearch.add(new FileExtensionConstraint("asa"));
        fileSearch.add(new FileSizeConstraint(0, 10));
        fileSearch.add(new FileDateConstraint(dateFormat.parse("04-05-2020"), dateFormat.parse("06-05-2020")));

        List<File> actualFiles = fileSearch.search("testDirectory");
        File[] expected = new File[]{new File("testDirectory/c.asa")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }
}