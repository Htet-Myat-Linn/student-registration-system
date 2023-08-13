package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class CourseSchedule extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcname;
	private JTextField txtFee;
	JLabel lblcid ;
	mySQLQueries msql=new mySQLQueries();
	JCheckBox chkbx3,chkbx4,chkbx5,chkbx6,chkbx7,chkbx8 ,chkbx9;
	JRadioButton rdoAM ,rdoPM,rdoAM1,rdoPM1;
	JComboBox cboTeacher,cboRoom;
	//String chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9;
	JComboBox cbostime,cboetime,cbosmin,cboemin1;
	String time,time1;
	String day;
	JPanel panelDay;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CourseSchedule dialog = new CourseSchedule();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseSchedule() {
		setForeground(Color.BLACK);
		getContentPane().setForeground(Color.CYAN);
		setTitle("Course Schedule:");
		setBounds(100, 100, 572, 722);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.CYAN);
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCourseID = new JLabel("Course ID:");
			lblCourseID.setBounds(36, 47, 135, 25);
			contentPanel.add(lblCourseID);
		}
		{
			lblcid = new JLabel("");
			Border b=BorderFactory.createLineBorder(Color.BLACK);
			lblcid.setBorder(b);
			lblcid.setBounds(214, 47, 258, 25);
			contentPanel.add(lblcid);
		}
		{
			JLabel lblcName = new JLabel("Course Name:");
			lblcName.setBounds(36, 105, 135, 25);
			contentPanel.add(lblcName);
		}
		{
			txtcname = new JTextField();
			txtcname.setBounds(214, 105, 258, 25);
			contentPanel.add(txtcname);
			txtcname.setColumns(10);
		}
		{
			JLabel lblday = new JLabel("Choose Day:");
			lblday.setBounds(36, 199, 135, 25);
			contentPanel.add(lblday);
		}
		
		JLabel lblstime = new JLabel("From: Time");
		lblstime.setBounds(36, 299, 135, 25);
		contentPanel.add(lblstime);
		
		cbostime = new JComboBox();
		cbostime.setModel(new DefaultComboBoxModel(new String[] {"-select-", "1:", "2:", "3:", "4:", "5:", "6:", "7:", "8:", "9:", "10:", "11:", "12:"}));
		cbostime.setBounds(214, 300, 66, 22);
		contentPanel.add(cbostime);
		
		rdoAM = new JRadioButton("AM");
		rdoAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoAM.isSelected())
				{
					rdoPM.setSelected(false);
				}
				
				time="AM";
			}
		});
		rdoAM.setBounds(352, 300, 50, 23);
		contentPanel.add(rdoAM);
		
		rdoPM = new JRadioButton("PM");
		rdoPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoPM.isSelected())
				{
					rdoAM.setSelected(false);
				}
				time="PM";
			}
		});
		rdoPM.setBounds(422, 300, 50, 23);
		contentPanel.add(rdoPM);
		
		JLabel lbletime = new JLabel("To: Time");
		lbletime.setBounds(36, 358, 135, 25);
		contentPanel.add(lbletime);
		
		cboetime = new JComboBox();
		cboetime.setModel(new DefaultComboBoxModel(new String[] {"-select-", "1:", "2:", "3:", "4:", "5:", "6:", "7:", "8:", "9:", "10:", "11:", "12:"}));
		cboetime.setBounds(214, 359, 66, 22);
		contentPanel.add(cboetime);
		
		rdoAM1 = new JRadioButton("AM");
		rdoAM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoAM1.isSelected())
				{
					rdoPM1.setSelected(false);
				}
				time1="AM";
			}
		});
		rdoAM1.setBounds(352, 359, 50, 23);
		contentPanel.add(rdoAM1);
		
		rdoPM1 = new JRadioButton("PM");
		rdoPM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoPM1.isSelected())
				{
					rdoAM1.setSelected(false);
;				}
				time1="PM";
			}
		});
		rdoPM1.setBounds(422, 359, 50, 23);
		contentPanel.add(rdoPM1);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setBounds(36, 416, 135, 25);
		contentPanel.add(lblFee);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(67, 591, 413, 56);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String result="";
	        	 
		            for(Component c: panelDay.getComponents())
		            {
		            	if(c.getClass().equals(JCheckBox.class))
		            	{
		            		JCheckBox jck=(JCheckBox) c;
		            		if(jck.isSelected())
		            		{
		            			result+=jck.getText()+",";
		            			
		            		}
		            		
		            	}
		            }
				
				if(Checking.IsNull(txtcname.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter course Name.");
		            txtcname.requestFocus();
		            txtcname.selectAll();
		        }
		        else if(day==null)
		        {
		        	JOptionPane.showMessageDialog(null, "Please choose day");
		        	
		            
		        }
		        else if(cbostime.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose start time");
				}
		        else if(cbosmin.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose start minutes");
				}
		        else if(time==null||time.equals(""))
		         {
		            JOptionPane.showMessageDialog(null, "Please choose AM or PM");
		           
		         }
				
		        else if(cboetime.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose end time");
				}
					       
		        else if(cboemin1.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose end minutes");
				}
		       
		       
		        else if(time1==null||time1.equals(""))
		         {
		            JOptionPane.showMessageDialog(null, "Please choose AM or PM");
		           
		         }
				
		        else if(Checking.IsNull(txtFee.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter course fee.");
		            txtFee.requestFocus();
		            txtFee.selectAll();
		        }
		        else if(!Checking.IsAllDigit(txtFee.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter valid course fee.");
		            txtFee.requestFocus();
		            txtFee.selectAll();
		        }
				
		        else if(cboTeacher.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose teacher name");
				}
				
		        else if(cboRoom.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose room number");
				}
							
		         
		        else{
		        	
		        	/*
		        	String st[] = new String[4];
		        	 st[0]=cbostime.getSelectedItem().toString().trim();
		        	 st[1]=cbosmin.getSelectedItem().toString().trim();
		        	 //st[3]=time;
		        	 st[2]=cboetime.getSelectedItem().toString().trim();
		        	 st[3]=cboemin1.getSelectedItem().toString().trim();
		        	// st[6]=time1;
		        	*/
				           
				          
		        	
		        
		        	 String st[] = new String[4];
		        	 st[0]=result;
		        	 st[1]=cbostime.getSelectedItem().toString().trim()+" "+cbosmin.getSelectedItem().toString().trim()+" "+time;
		        	 st[2]=cboetime.getSelectedItem().toString().trim()+" "+cboemin1.getSelectedItem().toString().trim()+" "+time1;
		        	 st[3]=msql.getRoomID(cboRoom.getSelectedItem().toString());
		        	 
		        	 							
			            boolean ee=msql.isduplicate("coursesctb", st);
			            boolean eeStart=msql.isduplicate("coursesctbStart", st);
			            boolean eeEnd=msql.isduplicate("coursesctbEnd", st);
			            
			            boolean eeBetween=msql.isBetweenTimes(st);
			            if(eeBetween) {
			            	 JOptionPane.showMessageDialog(null, "Time conflict!");
				                txtcname.requestFocus();
				                txtcname.selectAll();
			            }
			            else if(!ee )
			            {
			                JOptionPane.showMessageDialog(null, "Duplicate Record!");
			                txtcname.requestFocus();
			                txtcname.selectAll();
			            }else if(!eeStart)  {
			                JOptionPane.showMessageDialog(null, "Start Time Duplicate!");
			                txtcname.requestFocus();
			                txtcname.selectAll();
			            }
			            else if(!eeEnd)  {
			                JOptionPane.showMessageDialog(null, "End Time Duplicate!");
			                txtcname.requestFocus();
			                txtcname.selectAll();
			            }
			            	
			           
			            else
						       {
					            String str[]=new String[8];
					            str[0]=lblcid.getText();
					            str[1]=txtcname.getText();
					            str[2]=result;
					            str[3]=cbostime.getSelectedItem().toString().trim()+" "+cbosmin.getSelectedItem().toString().trim()+" "+time;                      
					            str[4]=cboetime.getSelectedItem().toString().trim()+" "+cboemin1.getSelectedItem().toString().trim()+" "+time1;
					            str[5]=txtFee.getText();
					            str[6]=msql.getTeacherid((String) cboTeacher.getSelectedItem());
					            str[7]=msql.getRoomID((String) cboRoom.getSelectedItem());
					           
					            boolean save=msql.insertData("coursesctb", str);
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
		btnSave.setBounds(34, 11, 89, 34);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(159, 11, 89, 34);
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
		btnClose.setMnemonic('C');
		btnClose.setBounds(284, 11, 89, 34);
		panel.add(btnClose);
		
		txtFee = new JTextField();
		txtFee.setBounds(214, 418, 258, 23);
		contentPanel.add(txtFee);
		txtFee.setColumns(10);
		
		JLabel lblTeacher = new JLabel("Teacher Name:");
		lblTeacher.setBounds(36, 477, 135, 25);
		contentPanel.add(lblTeacher);
		
		JLabel lblRoom = new JLabel("Room No:");
		lblRoom.setBounds(36, 531, 135, 25);
		contentPanel.add(lblRoom);
		
		cboTeacher = new JComboBox();
		cboTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cboTeacher.setBounds(214, 478, 258, 22);
		contentPanel.add(cboTeacher);
		
		cboRoom = new JComboBox();
		cboRoom.setBounds(214, 532, 258, 22);
		contentPanel.add(cboRoom);
		
		cbosmin = new JComboBox();
		cbosmin.setModel(new DefaultComboBoxModel(new String[] {"-select-", "00", "30"}));
		cbosmin.setBounds(279, 300, 61, 22);
		contentPanel.add(cbosmin);
		
		cboemin1 = new JComboBox();
		cboemin1.setModel(new DefaultComboBoxModel(new String[] {"-select-", "00", "30"}));
		cboemin1.setBounds(279, 359, 61, 22);
		contentPanel.add(cboemin1);
		
		panelDay = new JPanel();
		panelDay.setBackground(Color.LIGHT_GRAY);
		panelDay.setBounds(214, 164, 258, 120);
		contentPanel.add(panelDay);
		panelDay.setLayout(null);
		
		chkbx3 = new JCheckBox("Mon");
		chkbx3.setBounds(6, 7, 61, 23);
		panelDay.add(chkbx3);
		
		chkbx4 = new JCheckBox("Tue");
		chkbx4.setBounds(99, 7, 66, 23);
		panelDay.add(chkbx4);
		
		chkbx5 = new JCheckBox("Wed");
		chkbx5.setBounds(186, 7, 66, 23);
		panelDay.add(chkbx5);
		
		chkbx7 = new JCheckBox("Fri");
		chkbx7.setBounds(99, 51, 66, 23);
		panelDay.add(chkbx7);
		
		chkbx6 = new JCheckBox("Thu");
		chkbx6.setBounds(6, 51, 61, 23);
		panelDay.add(chkbx6);
		
		chkbx9 = new JCheckBox("Sun");
		chkbx9.setBounds(99, 90, 61, 23);
		panelDay.add(chkbx9);
		
		chkbx8 = new JCheckBox("Sat");
		chkbx8.setBounds(6, 90, 61, 23);
		panelDay.add(chkbx8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setForeground(Color.CYAN);
		panel_1.setBorder(new TitledBorder(null, "Course Schedule Detail ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 536, 661);
		contentPanel.add(panel_1);
		chkbx9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chkbx9.isSelected())
					day="Sun";
			}
		});
		chkbx6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbx6.isSelected())
					
					day="Thu";
			}
		});
		chkbx7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbx7.isSelected())
					
					day="Fri";
			}
		});
		chkbx5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbx5.isSelected())
					
					day="Wed";
			}
		});
		chkbx4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbx4.isSelected())
					
					day="Tue";
			}
		});
		chkbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbx3.isSelected())
					
					day="Mon";
				
			}
		});
		
		AutoID();
		fillTeacher();
		fillRoom();
	}
	
	public void AutoID()
	{
		try {
			lblcid.setText((String.valueOf(msql.getAutoid("coursescid","coursesctb","CSE_"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void clear()
	{
		    txtcname.setText("");
		    
	        //chkbx1.setSelected(false);
	        //chkbx2.setSelected(false);
	        chkbx3.setSelected(false);
	        chkbx4.setSelected(false);
	        chkbx5.setSelected(false);
	        chkbx6.setSelected(false);
	        chkbx7.setSelected(false);
	        chkbx8.setSelected(false);
	        chkbx9.setSelected(false);
	        
	        cbostime.setSelectedIndex(0);
	        cbosmin.setSelectedIndex(0);
	        cboetime.setSelectedIndex(0);
	        cboemin1.setSelectedIndex(0);
	        
	        rdoAM.setSelected(false);
	        rdoPM.setSelected(false);
	        rdoAM1.setSelected(false);
	        rdoPM1.setSelected(false);
	        	        
	        txtFee.setText("");
	        cboTeacher.setSelectedIndex(0);
	        cboRoom.setSelectedIndex(0);
	        
	        txtcname.requestFocus();
		
	}
	
	public void fillTeacher()
    {
        String str[]=msql.getNameForChoice("teachertb");
        cboTeacher.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cboTeacher.addItem(str[i].toString());
    }
	public void fillRoom()
    {
        String str[]=msql.getNameForChoice("roomtb");
        cboRoom.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cboRoom.addItem(str[i].toString());
    }
}
