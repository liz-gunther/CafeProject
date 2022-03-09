package com.perscholas.cafe1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product coffee = new Product("Coffee", 1.99, "House Drip Coffee");
        Product espresso = new Product("Espresso", 2.49, "Double Shot of Espresso");
        Product cappuccino = new Product("Cappuccino", 2.99, "Espresso w/ Steamed Milk");

        double subtotal = takeCustomerOrder(coffee, espresso, cappuccino);
        printTotalSales(subtotal);
    }

    private static double takeCustomerOrder(Product coffee, Product espresso, Product cappuccino) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many plain coffees would you like to order? --> ");
        coffee.setQuantity(scanner.nextInt());
        double subtotal = getDescriptionTotal(coffee);
        System.out.println("How many espressos would you like to order? --> ");
        espresso.setQuantity(scanner.nextInt());
        subtotal += getDescriptionTotal(espresso);
        System.out.println("How many cappuccinos would you like to order? --> ");
        cappuccino.setQuantity(scanner.nextInt());
        subtotal += getDescriptionTotal(cappuccino);
        scanner.close();
        return subtotal;
    }

    private static void printTotalSales(double subtotal) {
        System.out.println("Sales subtotal: $" + subtotal);
        System.out.printf("\nSales tax: $%.2f", subtotal * 0.08);
        System.out.printf("\nTotal price with tax: $%.2f", (subtotal + (subtotal * 0.08)));
    }

    private static double getDescriptionTotal(Product coffeeType) {
        System.out.printf("%s: %s\nSubtotal: $%.2f\n", coffeeType.getName(), coffeeType.getDescription(), coffeeType.calculateProductTotal());
        return coffeeType.calculateProductTotal();
    }

}
