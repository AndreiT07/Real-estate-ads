package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginPage extends JFrame {
	private JTextField edtUsername;
	private JPasswordField edtPassword;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		getContentPane().setForeground(Color.ORANGE);
		getContentPane().setBackground(Color.YELLOW);
		setTitle("Login");
		setBounds(100, 100, 350, 274);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 51, 122, 16);
		getContentPane().add(lblNewLabel);
		
		edtUsername = new JTextField();
		edtUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		edtUsername.setBounds(177, 48, 116, 22);
		getContentPane().add(edtUsername);
		edtUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(43, 103, 102, 16);
		getContentPane().add(lblNewLabel_1);
		
		edtPassword = new JPasswordField();
		edtPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		edtPassword.setBounds(177, 103, 116, 22);
		getContentPane().add(edtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				try{
					con = Db.mycon();
					String username = edtUsername.getText();
					char[] pass = edtPassword.getPassword();
					String password = new String(pass);
					Statement stm = con.createStatement();			
					//String sql = "select * from Login where username='"+username+"'and Password='"+password+"'";
					String sql="SELECT *FROM Login where username=? AND Password=?";
					//ResultSet rs = stm.executeQuery(sql);
					//System.out.println(username+password);
					pst = con.prepareCall(sql);
					pst.setString(1,username);
					pst.setString(2,password);
					rs=pst.executeQuery();
					if(rs.next()){
						//if username and password are true than go to home page
						JOptionPane.showMessageDialog( null, "Login was sucessful");
						dispose();//close login
						HomePage hpage = new HomePage();
						hpage.setVisible(true);
						//hpage.show();
						hpage.setLocationRelativeTo(null); 
						hpage.WLCLabel.setText("Welcome "+username+"!");
						System.out.println("Conectat");
						
					}else{
						//if username or password are wrong
						JOptionPane.showMessageDialog(null, "username or password wrong..");
						edtUsername.setText("");
						edtPassword.setText("");
					}
					
				}catch(Exception e2){
					JOptionPane.showInternalMessageDialog(null, "username or password wrong..");
					System.out.println(e2.getMessage());
					System.out.println("NeConectat");
					
				
				}
			}
			
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(0, 176, 97, 42);
		getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edtUsername.setText("");
				edtPassword.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(235, 176, 97, 42);
		getContentPane().add(btnReset);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Register().setVisible(true);
				dispose();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegister.setBounds(109, 176, 114, 42);
		getContentPane().add(btnRegister);

	}

	public JTextField getEdtUsername() {
		return edtUsername;
	}

	public JPasswordField getEdtPassword() {
		return edtPassword;
	}
}
