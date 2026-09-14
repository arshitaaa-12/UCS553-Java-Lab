import java.util.ArrayList;
import java.util.Scanner;

// Parent Exception
class ApplicationException extends Exception {
    ApplicationException(String message) {
        super(message);
    }
}

// Product Exception
class ProductException extends ApplicationException {
    ProductException(String message) {
        super(message);
    }
}

// Product Not Found Exception
class ProductNotFoundException extends ProductException {
    ProductNotFoundException(String message) {
        super(message);
    }
}

// Out Of Stock Exception
class OutOfStockException extends ProductException {
    OutOfStockException(String message) {
        super(message);
    }
}

// Payment Exception
class PaymentException extends ApplicationException {
    PaymentException(String message) {
        super(message);
    }
}

// Invalid Payment Exception
class InvalidPaymentException extends PaymentException {
    InvalidPaymentException(String message) {
        super(message);
    }
}

// Insufficient Funds Exception
class InsufficientFundsException extends PaymentException {
    InsufficientFundsException(String message) {
        super(message);
    }
}

// Order Exception
class OrderException extends ApplicationException {
    OrderException(String message) {
        super(message);
    }
}

// Empty Cart Exception
class EmptyCartException extends OrderException {
    EmptyCartException(String message) {
        super(message);
    }
}


// Main Shopping Cart Class
public class ques7 {

    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Integer> prices = new ArrayList<>();
    static ArrayList<Integer> stock = new ArrayList<>();

    static ArrayList<String> cart = new ArrayList<>();

    static double funds = 5000;

    // Search product
    static void searchProduct(String name)
            throws ProductNotFoundException {

        boolean found = false;

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).equalsIgnoreCase(name)) {

                System.out.println("Product found!");
                System.out.println("Product: " + products.get(i));
                System.out.println("Price: " + prices.get(i));
                System.out.println("Stock: " + stock.get(i));

                found = true;
                break;
            }
        }

        if (!found) {
            throw new ProductNotFoundException(
                "Product '" + name + "' not found"
            );
        }
    }


    // Add product to cart
    static void addProduct(String name)
            throws ProductNotFoundException,
                   OutOfStockException {

        boolean found = false;

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).equalsIgnoreCase(name)) {

                found = true;

                if (stock.get(i) <= 0) {
                    throw new OutOfStockException(
                        "Product '" + name + "' is out of stock"
                    );
                }

                cart.add(products.get(i));
                stock.set(i, stock.get(i) - 1);

                System.out.println(
                    name + " added to cart"
                );

                break;
            }
        }

        if (!found) {
            throw new ProductNotFoundException(
                "Product '" + name + "' not found"
            );
        }
    }


    // Remove product from cart
    static void removeProduct(String name)
            throws ProductNotFoundException {

        boolean removed = false;

        for (int i = 0; i < cart.size(); i++) {

            if (cart.get(i).equalsIgnoreCase(name)) {

                cart.remove(i);
                removed = true;

                // Return product to stock
                for (int j = 0; j < products.size(); j++) {

                    if (products.get(j).equalsIgnoreCase(name)) {
                        stock.set(j, stock.get(j) + 1);
                        break;
                    }
                }

                System.out.println(
                    name + " removed from cart"
                );

                break;
            }
        }

        if (!removed) {
            throw new ProductNotFoundException(
                "Product is not present in cart"
            );
        }
    }


    // Display cart
    static void displayCart() {

        if (cart.size() == 0) {
            System.out.println("Cart is empty");
            return;
        }

        System.out.println("\nProducts in cart:");

        double total = 0;

        for (int i = 0; i < cart.size(); i++) {

            String name = cart.get(i);

            for (int j = 0; j < products.size(); j++) {

                if (products.get(j).equalsIgnoreCase(name)) {

                    System.out.println(
                        (i + 1) + ". " +
                        products.get(j) +
                        " - Rs." +
                        prices.get(j)
                    );

                    total = total + prices.get(j);

                    break;
                }
            }
        }

        System.out.println("Total = Rs." + total);
    }


    // Calculate total
    static double calculateTotal() {

        double total = 0;

        for (int i = 0; i < cart.size(); i++) {

            String name = cart.get(i);

            for (int j = 0; j < products.size(); j++) {

                if (products.get(j).equalsIgnoreCase(name)) {
                    total = total + prices.get(j);
                    break;
                }
            }
        }

        return total;
    }


    // Payment
    static void payment(String paymentMethod)
            throws InvalidPaymentException,
                   InsufficientFundsException {

        if (cart.size() == 0) {
            return;
        }

        if (!paymentMethod.equalsIgnoreCase("card") &&
            !paymentMethod.equalsIgnoreCase("cash")) {

            throw new InvalidPaymentException(
                "Invalid payment method"
            );
        }

        double total = calculateTotal();

        if (total > funds) {

            throw new InsufficientFundsException(
                "Insufficient funds"
            );
        }

        funds = funds - total;

        System.out.println(
            "Payment successful: Rs." + total
        );
    }


    // Place order
    static void placeOrder(String paymentMethod)
            throws EmptyCartException,
                   InvalidPaymentException,
                   InsufficientFundsException {

        if (cart.size() == 0) {

            throw new EmptyCartException(
                "Cannot place order because cart is empty"
            );
        }

        payment(paymentMethod);

        System.out.println(
            "Order placed successfully!"
        );

        cart.clear();
    }


    // Main
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Product database
        products.add("Laptop");
        prices.add(50000);
        stock.add(2);

        products.add("Mouse");
        prices.add(500);
        stock.add(5);

        products.add("Keyboard");
        prices.add(1000);
        stock.add(3);

        products.add("Headphones");
        prices.add(2000);
        stock.add(0);


        int choice = 0;

        while (choice != 7) {

            System.out.println("\n===== SHOPPING CART =====");
            System.out.println("1. Search Product");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Check Funds");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {

                if (choice == 1) {

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    searchProduct(name);
                }

                else if (choice == 2) {

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    addProduct(name);
                }

                else if (choice == 3) {

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    removeProduct(name);
                }

                else if (choice == 4) {

                    displayCart();
                }

                else if (choice == 5) {

                    System.out.print(
                        "Enter payment method (card/cash): "
                    );

                    String method = sc.nextLine();

                    placeOrder(method);
                }

                else if (choice == 6) {

                    System.out.println(
                        "Available funds = Rs." + funds
                    );
                }

                else if (choice == 7) {

                    System.out.println("Exiting...");
                }

                else {

                    System.out.println("Invalid choice");
                }

            }

            // Product exception handler
            catch (ProductException e) {

                System.out.println(
                    "Product Error: " + e.getMessage()
                );
            }

            // Payment exception handler
            catch (PaymentException e) {

                System.out.println(
                    "Payment Error: " + e.getMessage()
                );
            }

            // Order exception handler
            catch (OrderException e) {

                System.out.println(
                    "Order Error: " + e.getMessage()
                );
            }

            // General application exception
            catch (ApplicationException e) {

                System.out.println(
                    "Application Error: " + e.getMessage()
                );
            }
        }

        sc.close();
    }
}