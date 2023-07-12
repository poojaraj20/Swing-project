package Hospital;

import java.awt.EventQueue;
import java.sql.*;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Button;

public class Dashboard extends JFrame {
	private JTextField Pname;
	private JTextField Page;
	private JTextField Paddress;
	private JTextField timeslot;
	private JTextArea d12;
	private JTextArea d13;
	private JTextArea d14;
	private JTextField docname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1920, 1080);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTextArea txtrHelloUser = new JTextArea();
		txtrHelloUser.setBounds(91, 10, 237, 58);
		txtrHelloUser.setEditable(false);
		txtrHelloUser.setForeground(Color.WHITE);
		txtrHelloUser.setOpaque(false);
		txtrHelloUser.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtrHelloUser.setText("Hello user,");
		getContentPane().add(txtrHelloUser);
		
		JTextArea txtrWelcomeToAbcd = new JTextArea();
		txtrWelcomeToAbcd.setBounds(91, 65, 593, 74);
		txtrWelcomeToAbcd.setEditable(false);
		txtrWelcomeToAbcd.setForeground(Color.WHITE);
		txtrWelcomeToAbcd.setOpaque(false);
		txtrWelcomeToAbcd.setText("Welcome to ABCD Hospital. \r\nBook your appoinment slot right now.");
		txtrWelcomeToAbcd.setFont(new Font("Times New Roman", Font.BOLD, 26));
		getContentPane().add(txtrWelcomeToAbcd);
		
		JLabel Pname1 = new JLabel("Patient name :");
		Pname1.setBounds(91, 201, 134, 24);
		Pname1.setForeground(Color.WHITE);
		Pname1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(Pname1);
		
		JLabel lblNewLabel_1 = new JLabel("Age :");
		lblNewLabel_1.setBounds(93, 246, 70, 24);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address :");
		lblNewLabel_2.setBounds(91, 290, 83, 24);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Blood Group :");
		lblNewLabel_4.setBounds(91, 335, 134, 24);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel_4);
		
		Pname = new JTextField();
		Pname.setBounds(251, 201, 257, 26);
		getContentPane().add(Pname);
		Pname.setColumns(10);
		
		Page = new JTextField();
		Page.setBounds(251, 246, 257, 26);
		Page.setColumns(10);
		getContentPane().add(Page);
		
		Paddress = new JTextField();
		Paddress.setBounds(251, 290, 257, 26);
		Paddress.setColumns(10);
		getContentPane().add(Paddress);
		
		
		JComboBox Pbloodgroup = new JComboBox();
		Pbloodgroup.setBounds(251, 338, 257, 21);
		Pbloodgroup.setModel(new DefaultComboBoxModel(new String[] {"A+", "AB+", "A-", "AB-", "B+", "B-", "O+", "O-"}));
		getContentPane().add(Pbloodgroup);
		
		JLabel lblNewLabel_5 = new JLabel("Patient Details :");
		lblNewLabel_5.setBounds(91, 160, 161, 18);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 20));
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Doctor Details:");
		lblNewLabel_6.setBounds(91, 395, 134, 24);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 20));
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblSelectDoctorName = new JLabel("Doctors  :");
		lblSelectDoctorName.setBounds(91, 454, 146, 24);
		lblSelectDoctorName.setForeground(Color.WHITE);
		lblSelectDoctorName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblSelectDoctorName);
		
		JTextArea Dname = new JTextArea();
		Dname.setBounds(243, 454, 445, 58);
		Dname.setEditable(false);
		Dname.setFont(new Font("Monospaced", Font.PLAIN, 16));
		Dname.setText("Dr. Shashank, Pidiatrician, MBBS, 9 -12 AM\r\nDr. David, Psyciatry, MBBS, 2 - 4 PM");
		getContentPane().add(Dname);
		
//		JButton btnNewButton = new JButton("OK");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
//					Statement stmt=con.createStatement();
//					ResultSet rsdata=stmt.executeQuery("select * from doctor where dname='"+Dname.getText()+"'");
//					
////					d12.setVisible(true);
////					d13.setVisible(true);
////					d14.setVisible(true);
//					if(rsdata.next()) {
//						d11.setVisible(true);
//						
//						d11.setText(rsdata.getString("DNAME"));
//
//					}
//					
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//		btnNewButton.setBounds(519, 454, 58, 24);
//		getContentPane().add(btnNewButton);
		
		JLabel lblEnterTimeSlot = new JLabel("Enter time slot :");
		lblEnterTimeSlot.setBounds(91, 567, 187, 24);
		lblEnterTimeSlot.setForeground(Color.WHITE);
		lblEnterTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblEnterTimeSlot);
		
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
		
		Random rand = new Random();
		// Generate Java random number 0 or 1
		int rand_int1 = rand.nextInt(10000);
		
		timeslot = new JTextField();
		timeslot.setBounds(251, 567, 257, 26);
		timeslot.setColumns(10);
		getContentPane().add(timeslot);
		
		JButton Submit = new JButton("Submit");
		Submit.setBounds(243, 601, 85, 21);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
					Statement stmt=con.createStatement();
					String query=String.format("insert into p_details values('%s',%d,'%s','%s','%s','%s')",Pname.getText(),Integer.parseInt(Page.getText()),Paddress.getText(),Pbloodgroup.getSelectedItem().toString(),docname.getText(),timeslot.getText());
					try {
						int i=stmt.executeUpdate(query);
						System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "submitted succesfully");
							new showtest().setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "failed");
						}
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		getContentPane().add(Submit);
		
		JLabel lblEnterDoctorName = new JLabel("Enter Doctor name :");
		lblEnterDoctorName.setBounds(91, 522, 187, 24);
		lblEnterDoctorName.setForeground(Color.WHITE);
		lblEnterDoctorName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblEnterDoctorName);
		
		docname = new JTextField();
		docname.setBounds(288, 522, 257, 26);
		docname.setColumns(10);
		getContentPane().add(docname);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(694, 0, 846, 845);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\appoinment1 (1).jpg"));
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBounds(573, 34, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 10, 696, 845);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(83, 152, 221));
		getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("New button");
		button.setBounds(560, 163, 85, 21);
		getContentPane().add(button);
		
		JButton btnNewButton_1 = new JButton("showname");
		btnNewButton_1.setBounds(477, 603, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(504, 613, 85, 21);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("showname");
		btnNewButton_3.setBounds(504, 613, 85, 21);
		btnNewButton_3.setForeground(Color.YELLOW);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(243, 648, 85, 21);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(243, 648, 85, 21);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(437, 613, 85, 21);
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(527, 603, 85, 21);
		getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(487, 634, 85, 21);
		getContentPane().add(btnNewButton_8);
		
//		d12 = new JTextArea();
//		d12.setColumns(10);
//		d12.setBounds(858, 498, 257, 26);
//		getContentPane().add(d12);
//		
//		d13 = new JTextArea();
//		d13.setColumns(10);
//		d13.setBounds(858, 552, 257, 26);
//		getContentPane().add(d13);
//		
//		d14 = new JTextArea();
//		d14.setColumns(10);
//		d14.setBounds(858, 601, 257, 26);
//		getContentPane().add(d14);
	}
}
