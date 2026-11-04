package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {

    private final double price;
    private final int discount;

    public DiscountedProduct(UUID id, String name, double price, int discount) {
        super(id, name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0!");
        }
        this.price = price;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки выходит из диапазона 0-100!");
        }
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return price * ((100 - discount) / 100d);
    }

    @Override
    public String toString() {
        return getName() + ": " + price + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
