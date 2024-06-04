package mybus;

import com.razorpay.Order;
import com.razorpay.RazorpayException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class Payment extends JFrame {

    private JButton payButton;
    private JTextField amountField;
    private JTextField currencyField;
    private JTextField receiptField;

    public Payment(String paymentValue, String newid) {
        // Initialize UI Components
        payButton = new JButton("Pay");
        amountField = new JTextField(10);
        currencyField = new JTextField(3);
        receiptField = new JTextField(20);

        // Set default values
        amountField.setText(paymentValue);
        amountField.setEditable(false);
        currencyField.setText("INR");
        currencyField.setEditable(false);
        receiptField.setText("Receipt#" + newid);
        receiptField.setEditable(false);

        // Add Action Listener to the button
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
                setVisible(false);
            }
        });

        // Layout Setup
        setLayout(new java.awt.GridLayout(5, 1));
        add(new JLabel("Amount:"));
        add(amountField);
        add(new JLabel("Currency:"));
        add(currencyField);
        add(new JLabel("Receipt:"));
        add(receiptField);
        add(payButton);

        // JFrame Settings
        setTitle("Razorpay Payment Gateway");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void processPayment() {
        double amount = Double.parseDouble(amountField.getText());
        String currency = currencyField.getText();
        String receipt = receiptField.getText();

        PaymentService paymentService = new PaymentService();

        try {
            Order order = paymentService.createOrder(amount, currency, receipt);
            JOptionPane.showMessageDialog(this, "Payment Successful! Payment ID: " + order.get("id"));
            String orderId = order.get("id").toString();
            //initiatePayment(orderId);
        } catch (RazorpayException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Payment Failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initiatePayment(String orderId) {
        // For demonstration purposes, open a browser window with Razorpay payment URL
        String paymentUrl = "https://dashboard.razorpay.com/#/app/orders/" + orderId + "/payments";
        try {
            java.awt.Desktop.getDesktop().browse(new URI(paymentUrl));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening payment page", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Payment("500", "1");
            }
        });
    }
}
