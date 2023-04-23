package personalbudgetingapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.TextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.Label;
import javax.swing.JTextField;

public class Start {

	private JFrame frame;
	private JFrame frame2;
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(35, 30, 281, 280);
		frame.getContentPane().add(panel);
		
		Button button_signup = new Button("Sign Up");
		button_signup.setBackground(Color.GRAY);
		button_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2 = new JFrame();
				frame2.getContentPane().setBackground(Color.BLACK);
				frame2.getContentPane().setLayout(null);
			}
		});
		button_signup.setBounds(521, 288, 51, 22);
		frame.getContentPane().add(button_signup);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(389, 103, 165, 22);
		frame.getContentPane().add(passwordField);
		
		Button button_login = new Button("Log In");
		button_login.setBackground(Color.GRAY);
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_login.setBounds(389, 206, 43, 22);
		frame.getContentPane().add(button_login);
		
		Label label = new Label("Email");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBackground(Color.BLACK);
		label.setBounds(389, 75, 62, 22);
		frame.getContentPane().add(label);
		
		textField_email = new JTextField();
		textField_email.setBounds(389, 49, 165, 22);
		frame.getContentPane().add(textField_email);
		textField_email.setColumns(10);
		
		Label label_1 = new Label("Password");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(389, 131, 62, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Don´t have account?");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(389, 288, 126, 22);
		frame.getContentPane().add(label_2);
		frame.setBounds(100, 100, 720, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * continuar aprendiendo a usar windowbuilder:
		 * https://www.eclipse.org/windowbuilder/#:~:text=WindowBuilder%20is%20composed%20of%20SWT,will%20be%20generated%20for%20you.
		 * https://documentation.basis.cloud/BASISHelp/WebHelp/eclipse-bdt/Getting_Started/Creating_a_WindowBuilder_Project.htm
		 * https://www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html
		 */
	}
}
