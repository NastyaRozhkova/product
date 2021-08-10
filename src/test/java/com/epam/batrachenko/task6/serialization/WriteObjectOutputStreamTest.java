package com.epam.batrachenko.task6.serialization;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task6.AddingProductsToCatalog;
import com.epam.batrachenko.task6.fill_product_strategy.random.GenerateProductDataStrategy;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class WriteObjectOutputStreamTest {
    private static final Logger log = LoggerFactory.getLogger(AddingProductsToCatalog.class);
    private static final int COUNT = 10000;

    @Test
    public void writeSerializationInGZipFormat() {
        List<Product> products = (new GenerateProductDataStrategy()).fill(COUNT);
        compressGzipFile(products, "serializationGZip.txt");
    }

    @Test
    public void writeSerialization() throws IOException {
        List<Product> products = (new GenerateProductDataStrategy()).fill(COUNT);
        File file = new File("serialization.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        for (Product product : products) {
            out.writeObject(product);
        }
        out.close();
    }

    private static void compressGzipFile(List<Product> products, String gzipFile) {
        try {
            FileOutputStream fos = new FileOutputStream(gzipFile);
            GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
            for (Product product : products) {
                gzipOS.write(product.toString().getBytes(StandardCharsets.UTF_8));
            }
            gzipOS.close();
            fos.close();
        } catch (IOException e) {
            log.error(e.toString(), e);
        }

    }
}
