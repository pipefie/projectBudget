package graphic;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Start {

	/**
	 * 
	 */

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Budget App");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 730, 460);
		
		JPanel panel_gray = new JPanel();
		panel_gray.setBackground(UIManager.getColor("CheckBox.light"));
		panel_gray.setBounds(10, 11, 321, 399);
		frame.getContentPane().add(panel_gray);
		
		try {
			BufferedImage logoBudgetApp = ImageIO.read(new File("C:\\personal_budget\\budgeting-high-resolution-logo-white-on-black-background.png"));
			Image logoReSize = logoBudgetApp.getScaledInstance(300, 390, Image.SCALE_SMOOTH);
			JLabel labelLogo = new JLabel(new ImageIcon(logoReSize));
			labelLogo.setBounds(12,15,300,390);
			panel_gray.add(labelLogo);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		Button button_signup = new Button("Sign Up");
		button_signup.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button_signup.setBackground(Color.GRAY);
		button_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUpWindow = new SignUp();
				signUpWindow.setVisible(true);
				frame.setVisible(false);
	
			}
		});
		button_signup.setBounds(545, 373, 75, 22);
		frame.getContentPane().add(button_signup);
		

		Button button_login = new Button("Log In");
		button_login.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button_login.setBackground(Color.GRAY);
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_login.setBounds(400, 210, 62, 22);
		frame.getContentPane().add(button_login);
		
		JLabel label_email = new JLabel("Email");
		label_email.setForeground(Color.WHITE);
		label_email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_email.setBackground(Color.BLACK);
		label_email.setBounds(400, 68, 62, 22);
		frame.getContentPane().add(label_email);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_email.setBounds(400, 35, 220, 22);
		frame.getContentPane().add(textField_email);
		textField_email.setColumns(10);
		
		JLabel label_password = new JLabel("Password");
		label_password.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_password.setForeground(Color.WHITE);
		label_password.setBounds(400, 172, 75, 22);
		frame.getContentPane().add(label_password);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		passwordField.setBounds(400, 139, 220, 22);
		frame.getContentPane().add(passwordField);
		
		JLabel label_noAccount = new JLabel("Don´t have account?");
		label_noAccount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_noAccount.setForeground(Color.WHITE);
		label_noAccount.setBounds(400, 373, 131, 22);
		frame.getContentPane().add(label_noAccount);
		
		
		/*
		 * continuar aprendiendo a usar windowbuilder:
		 * https://www.eclipse.org/windowbuilder/#:~:text=WindowBuilder%20is%20composed%20of%20SWT,will%20be%20generated%20for%20you.
		 * https://documentation.basis.cloud/BASISHelp/WebHelp/eclipse-bdt/Getting_Started/Creating_a_WindowBuilder_Project.htm
		 * https://www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html
		 */
	}
}