package com.perscholas.cafe2;

public class Coffee extends Product {
    boolean sugar;
    boolean milk;

    public Coffee() {
        super();
        this.sugar = false;
        this.milk = false;
    }

    @Override
    public double calculateProductTotal() {
        return this.getPrice() * this.getQuantity();
    }

    public Coffee(String name, double price, String description, boolean sugar, boolean milk) {
        super(name, price, description);
        this.sugar = sugar;
        this.milk = milk;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

}
