package Hospital;
import java.awt.Font;
import java.sql.*;
import java.awt.Window;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;

public class HospApp {

	private JFrame frame;
	private JTextField UnameEntry;
	private JPasswordField PassEntry;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospApp window = new HospApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HospApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(1181, 68, 99, 36);
		frame.getContentPane().add(lblNewLabel);
		Font fn= new Font("Arial",Font.PLAIN,30);
		lblNewLabel.setFont(fn);
		
		JLabel UserName = new JLabel("USER NAME");
		UserName.setOpaque(true);
		UserName.setBounds(1089, 169, 99, 27);
		frame.getContentPane().add(UserName);
		
		JLabel Passw = new JLabel("PASSWORD");
		Passw.setOpaque(true);
		Passw.setBounds(1089, 228, 99, 27);
		frame.getContentPane().add(Passw);
		
		UnameEntry = new JTextField();
		UnameEntry.setBounds(1281, 169, 142, 27);
		frame.getContentPane().add(UnameEntry);
		UnameEntry.setColumns(10);
		
		PassEntry = new JPasswordField();
		PassEntry.setBounds(1281, 228, 142, 27);
		frame.getContentPane().add(PassEntry);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
					Statement stmt=con.createStatement();
					ResultSet rsdata=stmt.executeQuery("select * from patients where UNAME='"+UnameEntry.getText()+"' and PASSWORD='"+PassEntry.getText()+"'");
					if(rsdata.next()) {
						JOptionPane.showMessageDialog(null, "Login successfull");
						Dashboard db=new Dashboard();
						db.setVisible(true);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Login failed");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnlogin.setBounds(1089, 315, 85, 27);
		frame.getContentPane().add(btnlogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(1338, 315, 85, 27);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
			
		});
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(1214, 315, 85, 27);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterFrame rf =new RegisterFrame();
				rf.setVisible(true);
				
			}
			
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\login2 (1).jpg"));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(0, 0, 845, 845);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(313, 584, 45, 13);
		frame.getContentPane().add(label);
		
		JTextArea txtrWelcomeBackNice = new JTextArea();
		txtrWelcomeBackNice.setFont(new Font("Bell MT", Font.PLAIN, 13));
		txtrWelcomeBackNice.setForeground(new Color(255, 255, 255));
		txtrWelcomeBackNice.setOpaque(false);
		txtrWelcomeBackNice.setText("Welcome back, nice too see again.");
		txtrWelcomeBackNice.setBounds(1181, 114, 222, 22);
		frame.getContentPane().add(txtrWelcomeBackNice);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(83, 152, 221));
		lblNewLabel_2.setBounds(844, 0, 696, 845);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel Passw_1 = new JLabel("PASSWORD");
		Passw_1.setOpaque(true);
		Passw_1.setBounds(1089, 278, 99, 27);
		frame.getContentPane().add(Passw_1);
	}
}
