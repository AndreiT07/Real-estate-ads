package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {
	private JTextField juname;
	private JTextField jfname;
	private JTextField jlname;
	private JPasswordField jpass;
	private JTextField jphone;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setBounds(100, 100, 600, 525);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblRegister = new JLabel("Register Form");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegister.setBackground(Color.BLUE);
		lblRegister.setBounds(244, 13, 130, 30);
		getContentPane().add(lblRegister);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Tahoma", Font.BOLD, 18));
		Username.setBounds(41, 78, 100, 20);
		getContentPane().add(Username);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(41, 146, 100, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(41, 216, 100, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(41, 287, 100, 20);
		getContentPane().add(lblNewLabel_3);
		
		juname = new JTextField();
		juname.setBounds(218, 79, 170, 22);
		getContentPane().add(juname);
		juname.setColumns(10);
		
		jfname = new JTextField();
		jfname.setBounds(218, 147, 170, 22);
		getContentPane().add(jfname);
		jfname.setColumns(10);
		
		jlname = new JTextField();
		jlname.setBounds(218, 217, 170, 22);
		getContentPane().add(jlname);
		jlname.setColumns(10);
		
		jpass = new JPasswordField();
		jpass.setBounds(218, 288, 170, 22);
		getContentPane().add(jpass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//register btn code
				String fnam = jfname.getText();
				String lnam = jlname.getText();
				String u_nam = juname.getText();
				String pass = jpass.getText();
				String Phn = jphone.getText();
				//System.out.println(u_nam+pass);
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				try{
				/*	Statement s = (Statement) Db.mycon().createStatement();
					((java.sql.Statement) s).executeUpdate("insert into Login (Username,Password)"
												+ "VALUES ('a','a')");
					
					JOptionPane.showMessageDialog(rootPane,"Your Account Created. Login Now!" );*/
					//Statement stm1 = connection.createStatement();
					Connection con = DriverManager.getConnection(url,"sa","asd123");
					String sql = "INSERT INTO Login (Username, Password, FName,LName,Phone)"
							+ "VALUES(?,?,?,?,?)";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, u_nam);
					statement.setString(2, pass);
					statement.setString(3, fnam);
					statement.setString(4, lnam);
					statement.setString(5, Phn);
					int rows = statement.executeUpdate();
					if(rows>0)
						System.out.println("Row has been inserted.");
				}catch(Exception e){
				
			}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegister.setBounds(244, 408, 130, 35);
		getContentPane().add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Go to Login");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new LoginPage().setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setBounds(465, 439, 80, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(41, 358, 100, 20);
		getContentPane().add(lblPhone);
		
		jphone = new JTextField();
		jphone.setBounds(218, 355, 170, 22);
		getContentPane().add(jphone);
		jphone.setColumns(10);

	}
}
