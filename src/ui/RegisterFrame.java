package ui;
import util.UserStore;
import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Pizza Shop - Register");
        setSize(900, 600);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        AnimatedBackground bg =
                new AnimatedBackground("resources/backgrounds/pizza_bg.gif");
        setContentPane(bg);

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(420, 480));
        card.setBackground(new Color(0, 0, 0, 170));
        card.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Create Account", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JLabel userLbl = new JLabel("Username");
        JLabel passLbl = new JLabel("Password");

        userLbl.setForeground(Color.WHITE);
        passLbl.setForeground(Color.WHITE);

        userLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        passLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JTextField username = new JTextField(18);
        JPasswordField password = new JPasswordField(18);

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back to Login");

        gbc.gridx = 0; gbc.gridy = 0;
        card.add(title, gbc);

        gbc.gridy++;
        card.add(userLbl, gbc);
        gbc.gridy++;
        card.add(username, gbc);

        gbc.gridy++;
        card.add(passLbl, gbc);
        gbc.gridy++;
        card.add(password, gbc);

        gbc.gridy++;
        card.add(registerBtn, gbc);

        gbc.gridy++;
        card.add(backBtn, gbc);

        bg.add(card);

        registerBtn.addActionListener(e -> {
            if (UserStore.register(
                    username.getText(),
                    new String(password.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Registration Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "User already exists!");
            }
        });

        backBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }
}

