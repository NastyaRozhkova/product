package com.epam.batrachenko.task7.proxy.factory.creators;

import com.epam.batrachenko.task7.proxy.factory.products.ProductMethods;
import com.epam.batrachenko.task7.proxy.factory.products.UnmodifiableProduct;
import com.epam.batrachenko.task7.proxy.handlers.ProductInvocationHandler;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class UnmodifiableProductCreator implements ProductProxyCreator {
    @Override
    public ProductMethods createProxyProduct() {
        UnmodifiableProduct product = new UnmodifiableProduct("test1", new BigDecimal("1"), "test1");
        return (ProductMethods) Proxy.newProxyInstance(
                UnmodifiableProduct.class.getClassLoader(),
                UnmodifiableProduct.class.getInterfaces(),
                new ProductInvocationHandler(product));
    }
}
