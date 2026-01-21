package ui;

import model.Cart;
import model.CartItem;

import javax.swing.*;
import java.awt.*;

public class CheckoutFrame extends JFrame {

    public CheckoutFrame(Cart cart) {

        // Window settings
        setTitle("Receipt 🧾");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Receipt area
        JTextArea receipt = new JTextArea();
        receipt.setEditable(false);
        receipt.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Header
        receipt.append("----- Pizza Store Receipt -----\n\n");

        // Cart items
        for (CartItem item : cart.getItems()) {
            receipt.append(
                item.getName() + " x" + item.getQty()
                + " = ৳ " + item.getTotal() + "\n"
            );
        }

        // Footer
        receipt.append("\n-------------------------------\n");
        receipt.append("TOTAL: ৳ " + cart.getTotal());

        // Add to frame
        add(new JScrollPane(receipt), BorderLayout.CENTER);

        setVisible(true);
    }
}

