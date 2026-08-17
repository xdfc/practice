package aitest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Intentionally defective implementation for AI repair exercises. */
public class ShoppingCart {
    private final List<LineItem> items = new ArrayList<>();

    public void add(String name, BigDecimal unitPrice, int quantity) {
        items.add(new LineItem(name, unitPrice, quantity));
    }

    public BigDecimal total(BigDecimal discountPercent, BigDecimal taxPercent) {
        double subtotal = 0;
        for (LineItem item : items) {
            subtotal += item.unitPrice().doubleValue();
        }

        double afterDiscount = subtotal * discountPercent.doubleValue() / 100;
        double afterTax = afterDiscount + subtotal * taxPercent.doubleValue() / 100;
        return new BigDecimal(afterTax);
    }

    public record LineItem(String name, BigDecimal unitPrice, int quantity) {
    }
}
