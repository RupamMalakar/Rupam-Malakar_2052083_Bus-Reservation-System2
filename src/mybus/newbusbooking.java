package mybus;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class newbusbooking extends JFrame {

    private JPanel contentPane;
    private JTextField userid, bookid;
    int amt, ph;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    newbusbooking frame = new newbusbooking();
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
    public newbusbooking() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1021, 690);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton showbill = new JButton("TOTAL FARE");
        showbill.setForeground(Color.WHITE);
        showbill.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showbill.setBackground(new Color(30, 144, 255));
        showbill.setBounds(99, 515, 221, 99);
        contentPane.add(showbill);

        JButton Pay = new JButton("Pay");
        Pay.setForeground(Color.WHITE);
        Pay.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Pay.setBackground(new Color(30, 144, 255));
        Pay.setBounds(400, 515, 221, 99);
        contentPane.add(Pay);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1039, 210);
        panel.setLayout(null);
        panel.setForeground(Color.BLACK);
        panel.setBackground(new Color(0, 51, 51));
        contentPane.add(panel);

        JLabel label = new JLabel("YOUR BUS");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Bahnschrift", Font.BOLD, 53));
        label.setBounds(118, 407, 285, 66);
        panel.add(label);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(newbusbooking.class.getResource("/buspic/1473314599.jpg")));
        label_1.setBounds(379, 11, 256, 256);
        panel.add(label_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.activeCaptionBorder);
        panel_1.setBounds(261, 11, 499, 158);
        panel.add(panel_1);

        JLabel lblFrom = new JLabel("FROM");
        lblFrom.setBounds(99, 238, 69, 14);
        lblFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblFrom);

        JComboBox combofrom = new JComboBox();
        combofrom.setBounds(99, 263, 193, 33);
        combofrom.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        combofrom.addItem("Kolkata");    // comboBox for from
        combofrom.addItem("Delhi");
        combofrom.addItem("Mumbai");
        combofrom.addItem("Chennai");
        combofrom.addItem("Lucknow");
        /*combobox.addItemListener(new ItemListener() {
            public void ItemStateChanged(ItemEvent e) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation", "root", "rupam@123");

                    Statement stmt = con.createStatement();
                    PreparedStatement ps = con.prepareStatement("insert into new_bus_booking values (?,?,?,?,?,?)");
                } catch (exception e) {

                }
            }
        });*/
        combofrom.setEditable(false);
        combofrom.setSelectedItem(null);
        contentPane.add(combofrom);

        JLabel lblTo = new JLabel("TO");
        lblTo.setBounds(409, 238, 69, 14);
        lblTo.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblTo);

        JComboBox comboto = new JComboBox();
        comboto.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        comboto.setBounds(409, 263, 193, 33);
        comboto.setEditable(false);    //check out later for false
        comboto.setSelectedItem(null);
        contentPane.add(comboto);

        combofrom.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (combofrom.getSelectedItem().equals("Kolkata")) {
                    comboto.removeAllItems();
                    comboto.addItem("Asansol");
                    comboto.addItem("Siliguri");
                } else if (combofrom.getSelectedItem().equals("Delhi")) {
                    comboto.removeAllItems();
                    comboto.addItem("Shimla");
                    comboto.addItem("Jaipur");
                } else if (combofrom.getSelectedItem().equals("Mumbai")) {
                    comboto.removeAllItems();
                    comboto.addItem("Pune");
                    comboto.addItem("Nashik");
                } else if (combofrom.getSelectedItem().equals("Chennai")) {
                    comboto.removeAllItems();
                    comboto.addItem("Bangalore");
                    comboto.addItem("Madurai");
                } else if (combofrom.getSelectedItem().equals("Lucknow")) {
                    comboto.removeAllItems();
                    comboto.addItem("Haldwani");
                    comboto.addItem("Ranchi");
                }
            }
        });

        JLabel lblAcNonac = new JLabel("AC / NON-AC");
        lblAcNonac.setBounds(731, 238, 97, 14);
        lblAcNonac.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblAcNonac);

        JComboBox ac = new JComboBox();
        ac.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        ac.setBounds(717, 263, 193, 33);
        ac.addItem("AC");
        ac.addItem("NON-AC");
        ac.setSelectedItem(null);
        ac.setEditable(false);
        contentPane.add(ac);

        JLabel username = new JLabel("USER-ID(ph. no)");
        username.setBounds(99, 341, 129, 14);
        username.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(username);

        userid = new JTextField();    //textField_2 for username
        userid.setBounds(99, 366, 192, 33);
        userid.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        userid.setColumns(10);
        //textField_2.setText(para);	//as here text is seted....
        contentPane.add(userid);
        userid.setEditable(true);

        JLabel lblNoOfPersons = new JLabel("NO. OF PERSONS");
        lblNoOfPersons.setBounds(409, 429, 129, 14);
        lblNoOfPersons.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblNoOfPersons);

        JLabel lblDateOfJourney = new JLabel("DATE OF ONWARD JOURNEY");
        lblDateOfJourney.setBounds(409, 341, 165, 14);
        lblDateOfJourney.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblDateOfJourney);

        JLabel book_id = new JLabel("BOOKING_ID :");
        book_id.setBounds(409, 613, 76, 14);
        book_id.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(book_id);

        bookid = new JTextField();
        bookid.setBounds(495, 604, 193, 33);
        bookid.setBorder(null);
        bookid.setColumns(10);
        //textField_3.setText(newid);	//as here text is seted....
        bookid.setOpaque(false);
        bookid.setBackground(new Color(240, 240, 240));
        contentPane.add(bookid);

        JDateChooser odate = new JDateChooser();
        odate.setBounds(409, 366, 193, 33);
        odate.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        odate.setDateFormatString("dd MMM , yyyy");
        contentPane.add(odate);

        JDateChooser retdate = new JDateChooser();
        retdate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        retdate.setBounds(717, 366, 193, 33);
        retdate.setDateFormatString("dd MMM , yyyy");
        contentPane.add(retdate);

        JComboBox pers = new JComboBox();
        pers.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        pers.setBounds(409, 454, 193, 33);
        pers.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pers.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
        pers.setEditable(false);
        contentPane.add(pers);

        JButton btnBookMyBus = new JButton("BOOK MY BUS");
        btnBookMyBus.setBounds(689, 515, 221, 99);
        btnBookMyBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //here mybus is database name, root is username and shourjyo is password
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation", "root", "rupam@123");

                    Statement stmt = con.createStatement();

                    PreparedStatement ps = con.prepareStatement("insert into new_bus_booking values (?,?,?,?,?,?,?,?)");//here 1 ? will include or not..
                    String value1 = combofrom.getSelectedItem().toString();
                    String value2 = comboto.getSelectedItem().toString();
                    String value3 = ac.getSelectedItem().toString();
                    String odateval = ((JTextField) odate.getDateEditor().getUiComponent()).getText();
                    String retdateval = ((JTextField) retdate.getDateEditor().getUiComponent()).getText();
                    //ps.setInt(1, Integer.parseInt(phn.getText())); //not taking long number
                    ps.setString(1, bookid.getText());
                    ps.setString(2, userid.getText());
                    ps.setString(3, value1);
                    ps.setString(4, value2);
                    ps.setString(5, value3);
                    ps.setString(6, pers.getSelectedItem().toString());
                    ps.setString(7, odateval);
                    ps.setString(8, retdateval);

                    int x = ps.executeUpdate();

                    con.close();
                } catch (Exception ae) {
                    System.out.print(ae);
                }
            }
        });
        btnBookMyBus.setForeground(Color.WHITE);
        btnBookMyBus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBookMyBus.setBackground(new Color(30, 144, 255));
        btnBookMyBus.setVisible(true);
        contentPane.add(btnBookMyBus);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 564, 1033, 10);
        panel_2.setBackground(new Color(0, 51, 51));
        contentPane.add(panel_2);

        JLabel lblDateOfReturn = new JLabel("DATE OF RETURN  JOURNEY");
        lblDateOfReturn.setBounds(717, 341, 165, 14);
        lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblDateOfReturn);

    }


    public newbusbooking(String para, String newid) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1021, 690);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(Color.BLACK);
        panel.setBackground(new Color(0, 51, 51));
        panel.setBounds(0, 0, 1039, 210);
        contentPane.add(panel);

        JLabel label = new JLabel("YOUR BUS");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Bahnschrift", Font.BOLD, 53));
        label.setBounds(118, 407, 285, 66);
        panel.add(label);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(newbusbooking.class.getResource("/buspic/1473314599.jpg")));
        label_1.setBounds(379, 11, 256, 256);
        panel.add(label_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.activeCaptionBorder);
        panel_1.setBounds(261, 11, 499, 158);
        panel.add(panel_1);

        JLabel lblFrom = new JLabel("FROM");
        lblFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblFrom.setBounds(99, 238, 69, 14);
        contentPane.add(lblFrom);

        JComboBox comboBox = new JComboBox();
        comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        comboBox.addItem("Kolkata");    // comboBox for from
        comboBox.addItem("Delhi");
        comboBox.addItem("Mumbai");
        comboBox.addItem("Chennai");
        comboBox.addItem("Lucknow");
        comboBox.setEditable(false);
        comboBox.setSelectedItem(null);
        comboBox.setBounds(99, 263, 193, 33);
        contentPane.add(comboBox);

        JLabel lblTo = new JLabel("TO");
        lblTo.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTo.setBounds(409, 238, 69, 14);
        contentPane.add(lblTo);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));// comboBox_1 for to
        comboBox_1.setEditable(false);    //check out later for false
        comboBox_1.setSelectedItem(null);
        comboBox_1.setBounds(409, 263, 193, 33);
        contentPane.add(comboBox_1);

        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (comboBox.getSelectedItem().equals("Kolkata")) {
                    comboBox_1.removeAllItems();
                    comboBox_1.addItem("Asansol");
                    comboBox_1.addItem("Siliguri");
                } else if (comboBox.getSelectedItem().equals("Delhi")) {
                    comboBox_1.removeAllItems();
                    comboBox_1.addItem("Shimla");
                    comboBox_1.addItem("Jaipur");
                } else if (comboBox.getSelectedItem().equals("Mumbai")) {
                    comboBox_1.removeAllItems();
                    comboBox_1.addItem("Pune");
                    comboBox_1.addItem("Nashik");
                } else if (comboBox.getSelectedItem().equals("Chennai")) {
                    comboBox_1.removeAllItems();
                    comboBox_1.addItem("Bangalore");
                    comboBox_1.addItem("Madurai");
                } else if (comboBox.getSelectedItem().equals("Lucknow")) {
                    comboBox_1.removeAllItems();
                    comboBox_1.addItem("Haldwani");
                    comboBox_1.addItem("Ranchi");
                }
            }
        });

        JLabel lblAcNonac = new JLabel("AC / NON-AC");
        lblAcNonac.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAcNonac.setBounds(731, 238, 97, 14);
        contentPane.add(lblAcNonac);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));// comboBox_2 for ac/non-ac
        comboBox_2.addItem("ac");
        comboBox_2.addItem("non-ac");
        comboBox_2.setSelectedItem(null);
        comboBox_2.setEditable(false);
        comboBox_2.setBounds(717, 263, 193, 33);
        contentPane.add(comboBox_2);

        JLabel username = new JLabel("USERNAME(ph. no)");
        username.setFont(new Font("Tahoma", Font.BOLD, 11));
        username.setBounds(99, 341, 129, 14);
        contentPane.add(username);

        userid = new JTextField();
        userid.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));//textField_2 for username
        userid.setColumns(10);
        userid.setBounds(99, 366, 192, 33);
        userid.setText(para);    //as here text is seted....
        contentPane.add(userid);
        userid.setEditable(false);

        JLabel lblNoOfPersons = new JLabel("NO. OF PERSONS");
        lblNoOfPersons.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNoOfPersons.setBounds(409, 429, 129, 14);
        contentPane.add(lblNoOfPersons);


        JLabel lblDateOfJourney = new JLabel("DATE OF ONWARD JOURNEY");
        lblDateOfJourney.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDateOfJourney.setBounds(409, 341, 165, 14);
        contentPane.add(lblDateOfJourney);

        JDateChooser odate = new JDateChooser();
        odate.setDateFormatString("dd MMM , yyyy");
        odate.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        odate.setBounds(409, 366, 193, 33);
        contentPane.add(odate);

        JLabel book_id = new JLabel("BOOKING_ID :");
        book_id.setBounds(409, 613, 76, 14);
        book_id.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(book_id);

        bookid = new JTextField();
        bookid.setBounds(495, 604, 193, 33);
        bookid.setBorder(null);
        bookid.setColumns(10);
        bookid.setText(newid);    //as here text is seted....
        bookid.setOpaque(false);
        bookid.setBackground(new Color(240, 240, 240));
        contentPane.add(bookid);


        JDateChooser retdate = new JDateChooser();
        retdate.setDateFormatString("dd MMM , yyyy");
        retdate.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        retdate.setBounds(717, 366, 193, 33);
        contentPane.add(retdate);

        JComboBox pers = new JComboBox();
        pers.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
        pers.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
        pers.setEditable(false);
        pers.setBounds(409, 454, 193, 33);
        contentPane.add(pers);

        JButton showbill = new JButton("TOTAL FARE");
        showbill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation", "root", "rupam@123");

                    PreparedStatement px = con.prepareStatement("select price from route_price where bfrom=? and bto=? and ac_non_ac=?");
                    String val1 = comboBox.getSelectedItem().toString();
                    String val2 = comboBox_1.getSelectedItem().toString();
                    String val3 = comboBox_2.getSelectedItem().toString();
                    px.setString(1, val1);
                    px.setString(2, val2);
                    px.setString(3, val3);

                    ResultSet rs = px.executeQuery();
                    while (rs.next()) {
                        ph = rs.getInt("price");

                        if (((JTextField) retdate.getDateEditor().getUiComponent()).getText().equals("")) {
                            amt = ph * (Integer.parseInt(pers.getSelectedItem().toString()));
                        } else {
                            amt = ph * (Integer.parseInt(pers.getSelectedItem().toString())) * 2;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Per Person price : " + ph + "\nTotal bill : " + amt);
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }

        });
        showbill.setForeground(Color.WHITE);
        showbill.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showbill.setBackground(new Color(30, 144, 255));
        showbill.setBounds(99, 515, 221, 99);
        contentPane.add(showbill);

        JButton Pay = new JButton("Pay");
        Pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation", "root", "rupam@123");

                    PreparedStatement px = con.prepareStatement("select price from route_price where bfrom=? and bto=? and ac_non_ac=?");
                    String val1 = comboBox.getSelectedItem().toString();
                    String val2 = comboBox_1.getSelectedItem().toString();
                    String val3 = comboBox_2.getSelectedItem().toString();
                    px.setString(1, val1);
                    px.setString(2, val2);
                    px.setString(3, val3);

                    ResultSet rs = px.executeQuery();
                    while (rs.next()) {
                        ph = rs.getInt("price");

                        if (((JTextField) retdate.getDateEditor().getUiComponent()).getText().equals("")) {
                            amt = ph * (Integer.parseInt(pers.getSelectedItem().toString()));
                        } else {
                            amt = ph * (Integer.parseInt(pers.getSelectedItem().toString())) * 2;
                        }
                    }
                } catch (Exception ae) {
                    System.out.println(ae);
                }
                Payment ob = new Payment(String.valueOf(amt), newid);
                ob.setVisible(true);
            }
        });
        Pay.setForeground(Color.WHITE);
        Pay.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Pay.setBackground(new Color(30, 144, 255));
        Pay.setBounds(400, 515, 221, 99);
        contentPane.add(Pay);

        JButton btnBookMyBus = new JButton("BOOK MY BUS");
        btnBookMyBus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //here mybus is database name, root is username and shourjyo is password
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation", "root", "rupam@123");

                    PreparedStatement px = con.prepareStatement("select price from route_price where bfrom=? and bto=? and ac_non_ac=?");
                    String val1 = comboBox.getSelectedItem().toString();
                    String val2 = comboBox_1.getSelectedItem().toString();
                    String val3 = comboBox_2.getSelectedItem().toString();
                    px.setString(1, val1);
                    px.setString(2, val2);
                    px.setString(3, val3);

                    ResultSet rs = px.executeQuery();
                    while (rs.next()) {
                        ph = rs.getInt("price");
                        if (((JTextField) retdate.getDateEditor().getUiComponent()).getText().equals("")) {
                            amt = ph * (Integer.parseInt(pers.getSelectedItem().toString()));
                        } else {
                            amt = ph * (Integer.parseInt(pers.getSelectedItem().toString())) * 2;
                        }
                    }

                    PreparedStatement ps = con.prepareStatement("insert into new_bus_booking values (?,?,?,?,?,?,?,?,?)");//here 1 ? will include or not..
                    String value1 = comboBox.getSelectedItem().toString();
                    String value2 = comboBox_1.getSelectedItem().toString();
                    String value3 = comboBox_2.getSelectedItem().toString();
                    String odateval = ((JTextField) odate.getDateEditor().getUiComponent()).getText();
                    String retdateval = ((JTextField) retdate.getDateEditor().getUiComponent()).getText();

                    ps.setInt(1, Integer.parseInt(bookid.getText()));
                    ps.setString(2, userid.getText());
                    ps.setString(3, value1);
                    ps.setString(4, value2);
                    ps.setString(5, value3);
                    ps.setString(6, pers.getSelectedItem().toString());
                    ps.setString(7, odateval);
                    ps.setString(8, retdateval);
                    ps.setInt(9, amt);

                    int x = ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Booking Successfull");
                    homepage hp = new homepage(para);
                    hp.setVisible(true);
                    setVisible(false);
                    con.close();
                } catch (Exception ae) {
                    System.out.print(ae);
                }
            }
        });
        btnBookMyBus.setForeground(Color.WHITE);
        btnBookMyBus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBookMyBus.setBackground(new Color(30, 144, 255));
        btnBookMyBus.setBounds(689, 515, 221, 99);
        btnBookMyBus.setVisible(true);
        contentPane.add(btnBookMyBus);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.DARK_GRAY);
        panel_2.setBounds(0, 564, 1033, 10);
        contentPane.add(panel_2);

        JLabel lblDateOfReturn = new JLabel("DATE OF RETURN  JOURNEY");
        lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDateOfReturn.setBounds(717, 341, 165, 14);
        contentPane.add(lblDateOfReturn);

    }
}
