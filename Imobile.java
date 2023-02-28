package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Imobile extends JFrame {

	private JPanel Panel;
	private JTextField nrCamere;
	private JTextField nrBai;
	private JTextField suprafUtila;
	private JTextField an;
	private JTextField oras;
	private JTextField jud_sect;
	private JTextField bloc;
	private JTextField scara;
	private JTextField ap;
	private JTextField etaj;
	private JTextField strada;
	private JTextField nr;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imobile frame = new Imobile();
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
	public Imobile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1306, 622);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 46, 922, 505);
		Panel.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		displayTable();
		
		
		
		
		
		
		
		JLabel lblNrcamere = new JLabel("NrCamere");
		lblNrcamere.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNrcamere.setBounds(41, 46, 86, 22);
		Panel.add(lblNrcamere);
		
		JLabel lblNrbai = new JLabel("NrBai");
		lblNrbai.setBounds(41, 83, 62, 16);
		lblNrbai.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblNrbai);
		
		JLabel lblSuprafatautila = new JLabel("SuprafataUtila");
		lblSuprafatautila.setBounds(41, 112, 142, 16);
		lblSuprafatautila.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblSuprafatautila);
		
		JLabel lblAnconstructie = new JLabel("AnConstructie");
		lblAnconstructie.setBounds(41, 141, 116, 16);
		lblAnconstructie.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblAnconstructie);
		
		JLabel lblOras = new JLabel("Oras");
		lblOras.setBounds(41, 169, 56, 16);
		lblOras.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblOras);
		
		JLabel lblJudetsector = new JLabel("Judet/Sector");
		lblJudetsector.setBounds(41, 198, 105, 16);
		lblJudetsector.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblJudetsector);
		
		JLabel lblBloc = new JLabel("Bloc");
		lblBloc.setBounds(41, 228, 56, 16);
		lblBloc.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblBloc);
		
		JLabel lblScara = new JLabel("Scara");
		lblScara.setBounds(41, 257, 56, 16);
		lblScara.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblScara);
		
		JLabel lblApartament = new JLabel("Apartament");
		lblApartament.setBounds(41, 286, 116, 16);
		lblApartament.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblApartament);
		
		JLabel lblEtaj = new JLabel("Etaj");
		lblEtaj.setBounds(41, 315, 56, 16);
		lblEtaj.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblEtaj);
		
		JLabel lblStrada = new JLabel("Strada");
		lblStrada.setBounds(41, 344, 56, 16);
		lblStrada.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblStrada);
		
		JLabel lblNumar = new JLabel("Numar");
		lblNumar.setBounds(41, 373, 56, 16);
		lblNumar.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblNumar);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(41, 402, 73, 16);
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblCategorie);
		
		JLabel lblCompartimentare = new JLabel("Compartimentare");
		lblCompartimentare.setBounds(41, 431, 142, 16);
		lblCompartimentare.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblCompartimentare);
		
		JLabel lblVanzator = new JLabel("Vanzator");
		lblVanzator.setBounds(41, 462, 86, 22);
		lblVanzator.setFont(new Font("Tahoma", Font.BOLD, 15));
		Panel.add(lblVanzator);
		
		nrCamere = new JTextField();
		nrCamere.setBounds(180, 47, 116, 22);
		Panel.add(nrCamere);
		nrCamere.setColumns(10);
		
		nrBai = new JTextField();
		nrBai.setBounds(180, 81, 116, 22);
		Panel.add(nrBai);
		nrBai.setColumns(10);
		
		suprafUtila = new JTextField();
		suprafUtila.setBounds(180, 110, 116, 22);
		Panel.add(suprafUtila);
		suprafUtila.setColumns(10);
		
		an = new JTextField();
		an.setBounds(180, 139, 116, 22);
		Panel.add(an);
		an.setColumns(10);
		
		oras = new JTextField();
		oras.setBounds(180, 167, 116, 22);
		Panel.add(oras);
		oras.setColumns(10);
		
		jud_sect = new JTextField();
		jud_sect.setBounds(180, 196, 116, 22);
		Panel.add(jud_sect);
		jud_sect.setColumns(10);
		
		bloc = new JTextField();
		bloc.setBounds(180, 226, 116, 22);
		Panel.add(bloc);
		bloc.setColumns(10);
		
		scara = new JTextField();
		scara.setBounds(180, 255, 116, 22);
		Panel.add(scara);
		scara.setColumns(10);
		
		ap = new JTextField();
		ap.setBounds(180, 284, 116, 22);
		Panel.add(ap);
		ap.setColumns(10);
		
		etaj = new JTextField();
		etaj.setBounds(180, 313, 116, 22);
		Panel.add(etaj);
		etaj.setColumns(10);
		
		strada = new JTextField();
		strada.setBounds(180, 342, 116, 22);
		Panel.add(strada);
		strada.setColumns(10);
		
		nr = new JTextField();
		nr.setBounds(180, 371, 116, 22);
		Panel.add(nr);
		nr.setColumns(10);
		
		JComboBox<String> categ = new JComboBox<String>();
		categ.setBounds(180, 400, 116, 22);
		Panel.add(categ);
		add_categ(categ);
		
		
		JComboBox compartimentare = new JComboBox();
		compartimentare.setBounds(180, 429, 116, 22);
		Panel.add(compartimentare);
		add_comp(compartimentare);
		
		JComboBox vanzator =  new JComboBox();
		vanzator.setBounds(180, 463, 116, 22);
		Panel.add(vanzator);
		add_vanz(vanzator);
		
	
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				nrCamere.setText(model.getValueAt(i, 1).toString());
				nrBai.setText(model.getValueAt(i, 2).toString());
				suprafUtila.setText(model.getValueAt(i, 3).toString());
				an.setText(model.getValueAt(i, 4).toString());
				oras.setText(model.getValueAt(i, 5).toString());
				jud_sect.setText(model.getValueAt(i, 6).toString());
				bloc.setText(model.getValueAt(i, 7).toString());
				scara.setText(model.getValueAt(i, 8).toString());
				ap.setText(model.getValueAt(i, 9).toString());
				etaj.setText(model.getValueAt(i, 10).toString());
				strada.setText(model.getValueAt(i, 11).toString());
				nr.setText(model.getValueAt(i, 12).toString());
				
				String catego = model.getValueAt(i, 13).toString();
				categ.setSelectedItem(catego);
				
				//System.out.println(catego);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				Connection con;
				try {
					con = DriverManager.getConnection(url);
					java.sql.Statement stm = con.createStatement();
					String query = "insert into Imobil(NumarCamere, NumarBai, SuprafataUtila, AnConstructie, Oras, [Judet/Sector],Bloc,"
							+ "Scara,Apartament,Etaj,Strada,Numar,IDCategorie,IDCompartimentare,IDVanzator)"
							+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, nrCamere.getText());
					pst.setString(2, nrBai.getText());
					pst.setString(3, suprafUtila.getText());
					pst.setString(4, an.getText());
					pst.setString(5, oras.getText());
					pst.setString(6, jud_sect.getText());
					pst.setString(7, bloc.getText());
					pst.setString(8, scara.getText());
					pst.setString(9, ap.getText());
					pst.setString(10, etaj.getText());
					pst.setString(11, strada.getText());
					pst.setString(12, nr.getText());
					
					String cate = "select IDCategorie from CategorieImobil where (Categorie = ?)";
					PreparedStatement catee = con.prepareStatement(cate);
					catee.setString(1, (categ.getSelectedItem()).toString());
					String id = null;
					ResultSet rs = catee.executeQuery();
					if(rs.next()){
						 id = rs.getString("IDCategorie");
					}
					
					String tip = "select IDCompartimentare from Compartimentare where (Compartimentare = ?)";
					PreparedStatement tipp = con.prepareStatement(tip);
					tipp.setString(1, (compartimentare.getSelectedItem()).toString());
					String idtip = null;
					ResultSet rs1 = tipp.executeQuery();
					if(rs1.next()){
						 idtip = rs1.getString("IDCompartimentare");
					}
					
					String vanzator1 = "select IDVanzator from Vanzator where (Nume = ?) and (Prenume = ?) ";
					PreparedStatement vinde = con.prepareStatement(vanzator1);
					String nume_full = vanzator.getSelectedItem().toString();
					String[] words = nume_full.split("\\s+");
					for (int i = 0; i < words.length; i++) {
					    words[i] = words[i].replaceAll("[^\\w]", "");
					}
					vinde.setString(1, words[0]);
					vinde.setString(2, words[1]);
					String idvanz = null;
					ResultSet rs2 = vinde.executeQuery();
					if(rs2.next()){
						 idvanz = rs2.getString("IDVanzator");
					}				
					pst.setString(13,id);
					pst.setString(14,idtip);
					pst.setString(15, idvanz);
					//pst.setString(16, idmom);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
					updateTable();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setBounds(41, 498, 97, 25);
		Panel.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				Connection con;
				try {
					con = DriverManager.getConnection(url);
					String query = "Delete from Imobil where (IDImobil = ?)";
					PreparedStatement pst = con.prepareStatement(query);
					int row = table.getSelectedRow();
					String value = (String) table.getModel().getValueAt(row, 0);
					System.out.println(value);
					pst.setString(1, value);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
					DefaultTableModel model = (DefaultTableModel) table.getModel();//updateTable();
					
					int rows = model.getRowCount(); 
					for(int i = rows - 1; i >=0; i--)
					{
					   model.removeRow(i); 
					}
					updateTable();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(180, 498, 97, 25);
		Panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				Connection con;
				try {
					con = DriverManager.getConnection(url);
					java.sql.Statement stm = con.createStatement();
					//String query = "Update Anunt set Scop=?,Pret = ? where IDAnunt = "+ idmom;
					int row = table.getSelectedRow();
					String value = table.getModel().getValueAt(row, 0).toString();
					String query = "Update Imobil set NumarCamere=?, NumarBai=?, SuprafataUtila=?, AnConstructie=?, Oras=?, [Judet/Sector]=?,Bloc=?,"
							+ "Scara=?,Apartament=?,Etaj=?,Strada=?,Numar=?,IDCategorie=?,IDCompartimentare=?,IDVanzator=? where IDImobil ="+value;
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, nrCamere.getText());
					pst.setString(2, nrBai.getText());
					pst.setString(3, suprafUtila.getText());
					pst.setString(4, an.getText());
					pst.setString(5, oras.getText());
					pst.setString(6, jud_sect.getText());
					pst.setString(7, bloc.getText());
					pst.setString(8, scara.getText());
					pst.setString(9, ap.getText());
					pst.setString(10, etaj.getText());
					pst.setString(11, strada.getText());
					pst.setString(12, nr.getText());
					
					String cate = "select IDCategorie from CategorieImobil where (Categorie = ?)";
					PreparedStatement catee = con.prepareStatement(cate);
					catee.setString(1, (categ.getSelectedItem()).toString());
					String id = null;
					ResultSet rs = catee.executeQuery();
					if(rs.next()){
						 id = rs.getString("IDCategorie");
					}
					
					String tip = "select IDCompartimentare from Compartimentare where (Compartimentare = ?)";
					PreparedStatement tipp = con.prepareStatement(tip);
					tipp.setString(1, (compartimentare.getSelectedItem()).toString());
					String idtip = null;
					ResultSet rs1 = tipp.executeQuery();
					if(rs1.next()){
						 idtip = rs1.getString("IDCompartimentare");
					}
					
					String vanzator1 = "select IDVanzator from Vanzator where (Nume = ?) and (Prenume = ?) ";
					PreparedStatement vinde = con.prepareStatement(vanzator1);
					String nume_full = vanzator.getSelectedItem().toString();
					String[] words = nume_full.split("\\s+");
					for (int i = 0; i < words.length; i++) {
					    words[i] = words[i].replaceAll("[^\\w]", "");
					}
					vinde.setString(1, words[0]);
					vinde.setString(2, words[1]);
					String idvanz = null;
					ResultSet rs2 = vinde.executeQuery();
					if(rs2.next()){
						 idvanz = rs2.getString("IDVanzator");
					}
					
				
					
					
					pst.setString(13,id);
					pst.setString(14,idtip);
					pst.setString(15, idvanz);
					//pst.setString(16, idmom);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Updated Sucessfully!");
					updateTable();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(41, 550, 97, 25);
		Panel.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(180, 550, 97, 25);
		Panel.add(btnBack);
		
		
		
	}
	
		public void add_categ(JComboBox categ){
		String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
			java.sql.Statement stm = con.createStatement();
			String sql = "select * from CategorieImobil";
			ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
			while(result.next()){
				String c=result.getString(2);
				categ.addItem(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		public void cat(JComboBox categ, String cuv){
			   
			 categ.setSelectedItem(cuv);
			
		}
		public void add_comp(JComboBox comp){
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con;
			try {
				con = DriverManager.getConnection(url);
				java.sql.Statement stm = con.createStatement();
				String sql = "select * from Compartimentare";
				ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
				while(result.next()){
					String c=result.getString(2);
					comp.addItem(c);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		public void add_vanz(JComboBox vanz){
			String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
			Connection con;
			try {
				con = DriverManager.getConnection(url);
				java.sql.Statement stm = con.createStatement();
				String sql = "select * from Vanzator";
				ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
				while(result.next()){
					String nume=result.getString(2);
					String prenume=result.getString(3);
					String item = nume+" "+prenume;
					vanz.addItem(item);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			public void add_moment(JComboBox mom){
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				Connection con;
				try {
					con = DriverManager.getConnection(url);
					java.sql.Statement stm = con.createStatement();
					String sql = "select Moment from Anunt ";
					ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
					while(result.next()){
						String momentul=result.getString(1);
	
						mom.addItem(momentul);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
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
				//model.addColumn("Anunt");
				

				
				
				
			
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
					//String momentul = result.getString(17);

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
			
			
			
			private void updateTable(){
				
				try{
					String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
					Connection con = DriverManager.getConnection(url);
					//Statement statement = (Statement) con.createStatement();
					java.sql.Statement stm = con.createStatement();
					String sql = "select * from Imobil";
					ResultSet result = ((java.sql.Statement) stm).executeQuery(sql);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
								int rows = model.getRowCount(); 
					for(int i = rows - 1; i >=0; i--)
					{
					   model.removeRow(i); 
					}
					
			
					while(result.next()){
						String IDImobil = result.getString(1);
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
						//String momentul = result.getString(17);

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
					
				}
				
			}
}
