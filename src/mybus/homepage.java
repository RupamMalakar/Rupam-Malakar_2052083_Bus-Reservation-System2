package mybus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homepage()
	{
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
		label_1.setBounds(379, 11, 256, 256);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon(homepage.class.getResource("/buspic/1473314599.jpg")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(261, 11, 499, 158);
		panel.add(panel_1);
		
		JButton btnBookABus = new JButton("BOOK A BUS");
		btnBookABus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				newbusbooking nbb = new newbusbooking();
				nbb.setVisible(true);
				setVisible(false);
			}
		});
		btnBookABus.setForeground(Color.WHITE);
		btnBookABus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBookABus.setBackground(new Color(30, 144, 255));
		btnBookABus.setBounds(57, 367, 221, 99);
		contentPane.add(btnBookABus);
		
		JButton btnCancelReservation = new JButton("CANCEL RESERVATION");
		btnCancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelReservation.setForeground(Color.WHITE);
		btnCancelReservation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelReservation.setBackground(new Color(30, 144, 255));
		btnCancelReservation.setBounds(400, 367, 221, 99);
		contentPane.add(btnCancelReservation);
		
		JLabel lblWelcomeToYour = new JLabel("WELCOME TO YOUR BUS !");
		lblWelcomeToYour.setBackground(Color.WHITE);
		lblWelcomeToYour.setForeground(new Color(0, 153, 255));
		lblWelcomeToYour.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblWelcomeToYour.setBounds(372, 221, 307, 62);
		contentPane.add(lblWelcomeToYour);
		
		JButton btnChangeBooking = new JButton("UPDATE BOOKING");
		btnChangeBooking.setForeground(Color.WHITE);
		btnChangeBooking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangeBooking.setBackground(new Color(30, 144, 255));
		btnChangeBooking.setBounds(731, 367, 221, 99);
		contentPane.add(btnChangeBooking);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 51));
		panel_2.setBounds(0, 564, 1033, 10);
		contentPane.add(panel_2);
		
		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnlogout.setForeground(Color.WHITE);
		btnlogout.setBounds(430, 524, 158, 29);
		btnlogout.setBackground(new Color(30, 144, 255));
		contentPane.add(btnlogout);
	}
	
	
	public homepage(String para) {
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
		label_1.setBounds(379, 11, 256, 256);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon(homepage.class.getResource("/buspic/1473314599.jpg")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(261, 11, 499, 158);
		panel.add(panel_1);
		
		JButton btnBookABus = new JButton("BOOK A BUS");
		btnBookABus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation","root","rupam@123");
				//Statement st=con.createStatement();
				//ResultSet rs=st.executeQuery("select max(book_id) as book_id from new_bus_booking");
				
				PreparedStatement f=con.prepareStatement("select max(book_id) as book_id1 from new_bus_booking");
				ResultSet rs=f.executeQuery();
		
				rs.next();
				int bookid=rs.getInt("book_id1");
				int id=bookid+1;
				System.out.println(id);	//only for checking....
				
				String newid=Integer.toString(id);
				newbusbooking nbb = new newbusbooking(para,newid);	// later included
				nbb.setVisible(true);
				setVisible(false);
				con.close();
				rs.close();
				}
				catch(Exception ae)
				{ 
					System.out.print(ae);
				}
				
				
			}
		});
		btnBookABus.setForeground(Color.WHITE);
		btnBookABus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBookABus.setBackground(new Color(30, 144, 255));
		btnBookABus.setBounds(57, 367, 221, 99);
		contentPane.add(btnBookABus);
		
		
		JButton btnCancelReservation = new JButton("CANCEL RESERVATION");
		btnCancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
					cancelbooking nbb = new cancelbooking(para);	// later included
					nbb.setVisible(true);
					setVisible(false);
			}
		});
		
		btnCancelReservation.setForeground(Color.WHITE);
		btnCancelReservation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelReservation.setBackground(new Color(30, 144, 255));
		btnCancelReservation.setBounds(400, 367, 221, 99);
		contentPane.add(btnCancelReservation);
		
		JLabel lblWelcomeToYour = new JLabel("WELCOME TO YOUR BUS !");
		lblWelcomeToYour.setBackground(Color.WHITE);
		lblWelcomeToYour.setForeground(new Color(0, 153, 255));
		lblWelcomeToYour.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblWelcomeToYour.setBounds(372, 221, 307, 62);
		contentPane.add(lblWelcomeToYour);
		
		JButton btnChangeBooking = new JButton("UPDATE BOOKING");
		btnChangeBooking.setForeground(Color.WHITE);
		btnChangeBooking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangeBooking.setBackground(new Color(30, 144, 255));
		btnChangeBooking.setBounds(731, 367, 221, 99);
		contentPane.add(btnChangeBooking);
		
		btnChangeBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
					updatebookingform nbb = new updatebookingform(para);	// later included
					nbb.setVisible(true);
					setVisible(false);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 51));
		panel_2.setBounds(0, 564, 1033, 10);
		contentPane.add(panel_2);
		
		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnlogout.setForeground(Color.WHITE);
		btnlogout.setBounds(430, 524, 158, 29);
		btnlogout.setBackground(new Color(30, 144, 255));
		contentPane.add(btnlogout);
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login lg = new login();
				lg.setVisible(true);
				setVisible(false);
			}
		});
	}
}
