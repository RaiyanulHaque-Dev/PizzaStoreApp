package model;

public class CartItem {

    private String name;
    private int price;
    private int qty;

    public CartItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.qty = 1;
    }

    public void incrementQty() {
        qty++;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public int getTotal() {
        return price * qty;
    }
}

