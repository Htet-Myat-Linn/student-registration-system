package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private String[] loginname;
	mySQLQueries msql=new mySQLQueries();
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("Admin Login:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblusername = new JLabel("Username:");
		lblusername.setForeground(Color.BLACK);
		lblusername.setBackground(Color.BLUE);

		Border b=BorderFactory.createLineBorder(Color.BLUE);
		lblusername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblusername.setBounds(141, 142, 121, 27);
		contentPane.add(lblusername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(308, 142, 149, 27);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setForeground(Color.BLACK);
		lblpassword.setBackground(Color.BLUE);
		lblpassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpassword.setBounds(141, 215, 121, 27);
		contentPane.add(lblpassword);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(38, 43, 496, 331);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Checking.IsNull(txtUsername.getText()))
			       {
			           JOptionPane.showMessageDialog(null, "Please enter user Name.");
			           txtUsername.requestFocus();
			           txtUsername.selectAll();  
			           
			       }
			else if(Checking.IsNull(passField.getText()))
			       {

			           JOptionPane.showMessageDialog(null, "Please enter password!");
			           passField.requestFocus();
			           passField.selectAll();
			       }
			
			String name=txtUsername.getText();
			String psw= passField.getText().toString();
			//loginname=msql.getPassword(psw,name);
			if(name.equals("admin") && psw.equals("12345678"))
			{
				MainRegistration reg=new MainRegistration();
				reg.show();
			}
			else {
			JOptionPane.showMessageDialog(null, "Username and password is does not match");
			txtUsername.requestFocus();
	        txtUsername.selectAll();  
	           
			
			//f.panel_3.hide();
			//f.show();
			//f.panel_1.show();
			//f.lbluser.setText(loginname[1]);
			//System.out.println(loginname[0]);


			}

			}
			
			
			
		});
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(198, 246, 114, 32);
		panel.add(btnNewButton);
		
		passField = new JPasswordField();
		passField.setBounds(275, 173, 141, 26);
		panel.add(passField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Su Mon Aung\\Downloads\\Screenshot 2023-04-04 225809.png"));
		lblNewLabel_1.setBounds(0, 0, 496, 331);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Student Registration Admin Login :");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(38, 11, 224, 21);
		contentPane.add(lblNewLabel);
	}
}
	
