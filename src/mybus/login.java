package mybus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import keeptoo.KGradientPanel;
import javax.swing.JTextArea;

public class login extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					login frame = new login();
					frame.setVisible(true);
					frame.setResizable(false);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 690);
		
		contentPane = new JPanel();	//contentPane jpanel
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.kGradientFocus = 600;
		gradientPanel.kStartColor = SystemColor.textHighlight;
		gradientPanel.kEndColor = SystemColor.control;
		gradientPanel.setkGradientFocus(600);
		gradientPanel.setkEndColor(SystemColor.control);
		gradientPanel.setkStartColor(new Color(0, 51, 51));
		gradientPanel.setBounds(0, 0, 879, 661);
		contentPane.add(gradientPanel);
		gradientPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(166, 338, 221, 99);
		gradientPanel.add(btnNewButton);
		//event handler for user login button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logindetails ld = new logindetails();
				ld.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(30, 144, 255));
		
		JButton btnSignup = new JButton("SIGN-UP");
		btnSignup.setBounds(499, 338, 221, 99);
		gradientPanel.add(btnSignup);
		//adding event handler for new user signup
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newsignup ns = new newsignup();
				ns.setVisible(true);
				setVisible(false);
				
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setBackground(new Color(30, 144, 255));
		
		JLabel lblNewLabel = new JLabel("TRAVEL . BOOKINGS . AND MORE ...");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 572, 515, 78);
		gradientPanel.add(lblNewLabel);
		
		JLabel lblYourBus = new JLabel("YOUR BUS !");
		lblYourBus.setForeground(new Color(255, 255, 255));
		lblYourBus.setFont(new Font("Impact", Font.PLAIN, 70));
		lblYourBus.setBackground(new Color(255, 255, 255));
		lblYourBus.setBounds(10, 523, 303, 62);
		gradientPanel.add(lblYourBus);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/buspic/1473314599.jpg")));
		lblNewLabel_1.setBounds(313, 11, 254, 240);
		gradientPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		//lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/buspic/images (3).jpg")));
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/buspic/xyz.jpg")).getImage().getScaledInstance(1021, 690, Image.SCALE_SMOOTH)));
		lblNewLabel_2.setBounds(0, 0, 879, 682);
		gradientPanel.add(lblNewLabel_2);
		
	}
}
