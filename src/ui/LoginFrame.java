package ui;
import util.UserStore;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Pizza Shop - Login");
        setSize(900, 600);                 // Normal size
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        // Background is .gif (Correct)
        AnimatedBackground bg =
                new AnimatedBackground("resources/backgrounds/pizza_bg.gif");
        setContentPane(bg);

        // Center card
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(420, 480));
        card.setBackground(new Color(0, 0, 0, 170));
        card.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // LOGO FIXED: changed from .png to .jpg
        JLabel logo = new JLabel(
                scaleImage("resources/icons/logo.png", 120, 120));
        logo.setHorizontalAlignment(JLabel.CENTER);

        JLabel title = new JLabel("Pizza Shop Login", JLabel.CENTER);
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

        username.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        password.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registerBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));

        gbc.gridx = 0; gbc.gridy = 0;
        card.add(logo, gbc);

        gbc.gridy++;
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
        card.add(loginBtn, gbc);

        gbc.gridy++;
        card.add(registerBtn, gbc);

        bg.add(card); // centered automatically

        loginBtn.addActionListener(e -> {
            if (UserStore.login(
                    username.getText(),
                    new String(password.getPassword()))) {
                      dispose();
                      new StoreFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterFrame();
        });

        setVisible(true);
    }

    // Safe image scaling
    private ImageIcon scaleImage(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(path);
        // Check if image loaded
        if (icon.getIconWidth() == -1) {
            System.err.println("Could not find image: " + path);
            return new ImageIcon(); // Return empty icon to prevent crash
        }
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
