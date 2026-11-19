package ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    private final Map<String, DiscountStrategy> strategies = new HashMap<>();

    public DiscountCalculator() {
        register("regular", new RegularDiscount());
        register("vip", new VipDiscount());
        register("super_vip", new SuperVipDiscount());
    }

    public void register(String userType, DiscountStrategy strategy) {
        strategies.put(userType, strategy);
    }

    public double calculateDiscount(String userType, double price) {
        DiscountStrategy strategy = strategies.get(userType);
        return strategy == null ? 0.0 : strategy.calculate(price);
    }
}