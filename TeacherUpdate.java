package student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TeacherUpdate extends JDialog {
	private final JPanel panel = new JPanel();
	public JTextField txttname;
	public JTextField txttphno;
	public JTextField txttemail;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClose;
	public JComboBox cboteacherid;
	mySQLQueries msql=new mySQLQueries();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TeacherUpdate dialog = new TeacherUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TeacherUpdate() {
		setTitle("Teacher Update");
		setBounds(100, 100, 421, 299);
		getContentPane().setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 385, 187);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Teacher Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		{
			JLabel l = new JLabel("Teacher ID:");
			l.setBounds(10, 29, 71, 14);
			panel.add(l);
		}
		{
			JLabel lblteacherName = new JLabel("Teacher Name:");
			lblteacherName.setBounds(10, 67, 95, 14);
			panel.add(lblteacherName);
		}
		
		{
			JLabel lblteacherPhoneNo = new JLabel("Teacher Phone No:");
			lblteacherPhoneNo.setBounds(10, 107, 95, 14);
			panel.add(lblteacherPhoneNo);
		}
		{
			JLabel lblteacherEmail = new JLabel("Teacher Email:");
			lblteacherEmail.setBounds(10, 149, 95, 14);
			panel.add(lblteacherEmail);
		}
		{
			txttname = new JTextField();
			txttname.setColumns(10);
			txttname.setBounds(138, 64, 190, 20);
			panel.add(txttname);
		}
		
		{
			txttphno = new JTextField();
			txttphno.setColumns(10);
			txttphno.setBounds(138, 104, 190, 20);
			panel.add(txttphno);
		}
		{
			txttemail = new JTextField();
			txttemail.setColumns(10);
			txttemail.setBounds(138, 146, 190, 20);
			panel.add(txttemail);
		}
		
		cboteacherid = new JComboBox();
		cboteacherid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboteacherid.getSelectedIndex()<=0)
		        {
		            txttname.setText("");
		            txttphno.setText("");
		            txttemail.setText("");
		        }
		        else
		        {
		            showTeacher();
		        }

			}
		});
		cboteacherid.setBounds(138, 25, 187, 22);
		panel.add(cboteacherid);
		{
			btnUpdate = new JButton("Update");
			btnUpdate.setBackground(Color.BLUE);
			btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cboteacherid.getSelectedIndex()==0)
			        {
			            JOptionPane.showMessageDialog(null, "Please choose teacher id.");
			            cboteacherid.requestFocus();
			        }
			        else if(Checking.IsValidName(txttname.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Name.");
			            txttname.requestFocus();
			            txttname.selectAll();
			        }
			        
			          else if(Checking.IsNull(txttphno.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Phone.");
			            txttphno.requestFocus();
			            txttphno.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txttphno.getText().trim()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Phone Number.");
			            txttphno.requestFocus();
			            txttphno.selectAll();
			        }
			        else if(Checking.IsNull(txttemail.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Email.");
			            txttemail.requestFocus();
			            txttemail.selectAll();
			        }
			        else{
			        	 String st[] = new String[3];
							st[0] = (String)txttname.getText();
							st[1] = (String)txttphno.getText();
							st[2] = (String)txttemail.getText();
							
							
				            boolean ee =msql.isduplicate("teachertb", st);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txttname.requestFocus();
				                txttname.selectAll();
				            }
					        else
					        {
					          if(JOptionPane.showConfirmDialog(null, "Are you Sure Update?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					          {
					              String []str = new String[3];
					              String id = cboteacherid.getSelectedItem().toString();
					              str[0]=txttname.getText();
					              str[1]=txttphno.getText();
					              str[2]=txttemail.getText();
					              boolean save = mySQLQueries.updateRecord("teachertb", id, str);
					              if(save)
					              {
					                  JOptionPane.showMessageDialog(null, "Successfully update record!","Update Record.",JOptionPane.INFORMATION_MESSAGE);
					                  clear();
						              cboteacherid.requestFocus();
					              }
					              else {
					            	  JOptionPane.showMessageDialog(null,"Failed to update the specified record","Cannot Updae.",JOptionPane.INFORMATION_MESSAGE);
					              clear();
					              cboteacherid.requestFocus();
					              }
					              clear();
					              cboteacherid.requestFocus();
					          }
			        }
			        }
				}
			});
			btnUpdate.setBounds(20, 218, 89, 23);
			getContentPane().add(btnUpdate);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnDelete.setBackground(Color.BLUE);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cboteacherid.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord("teachertb", id);
	                    	fillteacher();
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
			btnDelete.setBounds(132, 218, 89, 23);
			getContentPane().add(btnDelete);
		}
		{
			btnClose = new JButton("Close");
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
			btnClose.setBounds(242, 218, 89, 23);
			getContentPane().add(btnClose);
		}
		fillteacher();
		clear();
	}
	public void showTeacher()
	{
	    String result[]= mySQLQueries.getTeacherData(cboteacherid.getSelectedItem().toString());
	    txttname.setText(result[0]);
	    txttphno.setText(result[1]);
	    txttemail.setText(result[2]);
	}
	public void fillteacher()
    {
        cboteacherid.removeAllItems();
        cboteacherid.addItem("-Selected-");
        String str[]=mySQLQueries.getIDForChoice("teachertb");
        for(int i = 0 ; i<str.length ; i++)
        	cboteacherid.addItem(str[i].toString());
        cboteacherid.setSelectedIndex(0);
    }

    public void clear()
    {
        txttname.setText("");
        txttphno.setText("");
        txttemail.setText("");
        cboteacherid.requestFocus();
        cboteacherid.setSelectedIndex(0);
    }



}
