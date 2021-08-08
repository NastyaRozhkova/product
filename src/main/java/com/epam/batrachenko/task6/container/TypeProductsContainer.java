package com.epam.batrachenko.task6.container;

import com.epam.batrachenko.task6.factory.*;

import java.util.HashMap;
import java.util.Map;

public class TypeProductsContainer {
    private Map<String, ProductCreate> typeProducts = new HashMap();

    public TypeProductsContainer() {
        this.typeProducts.put("Product", new ProductCreate());
        this.typeProducts.put("Accessories", new AccessoriesCreate());
        this.typeProducts.put("ComputerPart", new ComputerPartCreate());
        this.typeProducts.put("GraphicsCard", new GraphicsCardCreate());
    }

    public ProductCreate getTypeProducts(String line) {
        return (ProductCreate) this.typeProducts.get(line.split("\\{")[0]);
    }
}

