package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Anunturi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField lblPret;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anunturi frame = new Anunturi();
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
	public Anunturi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 975, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.red);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(438, 13, 507, 327);
		contentPane.add(scrollPane);
	
		table = new JTable();
		
		//btnDelete.setBounds(129, 294, 97, 25);
		//contentPane.add(btnDelete);
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButton BtnInchiriere = new JRadioButton("Inchiriere");
		BtnInchiriere.setBounds(129, 18, 127, 25);
		contentPane.add(BtnInchiriere);
		
		JRadioButton BtnVanzare = new JRadioButton("Vanzare");
		BtnVanzare.setBounds(280, 18, 127, 25);
		contentPane.add(BtnVanzare);
		
		buttonGroup.add(BtnInchiriere);
		buttonGroup.add(BtnVanzare);
		
		JLabel lblScopAnunt = new JLabel("Scop anunt:");
		lblScopAnunt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblScopAnunt.setBackground(Color.YELLOW);
		lblScopAnunt.setBounds(12, 13, 109, 30);
		contentPane.add(lblScopAnunt);
		
		JLabel lblNewLabel = new JLabel("Pret");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 56, 109, 30);
		contentPane.add(lblNewLabel);
		
		lblPret = new JTextField();
		lblPret.setBounds(129, 62, 116, 22);
		contentPane.add(lblPret);
		lblPret.setColumns(10);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				txtID.setText(model.getValueAt(i, 4).toString());
				lblPret.setText(model.getValueAt(i, 2).toString());
				String tip = (String) model.getValueAt(i, 1);
				if(tip.equals("Inchiriere")){
					BtnInchiriere.setSelected(true);
				}
				else{
					BtnVanzare.setSelected(true);
				}
			}
		});
		
		
		
		scrollPane.setViewportView(table);
		displayTable();
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
					Connection con = DriverManager.getConnection(url);
					String query = "insert into Anunt(Scop, Pret,IDImobil) values(?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					//pst.setString(1,)
					String scop = null;
					if(BtnVanzare.isSelected())
						scop = "Vanzare";
					else if (BtnInchiriere.isSelected())
							scop = "Inchiriere";
					pst.setString(1, scop);
					pst.setString(2, lblPret.getText());
					pst.setString(3, txtID.getText());
					//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					//LocalDateTime now = LocalDateTime.now();
					String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				//	pst.setString(3,timeStamp);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted Successfully");
					updateTable();
					//DefaultTableModel model = (DefaultTableModel) table.getModel();
					//model.getDataVector().removeAllElements();
					//displayTable();
					lblPret.setText("");
					buttonGroup.clearSelection();
				
					
					//System.out.println("conectat");
				}catch(Exception e){
					System.out.println("nu");
					JOptionPane.showMessageDialog(null, "nu");
				}
			}
		});
		btnInsert.setBounds(129, 148, 97, 25);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				Connection con;
				
					try {
						con = DriverManager.getConnection(url);
						int row = table.getSelectedRow();
						String value = table.getModel().getValueAt(row, 0).toString();
						String query = "Update Anunt set Scop=?,Pret = ? where IDAnunt = "+ value;
						PreparedStatement pst = con.prepareStatement(query);
						String scop = null;
						if(BtnVanzare.isSelected())
							scop = "Vanzare";
						else if (BtnInchiriere.isSelected())
							scop = "Inchiriere";
						pst.setString(1, scop);
						pst.setString(2, lblPret.getText());
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Updated Successfully");
						updateTable();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String query = "Delete from Anunt where (Moment = ?)";
			}
		});
		btnUpdate.setBounds(129, 198, 97, 25);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
				Connection con;
				try {
					con = DriverManager.getConnection(url);
					String query = "Delete from Anunt where (IDAnunt = ?)";
					PreparedStatement pst = con.prepareStatement(query);
					int row = table.getSelectedRow();
					String value = (String) table.getModel().getValueAt(row, 0);
					pst.setString(1, value);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
					DefaultTableModel model = (DefaultTableModel) table.getModel();//updateTable();
					updateTable();
				/*	int rows = model.getRowCount(); 
					for(int i = rows - 1; i >=0; i--)
					{
					   model.removeRow(i); 
					}
					displayTable();*/
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(129, 251, 97, 25);
		contentPane.add(btnDelete);
		
		JButton btnImobile = new JButton(". . .");
		btnImobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tabel t1 = new Tabel();
				t1.setVisible(true);
			}
		});
		btnImobile.setBounds(280, 97, 36, 25);
		contentPane.add(btnImobile);
		
		JLabel lblIdimobil = new JLabel("IDImobil");
		lblIdimobil.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIdimobil.setBounds(12, 99, 81, 16);
		contentPane.add(lblIdimobil);
		
		txtID = new JTextField();
		txtID.setBounds(129, 97, 116, 22);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(129, 296, 97, 25);
		contentPane.add(btnBack);

		
	}

	private void displayTable() {
		// TODO Auto-generated method stub
		try{
		String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
		Connection con = DriverManager.getConnection(url);
		//Statement statement = (Statement) con.createStatement();
		java.sql.Statement stm = con.createStatement();
		String sql1 = "select A.IDAnunt, A.Scop,A.Pret,A.Moment,A.IDImobil ,I.Oras "
				+ "from Imobil I INNER JOIN Anunt A on I.IDImobil = A.IDImobil ";
		ResultSet result = ((java.sql.Statement) stm).executeQuery(sql1);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
		model.addColumn("IDAnunt");
		model.addColumn("Scop");
		model.addColumn("Pret");
		model.addColumn("Moment");
		model.addColumn("IDImobil");
		model.addColumn("Oras");
		String IDAnunt,Scop, Pret, Moment,Cod,Oras,IDImobil;
		while(result.next()){
			IDAnunt=result.getString(1);
			Scop=result.getString(2);
			Pret=result.getString(3);
			Moment=result.getString(4);
			IDImobil=result.getString(5);
			Oras=result.getString(6);
			String [] row = {IDAnunt,Scop,Pret,Moment,IDImobil,Oras};
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
			String sql1 = "select A.IDAnunt, A.Scop,A.Pret,A.Moment,A.IDImobil ,I.Oras from Imobil I INNER JOIN Anunt A on I.IDImobil = A.IDImobil ";
			//String sql = "select * from Anunt";
			
			ResultSet result = ((java.sql.Statement) stm).executeQuery(sql1);
			//ResultSet result1 = ((java.sql.Statement) stm).executeQuery(sql1);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
		
			String IDAnunt,Scop, Pret, Moment,Cod,Oras,IDImobil;
			while(result.next()){
				IDAnunt=result.getString(1);
				Scop=result.getString(2);
				Pret=result.getString(3);
				Moment=result.getString(4);
				IDImobil=result.getString(5);
				Oras=result.getString(6);
				String [] row = {IDAnunt,Scop,Pret,Moment,IDImobil,Oras};
				model.addRow(row);
				
			}
			stm.close();
			con.close();
			}catch(Exception e){
				System.out.println("nu");
			}
	}
}
