package student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

public class StudentEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPh;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtFather;
	private JTextField txtdob;
	JLabel lblid;
	String gender,nrc;
	JRadioButton rdoMale;
	JRadioButton rdoFemale;
	mySQLQueries msql=new mySQLQueries();
	private JTextField txtNrc;
	JComboBox cboCode,cboCity,cboNation ;
	Map<Integer,List<String>> map = new HashMap<>();
	CityShortName shortName = new CityShortName();
	ArrayList listCode = new ArrayList();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentEntry dialog = new StudentEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentEntry() {
		setTitle("Student Entry:");
		setBounds(100, 100, 601, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblStuid = new JLabel("Student ID:");
		lblStuid.setBounds(67, 60, 103, 21);
		contentPanel.add(lblStuid);
		
		lblid = new JLabel("");
		Border blackline=BorderFactory.createLineBorder(Color.BLACK);
		lblid.setBorder(blackline);
		lblid.setBounds(223, 60, 179, 21);
		contentPanel.add(lblid);
		
		JLabel lblName = new JLabel("Student Name:");
		lblName.setBounds(67, 103, 103, 21);
		contentPanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(223, 103, 179, 21);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNrc = new JLabel("NRC No:");
		lblNrc.setBounds(67, 155, 103, 21);
		contentPanel.add(lblNrc);
		
		JLabel lblPh = new JLabel("Phone No:");
		lblPh.setBounds(67, 258, 103, 21);
		contentPanel.add(lblPh);
		
		txtPh = new JTextField();
		txtPh.setBounds(223, 258, 179, 21);
		contentPanel.add(txtPh);
		txtPh.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(67, 308, 87, 21);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(223, 308, 179, 21);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(67, 355, 103, 21);
		contentPanel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(223, 355, 179, 21);
		contentPanel.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(67, 411, 87, 21);
		contentPanel.add(lblGender);
		
		rdoMale = new JRadioButton("Male");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdoMale.isSelected())
				{
					rdoFemale.setSelected(false);
				}
				gender="Male";
			}
			
		});
		rdoMale.setMnemonic('M');
		rdoMale.setBounds(223, 410, 83, 23);
		contentPanel.add(rdoMale);
		
		rdoFemale = new JRadioButton("Female");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdoFemale.isSelected())
				{
					rdoMale.setSelected(false);
				}
				gender="Female";
				
			}
		});
		rdoFemale.setMnemonic('F');
		rdoFemale.setBounds(316, 410, 86, 23);
		contentPanel.add(rdoFemale);
		
		JLabel lblFather = new JLabel("Father Name:");
		lblFather.setBounds(67, 459, 87, 21);
		contentPanel.add(lblFather);
		
		txtFather = new JTextField();
		txtFather.setBounds(223, 459, 179, 21);
		contentPanel.add(txtFather);
		txtFather.setColumns(10);
		
		JLabel lbldob = new JLabel("Date of Birth:");
		lbldob.setBounds(67, 508, 87, 21);
		contentPanel.add(lbldob);
		
		txtdob = new JTextField();
		txtdob.setBounds(223, 508, 179, 21);
		contentPanel.add(txtdob);
		txtdob.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(67, 578, 457, 58);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			private boolean save;

			public void actionPerformed(ActionEvent e) {
				
				if(Checking.IsValidName(txtName.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
		        else if(Checking.IsNull(txtName.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter student name.");;
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
		       
		        else if(cboCode.getSelectedIndex()==0)
		        {
		            JOptionPane.showMessageDialog(null,"Please enter your code.");;
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
				
		        else if(cboCity.getSelectedIndex()==0)
		        {
		            JOptionPane.showMessageDialog(null,"Please enter your city .");;
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
				
		        else if(cboNation.getSelectedIndex()==0)
		        {
		            JOptionPane.showMessageDialog(null,"Please enter your nation.");;
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
				
		        else if(Checking.IsNull(txtNrc.getText()))
		         {
		            JOptionPane.showMessageDialog(null, "Please enter NRC number");
		            txtNrc.requestFocus();
		            txtNrc.selectAll();
		         }
		         else if(!Checking.IsAllDigit(txtNrc.getText()))
		         {
		            JOptionPane.showMessageDialog(null, "Please enter only digit in NRC number");
		            txtNrc.requestFocus();
		            txtNrc.selectAll();
		         }
		         else if(Checking.IsNull(txtPh.getText()))
			        {
			            JOptionPane.showMessageDialog(null,"Please enter student Phone Number.");
			            txtPh.requestFocus();
			            txtPh.selectAll();
			        }
		         else if(txtNrc.getText().length()<6||txtNrc.getText().length()>6)
		         {
		            JOptionPane.showMessageDialog(null, "Please enter only 6 digit");
		            txtNrc.requestFocus();
		            txtNrc.selectAll();
		         }
		        
		        else if(!Checking.IsAllDigit(txtPh.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter valid Phone Number.");
		            txtPh.requestFocus();
		            txtPh.selectAll();
		        }
				
		       
				
		        else if(txtPh.getText().length()>11)
		        {
		            JOptionPane.showMessageDialog(null, "Please enter phone number only 11 digit.");
		            txtPh.requestFocus();
		            txtPh.selectAll();
		        }
				
		         else if(Checking.IsNull(txtEmail.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Email.");
		            txtEmail.requestFocus();
		            txtEmail.selectAll();
		        }
		         else if(!Checking.IsEformat(txtEmail.getText()))
		         {
		            JOptionPane.showMessageDialog(null, "Please enter valid email address");
		            txtEmail.requestFocus();
		            txtEmail.selectAll();
		         }
		         else if(Checking.IsNull(txtAddress.getText()))
		         {
		            JOptionPane.showMessageDialog(null, "Please enter student address");
		            txtAddress.requestFocus();
		            txtAddress.selectAll();
		         }
		         else if(gender==null||gender.equals(""))
		         {
		            JOptionPane.showMessageDialog(null, "Please choose Male or Female");
		           
		         }
		         else if(Checking.IsNull(txtAddress.getText()))
		         {
		            JOptionPane.showMessageDialog(null, "Please enter student address");
		            txtAddress.requestFocus();
		            txtAddress.selectAll();
		         }
		        
				
				
				
				
		         
		         else{
		        		String code,city,nation,number;
						code = (String) cboCode.getSelectedItem();
						city = (String) cboCity.getSelectedItem();
						nation = (String) cboNation.getSelectedItem();
						number = txtNrc.getText();
						nrc = code + city + "(" + nation + ")" + number;
		        	 
		        	 String st[] = new String[1];
		        	 
		        	// st[0]=(String)txtName.getText();	
		        	 
					 st[0]=nrc;
						
						
						
			            boolean ee=msql.isduplicate("studenttb", st);
			            if(!ee)
			            {
			                JOptionPane.showMessageDialog(null, "Student ");
			                txtName.requestFocus();
			                txtName.selectAll();
			            }
			            else
						       {
			            	  	
							String str[]=new String[9];
							str[0]=lblid.getText();
							str[1]=txtName.getText();
							str[2]=nrc;
							str[3]=txtPh.getText();
							str[4]=txtEmail.getText();
							str[5]=txtAddress.getText();
							str[6]=gender;
							str[7]=txtFather.getText();
							str[8]=txtdob.getText();
							//str[9]=txtEmail.getText();
							boolean save=msql.insertData("studenttb", str);
			            	
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
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSave.setBackground(Color.WHITE);
		btnSave.setMnemonic('S');
		btnSave.setBounds(32, 11, 97, 36);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				
			}
			
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(189, 11, 89, 36);
		panel.add(btnCancel);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
			
			
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnClose.setMnemonic('C');
		btnClose.setBounds(330, 11, 89, 36);
		panel.add(btnClose);
		
		cboCode = new JComboBox();
		cboCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillCode();
			}
		});
		cboCode.setModel(new DefaultComboBoxModel(new String[] {"-select-", "1/", "2/", "3/", "4/", "5/", "6/", "7/", "8/", "9/", "10/", "11/", "12/", "13/", "14/"}));
		cboCode.setBounds(223, 154, 83, 22);
		contentPanel.add(cboCode);
		
		cboCity = new JComboBox();
		cboCity.setModel(new DefaultComboBoxModel(new String[] {"--select--"}));
		cboCity.setBounds(316, 154, 86, 22);
		contentPanel.add(cboCity);
		
		cboNation = new JComboBox();
		cboNation.setModel(new DefaultComboBoxModel(new String[] {"--select--", "N", "E", "P"}));
		cboNation.setBounds(223, 202, 83, 22);
		contentPanel.add(cboNation);
		
		txtNrc = new JTextField();
		txtNrc.setBounds(316, 203, 86, 20);
		contentPanel.add(txtNrc);
		txtNrc.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBorder(new TitledBorder(null, "Enter Student Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 565, 639);
		contentPanel.add(panel_1);
		
		AutoID();
		
		}
		
	
		
	
	public void AutoID()
	{
		try {
			lblid.setText((String.valueOf(msql.getAutoid("studentid","studenttb","STU-"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillCode() {
		map = shortName.getCityCode();
		if(cboCode.getSelectedIndex() == 1)
		{
			System.out.println("Short Name => "+ map.get(1));	
			listCode = (ArrayList) map.get(1);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++) 
			{
 
				cboCity.addItem(listCode.get(i));
			}
		} 
		else if(cboCode.getSelectedIndex() == 2) {
			System.out.println("Short Name => "+ map.get(2));	
			listCode = (ArrayList) map.get(2);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 3) {
			System.out.println("Short Name => "+ map.get(3));	
			listCode = (ArrayList) map.get(3);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 4) {
			System.out.println("Short Name => "+ map.get(4));	
			listCode = (ArrayList) map.get(4);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 5) {
			System.out.println("Short Name => "+ map.get(5));	
			listCode = (ArrayList) map.get(5);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 6) {
			System.out.println("Short Name => "+ map.get(6));	
			listCode = (ArrayList) map.get(6);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 7) {
			System.out.println("Short Name => "+ map.get(7));	
			listCode = (ArrayList) map.get(7);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 8) {
			System.out.println("Short Name => "+ map.get(8));	
			listCode = (ArrayList) map.get(8);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 9) {
			System.out.println("Short Name => "+ map.get(9));	
			listCode = (ArrayList) map.get(9);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 10) {
			System.out.println("Short Name => "+ map.get(10));	
			listCode = (ArrayList) map.get(10);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 11) {
			System.out.println("Short Name => "+ map.get(11));	
			listCode = (ArrayList) map.get(11);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 12) {
			System.out.println("Short Name => "+ map.get(12));	
			listCode = (ArrayList) map.get(12);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 13) {
			System.out.println("Short Name => "+ map.get(13));	
			listCode = (ArrayList) map.get(13);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
		else if(cboCode.getSelectedIndex() == 14) {
			System.out.println("Short Name => "+ map.get(14));	
			listCode = (ArrayList) map.get(14);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
 
		}
 
	}
	
        
        public void clear()
	    {
	        txtName.setText("");
	        txtNrc.setText("");
	        txtPh.setText("");
	        txtEmail.setText("");
	        txtAddress.setText("");
	        rdoMale.setSelected(false);
	        rdoFemale.setSelected(false);
	        txtFather.setText("");
	        txtdob.setText("");
	        cboCode.setSelectedIndex(0);
	        cboCity.setSelectedIndex(0);
	        cboNation.setSelectedIndex(0);
	        
	        txtName.requestFocus();
	    }
    
}

