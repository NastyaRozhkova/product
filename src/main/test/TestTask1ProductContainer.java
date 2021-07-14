import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task1.List.ProductContainer;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;

public class TestTask1ProductContainer {
    @Test
    public void shouldAddToStart() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(0, expected);
        Assert.assertEquals(expected, products.get(0));
    }

    @Test
    public void shouldAddToEnd() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(products.size(), expected);
        Assert.assertEquals(expected, products.get(products.size() - 1));
    }

    @Test
    public void shouldAddToMiddle() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("11"), "uk"));
        products.add(0, new Product("test", new BigDecimal("12"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(1, expected);
        Assert.assertEquals(expected, products.get(1));
    }

    @Test
    public void shouldAddElement() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("12"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        Assert.assertEquals(expected, products.get(3));
        Assert.assertEquals(4, products.size());
    }

    @Test
    public void shouldReturnCorrectlyByIndex() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        Assert.assertEquals(expected, products.get(2));
    }

    @Test
    public void shouldRemoveCorrectlyByIndex() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        products.remove(2);
        Assert.assertEquals(2, products.size());
        Assert.assertNotEquals(expected, products.get(1));
    }

    @Test
    public void shouldRemoveCorrectlyByObject() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        Product expected = new Product("test", new BigDecimal("13"), "uk");
        products.add(expected);
        products.remove(expected);
        Assert.assertEquals(2, products.size());
    }

    @Test
    public void shouldNotRemoveIfNotObject() {
        ProductContainer<Product> products = new ProductContainer<>();
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(new Product("test", new BigDecimal("11"), "uk"));
        products.add(new Product("test", new BigDecimal("13"), "uk"));
        products.remove(new Product("test", new BigDecimal("15"), "uk"));
        Assert.assertEquals(3, products.size());
        Assert.assertFalse(products.remove(new Product("test", new BigDecimal("15"), "uk")));
    }

    @Test
    public void shouldCorrectReturnIterator() {
        ProductContainer<Product> products = new ProductContainer<>();
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(expected);
        products.add(new Product("test", new BigDecimal("13"), "uk"));
        Iterator<Product> it = products.iteratorWithLogic((p) -> p.getPrice().remainder(new BigDecimal("2")).equals(new BigDecimal("1")));
        Product result = it.next();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldCorrectIteratorHasNext() {
        ProductContainer<Product> products = new ProductContainer<>();
        Product expected = new Product("test", new BigDecimal("11"), "uk");
        products.add(new Product("test", new BigDecimal("10"), "uk"));
        products.add(expected);
        products.add(new Product("test", new BigDecimal("13"), "uk"));
        Iterator<Product> it = products.iteratorWithLogic((p) -> p.getPrice().remainder(new BigDecimal("2")).equals(new BigDecimal("1")));
        Product result = it.next();
        Assert.assertTrue(it.hasNext());
        it = products.iteratorWithLogic((p) -> p.getPrice().remainder(new BigDecimal("3")).equals(new BigDecimal("0")));
        Assert.assertFalse(it.hasNext());
    }
}
