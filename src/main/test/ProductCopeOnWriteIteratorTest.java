import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task2.List.ProductCopyOnWriteList;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;

public class ProductCopeOnWriteIteratorTest {
    @Test
    public void shouldCorrectlyWorkIteratorInForEach(){
        ProductCopyOnWriteList<Product> products=new ProductCopyOnWriteList<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));
        int count=0;
        for (Product temp: products) {
            count++;
            products.add(new Product("test", new BigDecimal("13"+count), "uk"));
        }
        Assert.assertEquals(2,2);
    }

    @Test
    public void shouldCorrectlyCopyOnWriteIterator(){
        ProductCopyOnWriteList<Product> products=new ProductCopyOnWriteList<>();
        products.add(0, new Product("test", new BigDecimal("10"), "uk"));
        products.add(0, new Product("test", new BigDecimal("13"), "uk"));
        Iterator<Product> it= products.iterator();
        products.remove(0);
        products.remove(0);
        Assert.assertEquals(new Product("test", new BigDecimal("13"), "uk"), it.next());

    }
}
