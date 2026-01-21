package ui;

import javax.swing.*;
import java.awt.*;
import model.Cart;

public class StoreFrame extends JFrame {

    public StoreFrame() {

        setTitle("Pizza Store 🍕");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ===== BACKGROUND PANEL =====
        BackgroundPanel bg =
                new BackgroundPanel("resources/backgrounds/bg_store.png");

        setContentPane(bg);
        bg.setLayout(new BorderLayout());

        // ===== TOTAL LABEL =====
        JLabel totalLbl = new JLabel("Total: ৳ 0", JLabel.CENTER);
        totalLbl.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        totalLbl.setOpaque(true);
        totalLbl.setBackground(new Color(255, 230, 120));

        // ===== CART =====
        Cart cart = new Cart(totalLbl);

        // ===== BUTTONS =====
        JButton resetBtn = new JButton("Reset ❌");
        JButton checkoutBtn = new JButton("Checkout 💳");

        resetBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        checkoutBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

        resetBtn.addActionListener(e -> cart.resetCart());
        checkoutBtn.addActionListener(e -> new CheckoutFrame(cart));

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        topPanel.add(resetBtn, BorderLayout.WEST);
        topPanel.add(totalLbl, BorderLayout.CENTER);
        topPanel.add(checkoutBtn, BorderLayout.EAST);

        // ===== STORE PANEL =====
        JPanel storePanel = new JPanel(new GridLayout(1, 3, 30, 30));
        storePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Glass effect panel
        storePanel.setBackground(new Color(255, 255, 255, 170));
        storePanel.setOpaque(true);

        // ===== PIZZA CARDS =====
        storePanel.add(new PizzaCard(
                "Cheese Blast",
                450,
                "resources/pizzas/pizza_cheese.png",
                cart
        ));

        storePanel.add(new PizzaCard(
                "Pepperoni Fun",
                550,
                "resources/pizzas/pizza_pepperoni.png",
                cart
        ));

        storePanel.add(new PizzaCard(
                "Veggie Fun",
                400,
                "resources/pizzas/pizza_veggie.png",
                cart
        ));

        // ===== ADD COMPONENTS =====
        bg.add(topPanel, BorderLayout.NORTH);
        bg.add(storePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

