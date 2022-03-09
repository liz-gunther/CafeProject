package com.perscholas.cafe2;

public class Espresso extends Product {
    boolean espressoShot;
    boolean macchiato;

    public Espresso() {
        super();
        this.espressoShot = false;
        this.macchiato = false;
    }
    //add $2 for every espresso shot and $1 for macchiato style
    //actual price = price from product class
    //if it has an espresso shot, actual price = actual price + 2
    //if it has macchiato, actual price = actual price + 1
    //product total = actual price * quantity
    @Override
    public double calculateProductTotal() {
        double actualPrice = this.getPrice();
        if (espressoShot) {
            actualPrice += 2;
        }
        if (macchiato) {
            actualPrice += 1;
        }
        return actualPrice * getQuantity();
    }

    public Espresso(String name, double price, String description, boolean espressoShot, boolean macchiato) {
        super(name, price, description);
        this.espressoShot = espressoShot;
        this.macchiato = macchiato;
    }

    public void setEspressoShot(boolean espressoShot) {
        this.espressoShot = espressoShot;
    }

    public void setMacchiato(boolean macchiato) {
        this.macchiato = macchiato;
    }

}
