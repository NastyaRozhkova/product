package com.epam.batrachenko.task5.chain;

import com.epam.batrachenko.task5.searching_files.FileFilterByParameters;
import com.epam.batrachenko.task5.util.Parameter;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        FileNameFilter constraint = new FileNameFilter("a.");

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/a.txt"), new File("testDirectory/a.exe")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyFilterByExtension() {
        FileExtensionFilter constraint = new FileExtensionFilter("exe");

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/a.exe"), new File("testDirectory/b.exe")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyFilterBySize() {
        FileSizeFilter constraint = new FileSizeFilter(20, 100);

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/d.asa")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyFilterByDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        FileDateFilter constraint = new FileDateFilter(dateFormat.parse("04-05-2020"), dateFormat.parse("06-05-2020"));

        List<File> actualFiles = constraint.handle(files);
        File[] expected = new File[]{new File("testDirectory/c.asa")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }

    @Test
    public void shouldCorrectlyChainFilter() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Map<Parameter, String> parameters = new LinkedHashMap<>();

        parameters.put(Parameter.NAME, "c.");
        parameters.put(Parameter.EXTENSION, "asa");
        parameters.put(Parameter.SIZE, "0/10");
        parameters.put(Parameter.DATE, "04-05-2020/06-05-2020");

        FileFilterByParameters fileFilterByParameters = new FileFilterByParameters();
        fileFilterByParameters.addParameters(parameters);
        List<File> actualFiles = fileFilterByParameters.search("testDirectory");
        File[] expected = new File[]{new File("testDirectory/c.asa")};

        Assert.assertArrayEquals(expected, actualFiles.toArray());
    }
}