package simpleCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator {
	private JFrame frame;
    private JTextField num1Field, num2Field, num3Field;
    private JLabel resultLabel;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(5, 1));

        // Top frame - Number 1
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter number1:"));
        num1Field = new JTextField(10);
        topPanel.add(num1Field);

        // Second frame - Number 2
        JPanel secondPanel = new JPanel();
        secondPanel.add(new JLabel("Enter number2:"));
        num2Field = new JTextField(10);
        secondPanel.add(num2Field);

        // Third frame - Number 3
        JPanel thirdPanel = new JPanel();
        thirdPanel.add(new JLabel("Enter number3:"));
        num3Field = new JTextField(10);
        thirdPanel.add(num3Field);

        // Bottom frame - Buttons
        JPanel bottomPanel = new JPanel();
        JButton addButton = new JButton("ADD");
        JButton subButton = new JButton("SUB");
        JButton mulButton = new JButton("MUL");
        JButton divButton = new JButton("DIV");
        bottomPanel.add(addButton);
        bottomPanel.add(subButton);
        bottomPanel.add(mulButton);
        bottomPanel.add(divButton);

        // Mid frame - Result display
        JPanel midPanel = new JPanel();
        midPanel.add(new JLabel("Result: "));
        resultLabel = new JLabel("");
        midPanel.add(resultLabel);

        // Add all panels to frame
        frame.add(topPanel);
        frame.add(secondPanel);
        frame.add(thirdPanel);
        frame.add(bottomPanel);
        frame.add(midPanel);

        // Add button actions
        addButton.addActionListener(e -> performOperation("add"));
        subButton.addActionListener(e -> performOperation("sub"));
        mulButton.addActionListener(e -> performOperation("mul"));
        divButton.addActionListener(e -> performOperation("div"));

        frame.setVisible(true);
    }

    private void performOperation(String operation) {
        try {
        	double n1 = Integer.parseInt(num1Field.getText());
            double n2 = Integer.parseInt(num2Field.getText());
            double n3 = Integer.parseInt(num3Field.getText());

            double result = 0;

            switch (operation) {
                case "add":
                    result = n1 + n2 + n3;
                    break;
                case "sub":
                    result = n1 - n2 - n3;
                    break;
                case "mul":
                    result = n1 * n2 * n3;
                    break;
                case "div":
                    if (n2 == 0 || n3 == 0) {
                        JOptionPane.showMessageDialog(frame, "Error: Cannot divide by zero!", "Math Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = n1 / n2 / n3;
                    break;
            }

            resultLabel.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
}
