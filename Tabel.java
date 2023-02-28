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

public class Tabel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabel frame = new Tabel();
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
	
	public Tabel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 827, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(742, 291, 97, 25);
		contentPane.add(btnClose);
		displayTable();
		
		
	}
	
	private void displayTable() {
		// TODO Auto-generated method stub
		try{
		String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
		Connection con = DriverManager.getConnection(url);
		//Statement statement = (Statement) con.createStatement();
		java.sql.Statement stm = con.createStatement();
		String sql = "select * from Imobil";
		ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("IDImobil");
		model.addColumn("NrCam");
		model.addColumn("NrBai");
		model.addColumn("SuprafUtila");
		model.addColumn("AnConstr");
		model.addColumn("Oras");
		model.addColumn("Judet/Sector");
		model.addColumn("Bl");
		model.addColumn("Sc");
		model.addColumn("Ap");
		model.addColumn("Et");
		model.addColumn("Str");
		model.addColumn("Nr");
		model.addColumn("Categ");
		model.addColumn("Compartimentare");
		model.addColumn("Vanzator");
		model.addColumn("Anunt");
		

		
		
		
	
		while(result.next()){
			String IDImobil=result.getString(1);
			String NrCam=result.getString(2);
			String NrBai=result.getString(3);
			String Supraf=result.getString(4);
			String an=result.getString(5);
			String oras=result.getString(6);
			String jud=result.getString(7);
			String bl=result.getString(8);
			String sc=result.getString(9);
			String ap=result.getString(10);
			String et=result.getString(11);
			String str=result.getString(12);
			String nr=result.getString(13);
			String cat=result.getString(14);
			String comp=result.getString(15);
			String vanz=result.getString(16);
		//	String momentul = result.getString(17);

			String cate = "select Categorie from CategorieImobil where (IDCategorie = ?)";
			PreparedStatement catee = con.prepareStatement(cate);
			catee.setString(1, cat);
			String id = null;
			ResultSet rs = catee.executeQuery();
			if(rs.next()){
				 id = rs.getString("Categorie");
			}
			

			String tip = "select Compartimentare from Compartimentare where IDCompartimentare = ?";
			PreparedStatement tipp = con.prepareStatement(tip);
			tipp.setString(1, comp);
			String idtip = null;
			ResultSet rs1 = tipp.executeQuery();
			if(rs1.next()){
				 idtip = rs1.getString("Compartimentare");
			}
			
			String vanzator1 = "select Nume, Prenume from Vanzator where IDVanzator = ? ";
			PreparedStatement vinde = con.prepareStatement(vanzator1);
			String idu = vanz;
			vinde.setString(1, idu);
			String num = null;
			String pren = null;
			ResultSet rs2 = vinde.executeQuery();
			if(rs2.next()){
				 num = rs2.getString("Nume");
				 pren = rs2.getString("Prenume");
			}
			String final_num = num + pren;
			

			String [] row = {IDImobil,NrCam,NrBai,Supraf,an,oras,jud,bl,sc,ap,et,str,nr,id,idtip,final_num};
			model.addRow(row);
			
		}
		stm.close();
		con.close();
		}catch(Exception e){
			System.out.println("nu");
		}
	}
}
