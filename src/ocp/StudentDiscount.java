package ocp;

public class StudentDiscount implements DiscountStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.15;
    }
}