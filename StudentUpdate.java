

package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class StudentUpdate extends JDialog {

	private final JPanel panel = new JPanel();
	public JTextField txtname;
	public JTextField txtPh;
	
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClose;
	public JComboBox cbostudentid;
	public JTextField txtNRC;
	public JTextField txtEmail;
	public JTextField txtAddress;
	public JTextField txtFather;
	public JTextField txtdob;
	private JLabel lblname;
	private JLabel lblnrc;
	private JLabel lblemail;
	private JLabel lbladdress;
	private JLabel lblfather;
	private JLabel lbldob;
	private JLabel l;
	private JLabel lblName;
	private JLabel lblph;
	public JTextField txtgender;
mySQLQueries msql=new mySQLQueries();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentUpdate dialog = new StudentUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentUpdate() {
		setTitle("Student Update");
		setBounds(100, 100, 368, 461);
		getContentPane().setLayout(null);
		panel.setBounds(10, 11, 326, 352);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		{
			l = new JLabel("Student ID:");
			l.setBounds(10, 29, 71, 14);
			panel.add(l);
		}
		{
			lblName = new JLabel("Student Name:");
			lblName.setBounds(10, 67, 95, 14);
			panel.add(lblName);
		}
		{
			lblnrc = new JLabel("NRC No:");
			lblnrc.setBounds(10, 103, 82, 14);
			panel.add(lblnrc);
		}
		
		
		{
			txtname = new JTextField();
			txtname.setColumns(10);
			txtname.setBounds(102, 64, 190, 20);
			panel.add(txtname);
		}
		{
			txtPh = new JTextField();
			txtPh.setColumns(10);
			txtPh.setBounds(102, 201, 190, 20);
			panel.add(txtPh);
		}
		
		
		cbostudentid = new JComboBox();
		cbostudentid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbostudentid.getSelectedIndex()<=0)
		        {
		            txtname.setText("");
		            txtname.setText("");
		           
		        }
		        else
		        {
		            showStudent();
		        }

			}
		});
		cbostudentid.setBounds(105, 25, 187, 22);
		panel.add(cbostudentid);
		
		lblph = new JLabel("Phone No:");
		lblph.setBounds(10, 204, 71, 14);
		panel.add(lblph);
		
		txtNRC = new JTextField();
		txtNRC.setBounds(102, 100, 190, 20);
		panel.add(txtNRC);
		txtNRC.setColumns(10);
		
		lblemail = new JLabel("Email:");
		lblemail.setBounds(10, 139, 71, 14);
		panel.add(lblemail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(102, 136, 190, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		lbladdress = new JLabel("Address:");
		lbladdress.setBounds(10, 176, 71, 14);
		panel.add(lbladdress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(102, 167, 190, 20);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		lblfather = new JLabel("Father Name:");
		lblfather.setBounds(10, 269, 88, 14);
		panel.add(lblfather);
		
		txtFather = new JTextField();
		txtFather.setBounds(102, 266, 187, 20);
		panel.add(txtFather);
		txtFather.setColumns(10);
		
		lbldob = new JLabel("Date Of Birth:");
		lbldob.setBounds(10, 309, 82, 14);
		panel.add(lbldob);
		
		txtdob = new JTextField();
		txtdob.setBounds(102, 303, 187, 20);
		panel.add(txtdob);
		txtdob.setColumns(10);
		
		JLabel lblgender = new JLabel("Gender:");
		lblgender.setHorizontalAlignment(SwingConstants.CENTER);
		lblgender.setBounds(10, 238, 46, 14);
		panel.add(lblgender);
		
		txtgender = new JTextField();
		txtgender.setBounds(102, 235, 187, 20);
		panel.add(txtgender);
		txtgender.setColumns(10);
		{
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbostudentid.getSelectedIndex()==0)
			        {
			            JOptionPane.showMessageDialog(null, "Please choose Studentt id.");
			            cbostudentid.requestFocus();
			        }
			        else if(Checking.IsValidName(txtname.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Name.");
			            txtname.requestFocus();
			            txtname.selectAll();
			        }
			        else if(Checking.IsValidName(txtNRC.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter NRC.");
			            txtPh.requestFocus();
			            txtPh.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtPh.getText().trim()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Phone No.");
			            txtNRC.requestFocus();
			            txtNRC.selectAll();
			        }
			        else if(Checking.IsValidName(txtEmail.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Email.");
			            txtEmail.requestFocus();
			            txtEmail.selectAll();
			        }
			        else if(Checking.IsValidName(txtAddress.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Address.");
			            txtAddress.requestFocus();
			            txtAddress.selectAll();
			        }
			        else if(Checking.IsValidName(txtgender.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Gender.");
			            txtgender.requestFocus();
			            txtgender.selectAll();
			        }
			        
			        else if(Checking.IsValidName(txtFather.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Father Name.");
			            txtFather.requestFocus();
			            txtFather.selectAll();
			        }
			        else if(Checking.IsValidName(txtdob.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Date Of Birth.");
			            txtdob.requestFocus();
			            txtdob.selectAll();
			        }
			       
			       
			       
			        else{
			        	 String st[] = new String[8];
							st[0] = (String)txtname.getText();
							st[1] = (String)txtPh.getText();
							st[2] = (String)txtNRC.getText();
							st[3] = (String)txtEmail.getText();
							st[4] = (String)txtAddress.getText();
							st[5] = (String)txtgender.getText();
							st[6] = (String)txtFather.getText();
							st[7] = (String)txtdob.getText();
							
							
							
				            boolean ee = msql.isduplicate("studenttb", st);
				            System.out.println(st[0]);
				            System.out.println(ee);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txtname.requestFocus();
				                txtname.selectAll();
				            }
					        else
					        {
					          if(JOptionPane.showConfirmDialog(null, "Are you Sure Update?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					          {
					        	  String str[] = new String[8];
					              String id = cbostudentid.getSelectedItem().toString();
					             
									str[0] = (String)txtname.getText();
									str[1] = (String)txtNRC.getText();
									str[2] = (String)txtPh.getText();
									str[3] = (String)txtEmail.getText();
									str[4] = (String)txtAddress.getText();
									str[5] = (String)txtgender.getText();
									str[6] = (String)txtFather.getText();
									str[7] = (String)txtdob.getText();
									
									System.out.print(txtname.getText());
									
					              
					              boolean save = msql.updateRecord2("studenttb", id, str);
					              if(save)
					              {
					                  JOptionPane.showMessageDialog(null, "Successfully update record!","Update Record.",JOptionPane.INFORMATION_MESSAGE);
					              clear();
					              cbostudentid.requestFocus();
					              }
					              else {
					            	  JOptionPane.showMessageDialog(null,"Failed to update the specified record","Cannot Update.",JOptionPane.INFORMATION_MESSAGE);
					              clear();
					              cbostudentid.requestFocus();
					              }
					              clear();
					              cbostudentid.requestFocus();
					          }
					        }
				            }
				}
			});
			btnUpdate.setBounds(21, 374, 89, 23);
			getContentPane().add(btnUpdate);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cbostudentid.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord1("studenttb", id);
	                    	clear();
	                    	fillStudent();
	                    }
	                    else
	                    {
	                    	JOptionPane.showMessageDialog(null, "Fail to delete record","Cannot Update",JOptionPane.INFORMATION_MESSAGE);
	                    }
	                } catch(Exception sqle) {
	                    sqle.printStackTrace();
	                }
					
				}
			});
			btnDelete.setBounds(129, 374, 89, 23);
			getContentPane().add(btnDelete);
		}
		{
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnClose.setBounds(247, 374, 89, 23);
			getContentPane().add(btnClose);
		}
		fillStudent();
		clear();
	}
	public void showStudent()
	{
	    String result[]= msql.getStudentData1(cbostudentid.getSelectedItem().toString());
	    txtname.setText(result[0]);
	    txtPh.setText(result[2]);
	    txtNRC.setText(result[1]);
	    txtEmail.setText(result[3]);
	    txtAddress.setText(result[4]);
	    txtgender.setText(result[5]);
	    txtFather.setText(result[6]);
	    txtdob.setText(result[7]);
	   
	}
	public void fillStudent()
    {
		cbostudentid.removeAllItems();
		cbostudentid.addItem("-Selected-");
        String str[]=mySQLQueries.getIDForChoice("studenttb");
        for(int i = 0 ; i<str.length ; i++)
        	cbostudentid.addItem(str[i].toString());
        cbostudentid.setSelectedIndex(0);
    }

    public void clear()
    {
        txtname.setText("");
        txtPh.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtNRC.setText("");
        txtgender.setText("");
        txtFather.setText("");
        txtdob.setText("");
        
        cbostudentid.requestFocus();
        cbostudentid.setSelectedIndex(0);
    }
}
/*  */
