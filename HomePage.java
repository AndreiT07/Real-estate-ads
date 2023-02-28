package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	protected JLabel WLCLabel = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		WLCLabel.setIcon(null);
		WLCLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		WLCLabel.setBounds(318, 13, 168, 16);
		contentPane.add(WLCLabel);
		
		JButton btnAnunturi = new JButton("Anunturi");
		btnAnunturi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Anunturi().setVisible(true);
				dispose();
			}
		});
		
		JButton btnImobile = new JButton("Imobile");
		btnImobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Imobile().setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Preturi");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Preturi().setVisible(true);
			}
		});
		btnNewButton.setBounds(419, 63, 120, 25);
		contentPane.add(btnNewButton);
		btnImobile.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnImobile.setForeground(Color.RED);
		btnImobile.setBounds(232, 63, 120, 25);
		contentPane.add(btnImobile);
		btnAnunturi.setForeground(Color.RED);
		btnAnunturi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnunturi.setBounds(42, 61, 120, 25);
		contentPane.add(btnAnunturi);
		
		JButton btnNewButton_1 = new JButton("Cauta Imobil");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CautaImobil().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(42, 124, 150, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vanzatori");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Vanzatori().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(232, 124, 120, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Site-uri");
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sites().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(419, 124, 120, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Stats Categ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatsCateg().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_4.setBounds(42, 197, 140, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Stats Preturi");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatsPreturi().setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_5.setBounds(232, 197, 155, 25);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Stats Imobil");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatsImobil().setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setForeground(Color.RED);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_6.setBounds(419, 199, 155, 25);
		contentPane.add(btnNewButton_6);
		
		JLabel label = new JLabel("");
		label.setLabelFor(label);
		label.setIcon(new ImageIcon("C:\\Users\\andre\\OneDrive\\Desktop\\1.jpg"));
		label.setBounds(-11, -28, 852, 533);
		contentPane.add(label);
		
		
		
	}
}
