import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | ₹" + price;
    }
}

public class day12 {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Pre-added products
        products.add(new Product(1, "Phone", 12000));
        products.add(new Product(2, "Laptop", 45000));
        products.add(new Product(3, "Headphones", 1500));
        products.add(new Product(4, "Keyboard", 800));

        int choice;

        do {
            System.out.println("\n===== Mini E-Commerce System =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addToCart();
                case 3 -> viewCart();
                case 4 -> checkout();
                case 5 -> System.out.println("Thank you for shopping!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void viewProducts() {
        System.out.println("\nID | Name | Price");
        System.out.println("--------------------");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    static void addToCart() {
        System.out.print("Enter Product ID to add: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.id == id) {
                cart.add(p);
                System.out.println("Added to cart!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void viewCart() {
        System.out.println("\n--- Your Cart ---");
        double total = 0;

        for (Product p : cart) {
            System.out.println(p);
            total += p.price;
        }

        System.out.println("Total: ₹" + total);
    }

    static void checkout() {
        double total = 0;
        for (Product p : cart) {
            total += p.price;
        }

        System.out.println("\nTotal Bill: ₹" + total);
        System.out.println("Order placed successfully!");
        cart.clear();
    }
}
