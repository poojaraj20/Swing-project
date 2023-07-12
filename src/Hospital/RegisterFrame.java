package Hospital;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtRegister;
	private JTextField txtEnterUsername;
	private JTextField txtEnterPassword;
	private JTextField txtEnterEmail;
	private JTextField txtMobileNo;
	private JTextField uname;
	private JTextField email;
	private JTextField phno;
	private JPasswordField password;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1920, 1080);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRegister = new JTextField();
		txtRegister.setEditable(false);
		txtRegister.setFont(new Font("Arial", Font.BOLD, 30));
		txtRegister.setText("Register");
		txtRegister.setBounds(1122, 68, 127, 36);
		contentPane.add(txtRegister);
		txtRegister.setColumns(10);
		
		JTextArea txtrDontHaveAn = new JTextArea();
		txtrDontHaveAn.setEditable(false);
		txtrDontHaveAn.setForeground(new Color(255, 255, 255));
		txtrDontHaveAn.setFont(new Font("Bell MT", Font.PLAIN, 13));
		txtrDontHaveAn.setOpaque(false);
		txtrDontHaveAn.setText("Don't have an account? Create an account now.\r\nIt takes less than a minute");
		txtrDontHaveAn.setBounds(1122, 114, 272, 40);
		contentPane.add(txtrDontHaveAn);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setEditable(false);
		txtEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterUsername.setText("Enter username:");
		txtEnterUsername.setBounds(1027, 184, 99, 27);
		contentPane.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		txtEnterPassword = new JTextField();
		txtEnterPassword.setEditable(false);
		txtEnterPassword.setText("Enter Password:");
		txtEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterPassword.setColumns(10);
		txtEnterPassword.setBounds(1027, 238, 99, 27);
		contentPane.add(txtEnterPassword);
		
		txtEnterEmail = new JTextField();
		txtEnterEmail.setEditable(false);
		txtEnterEmail.setText("E-mail:");
		txtEnterEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterEmail.setColumns(10);
		txtEnterEmail.setBounds(1027, 296, 99, 27);
		contentPane.add(txtEnterEmail);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setEditable(false);
		txtMobileNo.setText("Mobile No:");
		txtMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMobileNo.setColumns(10);
		txtMobileNo.setBounds(1027, 353, 99, 27);
		contentPane.add(txtMobileNo);
		
		uname = new JTextField();
		uname.setBounds(1201, 184, 220, 27);
		contentPane.add(uname);
		uname.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(1201, 296, 220, 27);
		contentPane.add(email);
		
		phno = new JTextField();
		phno.setColumns(10);
		phno.setBounds(1201, 353, 220, 27);
		contentPane.add(phno);
		
		password = new JPasswordField();
		password.setBounds(1201, 238, 220, 27);
		contentPane.add(password);
		
		JButton registerbtn = new JButton("Register");
		registerbtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		registerbtn.setBounds(1122, 433, 152, 27);
		contentPane.add(registerbtn);
		registerbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
					Statement stmt=con.createStatement();
					String sql="insert into patients values(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, uname.getText());
					ps.setString(2, password.getText());
					ps.setString(3, email.getText());
					ps.setString(4, phno.getText());
					
					try {
						int i=ps.executeUpdate();
						//System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "Registered succesfully");
							setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "Registered failed");
						}
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				catch (ClassNotFoundException e1) {
		
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
			
		});
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\reg (1).jpg"));
		lblNewLabel.setBounds(0, 0, 845, 845);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(83, 152, 221));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(845, 0, 695, 845);
		contentPane.add(lblNewLabel_1);
	}
}
