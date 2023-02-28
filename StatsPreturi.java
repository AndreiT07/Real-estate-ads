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

public class StatsPreturi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsPreturi frame = new StatsPreturi();
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
	public StatsPreturi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 411, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new HomePage().setVisible(true);
			}
		});
		btnNewButton.setBounds(326, 247, 97, 25);
		contentPane.add(btnNewButton);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Nume");
		model.addColumn("Suma");
		model.addColumn("Categorie");
		try{
			model.getDataVector().removeAllElements();
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con = DriverManager.getConnection(url);
			java.sql.Statement stm = con.createStatement();
			String sql1 = "select V.Nume+' ' +V.Prenume as Nume, (select sum(Pret) "
					+ "from Anunt where IDImobil = I.IDImobil) AS Suma, C.Categorie"
					+ " from Vanzator V inner join Imobil I on I.IDVanzator = V.IDVanzator "
					+ "inner join CategorieImobil C on I.IDCategorie=C.IDCategorie "
					+ "order by (select sum(Pret) from Anunt where IDImobil = I.IDImobil) desc";
					

			PreparedStatement pst = con.prepareStatement(sql1);				
			ResultSet result = pst.executeQuery();
			String Nume,Suma,Categorie;
			while(result.next()){
				Nume=result.getString(1);
				Suma=result.getString(2);
				Categorie=result.getString(3);
				String [] row = {Nume,Suma,Categorie};
				model.addRow(row);
				
			}
			stm.close();
			con.close();
			}catch(Exception e){
				System.out.println("nu");
			}
		
		
	}
}
