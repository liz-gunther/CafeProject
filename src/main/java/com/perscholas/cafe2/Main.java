package com.perscholas.cafe2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product coffee = new Coffee("Coffee", 1.99, "House Drip Coffee", false, false);
        Product espresso = new Espresso("Espresso", 2.49, "Double Shot of Espresso", false, false);
        Product cappuccino = new Cappuccino("Cappuccino", 2.99, "Espresso w/ Steamed Milk", false, false);

        double subtotal = takeCustomerOrder(coffee, espresso, cappuccino);
        printTotalSales(subtotal);
    }
//refactor -- consider moving each section to corresponding class

    private static double takeCustomerOrder(Product coffee, Product espresso, Product cappuccino) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many plain coffees would you like to order? --> ");
        coffee.setQuantity(scanner.nextInt());
        System.out.println("Would you like to add milk? (type yes or no) ->: ");
        if (scanner.next().equals("yes")) {((Coffee) coffee).setMilk(true);}
        System.out.println("Would you like to add sugar? (type yes or no) ->: ");
        if (scanner.next().equals("yes")) { ((Coffee) coffee).setSugar(true); }
        double subtotal = getDescriptionTotal(coffee);

        System.out.println("How many espressos would you like to order? --> ");
        espresso.setQuantity(scanner.nextInt());
        System.out.println("Would you like to add an extra espresso shot? (type yes or no) ->: ");
        if (scanner.next().equals("yes")) { ((Espresso) espresso).setEspressoShot(true); }
        System.out.println("Would you like to make it a macchiato? (type yes or no) ->: ");
        if (scanner.next().equals("yes")) { ((Espresso) espresso).setMacchiato(true); }
        subtotal += getDescriptionTotal(espresso);

        System.out.println("How many cappuccinos would you like to order? --> ");
        cappuccino.setQuantity(scanner.nextInt());
        System.out.println("Would you like to add peppermint? (type yes or no) ->: ");
        if (scanner.next().equals("yes")) { ((Cappuccino) cappuccino).setPeppermint(true); }
        System.out.println("Would you like to add whipped cream? (type yes or no) ->: ");
        if (scanner.next().equals("yes")) { ((Cappuccino) cappuccino).setWhippedCream(true); }
        subtotal += getDescriptionTotal(cappuccino);
        scanner.close();
        return subtotal;
    }

    private static void printTotalSales(double subtotal) {
        System.out.println("Sales subtotal: $" + subtotal);
        System.out.printf("\nSales tax: $%.2f", subtotal * 0.08);
        System.out.printf("\nTotal price with tax: $%.2f", (subtotal + (subtotal * 0.08)));
    }
//maybe move to product class
    private static double getDescriptionTotal(Product coffeeType) {
        System.out.printf("%s: %s\n", coffeeType.getName(), coffeeType.getDescription());
        System.out.printf("Subtotal: $%.2f\n", coffeeType.calculateProductTotal());

        return coffeeType.calculateProductTotal();
    }

}
