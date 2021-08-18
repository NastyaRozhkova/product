package com.epam.batrachenko.task8.analyze_sequence_bytes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;

public class FileReaderUtilTest {
    @Before
    public void setUp() throws Exception {
        File file = new File("FileReaderUtilTest.txt");
        file.createNewFile();
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.write(new byte[]{100, 100, 100, 100, 100, 100, 100});
        raf.close();
    }

    @After
    public void tearDown() throws Exception {
        File file = new File("FileReaderUtilTest.txt");
        file.delete();
    }

    @Test
    public void shouldGetFileTextCorrectly() {
        byte[] expected = new byte[]{100, 100, 100, 100, 100, 100, 100};
        byte[] actual = FileReaderUtil.getFileText("FileReaderUtilTest.txt");
        Assert.assertArrayEquals(expected, actual);
    }
}