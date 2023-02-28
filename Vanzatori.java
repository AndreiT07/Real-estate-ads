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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Vanzatori extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vanzatori frame = new Vanzatori();
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
	public Vanzatori() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 43, 660, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Nume");
		model.addColumn("Prenume");
		model.addColumn("NumarImobile");
		JButton btnNewButton = new JButton("Afiseaza");
		
		btnNewButton.setBounds(12, 72, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblAfiseazaVanzatoriiDesc = new JLabel("Afiseaza vanzatorii descrescator sau crescator in functie de numarul de imobile");
		lblAfiseazaVanzatoriiDesc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAfiseazaVanzatoriiDesc.setBounds(12, 13, 547, 16);
		contentPane.add(lblAfiseazaVanzatoriiDesc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 39, 97, 22);
		contentPane.add(comboBox);
		comboBox.addItem("asc");
		comboBox.addItem("desc");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(12, 121, 97, 25);
		contentPane.add(btnBack);
	
	
	
	
	
	
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					model.getDataVector().removeAllElements();
					String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
					Connection con = DriverManager.getConnection(url);
					//Statement statement = (Statement) con.createStatement();
					java.sql.Statement stm = con.createStatement();
					String x = comboBox.getSelectedItem().toString();
					String sql1 = "SELECT A.Nume, A.Prenume, Count(IDImobil) as NumarImobile from"
							+ " Vanzator as A left join Imobil as V on A.IDVanzator = V.IDVanzator"
							+ " group by  A.Nume, A.Prenume order by NumarImobile "+x;
					PreparedStatement pst = con.prepareStatement(sql1);
					ResultSet result = pst.executeQuery();
					String Nume,Prenume,Nr;
					while(result.next()){
						Nume=result.getString(1);
						Prenume=result.getString(2);
						Nr=result.getString(3);
						String [] row = {Nume,Prenume,Nr};
						model.addRow(row);
						
					}
					stm.close();
					con.close();
					}catch(Exception e){
						System.out.println("nu");
					}
			}
		});
	
	
	
	
	}
}
