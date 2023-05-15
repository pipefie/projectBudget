package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import personalbudgetingapp.Expenses;
import personalbudgetingapp.Income;
import personalbudgetingapp.Transaction;
import personalbudgetingapp.User;
import java.awt.HeadlessException;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import org.jfree.chart.*;
import org.jfree.data.*;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private User usuario;
	private ArrayList<Income> incomeListUser = usuario.getListIncome();
	private ArrayList<Expenses> expenseListUser = usuario.getListExpenses();
	
	

	public MainWindow(User usuario) throws HeadlessException {
		super();
		this.usuario = usuario;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(0,0,0));
		contentPane.setLayout(null);
		setTitle("Main Page");
		setResizable(false);
		
		JButton btnIncome = new JButton("Income");
		btnIncome.setBounds(310, 138, 100, 23);
		contentPane.add(btnIncome);
		
		JButton btnExpense = new JButton("Expense");
		btnExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExpense.setBounds(310, 80, 100, 23);
		contentPane.add(btnExpense);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(310, 288, 100, 23);
		contentPane.add(btnDelete);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(310, 231, 100, 23);
		contentPane.add(btnModify);
		
		JPanel panelExpenseList = new JPanel(new BorderLayout());
		JLabel labelExpense = new JLabel("Expenses");
		labelExpense.setHorizontalAlignment(SwingConstants.CENTER);
		labelExpense.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panelExpenseList.add(labelExpense, BorderLayout.NORTH);
		DefaultListModel<Transaction> modelExpenseList = new DefaultListModel<>();
		if (!expenseListUser.isEmpty()) {
			
			for (Expenses transaction : expenseListUser) {
				modelExpenseList.addElement(transaction);
			}
		}
		
		JList<Transaction> expenseList = new JList<Transaction>(modelExpenseList);
		expenseList.setBounds(10, 34, 290, 155);
		expenseList.setBackground(new Color(51,51,51));
		expenseList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int numSelected = expenseList.getSelectedIndices().length;
				btnDelete.setEnabled(numSelected>0);
				btnModify.setEnabled(numSelected == 1);
			}
		});
		
		panelExpenseList.add(new JScrollPane(expenseList), BorderLayout.CENTER);
		
		
		JPanel panelIncomeList = new JPanel(new BorderLayout());
		JLabel labelIncome = new JLabel("Incomes");
		labelIncome.setHorizontalAlignment(SwingConstants.CENTER);
		labelIncome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panelIncomeList.add(labelIncome, BorderLayout.NORTH);
		DefaultListModel<Transaction> modelIncomeList = new DefaultListModel<>();
		
		if (!incomeListUser.isEmpty()) {
			for (Income transaction : incomeListUser ) {
				modelIncomeList.addElement(transaction);
			}
		}
		
		JList<Transaction> incomeList = new JList<Transaction>(modelIncomeList);
		incomeList.setBackground(new Color(51, 51, 51));
		incomeList.setBounds(10, 215, 290, 155);
		incomeList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int numSelected = incomeList.getSelectedIndices().length;
				btnDelete.setEnabled(numSelected>0);
				btnModify.setEnabled(numSelected == 1);
				
			}
		});
		panelIncomeList.add(new JScrollPane(incomeList), BorderLayout.CENTER);
		
		getContentPane().add(panelIncomeList);
		getContentPane().add(panelExpenseList);
		
		panelExpenseList.setBounds(10, 34, 290, 155);
		panelIncomeList.setBounds(10, 215, 290, 155);

		JLabel lblNameCurrentUser = new JLabel("Welcome "+ usuario.getFirstName());
		lblNameCurrentUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNameCurrentUser.setForeground(new Color(0, 0, 0));
		lblNameCurrentUser.setBounds(569, 11, 135, 23);
		contentPane.add(lblNameCurrentUser);
		lblNameCurrentUser.setForeground(new Color(51,51,51));
		
		JPanel panel = new JPanel(new GridLayout(2,2));
		panel.setBounds(420, 34, 290, 336);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Add Account");
		btnNewButton.setBounds(310, 347, 100, 23);
		contentPane.add(btnNewButton);
		
	}
}
