package graphic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import personalbudgetingapp.Account;
import personalbudgetingapp.CategoryofIncome;
import personalbudgetingapp.Income;
import personalbudgetingapp.User;
import java.util.Currency;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IncomeWindow extends JFrame {
	private Income currentIncome = new Income();
	private User usuario;
	private ArrayList<Account> userAccounts = usuario.getUserAccounts();
	private ArrayList<Income> incomeListUser = usuario.getListIncome();
	private JPanel contentPane;
	private Date today = new Date();
	
	

	public IncomeWindow(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public IncomeWindow(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public IncomeWindow(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	

	public IncomeWindow(User usuario) throws HeadlessException {
		super();
		this.usuario = usuario;
	}

	public IncomeWindow(User usuario, Date today) throws HeadlessException {
		super();
		this.usuario = usuario;
		this.today = today;
	}

	public IncomeWindow(Income income, User usuario, Date today) throws HeadlessException {
		super();
		this.currentIncome = income;
		this.usuario = usuario;
		this.today = today;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeWindow frame = new IncomeWindow();
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
	public IncomeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setTitle("New Income");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
getContentPane().setBackground(new Color(0,0,0));
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setBounds(15, 79, 53, 17);
		amountLabel.setForeground(UIManager.getColor("Button.background"));
		amountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		
		JTextField amountTextField = new JTextField();
		amountTextField.setBounds(15, 103, 118, 22);
		amountTextField.setColumns(10);
		
		JLabel accountLabel = new JLabel("Account");
		accountLabel.setBounds(15, 16, 53, 17);
		accountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		accountLabel.setForeground(UIManager.getColor("Button.background"));
		
		JLabel currencyLabel = new JLabel("Currency");
		currencyLabel.setBounds(151, 81, 45, 15);
		currencyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		currencyLabel.setForeground(UIManager.getColor("Button.background"));
		
		
		MutableComboBoxModel modelAccountsBox = new DefaultComboBoxModel<>(userAccounts.toArray(new Account[0]));
		JComboBox<Account> accountComboBox = new JComboBox<>(modelAccountsBox);
		accountComboBox.setBounds(15, 39, 196, 22);
		modelAccountsBox.setSelectedItem(-1);
		
		JFormattedTextField formattedCurrencyTextField = new JFormattedTextField();
		formattedCurrencyTextField.setBounds(151, 102, 60, 22);
		formattedCurrencyTextField.setBackground(new Color(105, 105, 105));
		formattedCurrencyTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Currency currencyAccount = usuario.getUserAccounts().get(accountComboBox.getSelectedIndex()).getCurrencyAccount();
		formattedCurrencyTextField.setText(currencyAccount.toString());

		JLabel categoryLabel = new JLabel("Category ");
		categoryLabel.setBounds(15, 141, 55, 17);
		categoryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		categoryLabel.setForeground(UIManager.getColor("Button.background"));
		
		MutableComboBoxModel modelCategoryBox = new DefaultComboBoxModel<>(CategoryofIncome.values());
		JComboBox<CategoryofIncome> categoryComboBox = new JComboBox<>(modelCategoryBox);
		categoryComboBox.setBounds(15, 164, 196, 22);
		categoryComboBox.setSelectedIndex(-1);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(15, 204, 38, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		
		SpinnerDateModel modelSpinner = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
		JSpinner spinnerDate = new JSpinner(modelSpinner);
		spinnerDate.setBounds(15, 227, 118, 20);
		spinnerDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinnerDate.setAlignmentY(CENTER_ALIGNMENT);
		
		JTextArea textAreaComments = new JTextArea();
		textAreaComments.setBounds(251, 38, 160, 177);
		textAreaComments.setLineWrap(true);
		
		JLabel lblNewLabel_1 = new JLabel("Comments");
		lblNewLabel_1.setBounds(251, 16, 62, 17);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(UIManager.getColor("Button.background"));
		contentPane.setLayout(null);
		contentPane.add(amountLabel);
		contentPane.add(currencyLabel);
		contentPane.add(amountTextField);
		contentPane.add(formattedCurrencyTextField);
		contentPane.add(categoryLabel);
		contentPane.add(categoryComboBox);
		contentPane.add(lblNewLabel);
		contentPane.add(accountComboBox);
		contentPane.add(spinnerDate);
		contentPane.add(accountLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textAreaComments);
		
		JButton btnAdd = new JButton("Add");
		
		if(accountComboBox.getSelectedIndex()==-1 || amountTextField.getText().isEmpty() || categoryComboBox.getSelectedIndex()==-1) {
			btnAdd.setEnabled(false);
		}
		else {
			btnAdd.setEnabled(true);
		}
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIncome.setAccountofTransaction((Account)modelAccountsBox.getSelectedItem());
				currentIncome.setAmountofTransaction(Double.valueOf(amountTextField.getText()));
				currentIncome.setCurrencyofTransaction((Currency)((Account) modelAccountsBox.getSelectedItem()).getCurrencyAccount());
				currentIncome.setCategory((CategoryofIncome)modelCategoryBox.getSelectedItem());
				Date selectedDate = (Date)modelSpinner.getValue();
				GregorianCalendar selectedCalendar = new GregorianCalendar();
				selectedCalendar.setTime(selectedDate);
				currentIncome.setDateofTransaction(selectedCalendar);
				try {
					currentIncome.setComments(textAreaComments.getText());
				} catch (NullPointerException e2) {
					currentIncome.setComments(null);
				}
				incomeListUser.add(currentIncome);
				
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAdd.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnAdd.setBounds(339, 226, 72, 23);
		contentPane.add(btnAdd);
	}

}
