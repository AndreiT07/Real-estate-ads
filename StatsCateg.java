package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class StatsCateg extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsCateg frame = new StatsCateg();
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
	public StatsCateg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 408, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HomePage().setVisible(true);
			}
		});
		btnBack.setBounds(323, 228, 97, 25);
		contentPane.add(btnBack);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Categorie");
		model.addColumn("Numar");
		
		try{
			model.getDataVector().removeAllElements();
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con = DriverManager.getConnection(url);
			java.sql.Statement stm = con.createStatement();
			//System.out.println(oras);
			String sql1 = "select distinct C.Categorie, (select count(*) from "
					+ "Imobil where IDCategorie = I.IDCategorie) as Nr from Imobil I"
					+ " inner join Anunt A on I.IDImobil = A.IDImobil "
					+ "inner join CategorieImobil C  on I.IDCategorie = C.IDCategorie "
					+ "group by C.Categorie,I.IDCategorie";

					

			PreparedStatement pst = con.prepareStatement(sql1);				
			ResultSet result = pst.executeQuery();
			String Categorie,Numar;
			while(result.next()){
				Categorie=result.getString(1);
				Numar=result.getString(2);
				String [] row = {Categorie,Numar};
				model.addRow(row);
				
			}
			stm.close();
			con.close();
			}catch(Exception e){
				System.out.println("nu");
			}
		
	}

}
