package com.epam.batrachenko.task2.List;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class UnmodifiableModifiableProductListTest {

    @Test
    public void shouldNotAddToStart() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        Assert.assertThrows(UnsupportedOperationException.class, () -> products.add(0, new Product("test", new BigDecimal("14"), "uk")));
    }

    @Test
    public void shouldAddToEnd() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        products.add(new Product("test", new BigDecimal("14"), "uk"));

        Assert.assertEquals(new Product("test", new BigDecimal("14"), "uk"), products.get(4));
    }

    @Test
    public void shouldNotAddToMiddleUnmodifiableList() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        Assert.assertThrows(UnsupportedOperationException.class, () -> products.add(1, new Product("test", new BigDecimal("14"), "uk")));
    }

    @Test
    public void shouldAddToStartModifiableList() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        products.add(2, new Product("test", new BigDecimal("14"), "uk"));

        Assert.assertEquals(new Product("test", new BigDecimal("14"), "uk"), products.get(2));
    }

    @Test
    public void shouldNotRemoveFirst() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        Assert.assertThrows(UnsupportedOperationException.class, () -> products.remove(0));
    }

    @Test
    public void shouldRemoveLastInModifiablePart() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        products.remove(products.size() - 1);

        Assert.assertEquals(3, products.size());
    }

    @Test
    public void shouldReturnCorrectlyByIndex() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        Assert.assertEquals(new Product("test", new BigDecimal("11"), "uk"), products.get(1));
        Assert.assertEquals(new Product("test", new BigDecimal("12"), "uk"), products.get(2));
    }

    @Test
    public void shouldRemoveCorrectlyByObject() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        products.remove(new Product("test", new BigDecimal("12"), "uk"));

        Assert.assertEquals(3, products.size());
    }

    @Test
    public void shouldNotRemoveInUnmodifiableList() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        Assert.assertThrows(UnsupportedOperationException.class, () -> products.remove(new Product("test", new BigDecimal("11"), "uk")));
    }

    @Test
    public void shouldCorrectlyContains() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        Assert.assertTrue(products.contains(new Product("test", new BigDecimal("12"), "uk")));
        Assert.assertTrue(products.contains(new Product("test", new BigDecimal("11"), "uk")));
        Assert.assertFalse(products.contains(new Product("test", new BigDecimal("15"), "uk")));
    }

    @Test
    public void shouldCorrectlyClear() {
        ProductArrayList<Product> unmodifiableProducts = new ProductArrayList<>();

        unmodifiableProducts.add(new Product("test", new BigDecimal("10"), "uk"));
        unmodifiableProducts.add(new Product("test", new BigDecimal("11"), "uk"));

        ProductArrayList<Product> modifiableProducts = new ProductArrayList<>();

        modifiableProducts.add(new Product("test", new BigDecimal("12"), "uk"));
        modifiableProducts.add(new Product("test", new BigDecimal("13"), "uk"));

        UnmodifiableModifiableProductList<Product> products = new UnmodifiableModifiableProductList<>(unmodifiableProducts, modifiableProducts);

        products.clear();

        Assert.assertEquals(2, products.size());
        Assert.assertArrayEquals(unmodifiableProducts.toArray(), products.toArray());
    }
}