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

import personalbudgetingapp.DataStorage;
import personalbudgetingapp.User;

public class Start {

	/**
	 * 
	 */

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField_email;
	private DataStorage data;
	private SignUp signUpWindow;

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
		data = new DataStorage();
		try {
			data.readdDataUsers();
			data.readDataCredentials(); 
		} catch (Exception e) {
			System.err.println("Data file not found. Starting with an empty DataStorage object.");
			e.printStackTrace();
		}
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
		button_signup.setForeground(UIManager.getColor("Button.background"));
		button_signup.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button_signup.setBackground(Color.GRAY);
		button_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				signUpWindow = new SignUp(data, Start.this);
				signUpWindow.setVisible(true);
			}
		});
		button_signup.setBounds(545, 373, 75, 22);
		frame.getContentPane().add(button_signup);
		

		Button button_login = new Button("Log In");
		button_login.setForeground(UIManager.getColor("Button.background"));
		button_login.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button_login.setBackground(UIManager.getColor("Button.darkShadow"));
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String userEmail = textField_email.getText();
					char[] userPasswordChar = passwordField.getPassword();
					String userPassword = new String(userPasswordChar);
					if (data.checkCredentials(userEmail, userPassword)) {
						User usuario = data.getUser(userEmail);
						MainWindow mainWindow = new MainWindow(usuario, data, Start.this);
						mainWindow.setVisible(true);
						mainWindow.updateExpenseList(usuario.getListExpenses());
						mainWindow.updateIncomeList(usuario.getListIncome());
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(frame, "Invalid email or password");
					}
				
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
		
		
	}
	
	public void showWindow () {
		frame.setVisible(true);
	}
	
}
