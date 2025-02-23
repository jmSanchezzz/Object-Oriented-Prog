package labInterface;

public class ShoppeePay implements PaymentMode {

    @Override
    public double determineDiscountRate() {
        return 0.1;
    }
}
