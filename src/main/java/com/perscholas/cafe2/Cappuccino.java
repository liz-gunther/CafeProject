package com.perscholas.cafe2;

public class Cappuccino extends Product {
    boolean peppermint;
    boolean whippedCream;

    public Cappuccino() {
        super();
        this.peppermint = false;
        this.whippedCream = false;
    }
    public Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream) {
        super(name, price, description);
        this.peppermint = peppermint;
        this.whippedCream = whippedCream;
    }
    //add $2 for peppermint and $1 for whipped cream
    //actual price = price from product class
    //if it has peppermint, actual price = actual price + 2
    //if it has whipped cream, actual price = actual price + 1
    //product total = actual price * quantity
    @Override
    public double calculateProductTotal() {
        double actualPrice = this.getPrice();
        if (peppermint) {
            actualPrice += 2;
        }
        if (this.whippedCream) {
            actualPrice += 1;
        }
        double productTotal = actualPrice * getQuantity();
        return productTotal;
    }

    public boolean isPeppermint() {
        return peppermint;
    }

    public void setPeppermint(boolean peppermint) {
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream() {
        return this.whippedCream;
    }

    public void setWhippedCream(boolean whippedCream) {
        this.whippedCream = whippedCream;
    }

}
