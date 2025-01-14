package lt.techin.store.model;


import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private Store store;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        System.out.print("Enter store line: ");
        String line = scanner.nextLine();
        System.out.print("Enter store city: ");
        String city = scanner.nextLine();
        this.store = new Store(line,city);
    }

    public void start() {
        boolean active = true;
        while (active) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> active = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nStore Management System");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int getValidProductType() {
        while (true) {
            System.out.println("\nSelect product type:");
            System.out.println("1. Beer");
            System.out.println("2. Wine");
            System.out.println("3. Shrek");
            System.out.println("4. Back to main menu");

            int type = getChoice();
            if (type == 1 || type == 2 || type == 3 || type == 4) {
                return type;
            }
            System.out.println("Invalid choice! Please select 1, 2, 3 or 4");
        }
    }
    private void addProduct() {
        int type = getValidProductType();
        if (type == 4) {
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter volume (%): ");
        double volume = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter amount (L): ");
        double amount = Double.parseDouble(scanner.nextLine());

        try {
            Product product = switch (type) {
                case 1 -> new Beer(name, price, volume, amount);
                case 2 -> new Wine(name, price, volume, amount);
                case 3 -> new Shrek(name, price, volume, amount);
                default -> throw new IllegalArgumentException("Invalid product type");
            };
            store.addProduct(product);
            System.out.println("Product added successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewProducts() {
        if (store.getProducts().isEmpty()) {
            System.out.println("\nNo products in store");
            return;
        }

        System.out.println("\nStore Products:");
        System.out.println(store);
    }
}
