package ui;

import javax.swing.*;
import java.awt.*;
import model.Cart;

public class PizzaCard extends JPanel {

    public PizzaCard(String name, int price, String imgPath, Cart cart) {

        // ===== CARD PANEL SETTINGS =====
        setPreferredSize(new Dimension(260, 360));
        setBackground(new Color(255, 245, 230));
        setBorder(BorderFactory.createLineBorder(
                new Color(255, 153, 51), 3));
        setLayout(new BorderLayout(10, 10));

        // ===== PIZZA IMAGE (BIGGER) =====
        JLabel imgLabel = new JLabel(
                scaleImage(imgPath, 200, 160)
        );
        imgLabel.setHorizontalAlignment(JLabel.CENTER);

        // ===== PIZZA NAME =====
        JLabel nameLabel = new JLabel(name, JLabel.CENTER);
        nameLabel.setFont(
                new Font("Comic Sans MS", Font.BOLD, 18)
        );
        nameLabel.setForeground(new Color(180, 60, 0));

        // ===== PRICE =====
        JLabel priceLabel = new JLabel(
                "Price: ৳ " + price, JLabel.CENTER
        );
        priceLabel.setFont(
                new Font("Comic Sans MS", Font.BOLD, 16)
        );
        priceLabel.setForeground(Color.RED);

        // ===== BUTTONS =====
        JButton addBtn = new JButton("+");
        JButton removeBtn = new JButton("-");

        addBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        removeBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        addBtn.setBackground(new Color(144, 238, 144));
        removeBtn.setBackground(new Color(255, 182, 193));

        addBtn.addActionListener(e -> cart.addItem(name, price));
        removeBtn.addActionListener(e -> cart.removeItem(name));

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.add(removeBtn);
        btnPanel.add(addBtn);

        // ===== CENTER TEXT PANEL =====
        JPanel textPanel = new JPanel(
                new GridLayout(2, 1, 5, 5)
        );
        textPanel.setOpaque(false);
        textPanel.add(nameLabel);
        textPanel.add(priceLabel);

        // ===== ADD TO CARD =====
        add(imgLabel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    // ===== IMAGE SCALING METHOD =====
    private ImageIcon scaleImage(String path, int w, int h) {
        Image img = new ImageIcon(path).getImage();
        return new ImageIcon(
                img.getScaledInstance(w, h, Image.SCALE_SMOOTH)
        );
    }
}

