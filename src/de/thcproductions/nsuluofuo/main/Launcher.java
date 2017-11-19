package de.thcproductions.nsuluofuo.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Launcher {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private Game game;
	static String adress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
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
	public Launcher() {
		initialize();
		game = new Game("NSULUOFUO", 640, 480);
		adress = textField_1.getText();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 262);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.start();
			}
		});
		btnNewButton.setBounds(335, 189, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(335, 122, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(335, 36, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(335, 11, 60, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(335, 67, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(335, 92, 89, 22);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPlayer = new JLabel("> Player1 <");
		lblPlayer.setBounds(335, 164, 89, 14);
		frame.getContentPane().add(lblPlayer);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 315, 167);
		frame.getContentPane().add(textPane);
		
		JLabel lblServeradress = new JLabel("Serveradress:");
		lblServeradress.setBounds(10, 193, 68, 14);
		frame.getContentPane().add(lblServeradress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 190, 237, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
