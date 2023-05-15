package graphic;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JButton;
import personalbudgetingapp.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ExpenseWindow extends JFrame {
	
	private Expenses currentExpense = new Expenses();
	private JPanel contentPane;
	private JTextField amountTextField;
	private Date today = new Date();
	private User currentUser;
	private ArrayList<Account> accountListUser = currentUser.getUserAccounts(); //null pointer piece of shit
	private ArrayList<Expenses> expenseListUser = currentUser.getListExpenses();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpenseWindow frame = new ExpenseWindow();
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
	public ExpenseWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		setResizable(false);
		setTitle("New Expense");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setBackground(new Color(0,0,0));
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setBounds(15, 79, 53, 17);
		amountLabel.setForeground(UIManager.getColor("Button.background"));
		amountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		amountTextField = new JTextField();
		amountTextField.setBounds(15, 103, 110, 22);
		amountTextField.setColumns(10);
		
		JLabel accountLabel = new JLabel("Account");
		accountLabel.setBounds(15, 16, 53, 17);
		accountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		accountLabel.setForeground(UIManager.getColor("Button.background"));
		
		JLabel currencyLabel = new JLabel("Currency");
		currencyLabel.setBounds(135, 81, 45, 15);
		currencyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		currencyLabel.setForeground(UIManager.getColor("Button.background"));
		
		JFormattedTextField formattedCurrencyTextField = new JFormattedTextField();
		formattedCurrencyTextField.setBounds(135, 102, 60, 22);
		formattedCurrencyTextField.setBackground(new Color(105, 105, 105));
		formattedCurrencyTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		MutableComboBoxModel modelAccountBox = new DefaultComboBoxModel<>(accountListUser.toArray(new Account[0]));
		JComboBox<Account> accountComboBox = new JComboBox<>(modelAccountBox);
		accountComboBox.setBounds(15, 39, 196, 22);
		accountComboBox.setSelectedIndex(-1);
		
		JLabel categoryLabel = new JLabel("Category ");
		categoryLabel.setBounds(15, 141, 55, 17);
		categoryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		categoryLabel.setForeground(UIManager.getColor("Button.background"));
		
		MutableComboBoxModel modelCategoryExpense = new DefaultComboBoxModel<>(CategoryofExpense.values());
		JComboBox<CategoryofExpense> categoryComboBox = new JComboBox<>(modelCategoryExpense);
		categoryComboBox.setSelectedIndex(-1);
		
		MutableComboBoxModel<String> subcategoryModel = new DefaultComboBoxModel<>();
		JComboBox subcategoryComboBox = new JComboBox(subcategoryModel);
		subcategoryComboBox.setBounds(15, 222, 150, 22);
		contentPane.add(subcategoryComboBox);
		subcategoryComboBox.setSelectedIndex(-1);
		
		categoryComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				subcategoryComboBox.removeAllItems();
				
				CategoryofExpense selectedCategory = (CategoryofExpense) categoryComboBox.getSelectedItem();
				
				for(String subcategory : selectedCategory.getSubcategories()) {
					subcategoryModel.addElement(subcategory);
				}
				
			}
		});
		categoryComboBox.setBounds(15, 164, 196, 22);
		categoryComboBox.setSelectedIndex(-1);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(175, 201, 38, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		
		SpinnerDateModel modelSpinner = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
		JSpinner spinnerDate = new JSpinner(modelSpinner);
		spinnerDate.setBounds(175, 224, 100, 20);
		spinnerDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinnerDate.setAlignmentY(CENTER_ALIGNMENT);
		
		JTextArea textAreaComments = new JTextArea();
		textAreaComments.setBounds(251, 38, 160, 148);
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
				currentExpense.setAccountofTransaction((Account)modelAccountBox.getSelectedItem());
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAdd.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnAdd.setBounds(339, 226, 72, 23);
		contentPane.add(btnAdd);
		

		
		JLabel lblSubcategory = new JLabel("Subcategory");
		lblSubcategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSubcategory.setForeground(UIManager.getColor("Button.background"));
		lblSubcategory.setBounds(15, 201, 80, 14);
		contentPane.add(lblSubcategory);
		


		
		
	}
}
