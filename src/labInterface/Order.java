package labInterface;

public class Order {
    private String item;
    private int quantity;
    private double unitPrice;
    private double totalAmount;

    public Order(String item, int quantity, double unitPrice) {
        this.item = item;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalAmount = 0;
    }
    public void processPayment(PaymentMode paymentMethod) {
        double subtotal = quantity * unitPrice;
        double discount = subtotal * paymentMethod.determineDiscountRate();
        totalAmount = subtotal - discount;

        System.out.println("\nPayment order details if " + paymentMethod.getClass().getSimpleName());
        System.out.println("Discount rate is " + (paymentMethod.determineDiscountRate() * 100) + "%");
        System.out.println("Payment amount is " + totalAmount);
    }

    public void displayOrderDetails() {
        System.out.println("\nOrder item is " + item + ".");
        System.out.println("Unit price is " + unitPrice);
        System.out.println("Quantity is " + quantity + "\n");
    }
}
