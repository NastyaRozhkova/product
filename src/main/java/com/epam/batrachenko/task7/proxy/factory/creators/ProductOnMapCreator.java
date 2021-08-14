package com.epam.batrachenko.task7.proxy.factory.creators;

import com.epam.batrachenko.task7.proxy.factory.products.ProductMethods;
import com.epam.batrachenko.task7.proxy.factory.products.ProductOnMap;

public class ProductOnMapCreator implements ProductProxyCreator {
    @Override
    public ProductMethods createProxyProduct() {
        return new ProductOnMap();
    }
}
