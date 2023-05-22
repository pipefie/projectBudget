package graphic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import personalbudgetingapp.Account;
import personalbudgetingapp.DataStorage;
import personalbudgetingapp.Expenses;
import personalbudgetingapp.Income;
import personalbudgetingapp.User;
import personalbudgetingapp.Account.AccountType;

public class NewAccount extends JFrame {

	private User usuario;
	private Account cuentaUser; 
	private ArrayList<Account> userAccounts;
	private ArrayList<Expenses> expensesListUser;
	private ArrayList<Income> incomeListUser;
	private DataStorage data;
	

	private JPanel contentPane;
	private JTextField accountName;
	private JTextField textFieldCountry;
	private MainWindow mainWindow;
	
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	private JFormattedTextField startingAmount;
	


	public NewAccount(User usuario, DataStorage data, MainWindow mainWindow, Account cuentaUser) throws HeadlessException {
		super();
		this.usuario = usuario;
		this.data = data;
		this.mainWindow = mainWindow;
		this.cuentaUser = cuentaUser;
		userAccounts = usuario.getUserAccounts(); //encontrar duplicado de account
		
		
		accountCreation();
	}


	private void accountCreation() {
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
		label_currency.setBounds(417, 95, 53, 17);
		getContentPane().add(label_currency);
		
		JRadioButton rdbtnUsd = new JRadioButton("USD");
		rdbtnUsd.setForeground(UIManager.getColor("Button.background"));
		rdbtnUsd.setBackground(UIManager.getColor("Button.focus"));
		rdbtnUsd.setBounds(417, 125, 65, 23);
		contentPane.add(rdbtnUsd);
		
		JRadioButton rdbtnEur = new JRadioButton("EUR");
		rdbtnEur.setForeground(UIManager.getColor("Button.background"));
		rdbtnEur.setBackground(UIManager.getColor("Button.focus"));
		rdbtnEur.setBounds(484, 125, 65, 23);
		contentPane.add(rdbtnEur);
		
		JRadioButton rdbtnCop = new JRadioButton("COP");
		rdbtnCop.setForeground(UIManager.getColor("Button.background"));
		rdbtnCop.setBackground(UIManager.getColor("Button.focus"));
		rdbtnCop.setBounds(551, 125, 65, 23);
		contentPane.add(rdbtnCop);
		
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(rdbtnCop);
		grupoBotones.add(rdbtnEur);
		grupoBotones.add(rdbtnUsd);
		
		
		JComboBox <AccountType> typesAccount = new JComboBox<AccountType>();
		MutableComboBoxModel modeltypesAccount = new DefaultComboBoxModel<>(Account.AccountType.values());
		typesAccount.setModel(modeltypesAccount); 
		typesAccount.setSelectedIndex(-1);
		typesAccount.setBounds(417, 265, 200, 22);
		contentPane.add(typesAccount);
		
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAccount.setForeground(UIManager.getColor("Button.highlight"));
		lblAccount.setBounds(417, 235, 53, 17);
		contentPane.add(lblAccount);
		
		accountName = new JTextField();
		accountName.setBounds(417, 55, 200, 22);
		contentPane.add(accountName);
		accountName.setColumns(10);
		
		JLabel lblAccountName = new JLabel("Account Name");
		lblAccountName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAccountName.setForeground(UIManager.getColor("Button.highlight"));
		lblAccountName.setBounds(417, 25, 92, 14);
		contentPane.add(lblAccountName);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(417, 195, 200, 22);
		contentPane.add(textFieldCountry);
		textFieldCountry.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCountry.setForeground(UIManager.getColor("Button.highlight"));
		lblCountry.setBounds(417, 165, 65, 17);
		contentPane.add(lblCountry);
		
		
		// here starting amount
		numberFormat.setMinimumFractionDigits(0);
		numberFormat.setMaximumFractionDigits(2);
		startingAmount = new JFormattedTextField(numberFormat);
		startingAmount.setColumns(10);
		startingAmount.setBounds(417, 335, 200, 22);
		contentPane.add(startingAmount);
		
		JLabel lblAmount = new JLabel("Starting Amount");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAmount.setBounds(417, 305, 108, 20);
		contentPane.add(lblAmount);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setEnabled(true);
		
		if (cuentaUser == null) {
			cuentaUser = new Account();
		}
		else {
			accountName.setText(cuentaUser.getAccountName());
			if (cuentaUser.getCurrencyAccount().getCurrencyCode().equals("USD")) {
				rdbtnUsd.doClick();
			}
			else if (cuentaUser.getCurrencyAccount().getCurrencyCode().equals("EUR")) {
				rdbtnEur.doClick();
			}
			else if (cuentaUser.getCurrencyAccount().getCurrencyCode().equals("COP")) {
				rdbtnCop.doClick();
			}
			textFieldCountry.setText(cuentaUser.getCountry());
			typesAccount.setSelectedItem(cuentaUser.getAccountType());
			startingAmount.setText(String.valueOf(cuentaUser.getStarting_amount()));
		}
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (usuario.getUserAccounts().contains(cuentaUser)) {
					userAccounts.remove(cuentaUser);
				}
				
				if (accountName.getText().isEmpty() || (!rdbtnCop.isSelected() && !rdbtnEur.isSelected() && !rdbtnUsd.isSelected()) ||
				textFieldCountry.getText().isEmpty() || startingAmount.getText().isEmpty() ||typesAccount.getSelectedIndex() == -1  ) {
					JOptionPane.showMessageDialog(NewAccount.this, "Please fill in all the required fields.");
		            return;
				}
				
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
				userAccounts.add(cuentaUser);
				mainWindow.setVisible(true);
				mainWindow.updateAccountBox(userAccounts);
	
				dispose();
				
				
			}
		});
		btnAdd.setBounds(615, 387, 89, 23);
		contentPane.add(btnAdd );
		
		JButton btnBack = new JButton("Cancel");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainWindow.setVisible(true);

				dispose();
			}
		});
		btnBack.setBounds(341, 387, 89, 23);
		contentPane.add(btnBack);
		

		
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}
