package com.epam.batrachenko.task7.proxy.factory.creators;

import com.epam.batrachenko.task7.proxy.factory.products.ProductMethods;
import com.epam.batrachenko.task7.proxy.factory.products.ProxiedProduct;
import com.epam.batrachenko.task7.proxy.handlers.ProductInvocationHandler;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class UnmodifiableProductCreator implements ProductProxyCreator {
    @Override
    public ProductMethods createProxyProduct() {
        ProxiedProduct product = new ProxiedProduct("test1", new BigDecimal("1"), "test1");
        return (ProductMethods) Proxy.newProxyInstance(
                ProxiedProduct.class.getClassLoader(),
                ProxiedProduct.class.getInterfaces(),
                new ProductInvocationHandler(product));
    }
}
