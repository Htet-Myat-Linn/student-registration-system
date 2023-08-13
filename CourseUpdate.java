
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
import java.awt.SystemColor;

public class CourseUpdate extends JDialog {
	private final JPanel panel = new JPanel();
	public JTextField txtcname;
	public JTextField txtcfee;
	
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClose;
	public JComboBox cbocoursescid;
	public JTextField txtcourseday;
	public JTextField txtstime;
	public JTextField txtetime;
	public JTextField txttname;
	public JTextField txtroom;
	private JLabel lblcourseday;
	private JLabel lblcoursestime;
	private JLabel lbletime;
	private JLabel lblcoursefee;
	private JLabel lbltname;
	private JLabel lblroom;
	mySQLQueries msql=new mySQLQueries();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CourseUpdate dialog = new CourseUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseUpdate() {
		setTitle("Course Update");
		setBounds(100, 100, 368, 405);
		getContentPane().setLayout(null);
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 326, 310);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Course Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		{
			JLabel l = new JLabel("Course ID:");
			l.setBounds(10, 29, 71, 14);
			panel.add(l);
		}
		{
			JLabel lblcourseName = new JLabel("Course Name:");
			lblcourseName.setBounds(10, 67, 95, 14);
			panel.add(lblcourseName);
		}
		{
			lblcoursefee = new JLabel("Course Fee:");
			lblcoursefee.setBounds(10, 204, 82, 14);
			panel.add(lblcoursefee);
		}
		
		
		{
			txtcname = new JTextField();
			txtcname.setColumns(10);
			txtcname.setBounds(102, 64, 190, 20);
			panel.add(txtcname);
		}
		{
			txtcfee = new JTextField();
			txtcfee.setColumns(10);
			txtcfee.setBounds(102, 201, 190, 20);
			panel.add(txtcfee);
		}
		
		
		cbocoursescid = new JComboBox();
		cbocoursescid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbocoursescid.getSelectedIndex()==0)
		        {
		            txtcname.setText("");
		            txtcfee.setText("");
		           
		        }
		        else
		        {
		            showCourse();
		        }

			}
		});
		cbocoursescid.setBounds(105, 25, 187, 22);
		panel.add(cbocoursescid);
		
		lblcourseday = new JLabel("Course Day:");
		lblcourseday.setBounds(10, 103, 71, 14);
		panel.add(lblcourseday);
		
		txtcourseday = new JTextField();
		txtcourseday.setBounds(102, 100, 190, 20);
		panel.add(txtcourseday);
		txtcourseday.setColumns(10);
		
		lblcoursestime = new JLabel("Start Time:");
		lblcoursestime.setBounds(10, 139, 71, 14);
		panel.add(lblcoursestime);
		
		txtstime = new JTextField();
		txtstime.setBounds(102, 136, 190, 20);
		panel.add(txtstime);
		txtstime.setColumns(10);
		
		lbletime = new JLabel("End Time:");
		lbletime.setBounds(10, 176, 71, 14);
		panel.add(lbletime);
		
		txtetime = new JTextField();
		txtetime.setBounds(102, 167, 190, 20);
		panel.add(txtetime);
		txtetime.setColumns(10);
		
		lbltname = new JLabel("Teacher Name:");
		lbltname.setBounds(10, 238, 88, 14);
		panel.add(lbltname);
		
		txttname = new JTextField();
		txttname.setBounds(102, 232, 187, 20);
		panel.add(txttname);
		txttname.setColumns(10);
		
		lblroom = new JLabel("Room:");
		lblroom.setBounds(10, 273, 46, 14);
		panel.add(lblroom);
		
		txtroom = new JTextField();
		txtroom.setBounds(102, 270, 187, 20);
		panel.add(txtroom);
		txtroom.setColumns(10);
		{
			btnUpdate = new JButton("Update");
			btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setBackground(Color.BLUE);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbocoursescid.getSelectedIndex()==0)
			        {
			            JOptionPane.showMessageDialog(null, "Please choose course schedule id.");
			            cbocoursescid.requestFocus();
			        }
			        else if(Checking.IsValidName(txtcname.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Name.");
			            txtcname.requestFocus();
			            txtcname.selectAll();
			        }
			        else if(Checking.IsValidName(txtcourseday.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Day.");
			            txtcourseday.requestFocus();
			            txtcourseday.selectAll();
			        }
			        else if(Checking.IsValidName(txtstime.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Start Time.");
			            txtstime.requestFocus();
			            txtstime.selectAll();
			        }
			        else if(Checking.IsValidName(txtetime.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid End Time.");
			            txtetime.requestFocus();
			            txtetime.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtcfee.getText().trim()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter course Fee.");
			            txtcfee.requestFocus();
			            txtcfee.selectAll();
			        }
			        else if(Checking.IsValidName(txttname.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Teacher Name.");
			            txttname.requestFocus();
			            txttname.selectAll();
			        }
			        else if(Checking.IsValidName(txtroom.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Room No.");
			            txtroom.requestFocus();
			            txtroom.selectAll();
			        }
					
			      
			       
			       
			       
			        else{
			        	 String st[] = new String[7];
							st[0] = (String)txtcname.getText();
							st[1] = (String)txtcourseday.getText();
							st[2] = (String)txtstime.getText();
							st[3] = (String)txtetime.getText();
							st[4] = (String)txtcfee.getText();
							st[5] = (String)txttname.getText();
							st[6] = (String)txtroom.getText();
							
							
							
							
				            boolean ee =msql.isduplicate("coursesctb", st);
				            System.out.println(st[0]);
				            System.out.println(ee);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txtcname.requestFocus();
				                txtcname.selectAll();
				            }
					        else
					        {
					          if(JOptionPane.showConfirmDialog(null, "Are you Sure Update?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					          {
					              String []str = new String[7];
					              String id = cbocoursescid.getSelectedItem().toString();
					              st[0] = (String)txtcname.getText();
									st[1] = (String)txtcourseday.getText();
									st[2] = (String)txtstime.getText();
									st[3] = (String)txtetime.getText();
									st[4] = (String)txtcfee.getText();
									st[5] = (String)txttname.getText();
									st[6] = (String)txtroom.getText();
									
					              
					              boolean save = mySQLQueries.updateRecord("coursesctb", id, st);
					              if(save)
					              {
					                  JOptionPane.showMessageDialog(null, "Successfully update record!","Update Record.",JOptionPane.INFORMATION_MESSAGE);
					              clear();
					              cbocoursescid.requestFocus();
					              }
					              else {
					            	  JOptionPane.showMessageDialog(null,"Failed to update the specified record","Cannot Updae.",JOptionPane.INFORMATION_MESSAGE);
					              clear();
					              cbocoursescid.requestFocus();
					              }
					              clear();
					              cbocoursescid.requestFocus();
					          }
					        }
				            }
				}
			});
			btnUpdate.setBounds(20, 332, 89, 23);
			getContentPane().add(btnUpdate);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnDelete.setBackground(Color.BLUE);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cbocoursescid.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord("coursesctb", id);
	                    	fillCourse();
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
			btnDelete.setBounds(130, 332, 89, 23);
			getContentPane().add(btnDelete);
		}
		{
			btnClose = new JButton("Close");
			btnClose.setForeground(Color.WHITE);
			btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnClose.setBackground(Color.BLUE);
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnClose.setBounds(247, 332, 89, 23);
			getContentPane().add(btnClose);
		}
		fillCourse();
		clear();
	}
	public void showCourse()
	{
	    String result[]=msql.getCourseData1(cbocoursescid.getSelectedItem().toString());
	    txtcname.setText(result[0]);
	    txtcourseday.setText(result[1]);
	    txtstime.setText(result[2]);
	    txtetime.setText(result[3]);
	    txtcfee.setText(result[4]);
	    txttname.setText(result[5]);
	    txtroom.setText(result[6]);
	   
	}
	public void fillCourse()
    {
		cbocoursescid.removeAllItems();
		cbocoursescid.addItem("-Selected-");
        String str[]=mySQLQueries.getIDForChoice("coursesctb");
        for(int i = 0 ; i<str.length ; i++)
        	cbocoursescid.addItem(str[i].toString());
        cbocoursescid.setSelectedIndex(0);
    }

    public void clear()
    {
        txtcname.setText("");
        txtcourseday.setText("");
        txtstime.setText("");
        txtetime.setText("");
        txtcfee.setText("");
        txttname.setText("");
        txtroom.setText("");
        
        cbocoursescid.requestFocus();
        cbocoursescid.setSelectedIndex(0);
    }
}
