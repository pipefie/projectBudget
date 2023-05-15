package graphic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

import javax.swing.border.EmptyBorder;

import personalbudgetingapp.*;
import personalbudgetingapp.Account.AccountType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountCreation extends JFrame {
	
	private User usuario;
	private Account cuentaUser = new Account(); 

	private ArrayList<Expenses> expensesListUser = new ArrayList<>();
	private ArrayList<Income> incomeListUser = new ArrayList<>();
	

	private JPanel contentPane;
	private JTextField accountName;
	private JTextField textFieldCountry;
	
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	private JFormattedTextField startingAmount;
	
	
	

	public AccountCreation(User usuario) throws HeadlessException {
		super();
		this.setUsuario(usuario);
	}
	
	

	public AccountCreation(User usuario, Account cuentaUser) throws HeadlessException {
		super();
		this.usuario = usuario;
		this.cuentaUser = cuentaUser;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCreation frame = new AccountCreation();
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
	public AccountCreation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0));
		contentPane.setLayout(null);
		setResizable(false);
		setTitle("Account Info");
		setContentPane(contentPane);
		
		JPanel panel_gray = new JPanel();
		panel_gray.setBackground(UIManager.getColor("CheckBox.light"));
		panel_gray.setBounds(10, 11, 321, 399);
		contentPane.add(panel_gray);
		
		try {
			BufferedImage logoBudgetApp = ImageIO.read(new File("C:\\personal_budget\\budgeting-high-resolution-logo-white-on-black-background.png"));
			Image logoReSize = logoBudgetApp.getScaledInstance(300, 390, Image.SCALE_SMOOTH);
			JLabel labelLogo = new JLabel(new ImageIcon(logoReSize));
			labelLogo.setBounds(12,15,300,390);
			panel_gray.add(labelLogo);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		JLabel label_currency = new JLabel("Currency");
		label_currency.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_currency.setForeground(Color.white);
		label_currency.setBounds(400, 81, 53, 17);
		getContentPane().add(label_currency);
		
		JRadioButton rdbtnUsd = new JRadioButton("USD");
		rdbtnUsd.setForeground(UIManager.getColor("Button.background"));
		rdbtnUsd.setBackground(UIManager.getColor("Button.focus"));
		rdbtnUsd.setBounds(400, 111, 65, 23);
		contentPane.add(rdbtnUsd);
		
		JRadioButton rdbtnEur = new JRadioButton("EUR");
		rdbtnEur.setForeground(UIManager.getColor("Button.background"));
		rdbtnEur.setBackground(UIManager.getColor("Button.focus"));
		rdbtnEur.setBounds(467, 111, 65, 23);
		contentPane.add(rdbtnEur);
		
		JRadioButton rdbtnCop = new JRadioButton("COP");
		rdbtnCop.setForeground(UIManager.getColor("Button.background"));
		rdbtnCop.setBackground(UIManager.getColor("Button.focus"));
		rdbtnCop.setBounds(534, 111, 65, 23);
		contentPane.add(rdbtnCop);
		
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnCop);
		grupoBotones.add(rdbtnEur);
		grupoBotones.add(rdbtnUsd);
		
		
		JComboBox <AccountType> typesAccount = new JComboBox<AccountType>();
		MutableComboBoxModel modeltypesAccount = new DefaultComboBoxModel<>(Account.AccountType.values());
		typesAccount.setModel(modeltypesAccount); 
		typesAccount.setSelectedIndex(-1);
		typesAccount.setBounds(400, 251, 200, 22);
		contentPane.add(typesAccount);
		
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAccount.setForeground(UIManager.getColor("Button.highlight"));
		lblAccount.setBounds(400, 221, 53, 17);
		contentPane.add(lblAccount);
		
		accountName = new JTextField();
		accountName.setBounds(400, 41, 200, 22);
		contentPane.add(accountName);
		accountName.setColumns(10);
		
		JLabel lblAccountName = new JLabel("Account Name");
		lblAccountName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAccountName.setForeground(UIManager.getColor("Button.highlight"));
		lblAccountName.setBounds(400, 11, 92, 14);
		contentPane.add(lblAccountName);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(400, 181, 200, 22);
		contentPane.add(textFieldCountry);
		textFieldCountry.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCountry.setForeground(UIManager.getColor("Button.highlight"));
		lblCountry.setBounds(400, 151, 65, 17);
		contentPane.add(lblCountry);
		
		
		// here starting amount
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		startingAmount = new JFormattedTextField(numberFormat);
		startingAmount.setColumns(10);
		startingAmount.setBounds(400, 321, 200, 22);
		contentPane.add(startingAmount);
		
		JLabel lblAmount = new JLabel("Starting Amount");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAmount.setBounds(400, 291, 108, 20);
		contentPane.add(lblAmount);
		
		JButton btnSignUp = new JButton("SignUp");
		
		if (accountName.getText().isEmpty() || !rdbtnCop.isSelected() || !rdbtnEur.isSelected() || !rdbtnUsd.isSelected() ||
				textFieldCountry.getText().isEmpty() || startingAmount.getText().isEmpty() ||typesAccount.getSelectedIndex() == -1  ) {
			btnSignUp.setEnabled(false);
		}
		else {
			btnSignUp.setEnabled(true);
		}
		
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuentaUser.setAccountName(accountName.getText());
				
				if (rdbtnCop.isSelected()) {
					cuentaUser.setCurrencyAccount(Currency.getInstance("COP")); 
				}
				else if (rdbtnEur.isSelected()) {
					cuentaUser.setCurrencyAccount(Currency.getInstance("EUR"));
				}
				else if (rdbtnUsd.isSelected()) {
					cuentaUser.setCurrencyAccount(Currency.getInstance("USD"));;
				}
				
				cuentaUser.setCountry(textFieldCountry.getText());
				cuentaUser.setAccountType((AccountType)typesAccount.getSelectedItem());
				String amountnotNumber = startingAmount.getText();
				double amountNumber = 0.0;
				
				try {
					amountNumber = Double.valueOf(amountnotNumber);
					cuentaUser.setStarting_amount(amountNumber);
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,"Invalid input. Please enter valid number, and use period (.) to separate decimals", "Error", JOptionPane.ERROR_MESSAGE );
					startingAmount.setValue(0.0);
					startingAmount.requestFocus();
					}
				usuario.getUserAccounts().add(cuentaUser);
				usuario.setListExpenses(expensesListUser);
				usuario.setListIncome(incomeListUser);
				
				JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnSignUp);
				
				JOptionPane.showMessageDialog(parentFrame, "Successful SignUp", "SignUp Complete", JOptionPane.INFORMATION_MESSAGE);
				
				MainWindow mainApp = new MainWindow(usuario);
				mainApp.setVisible(true);
				setVisible(false);
				
				
				
			}
		});
		btnSignUp.setBounds(615, 387, 89, 23);
		contentPane.add(btnSignUp);
		
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}
