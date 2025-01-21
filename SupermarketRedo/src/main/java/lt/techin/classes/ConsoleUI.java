package lt.techin.classes;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleUI {
    private SupermarketServiceImplementation ssi;
    private Scanner scan;

    public ConsoleUI() {
        ProductStorage ps = new ProductStorage();
        CashRegister cr = new CashRegister();
        this.ssi = new SupermarketServiceImplementation(ps,cr);
        this.scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\nWelcome to the Supermarket.");
        menu();

    }

    public void menu() {
        boolean stop = false;
        while (!stop) {
            System.out.println("\nPlease choose an option:\n 1.View Available Products \n 2.View Available Change" +
                    "\n 3.Select Product \n 4.Quit");
         try  {
                int choice = Integer.parseInt(scan.nextLine().trim());
                switch (choice) {
                    case 1 -> ssi.getProducts();
                    case 2 -> ssi.getCashRegisterValues();
                    case 3 -> {
                        productMenu();
                    }
                    case 4 -> {
                        stop = true;
                        System.out.println("\nThank you for your patronage!\n");
                        break;
                    }
                    default -> System.out.println("Invalid number, please try again");
                }
        } catch (NumberFormatException e) {
             System.out.println("Please enter a number");
         }
    }
    }

    public void productMenu() {
        System.out.print("Type in the product you wish to purchase: ");
      try  {
            String name = scan.nextLine().trim().toUpperCase();
            ssi.selectProduct(name);
            String capName = Arrays.stream(name.split(" "))
                    .filter(x -> !x.isEmpty())
                    .map(x -> {
                        String fL = x.substring(0, 1).toUpperCase();
                        String rest = x.substring(1).toLowerCase();
                        return fL + rest;
                    })
                    .collect(Collectors.joining(""));

            System.out.println("\nYou have selected " + capName + ". The price of the desired product is " + String.format("%.2f", ssi.getSelectedProduct().getPrice()) + "£.");
            transactionMenu();
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
      }
    }

    public void transactionMenu() {
        boolean stop = false;


        while (!stop) {
            System.out.println("\nPick an option:\n 1.Add Payment \n 2.Complete Transaction" +
            "\n 3.Cancel Transaction");
          try  {
                int input = Integer.parseInt(scan.nextLine().trim());
                switch (input) {
                    case 1 -> payment();
                    case 2 -> {
                        try{
                            ssi.completeTransaction();
                            System.out.println("Transaction Successful");
                            stop = true;
                            break;
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        ssi.cancelTransaction();
                        System.out.println("\n Transaction Cancelled\n");
                        stop = true;
                        break;
                    }
                    default -> System.out.println("Invalid selection");
                }
            } catch (NumberFormatException e) {
              System.out.println("Enter a valid number");
          }
        }

    }
    public void payment() {
        System.out.println("Select amount: \n 1. 0.10£ \n 2. 0.50£" +
                "\n 3. 1.00£ \n 4. 2.00£");
        int input = Integer.parseInt(scan.nextLine().trim());
        double amount = 0;
        switch (input) {
            case 1 -> amount = 0.10;
            case 2 -> amount = 0.50;
            case 3 -> amount = 1.00;
            case 4 -> amount = 2.00;
            default -> System.out.println("Invalid selection");
        }
        try {
            ssi.addPayment(amount);
            System.out.printf("Added %.2f£\n", amount);
            System.out.printf("Remaining Payment: %.2f£\n", ssi.getRemainingPayment());
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
