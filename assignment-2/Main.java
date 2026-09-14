abstract class FoodOrder {
    private int orderId;
    private String customerName;
    private double amount;

    static String restaurantName = "Food Paradise";
    static int count = 0;

    FoodOrder(int id, String name, double amt) {
        orderId = id;
        customerName = name;
        amount = amt;
        count++;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public abstract double calculateDeliveryCharge();

    static void displayTotalOrders() {
        System.out.println("Total Orders: " + count);
    }
}

interface Discountable {
    double applyDiscount();
}

class RegularOrder extends FoodOrder implements Discountable {
    RegularOrder(int id, String name, double amt) {
        super(id, name, amt);
    }

    public double calculateDeliveryCharge() {
        return 80;
    }

    public double applyDiscount() {
        return getAmount() * 0.10;
    }
}

class PremiumOrder extends FoodOrder implements Discountable {
    PremiumOrder(int id, String name, double amt) {
        super(id, name, amt);
    }

    public double calculateDeliveryCharge() {
        return 50;
    }

    public double applyDiscount() {
        return getAmount() * 0.15;
    }
}

class OrderUtility {
    static void summary(FoodOrder order) {
        double discount = ((Discountable) order).applyDiscount();
        double delivery = order.calculateDeliveryCharge();
        double finalAmount = order.getAmount() - discount + delivery;

        System.out.println("----------------------------");
        System.out.println("Order ID : " + order.getOrderId());
        System.out.println("Customer : " + order.getCustomerName());
        System.out.println("Bill     : Rs." + order.getAmount());
        System.out.println("Discount : Rs." + discount);
        System.out.println("Delivery : Rs." + delivery);
        System.out.println("Payable  : Rs." + finalAmount);
    }
}

public class Main {
    public static void main(String[] args) {

        FoodOrder[] orders = {
                new RegularOrder(101, "Arshita", 500),
                new PremiumOrder(102, "Rahul", 800),
                new RegularOrder(103, "Priya", 600),
                new PremiumOrder(104, "Aman", 900),
                new RegularOrder(105, "Neha", 700),
                new PremiumOrder(106, "Riya", 1000)
        };

        System.out.println("Restaurant: " + FoodOrder.restaurantName);

        for (FoodOrder o : orders) {
            OrderUtility.summary(o);
        }

        FoodOrder.displayTotalOrders();
    }
}