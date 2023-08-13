package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TeacherEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTName;
	private JTextField txtTPh;
	private JTextField txtTEmail;
	JLabel lbltid ;
	mySQLQueries msql=new mySQLQueries();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TeacherEntry dialog = new TeacherEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TeacherEntry() {
		setTitle("Teacher Entry:");
		setBounds(100, 100, 456, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.CYAN);
			panel.setBorder(new TitledBorder(null, "Lecturer Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 414, 226);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblTeacher = new JLabel("Teacher ID:");
				lblTeacher.setBounds(10, 38, 105, 25);
				panel.add(lblTeacher);
			}
			{
				JLabel lbltName = new JLabel("Name:");
				lbltName.setBounds(10, 80, 105, 25);
				panel.add(lbltName);
			}
			{
				JLabel lblTph = new JLabel("Phone No:");
				lblTph.setBounds(10, 126, 105, 25);
				panel.add(lblTph);
			}
			{
				JLabel lbltEmail = new JLabel("Email:");
				lbltEmail.setBounds(10, 170, 105, 25);
				panel.add(lbltEmail);
			}
			{
				lbltid = new JLabel("");
				Border b=BorderFactory.createLineBorder(Color.BLACK);
				lbltid.setBorder(b);
				lbltid.setBounds(125, 38, 110, 25);
				panel.add(lbltid);
			}
			{
				txtTName = new JTextField();
				txtTName.setBounds(125, 80, 110, 25);
				panel.add(txtTName);
				txtTName.setColumns(10);
			}
			{
				txtTPh = new JTextField();
				txtTPh.setColumns(10);
				txtTPh.setBounds(125, 128, 110, 25);
				panel.add(txtTPh);
			}
			{
				txtTEmail = new JTextField();
				txtTEmail.setColumns(10);
				txtTEmail.setBounds(125, 172, 110, 25);
				panel.add(txtTEmail);
			}
		}
		{
			JButton btnSave = new JButton("Save");
			btnSave.setForeground(Color.WHITE);
			btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnSave.setBackground(Color.BLUE);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(Checking.IsNull(txtTName.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Teacher Name.");
			            txtTName.requestFocus();
			            txtTName.selectAll();
			        }
			        else if(Checking.IsNull(txtTPh.getText()))
			        {
			            JOptionPane.showMessageDialog(null,"Please Phone No.");;
			            txtTPh.requestFocus();
			            txtTPh.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtTPh.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid phone no.");
			            txtTPh.requestFocus();
			            txtTPh.selectAll();
			        }
			        else if(txtTPh.getText().length()>11)
			        {
			            JOptionPane.showMessageDialog(null, "Please enter phone number only 11 digit.");
			            txtTPh.requestFocus();
			            txtTPh.selectAll();
			        }
			        else if(Checking.IsNull(txtTEmail.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter email address.");
			            txtTEmail.requestFocus();
			            txtTEmail.selectAll();
			        }
			        else if(!Checking.IsEformat(txtTEmail.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid email address.");
			            txtTEmail.requestFocus();
			            txtTEmail.selectAll();
			        }
					
					
			        else{
			        	 String st[] = new String[3];
							st[0]=(String)txtTName.getText();
							st[1]=(String)txtTPh.getText();
							st[2]=(String)txtTEmail.getText();
							
							
				            boolean ee=msql.isduplicate("teachertb", st);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txtTName.requestFocus();
				                txtTName.selectAll();
				            }
				            else
							       {
						            String str[]=new String[4];
						            str[0]=lbltid.getText();
						            str[1]=txtTName.getText();
						            str[2]=txtTPh.getText();
						            str[3]=txtTEmail.getText();
						           
						            //str[9]=txtEmail.getText();
						            boolean save=msql.insertData("teachertb", str);
						            if(save)
						            {
						                JOptionPane.showMessageDialog(null, "Successfully saved record!","Save Record.",JOptionPane.INFORMATION_MESSAGE);
						                AutoID();
						                clear();
						            }
						            else
						            {
						                JOptionPane.showMessageDialog(null,"Failed to save new record","Cannot Save",JOptionPane.INFORMATION_MESSAGE);
						                AutoID();
						            }
						        
							       }
			        }
				}
			});
			btnSave.setMnemonic('S');
			btnSave.setBounds(45, 248, 89, 32);
			contentPanel.add(btnSave);
		}
		{
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setForeground(Color.WHITE);
			btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnCancel.setBackground(Color.BLUE);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			btnCancel.setMnemonic('C');
			btnCancel.setBounds(174, 248, 89, 32);
			contentPanel.add(btnCancel);
		}
		{
			JButton btnClose = new JButton("Close");
			btnClose.setForeground(Color.WHITE);
			btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnClose.setBackground(Color.BLUE);
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnClose.setMnemonic('C');
			btnClose.setBounds(301, 248, 89, 32);
			contentPanel.add(btnClose);
		}
		
		AutoID();
	}
	
	public void AutoID()
	
	{
		try {
			lbltid.setText((String.valueOf(msql.getAutoid("teacherid","teachertb","TCR-"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clear()
	{
		txtTName.setText("");
	    txtTPh.setText("");
	    txtTEmail.setText("");
	    txtTName.requestFocus();
	}
	

}
