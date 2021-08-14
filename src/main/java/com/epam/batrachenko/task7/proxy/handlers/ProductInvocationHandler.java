package com.epam.batrachenko.task7.proxy.handlers;

import com.epam.batrachenko.task7.proxy.factory.products.UnmodifiableProduct;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProductInvocationHandler implements InvocationHandler {
    private UnmodifiableProduct unmodifiableProduct;

    public ProductInvocationHandler(UnmodifiableProduct unmodifiableProduct) {
        this.unmodifiableProduct = unmodifiableProduct;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("set")){
            throw new UnsupportedOperationException();
        } else{
            return method.invoke(unmodifiableProduct,args);
        }
    }
}
