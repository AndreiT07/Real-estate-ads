package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Preturi extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preturi frame = new Preturi();
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
	public Preturi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 428, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.red);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 13, 386, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HomePage().setVisible(true);
			}
		});
		btnBack.setBounds(301, 328, 97, 25);
		contentPane.add(btnBack);
		try{
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con = DriverManager.getConnection(url);
			//Statement statement = (Statement) con.createStatement();
			java.sql.Statement stm = con.createStatement();
			String sql = "select A.Pret, I.Oras from Imobil I inner join Anunt A on I.IDImobil=A.IDImobil";
			//String sql = "select I.IDCategorie, C.Categorie, A.Pret from Imobil I inner join Anunt A on I.IDImobil = A.IDImobil inner join CategorieImobil C on I.IDCategorie = C.IDCategorie";
			ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addColumn("Pret");
			model.addColumn("Oras");
			//model.addColumn("Moment");
			
			String Categorie, Pret;
		while(result.next()){
				Categorie=result.getString(1);
				Pret=result.getString(2);
				//Moment=result.getString(4);
				String [] row = {Categorie, Pret};
				model.addRow(row);
				
			}
			stm.close();
			con.close();
			}catch(Exception e){
				System.out.println("nu");
			}
		//displayTable();
	}
		private void displayTable() {
			// TODO Auto-generated method stub
			try{
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con = DriverManager.getConnection(url);
			//Statement statement = (Statement) con.createStatement();
			java.sql.Statement stm = con.createStatement();
			String sql = "select * from Anunt";
			ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			model.addColumn("Scop");
			model.addColumn("Pret");
			model.addColumn("Moment");
			
			String Scop, Pret, Moment;
			while(result.next()){
				Scop=result.getString(2);
				Pret=result.getString(3);
				Moment=result.getString(4);
				String [] row = {Scop, Pret, Moment};
				model.addRow(row);
				
			}
			stm.close();
			con.close();
			}catch(Exception e){
				System.out.println("nu");
			}
		}
	}

