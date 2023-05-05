package graphic;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 730, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(0,0,0));
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 290, 290);
		contentPane.add(list);
		list.setBackground(new Color(51,51,51));
		
		
		JButton btnNewButton = new JButton("Expense");
		btnNewButton.setBounds(338, 29, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Income");
		btnNewButton_1.setBounds(338, 63, 100, 23);
		contentPane.add(btnNewButton_1);
		setTitle("Main Page");
		setResizable(false);
		
		
		
	}
}
