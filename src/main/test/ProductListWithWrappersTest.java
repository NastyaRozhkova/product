import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task2.List.ProductCopyOnWriteList;
import com.epam.batrachenko.task2.List.ProductListWithWrappers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductListWithWrappersTest {
    @Test
    public void shouldCorrectlyWorkStaticUnmodifiable(){
        ProductListWithWrappers<Product> products=new ProductListWithWrappers<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));
        ProductListWithWrappers<Product> productList = ProductListWithWrappers.unmodifiableList(products);
        Assert.assertThrows(UnsupportedOperationException.class, ()->{productList.add(new Product("test", new BigDecimal("13"), "uk"));});
    }

    @Test
    public void shouldCorrectlyWorkUnmodifiable(){
        ProductListWithWrappers<Product> products=new ProductListWithWrappers<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));
        ProductListWithWrappers<Product> productList = products.unmodifiableList();
        Assert.assertThrows(UnsupportedOperationException.class, ()->productList.add(new Product("test", new BigDecimal("13"), "uk")));
    }

    @Test
    public void shouldCorrectlyCreateUnmodifiableList(){
        ProductListWithWrappers<Product> products=new ProductListWithWrappers<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));
        ProductListWithWrappers<Product> productList = products.unmodifiableList();
        Assert.assertArrayEquals(products.toArray(),productList.toArray());
    }
    @Test
    public void shouldCorrectlyCreateStaticUnmodifiableList(){
        ProductListWithWrappers<Product> products=new ProductListWithWrappers<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));
        ProductListWithWrappers<Product> productList = ProductListWithWrappers.unmodifiableList(products);
        Assert.assertArrayEquals(products.toArray(),productList.toArray());
    }
}
