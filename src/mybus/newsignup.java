package mybus;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class newsignup extends JFrame {

	private JPanel contentPane;
	private JTextField phn;
	private JTextField eml;
	private JPasswordField pw;
	private JTextField nm;
	private JTextField gnd;
	private JRadioButton male,female;
	private ButtonGroup buttonGroup;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newsignup frame = new newsignup();
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
	public newsignup() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 690);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("NAME");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(670, 70, 86, 14);
		contentPane.add(label);
		
		nm = new JTextField();
		nm.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		nm.setColumns(10);
		nm.setBounds(670, 95, 193, 33);
		contentPane.add(nm);
		
		JLabel lblUsername = new JLabel("PHONE NUMBER");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(670, 139, 86, 14);
		contentPane.add(lblUsername);

		phn = new JTextField();	//phn JTextField
		phn.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		phn.setBounds(670, 164, 193, 33);
		contentPane.add(phn);
		phn.setColumns(10);
				
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(670, 208, 86, 14);
		contentPane.add(lblEmail);

		eml = new JTextField();	//eml JTextField
		eml.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		eml.setColumns(10);
		eml.setBounds(670, 233, 193, 33);
		contentPane.add(eml);		
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(670, 294, 86, 14);
		contentPane.add(lblPassword);
				
		pw = new JPasswordField();
		pw.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51), new Color(0, 51, 51)));
		pw.setBounds(670, 319, 193, 33);
		contentPane.add(pw);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(669, 382, 46, 14);
		contentPane.add(lblGender);

		male=new JRadioButton("male");
		male.setActionCommand("male");			//it is for "male" value which is put into the database...
		male.setBounds(670, 407, 100, 33);
		contentPane.add(male);
		male.setSelected(true);
		
		female=new JRadioButton("female");
		female.setActionCommand("female");		//it is for "female" value which is put into the database...
		female.setBounds(800, 407, 100, 33);
		contentPane.add(female);
		
		buttonGroup=new ButtonGroup();
		buttonGroup.add(male);
		buttonGroup.add(female);
		
		/*gnd = new JTextField();
		gnd.setColumns(10);
		gnd.setBounds(670, 407, 193, 33);
		contentPane.add(gnd);
		*/
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try{ 
					if(nm.getText().equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(null, "Name field is empty");
						newsignup ns = new newsignup();
						ns.setVisible(true);
						setVisible(false);
					}
					else if(phn.getText().equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(null, "Phone Number field is empty");
						newsignup ns = new newsignup();
						ns.setVisible(true);
						setVisible(false);
					}
					else if(eml.getText().equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(null, "Email field is empty");
						newsignup ns = new newsignup();
						ns.setVisible(true);
						setVisible(false);
					}
					else if(pw.getText().equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(null, "Password is empty");
						newsignup ns = new newsignup();
						ns.setVisible(true);
						setVisible(false);
					}
					else 
					{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_ticket_reservation","root","rupam@123");
					
					Statement stmt=con.createStatement();
					PreparedStatement ps = con.prepareStatement("insert into new_sign_up values (?,?,?,?,?)");
					
					String gender=buttonGroup.getSelection().getActionCommand();	//get value from radiobutton....
					
					System.out.println(gender);
					ps.setString(1, nm.getText());
					ps.setString(2, phn.getText());
					ps.setString(3, eml.getText());
					ps.setString(4, pw.getText());
					ps.setString(5, gender);
					
					int x = ps.executeUpdate();
					
					if(x>0) 
					{
						JOptionPane.showMessageDialog(null, "SignUp Successful!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "SignUp Unsuccessful!");
						
					}
					
					con.close();  
					logindetails ld = new logindetails();
					ld.setVisible(true);
					setVisible(false);
					}
				}
				catch(Exception ae)
				{ 
					System.out.print(ae);
				}
				
				//here,following 3 lines for redirecting to logindetals page... 
				
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBackground(new Color(30, 144, 255));
		btnRegister.setBounds(670, 476, 221, 99);
		contentPane.add(btnRegister);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 499, 668);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("YOUR BUS");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Bahnschrift", Font.BOLD, 53));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(118, 407, 285, 66);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(newsignup.class.getResource("/buspic/1473314599.jpg")));
		label_2.setBounds(118, 62, 256, 351);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(0, 96, 499, 170);
		panel.add(panel_1);
		
	}
}
