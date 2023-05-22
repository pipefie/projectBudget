package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import personalbudgetingapp.Account;
import personalbudgetingapp.DataStorage;
import personalbudgetingapp.Expenses;
import personalbudgetingapp.Income;
import personalbudgetingapp.Transaction;
import personalbudgetingapp.User;
import java.awt.HeadlessException;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListModel;
import javax.swing.MutableComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextArea;



public class MainWindow extends JFrame {

	private JPanel contentPane;
	private User usuario;
	private ArrayList<Income> incomeListUser;
	private ArrayList<Expenses> expenseListUser;
	private NewAccount accountWindow ;
	private DataStorage data;
	private JList<Expenses> expenseList;
	private DefaultListModel<Expenses> modelExpenseList = new DefaultListModel<>();
	private JList<Income> incomeList;
	private DefaultListModel<Income> modelIncomeList = new DefaultListModel<>();
	private Start startWindow;
	private JButton btnDelete;
	private JButton btnModify;
	//variable to track the JList selected
	private String selectedList;

	public MainWindow(User usuario, DataStorage data) throws HeadlessException {
		super();
		this.usuario = usuario;
		this.data = data;
		incomeListUser = usuario.getListIncome();
		expenseListUser= usuario.getListExpenses();
		mainWindow();
	}
	

	/**
	 * @wbp.parser.constructor
	 */
	public MainWindow(User usuario, DataStorage data, Start startWindow) throws HeadlessException {
		super();
		this.usuario = usuario;
		this.data = data;
		this.startWindow = startWindow;
		mainWindow();
	}

	private void mainWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 740, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(0,0,0));
		contentPane.setLayout(null);
		setTitle("Main Page");
		setResizable(false);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(51, 51, 51));
		panelInfo.setBounds(424, 130, 290, 240);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		
		JTextArea textAreaDetails = new JTextArea();
		textAreaDetails.setBounds(10, 11, 270, 218);
		textAreaDetails.setLineWrap(true);
		textAreaDetails.setEditable(false);
		panelInfo.add(textAreaDetails);
		
		JLabel lblNameCurrentUser = new JLabel("Welcome "+ usuario.getFirstName());
		lblNameCurrentUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNameCurrentUser.setForeground(new Color(0, 0, 0));
		lblNameCurrentUser.setBounds(569, 11, 135, 23);
		contentPane.add(lblNameCurrentUser);
		lblNameCurrentUser.setForeground(new Color(51,51,51));
		
		
		JButton btnIncome = new JButton("Income");
		btnIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IncomeWindow incomeWindow = new IncomeWindow(null, usuario, MainWindow.this, data);
				incomeWindow.setVisible(true);
			}
		});
		btnIncome.setBounds(310, 130, 100, 23);
		contentPane.add(btnIncome);
		
		JButton btnExpense = new JButton("Expense");
		btnExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExpenseWindow newExpense = new ExpenseWindow(MainWindow.this, null, usuario, data);
				newExpense.setVisible(true);
				setVisible(false);
			}
		});
		btnExpense.setBounds(310, 80, 100, 23);
		contentPane.add(btnExpense);
		
		JButton btnDetails = new JButton("Details");

		btnDetails.setBounds(625, 387, 89, 23);
		contentPane.add(btnDetails);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(310, 230, 100, 23);
		contentPane.add(btnDelete);
		
		btnModify = new JButton("Modify");
		btnModify.setBounds(310, 180, 100, 23);
		contentPane.add(btnModify);
		
		MutableComboBoxModel modelAccounts = new DefaultComboBoxModel<>(usuario.getUserAccounts().toArray());
		JComboBox <Account> comboBoxAccounts = new JComboBox<Account>(modelAccounts);
		comboBoxAccounts.setBackground(new Color(128, 128, 128));
		comboBoxAccounts.setBounds(420, 68, 200, 23);
		comboBoxAccounts.setSelectedIndex(-1);
		
		
		JPanel panelAccount = new JPanel(new BorderLayout());
		JLabel labelAccounts = new JLabel("Account");
		labelAccounts.setBackground(UIManager.getColor("Button.darkShadow"));
		labelAccounts.setHorizontalAlignment(SwingConstants.CENTER);
		labelAccounts.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelAccounts.setForeground(UIManager.getColor("Button.focus"));
		labelAccounts.setBounds(420, 34, 80, 20);
		panelAccount.add(labelAccounts,BorderLayout.NORTH);
		panelAccount.add(comboBoxAccounts,BorderLayout.CENTER);
		panelAccount.setBounds(420, 45, 290, 43);
		contentPane.add(panelAccount);

		JPanel panelExpenseList = new JPanel(new BorderLayout());
		JLabel labelExpense = new JLabel("Expenses");
		labelExpense.setHorizontalAlignment(SwingConstants.CENTER);
		labelExpense.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panelExpenseList.add(labelExpense, BorderLayout.NORTH);

		if (expenseListUser!=null) { //null pointer piece of shit
			for (Expenses transaction : expenseListUser) {
				modelExpenseList.addElement(transaction);
			}
		}
	
		
		
		//expense list
		expenseList = new JList<Expenses>(modelExpenseList);
		expenseList.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==1) {
					expenseList.clearSelection();
				}
				else if(e.getClickCount()==2) {
					int index = expenseList.locationToIndex(e.getPoint());
					expenseList.setSelectedIndex(index);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		expenseList.setBounds(10, 34, 290, 155);
		expenseList.setBackground(UIManager.getColor("Button.highlight"));
		panelExpenseList.add(new JScrollPane(expenseList), BorderLayout.CENTER);
		
		
		JPanel panelIncomeList = new JPanel(new BorderLayout());
		JLabel labelIncome = new JLabel("Incomes");
		labelIncome.setHorizontalAlignment(SwingConstants.CENTER);
		labelIncome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panelIncomeList.add(labelIncome, BorderLayout.NORTH);
		
		
		if (incomeListUser!=null) {
			for (Income transaction : incomeListUser ) {
				modelIncomeList.addElement(transaction);
			}
		}
		
		//income list
		incomeList = new JList<Income>(modelIncomeList);
		incomeList.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==1) {
					incomeList.clearSelection();
				}
				else if (e.getClickCount()==2) {
					int index = incomeList.locationToIndex(e.getPoint());
					incomeList.setSelectedIndex(index);
				}
				
			}
		});
		incomeList.setBackground(UIManager.getColor("Button.highlight"));
		incomeList.setBounds(10, 215, 290, 155);
		panelIncomeList.add(new JScrollPane(incomeList), BorderLayout.CENTER);
		
		getContentPane().add(panelIncomeList);
		getContentPane().add(panelExpenseList);
		
		panelExpenseList.setBounds(10, 34, 290, 155);
		panelIncomeList.setBounds(10, 215, 290, 155);
		
		//listener for the income and expense list
		
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if(e.getSource() == expenseList) {
						selectedList = "expense";
					}
					else if (e.getSource() == incomeList) {
						selectedList = "income";
					}
					
					int selectedCount = expenseList.getSelectedIndices().length + incomeList.getSelectedIndices().length;
					btnModify.setEnabled(selectedCount == 1);
					btnDelete.setEnabled(selectedCount > 0);
					btnDetails.setEnabled((selectedCount == 1 && comboBoxAccounts.getSelectedIndex()==-1) 
							|| (selectedCount == 0 && comboBoxAccounts.getSelectedIndex()!=-1) );
				
				}
			}
		};
		
		expenseList.addListSelectionListener(listSelectionListener);
		incomeList.addListSelectionListener(listSelectionListener);
		
		//listeners to delete and modify
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * delete the transaction from the list user, from the data and from the GUI
				 * corresponding list
				 */
				List<Income> selectedIncomes = incomeList.getSelectedValuesList();
				List<Expenses> selectedExpenses = expenseList.getSelectedValuesList();
				
				int confirmDialog = JOptionPane.showConfirmDialog(MainWindow.this, 
						"Are you sure you want to delete the selected transaction(s)?", "confirmation", JOptionPane.YES_NO_OPTION);
				
				if (confirmDialog == JOptionPane.YES_OPTION) {
					for (Income income : selectedIncomes) {
						
						usuario.getListIncome().remove(income);
						data.deleteIncome(usuario, income);
						modelIncomeList.removeElement(income);
						
					}
					for (Expenses expense : selectedExpenses) {
						
						usuario.getListExpenses().remove(expense);
						data.deleteExpense(usuario, expense);
						modelExpenseList.removeElement(expense);
						
					}
				}
			}
		});
		
		//modify listener
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (selectedList.equals("expense")) {
					
					ExpenseWindow expenseModify = new ExpenseWindow(MainWindow.this, expenseList.getSelectedValue(),usuario,data);
					expenseModify.setVisible(true);
				}
				else if (selectedList.equals("income")) {
					
					IncomeWindow incomeModify = new IncomeWindow(incomeList.getSelectedValue() ,usuario, MainWindow.this, data);
					incomeModify.setVisible(true);
				}
				
			}
		});
		
		//details listener
		
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (incomeList.isSelectionEmpty() && expenseList.isSelectionEmpty()) {
					textAreaDetails.setText(comboBoxAccounts.getSelectedItem().toString());
				}
				else if (incomeList.isSelectionEmpty() && comboBoxAccounts.getSelectedIndex()==-1) {
					textAreaDetails.setText(expenseList.getSelectedValue().details());
				}
				else if (comboBoxAccounts.getSelectedIndex()==-1 && expenseList.isSelectionEmpty()) {
					textAreaDetails.setText(incomeList.getSelectedValue().details());
				}
				else if (comboBoxAccounts.getSelectedIndex()!=-1 && (!incomeList.isSelectionEmpty()|| !expenseList.isSelectionEmpty())) {
					comboBoxAccounts.setSelectedIndex(-1);
					if(!incomeList.isSelectionEmpty()) {
						textAreaDetails.setText(incomeList.getSelectedValue().details());
					}
					else {
						textAreaDetails.setText(expenseList.getSelectedValue().details());
					}
				}
				
			}
		});

		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				accountWindow = new NewAccount(usuario, data, MainWindow.this);
				accountWindow.setVisible(true);
				setVisible(false);
				
			}
		});
		btnAddAccount.setBounds(310, 320, 100, 23);
		contentPane.add(btnAddAccount);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				data.writeDataUsers();
				data.writeDataCredentials();
				dispose();
				//hacer la salida de la app pero antes cargando todos los datos necesarios al fichero 
				
			}
		});
		btnExit.setBounds(10, 387, 89, 23);
		contentPane.add(btnExit);
		
		
	}
	
	
	public void updateExpenseList(ArrayList<Expenses> expenseListUser) {
		
		modelExpenseList.clear();
		
		for (Expenses expense : expenseListUser) {
			modelExpenseList.addElement(expense);
		}
	}
	
	public void updateIncomeList(ArrayList<Income> incomeListUser) {
		modelIncomeList.clear();
		
		for(Income income : incomeListUser) {
			modelIncomeList.addElement(income);
		}
	}
}
