package com.epam.batrachenko.task5.read_file_wrappers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFileWrapperTest {
    private static final String[] testLines = new String[]{
            "hello",
            "it is test",
            "there are four lines",
            "it is last line"};

    @Before
    public void createInputFile() throws IOException {
        File file =new File("input.txt");
        file.createNewFile();
        try (RandomAccessFile rf = new RandomAccessFile(file, "rw")) {
            for (String temp : testLines) {
                rf.write((temp + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    @After
    public void deleteInputFile() {
        File file =new File("input.txt");
        file.delete();
    }

    @Test
    public void shouldCorrectlyWorkIterator() throws IOException {
        ReadTextFileWrapper file = new ReadTextFileWrapper("input.txt");

        List<String> lines = new ArrayList<>();
        for (String line : file) {
            lines.add(line);
        }

        file.close();

        Assert.assertArrayEquals(testLines, lines.toArray());
    }
}