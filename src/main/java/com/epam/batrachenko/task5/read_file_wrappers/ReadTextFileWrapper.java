package com.epam.batrachenko.task5.read_file_wrappers;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Wrapper for read text from file.
 * Implements iterable for using in for each and closeable to close file.
 *
 * @author Vladyslav Batrachenko
 * @see RandomAccessFile
 */
public class ReadTextFileWrapper implements Iterable<String>, Closeable {
    private RandomAccessFile sc;
    private static final Logger log = LoggerFactory.getLogger(ReadTextFileWrapper.class);

    public ReadTextFileWrapper(String fileName) {
        try {
            sc = new RandomAccessFile(new File(fileName), "r");
        } catch (FileNotFoundException e) {
            log.error("File with this name was not found!", e);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new FileIterator();
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }

    private class FileIterator implements Iterator<String> {
        private String line;

        public FileIterator() {
            try {
                line = sc.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            return line != null;
        }

        @Override
        public String next() {
            if (hasNext()) {
                String temp = line;
                try {
                    line = sc.readLine();
                } catch (IOException e) {
                    log.error("Line not found", e);
                }
                return temp;
            }
            throw new NoSuchElementException();
        }
    }
}
