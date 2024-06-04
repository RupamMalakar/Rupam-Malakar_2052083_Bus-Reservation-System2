package mybus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Otp extends JFrame {
    private JButton submitButton;
    private JTextField otpField;

    Otp(String phNo) {
        submitButton = new JButton("Submit");
        otpField = new JTextField(4);

        setLayout(new java.awt.GridLayout(5, 1));
        add(new JLabel("OTP :"));
        add(otpField);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation", "root", "rupam@123");

                    PreparedStatement ps = con.prepareStatement("select * from otp where phno=? and otp_val=?");
                    ps.setString(1, phNo);
                    ps.setString(2, otpField.getText());
                    ResultSet rs = ps.executeQuery();
                    int flag = 0;
                    while (rs.next()) {
                        flag = 1;
                        ps = con.prepareStatement("delete from otp where phno=? and otp_val=?");
                        ps.setString(1, phNo);
                        ps.setString(2, otpField.getText());
                        int i = ps.executeUpdate();
                        if (i > 0) {
                            //
                            JOptionPane.showMessageDialog(null, "Welcome to YOUR BUS !");
                            homepage hp = new homepage(phNo);
                            hp.setVisible(true);
                            setVisible(false);
                        }
                    }

                    if(flag == 0){
                        JOptionPane.showMessageDialog(null, "Otp is not matched !");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        setTitle("Otp verification");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
