package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;
    private JLabel imageLabel;

    // Nested static class for gradient background
    static class GradientPanel extends JPanel {
        private Color color1;
        private Color color2;

        public GradientPanel(Color color1, Color color2) {
            this.color1 = color1;
            this.color2 = color2;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();
            // Create a vertical gradient from color1 to color2
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(500, 450); // Increased height for better gradient visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a GradientPanel and set it as the content pane
        GradientPanel gradientPanel = new GradientPanel(new Color(150, 200, 250), new Color(250, 200, 150)); // Blue to Orange gradient
        gradientPanel.setLayout(new GridBagLayout()); // GradientPanel will now hold the GridBagLayout
        setContentPane(gradientPanel); // Set gradientPanel as the content pane

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding around components

        // --- Main Screen Image ---
        // User should place an image file (e.g., 'main_calculator.png') in the same directory as SimpleCalculator.java
        // or provide a full path. If not found, the label will be empty.
        String mainImagePath = "main_calculator.png"; // <-- Change this path if your image is elsewhere
        ImageIcon mainImageIcon = null;
        try {
            mainImageIcon = new ImageIcon(new ImageIcon(mainImagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.err.println("Error loading main image: " + e.getMessage());
        }
        imageLabel = new JLabel(mainImageIcon);
        imageLabel.setPreferredSize(new Dimension(100, 100));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.CENTER;
        gradientPanel.add(imageLabel, gbc); // Add to gradientPanel

        // --- Number 1 Input ---
        gbc.gridwidth = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 1; gradientPanel.add(new JLabel("Number 1:"), gbc);
        num1Field = new JTextField();
        num1Field.setBackground(new Color(255, 255, 200)); // Light yellow background for input fields
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 3;
        gradientPanel.add(num1Field, gbc); // Add to gradientPanel

        // --- Number 2 Input ---
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gradientPanel.add(new JLabel("Number 2:"), gbc);
        num2Field = new JTextField();
        num2Field.setBackground(new Color(255, 255, 200)); // Light yellow background for input fields
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 3;
        gradientPanel.add(num2Field, gbc); // Add to gradientPanel

        // --- Operation Buttons ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttonPanel.setOpaque(false); // Make transparent to show gradient
        
        JButton addButton = new JButton("+");
        addButton.setBackground(new Color(100, 200, 100)); // Green
        addButton.setForeground(Color.WHITE);

        JButton subButton = new JButton("-");
        subButton.setBackground(new Color(200, 100, 100)); // Red
        subButton.setForeground(Color.WHITE);

        JButton mulButton = new JButton("*");
        mulButton.setBackground(new Color(100, 100, 200)); // Blue
        mulButton.setForeground(Color.WHITE);

        JButton divButton = new JButton("/");
        divButton.setBackground(new Color(200, 200, 100)); // Yellow
        divButton.setForeground(Color.BLACK);

        // Set smaller preferred size for buttons
        Dimension buttonSize = new Dimension(50, 30);
        addButton.setPreferredSize(buttonSize);
        subButton.setPreferredSize(buttonSize);
        mulButton.setPreferredSize(buttonSize);
        divButton.setPreferredSize(buttonSize);

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.NONE;
        gradientPanel.add(buttonPanel, gbc); // Add to gradientPanel

        // --- Result Display ---
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel resultLabelText = new JLabel("Result:");
        resultLabelText.setForeground(Color.DARK_GRAY); // Dark gray text for labels
        gradientPanel.add(resultLabelText, gbc);
        
        resultLabel = new JLabel("0.0");
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        resultLabel.setBackground(Color.WHITE);
        resultLabel.setOpaque(true);
        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 18)); // Larger, bold font
        gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 3;
        gradientPanel.add(resultLabel, gbc); // Add to gradientPanel

        // --- Action Listener for Buttons ---
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(num1Field.getText());
                    double n2 = Double.parseDouble(num2Field.getText());
                    double result = 0;
                    String command = e.getActionCommand();
                    String popupImage = "";

                    switch (command) {
                        case "+":
                            result = n1 + n2;
                            popupImage = "add_icon.png";
                            break;
                        case "-":
                            result = n1 - n2;
                            popupImage = "sub_icon.png";
                            break;
                        case "*":
                            result = n1 * n2;
                            popupImage = "mul_icon.png";
                            break;
                        case "/":
                            if (n2 == 0) {
                                resultLabel.setText("Error: Div by 0");
                                showResultPopup("Error: Division by zero!", "error_icon.png");
                                return;
                            }
                            result = n1 / n2;
                            popupImage = "div_icon.png";
                            break;
                    }
                    resultLabel.setText(String.format("%.2f", result));
                    showResultPopup(String.format("%.2f", result), popupImage);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid Input");
                    showResultPopup("Invalid Input!", "error_icon.png");
                }
            }
        };

        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);

        setVisible(true);
    }

    /**
     * Displays the calculation result in a small pop-up window with an image.
     * @param resultText The result to display.
     * @param imagePath The path to the image file to show in the pop-up.
     *                  User should place image files (e.g., 'add_icon.png', 'error_icon.png')
     *                  in the same directory as SimpleCalculator.java or provide full paths.
     */
    private void showResultPopup(String resultText, String imagePath) {
        JDialog popup = new JDialog(this, "Calculation Result", true);
        popup.setSize(300, 200);
        popup.setLayout(new BorderLayout(10, 10));
        popup.getContentPane().setBackground(new Color(255, 240, 220));

        JLabel resultDisplay = new JLabel("Result: " + resultText, SwingConstants.CENTER);
        resultDisplay.setFont(new Font("Serif", Font.BOLD, 20));
        popup.add(resultDisplay, BorderLayout.NORTH);

        ImageIcon popupImageIcon = null;
        try {
            popupImageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.err.println("Error loading popup image: " + e.getMessage());
        }
        JLabel popupImageLabel = new JLabel(popupImageIcon, SwingConstants.CENTER);
        popup.add(popupImageLabel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> popup.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 240, 220));
        buttonPanel.add(okButton);
        popup.add(buttonPanel, BorderLayout.SOUTH);

        popup.setLocationRelativeTo(this);
        popup.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}

