package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ArrayList<CartItem> items = new ArrayList<>();
    private JLabel totalLabel;

    public Cart(JLabel totalLabel) {
        this.totalLabel = totalLabel;
        updateTotal();
    }

    public void addItem(String name, int price) {
        for (CartItem item : items) {
            if (item.getName().equals(name)) {
                item.incrementQty();
                updateTotal();
                return;
            }
        }
        items.add(new CartItem(name, price));
        updateTotal();
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
        updateTotal();
    }

    public void resetCart() {
        items.clear();
        updateTotal();
    }

    public int getTotal() {
        int sum = 0;
        for (CartItem i : items) sum += i.getTotal();
        return sum;
    }

    // ✅ Getter for UI access
    public List<CartItem> getItems() {
        return items;
    }

    private void updateTotal() {
        totalLabel.setText("Total: ৳ " + getTotal());
    }
}

