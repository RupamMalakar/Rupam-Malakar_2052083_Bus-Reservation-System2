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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;


public class updatebooking extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	//private JTextField ureturn;
	private JTextField pno;
	private JTextField ubookid;
	int amt,ph;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatebooking frame = new updatebooking();
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
	public updatebooking() 
	{
		System.out.println("checking");
	}
	
	
	public updatebooking(String para,int x) {
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
		label_1.setIcon(new ImageIcon(updatebooking.class.getResource("/buspic/1473314599.jpg")));
		label_1.setBounds(379, 11, 256, 256);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(261, 11, 499, 158);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("FROM");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(99, 238, 69, 14);
		contentPane.add(label_2);
		
		
		JComboBox ufrom = new JComboBox();	// ufrom for from
		ufrom.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		ufrom.addItem("Kolkata");	
		ufrom.addItem("Delhi");
		ufrom.addItem("Mumbai");
		ufrom.addItem("Chennai");
		ufrom.addItem("Lucknow");
		ufrom.setSelectedItem(null);
		ufrom.setEditable(false);
		ufrom.setBounds(99, 263, 193, 33);
		contentPane.add(ufrom);
		
		JLabel label_3 = new JLabel("TO");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(409, 238, 69, 14);
		contentPane.add(label_3);
		
		JComboBox uto = new JComboBox();	// ufrom for to
		uto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		uto.setBounds(409, 263, 193, 33);
		contentPane.add(uto);
		
		ufrom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ufrom.getSelectedItem().equals("Kolkata"))
				{
					uto.removeAllItems();
					uto.addItem("Asansol");
					uto.addItem("Siliguri");
				}
				else if(ufrom.getSelectedItem().equals("Delhi"))
				{
					uto.removeAllItems();
					uto.addItem("Shimla");
					uto.addItem("Jaipur");
				}
				else if(ufrom.getSelectedItem().equals("Mumbai"))
				{
					uto.removeAllItems();
					uto.addItem("Pune");
					uto.addItem("Nashik");
				}
				else if(ufrom.getSelectedItem().equals("Chennai"))
				{
					uto.removeAllItems();
					uto.addItem("Bangalore");
					uto.addItem("Madurai");
				}
				else if(ufrom.getSelectedItem().equals("Lucknow"))
				{
					uto.removeAllItems();
					uto.addItem("Haldwani");
					uto.addItem("Ranchi");
				}
			}
		});
		
		JLabel label_4 = new JLabel("AC / NON-AC");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(717, 238, 97, 14);
		contentPane.add(label_4);
		
		JComboBox uac = new JComboBox();	// ufrom for ac/non-ac
		uac.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		uac.addItem("ac");
		uac.addItem("non-ac");
		uac.setSelectedItem(null);
		uac.setEditable(false);
		uac.setBounds(717, 263, 193, 33);
		contentPane.add(uac);
		
		JLabel label_5 = new JLabel("NO. OF PERSONS (max 20)");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(409, 429, 143, 14);
		contentPane.add(label_5);
		
		JLabel lblDateOfOnward = new JLabel("DATE OF ONWARD JORNEY");
		lblDateOfOnward.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfOnward.setBounds(409, 341, 150, 14);
		contentPane.add(lblDateOfOnward);
		
		JLabel lblUserid = new JLabel("USER-ID(Phone Number)");
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserid.setBounds(99, 341, 165, 14);
		contentPane.add(lblUserid);
		
		pno = new JTextField();		//textfield for return date
		pno.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		pno.setText(para);
		pno.setEditable(false);
		pno.setColumns(10);
		pno.setBounds(99, 368, 193, 33);
		contentPane.add(pno);
		
		JLabel lblBookingId = new JLabel("BOOKING ID :");
		lblBookingId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookingId.setBounds(409, 613, 72, 14);
		contentPane.add(lblBookingId);
		
		ubookid = new JTextField();		//textfield for book_id
		ubookid.setBorder(null);
		String a=Integer.toString(x);
		ubookid.setText(a);
		ubookid.setOpaque(false);
		ubookid.setBackground(new Color(240,240,240));
		ubookid.setColumns(10);
		ubookid.setBounds(491, 611, 156, 19);
		contentPane.add(ubookid);
		
		JButton btnUpdateBooking = new JButton("UPDATE BOOKING");
		btnUpdateBooking.setForeground(Color.WHITE);
		btnUpdateBooking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateBooking.setBackground(new Color(30, 144, 255));
		btnUpdateBooking.setBounds(689, 515, 221, 99);
		contentPane.add(btnUpdateBooking);
		
		JDateChooser odate = new JDateChooser();
		odate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		odate.setDateFormatString("dd MMM , yyyy");
		odate.setBounds(409, 366, 193, 33);
		contentPane.add(odate);
		
		JDateChooser retdate = new JDateChooser();
		retdate.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		retdate.setDateFormatString("dd MMM , yyyy");
		retdate.setBounds(717, 368, 193, 33);
		contentPane.add(retdate);
		
		JComboBox upers = new JComboBox();
		upers.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		upers.setEditable(false);
		upers.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		upers.setBounds(409, 454, 193, 33);
		contentPane.add(upers);
		
		JButton totfare = new JButton("TOTAL FARE");
		totfare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation","root","rupam@123");

				PreparedStatement px=con.prepareStatement("select price from route_price where bfrom=? and bto=? and ac_non_ac=?");
				String val1=ufrom.getSelectedItem().toString();
				String val2=uto.getSelectedItem().toString();
				String val3=uac.getSelectedItem().toString();
				px.setString(1,val1);
				px.setString(2,val2);
				px.setString(3,val3);

				ResultSet rs=px.executeQuery();
				//ResultSetMetaData rsm=rs.getMetaData();
					
					
					while(rs.next())
					{
						 ph = rs.getInt("price");
						
						 if(((JTextField)retdate.getDateEditor().getUiComponent()).getText().equals(""))
							{
							 amt = ph * (Integer.parseInt(upers.getSelectedItem().toString()));							
							 }
						 else
						 {
							 amt = ph * (Integer.parseInt(upers.getSelectedItem().toString())) * 2;
						 }
					}
					
					JOptionPane.showMessageDialog(null, "Per Person price : "+ph+"\nTotal bill : "+amt);
			}
				catch(Exception ae)
				{ 
					System.out.println(ae);
				}
		}
			}
		);
		totfare.setForeground(Color.WHITE);
		totfare.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totfare.setBackground(new Color(30, 144, 255));
		totfare.setBounds(99, 515, 221, 99);
		contentPane.add(totfare);
		
		btnUpdateBooking.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				try
				{

					Class.forName("com.mysql.cj.jdbc.Driver");  
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation","root","rupam@123");
					
					PreparedStatement px=con.prepareStatement("select price from route_price where bfrom=? and bto=? and ac_non_ac=?");
					String val1=ufrom.getSelectedItem().toString();
					String val2=uto.getSelectedItem().toString();
					String val3=uac.getSelectedItem().toString();
					px.setString(1,val1);
					px.setString(2,val2);
					px.setString(3,val3);

					ResultSet rs=px.executeQuery();
					//ResultSetMetaData rsm=rs.getMetaData();
						
						
						while(rs.next())
						{
							 ph = rs.getInt("price");
							
							 if(((JTextField)retdate.getDateEditor().getUiComponent()).getText().equals(""))
								{
								 amt = ph * (Integer.parseInt(upers.getSelectedItem().toString()));							
								 }
							 else
							 {
								 amt = ph * (Integer.parseInt(upers.getSelectedItem().toString())) * 2;
							 }
						}
				
					PreparedStatement ps=con.prepareStatement("update new_bus_booking set bfrom=?,bto=?,ac_non_ac=?,no_of_persons=?,bdate=?,rdate=?,total_bill=? where book_id=? and phone_no=?");
						//7 ?marks
					String fromvalue=ufrom.getSelectedItem().toString();
					String tovalue=uto.getSelectedItem().toString();
					String acvalue=uac.getSelectedItem().toString();
					String odateval = ((JTextField)odate.getDateEditor().getUiComponent()).getText();
					String retdateval = ((JTextField)retdate.getDateEditor().getUiComponent()).getText();
					String persons=upers.getSelectedItem().toString();
					
					ps.setString(1,fromvalue); 
					ps.setString(2,tovalue);
					ps.setString(3,acvalue);
					ps.setString(4,persons);
					ps.setString(5,odateval);
					ps.setString(6, retdateval);
					ps.setInt(7,amt);
					ps.setInt(8,x);
					ps.setString(9,para);
					
					int x=ps.executeUpdate();
					if(x>0) 
					{
						JOptionPane.showMessageDialog(null, "Updation Successful!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Updation Unsuccessful!");
						
					}
					
					con.close();
					homepage ob=new homepage(para);
					ob.setVisible(true);
					setVisible(false);
				}
				
				catch(Exception ae)
				{
					System.out.println(ae);
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 564, 1033, 10);
		contentPane.add(panel_2);
		
		JLabel label_6 = new JLabel("DATE OF RETURN  JOURNEY");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(717, 341, 165, 14);
		contentPane.add(label_6);
		
	}
}

