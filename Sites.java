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

public class Sites extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sites frame = new Sites();
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
	public Sites() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 408, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(335, 247, 97, 25);
		contentPane.add(btnNewButton);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Pret");
		model.addColumn("Scop");
		model.addColumn("Oras");
		model.addColumn("NumeSite");
		model.addColumn("Link");
		
		try{
			model.getDataVector().removeAllElements();
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con = DriverManager.getConnection(url);
			java.sql.Statement stm = con.createStatement();
			//System.out.println(oras);
			String sql1="select An.Pret,An.Scop,I.Oras,S.Nume as NumeSite, S.Link "
					+ "from AnuntSite A inner join Site S on S.IDSite = A.IDSite "
					+ "inner join Anunt An on An.IDAnunt = A.IDAnunt "
					+ "inner join Imobil I on I.IDImobil = An.IDImobil";

			PreparedStatement pst = con.prepareStatement(sql1);				
			ResultSet result = pst.executeQuery();
			String Pret,Scop,Oras,NumeSite,Link;
			while(result.next()){
				Pret=result.getString(1);
				Scop=result.getString(2);
				Oras=result.getString(3);
				NumeSite=result.getString(4);
				Link=result.getString(5);
				String [] row = {Pret,Scop,Oras,NumeSite,Link};
				model.addRow(row);
				
			}
			stm.close();
			con.close();
			}catch(Exception e){
				System.out.println("nu");
			}
	}

}
