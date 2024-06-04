package mybus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class cancelbooking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancelbooking frame = new cancelbooking();
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
	public cancelbooking()
	{
		//System.out.println("checking");
	}
	
	
	public cancelbooking(String para) {
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
		panel.setBounds(0, 0, 499, 668);
		contentPane.add(panel);
		
		JLabel label = new JLabel("YOUR BUS");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Bahnschrift", Font.BOLD, 53));
		label.setBackground(Color.WHITE);
		label.setBounds(118, 407, 285, 66);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(cancelbooking.class.getResource("/buspic/1473314599.jpg")));
		label_1.setBounds(118, 62, 256, 351);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(0, 96, 499, 170);
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		textField.setColumns(10);
		textField.setBounds(633, 217, 275, 51);
		contentPane.add(textField);
		
		JButton btnCancelBooking = new JButton("CANCEL BOOKING");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
				Class.forName("com.mysql.cj.jdbc.Driver");  
				//here mybus is database name, root is username and shourjyo is password
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation","root","rupam@123");

				PreparedStatement ps=con.prepareStatement("delete from new_bus_booking where book_id=? and phone_no=?");
				int a=Integer.parseInt(textField.getText());
				ps.setInt(1,a);
				ps.setString(2,para);
				int x=ps.executeUpdate();
					//System.out.println(x);
					if(x>0) 
					{
						JOptionPane.showMessageDialog(null, "Reservation Cancelled");
						homepage hp = new homepage(para);
						hp.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid book_id");
						
					}
				}
		
				catch(Exception ae)
				{ 
					System.out.println(ae);
				}
				
			}
		});
		
		btnCancelBooking.setForeground(Color.WHITE);
		btnCancelBooking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelBooking.setBackground(new Color(30, 144, 255));
		btnCancelBooking.setBounds(661, 399, 221, 99);
		contentPane.add(btnCancelBooking);
		
		JLabel lblBookingId = new JLabel("Enter your BOOKING ID");
		lblBookingId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookingId.setBounds(633, 192, 170, 14);
		contentPane.add(lblBookingId);
		
		JLabel lblBookingCancellation = new JLabel("BOOKING CANCELLATION");
		lblBookingCancellation.setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		lblBookingCancellation.setBounds(570, 37, 378, 51);
		contentPane.add(lblBookingCancellation);
	}

}

