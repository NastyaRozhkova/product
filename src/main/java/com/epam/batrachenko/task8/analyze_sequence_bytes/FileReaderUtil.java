package com.epam.batrachenko.task8.analyze_sequence_bytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileReaderUtil {
    public static byte[] getFileText(String fileName) {
        byte[] fileText = new byte[0];
        File file = new File(fileName);
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            fileText = new byte[(int) raf.length()];
            raf.readFully(fileText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileText;
    }
}
