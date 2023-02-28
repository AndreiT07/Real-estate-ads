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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CautaImobil extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textOras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CautaImobil frame = new CautaImobil();
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
	public CautaImobil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 25, 470, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCauta = new JButton("Cauta");
		
		btnCauta.setBounds(12, 106, 97, 25);
		contentPane.add(btnCauta);
		
		textOras = new JTextField();
		textOras.setBounds(12, 52, 116, 22);
		contentPane.add(textOras);
		textOras.setColumns(10);
		
		JLabel lblOras = new JLabel("Oras:");
		lblOras.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOras.setBounds(12, 25, 116, 16);
		contentPane.add(lblOras);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(12, 215, 97, 25);
		contentPane.add(btnBack);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Scop");
		model.addColumn("Pret");
		
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String oras = textOras.getText();
			try{
				model.getDataVector().removeAllElements();
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				Connection con = DriverManager.getConnection(url);
				java.sql.Statement stm = con.createStatement();
				//System.out.println(oras);
				String sql1 = "SELECT A.Scop, A.Pret from Anunt A "
						+ "inner join Imobil I on A.IDImobil = I.IDImobil where I.Oras ='"+oras+"'";

				PreparedStatement pst = con.prepareStatement(sql1);				
				ResultSet result = pst.executeQuery();
				String Scop,Pret;
				while(result.next()){
					Scop=result.getString(1);
					Pret=result.getString(2);
					
					String [] row = {Scop,Pret};
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
