package labInterface;

import java.util.Scanner;

public  class PaymentApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("   ✨ Welcome to JM Merchandise! ✨   ");
        System.out.println("======================================");
        System.out.println("  Would you like to start a new order? ");
        System.out.print("            ➡ [Y] Yes  |  [N] No: ");
        String choice = scan.nextLine().toUpperCase();
        switch (choice) {
            case "Y":
                System.out.print("Type order item: ");
                String item = scan.nextLine();
                System.out.print("Type unit price: ");
                double unitPrice = scan.nextDouble();
                System.out.print("Type quantity: ");
                int quantity = scan.nextInt();
                Order order = new Order(item, quantity, unitPrice);
                order.displayOrderDetails();
                order.processPayment(new GCash());
                order.processPayment(new Maya());
                order.processPayment(new ShoppeePay());
                break;

            case "N":
                System.out.println("Too bad we have a lot of new stocks!");
                break;
        }
    }
}
