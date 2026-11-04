package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final double PRICE = 55;

    public FixPriceProduct(UUID id, String name) {
        super(id, name);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
