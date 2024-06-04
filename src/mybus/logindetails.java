package mybus;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class logindetails extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    //private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    logindetails frame = new logindetails();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public logindetails() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //window han
        setBounds(100, 100, 1021, 690);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsernamephoneNumber = new JLabel("USER-ID (Phone Number)");
        lblUsernamephoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsernamephoneNumber.setBounds(647, 127, 170, 14);
        contentPane.add(lblUsernamephoneNumber);

        textField = new JTextField();
        textField.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        textField.setColumns(10);
        textField.setBounds(647, 152, 221, 47);
        contentPane.add(textField);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPassword.setBounds(647, 255, 86, 14);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        passwordField.setBounds(647, 280, 221, 47);
        contentPane.add(passwordField);


        JButton btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation", "root", "rupam@123");

                    PreparedStatement ps = con.prepareStatement("select * from new_sign_up where phone_no=? and password=?");
                    ps.setString(1, textField.getText());
                    ps.setString(2, passwordField.getText());
                    ResultSet rs = ps.executeQuery();
                    //ResultSetMetaData rsm=rs.getMetaData();

                    int c = 0;
                    String mail = null;
                    while (rs.next()) {
                        c++;
                        mail = rs.getString(3);
                    }
                    //System.out.println(c);
                    if (c > 0) {
                        //
                        PreparedStatement f = con.prepareStatement("select max(id) as id from otp");
                        ResultSet rs2 = f.executeQuery();

                        rs2.next();
                        int maxId = rs2.getInt("id");
                        int id = maxId + 1;

                        PreparedStatement ps2 = con.prepareStatement("INSERT INTO OTP VALUES(?,?,?)");
                        ps2.setInt(1, id);
                        ps2.setString(2, textField.getText());
                        SecureRandom random = new SecureRandom();
                        String otp = String.valueOf(1000 + random.nextInt(9000));
                        ps2.setString(3, otp);
                        ps2.executeUpdate();

                        MailUtil.sendEmail(mail, "OTP", "Otp is : " + otp);
                        Otp otpObj = new Otp(textField.getText());
                        otpObj.setVisible(true);

                        //
                        //String msg = textField.getText();            //later included

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");

                    }
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
        });
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLogin.setBackground(new Color(30, 144, 255));
        btnLogin.setBounds(647, 436, 221, 99);
        contentPane.add(btnLogin);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(Color.BLACK);
        panel.setBackground(new Color(0, 51, 51));
        panel.setBounds(0, 0, 499, 668);
        contentPane.add(panel);

        JLabel label = new JLabel("YOUR BUS");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Impact", Font.BOLD, 53));
        label.setBackground(Color.WHITE);
        label.setBounds(118, 407, 285, 66);
        panel.add(label);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(logindetails.class.getResource("/buspic/1473314599.jpg")));
        label_1.setBounds(118, 62, 256, 351);
        panel.add(label_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.activeCaptionBorder);
        panel_1.setBounds(0, 96, 499, 170);
        panel.add(panel_1);


    }
}
