package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatsImobil extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsImobil frame = new StatsImobil();
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
	public StatsImobil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 392, 227);
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
		btnBack.setBounds(307, 244, 97, 25);
		contentPane.add(btnBack);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("IDImobil");
		model.addColumn("Oras");
		model.addColumn("NrAnunturi");
		
		try{
			model.getDataVector().removeAllElements();
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con = DriverManager.getConnection(url);
			java.sql.Statement stm = con.createStatement();
			//System.out.println(oras);
			String sql1 = "select I.IDImobil, I.Oras, "
					+ "(select count(*) from Anunt where IDImobil = I.IDImobil) as NumarAnunturi from Imobil I";
					

			PreparedStatement pst = con.prepareStatement(sql1);				
			ResultSet result = pst.executeQuery();
			String ID,Oras,NrAnunturi;
			while(result.next()){
				ID=result.getString(1);
				Oras=result.getString(2);
				NrAnunturi=result.getString(3);
				String [] row = {ID,Oras,NrAnunturi};
				model.addRow(row);
				
			}
			stm.close();
			con.close();
			}catch(Exception e){
				System.out.println("nu");
			}
	}

}
