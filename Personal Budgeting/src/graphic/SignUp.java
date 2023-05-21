package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import personalbudgetingapp.DataStorage;
import personalbudgetingapp.User;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {
	
	private User usuario;
	private DataStorage data;
	private AccountCreation accountInfo;
	private Start startWindow;


	public SignUp(DataStorage data, Start startWindow) throws HeadlessException {
		super();
		this.data = data;
		this.startWindow = startWindow;
		usuario = new User();
		signUp();
	}


	private static final long serialVersionUID = 6595274993213545359L;
	private JPanel contentPane;


	private void signUp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0));
		setResizable(false);
		setTitle("Sign Up");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.light"));
		panel.setBounds(10, 10, 321, 399);
		getContentPane().add(panel);
		
		try {
			BufferedImage logoBudgetApp = ImageIO.read(new File("C:\\personal_budget\\budgeting-high-resolution-logo-white-on-black-background.png"));
			Image logoReSize = logoBudgetApp.getScaledInstance(300, 390, Image.SCALE_SMOOTH);
			JLabel labelLogo = new JLabel(new ImageIcon(logoReSize));
			labelLogo.setBounds(12,15,300,390);
			panel.add(labelLogo);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JTextField textField_email = new JTextField();
		textField_email.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_email.setBounds(400, 88, 220, 22);
		getContentPane().add(textField_email);
		textField_email.setColumns(10);
		
		
		JLabel label_email = new JLabel("Email");
		label_email.setForeground(Color.WHITE);
		label_email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_email.setBounds(400, 58, 62, 22);
		getContentPane().add(label_email);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		passwordField.setBounds(400, 158, 220, 22);
		getContentPane().add(passwordField);
		
		JLabel label_password = new JLabel("Password");
		label_password.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_password.setForeground(Color.WHITE);
		label_password.setBounds(400, 128, 75, 22);
		getContentPane().add(label_password);
		
		
		JTextField first_name = new JTextField();
		first_name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		first_name.setBounds(400,228,220,22);
		getContentPane().add(first_name);
		
		JLabel label_first_name = new JLabel("First Name");
		label_first_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_first_name.setForeground(Color.white);
		label_first_name.setBounds(400, 198, 75, 22);
		getContentPane().add(label_first_name);
		
		JTextField last_name = new JTextField();
		last_name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		last_name.setForeground(new Color(0, 0, 0));
		last_name.setBounds(400,298,220,22);
		getContentPane().add(last_name);
		
		JLabel label_last_name = new JLabel("Last Name");
		label_last_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_last_name.setForeground(Color.white);
		label_last_name.setBounds(400, 268, 75, 22);
		getContentPane().add(label_last_name);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNext.setEnabled(true);
		

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_email.getText().isEmpty() 
						|| passwordField.getPassword().length == 0 
						|| first_name.getText().isEmpty() || last_name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(SignUp.this, "Please fill in all the required fields.");
		            return; // Stop further execution if validation fails
					
				}
				
				usuario.setEmail(textField_email.getText());
				usuario.setPassword(String.valueOf(passwordField.getPassword()));
				data.addAppUser(textField_email.getText(), passwordField.getPassword().toString());
				
				usuario.setFirstName(first_name.getText());
				usuario.setLasName(last_name.getText());
				
				accountInfo  = new AccountCreation(usuario, data, SignUp.this);
				
				accountInfo.setVisible(true);
				setVisible(false);
				

			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNext.setBounds(615, 387, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startWindow.showWindow();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(341, 386, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}
