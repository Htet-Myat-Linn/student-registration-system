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

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegistrationEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Border b=BorderFactory.createLineBorder(Color.BLACK);
	private JTextField txtEfee;
	JLabel lblrid ;
	mySQLQueries msql=new mySQLQueries();
	JComboBox cbosName,cboCourse;
	JLabel lblnrc1,lblPh1,lblEmail1,lblAddress1,lblGender1,lblFather1,lbldob1;
	JLabel lblDay1,lblsTime1,lbleTime1,lblFee1,lblTeacher1,lblRoom1,lblDate1;
	date d=new date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrationEntry dialog = new RegistrationEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrationEntry() {
		setTitle("Registration Form:");
		setBounds(100, 100, 818, 551);
		
		/*
		Dimension screenDimension=Toolkit.getDefaultToolkit().getScreenSize();
		int centerX=(int) (screenDimension.getWidth() - getWidth()) /2;
		int centerY=(int) (screenDimension.getWidth() - getHeight()) /2;
		setLocation(centerX,centerY);
		*/
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registration Form:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 205, 26);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.CYAN);
		panel.setBounds(10, 45, 361, 400);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Registration ID:");
		lblNewLabel_1.setBounds(10, 11, 113, 21);
		panel.add(lblNewLabel_1);
		
		lblrid = new JLabel("");
		lblrid.setBorder(b);
		lblrid.setBounds(179, 14, 144, 21);
		panel.add(lblrid);
		
		JLabel lblStuName = new JLabel("Student Name:");
		lblStuName.setBounds(10, 54, 113, 21);
		panel.add(lblStuName);
		
		cbosName = new JComboBox();
		cbosName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudent();
				
			}
		});
		cbosName.setBounds(179, 54, 144, 21);
		panel.add(cbosName);
		
		JLabel lblnrc = new JLabel("NRC No:");
		lblnrc.setBounds(10, 99, 113, 21);
		panel.add(lblnrc);
		
		lblnrc1 = new JLabel("");
		lblnrc1.setBorder(b);
		lblnrc1.setBounds(179, 102, 144, 21);
		panel.add(lblnrc1);
		
		JLabel lblPh = new JLabel("Ph No:");
		lblPh.setBounds(10, 144, 113, 21);
		panel.add(lblPh);
		
		lblPh1 = new JLabel("");
		lblPh1.setBorder(b);
		lblPh1.setBounds(179, 144, 144, 21);
		panel.add(lblPh1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 186, 113, 21);
		panel.add(lblEmail);
		
		lblEmail1 = new JLabel("");
		lblEmail1.setBorder(b);
		lblEmail1.setBounds(179, 186, 144, 21);
		panel.add(lblEmail1);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 231, 113, 21);
		panel.add(lblAddress);
		
		lblAddress1 = new JLabel("");
		lblAddress1.setBorder(b);
		lblAddress1.setBounds(179, 231, 144, 21);
		panel.add(lblAddress1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 275, 113, 21);
		panel.add(lblGender);
		
		lblGender1 = new JLabel("");
		lblGender1.setBorder(b);
		lblGender1.setBounds(179, 275, 144, 21);
		panel.add(lblGender1);
		
		JLabel lblFather = new JLabel("Father:");
		lblFather.setBounds(10, 321, 113, 21);
		panel.add(lblFather);
		
		lbldob1 = new JLabel("");
		lbldob1.setBorder(b);
		lbldob1.setBounds(179, 324, 144, 21);
		panel.add(lbldob1);
		
		JLabel lbldob = new JLabel("Date of Birth:");
		lbldob.setBounds(10, 368, 113, 21);
		panel.add(lbldob);
		
		lblFather1 = new JLabel("");
		lblFather1.setBorder(b);
		lblFather1.setBounds(179, 368, 144, 21);
		panel.add(lblFather1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(415, 45, 377, 400);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblcName = new JLabel("Course Name:");
		lblcName.setBounds(33, 11, 116, 20);
		panel_1.add(lblcName);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(33, 54, 116, 20);
		panel_1.add(lblDay);
		
		lblDay1 = new JLabel("");
		lblDay1.setBorder(b);
		lblDay1.setBounds(210, 54, 157, 20);
		panel_1.add(lblDay1);
		
		JLabel lblsTime = new JLabel("From: Time");
		lblsTime.setBounds(33, 105, 116, 20);
		panel_1.add(lblsTime);
		
		lblsTime1 = new JLabel("");
		lblsTime1.setBorder(b);
		lblsTime1.setBounds(210, 105, 157, 20);
		panel_1.add(lblsTime1);
		
		JLabel lbleTime = new JLabel("To: Time");
		lbleTime.setBounds(33, 147, 116, 20);
		panel_1.add(lbleTime);
		
		lbleTime1 = new JLabel("");
		lbleTime1.setBorder(b);
		lbleTime1.setBounds(210, 147, 157, 20);
		panel_1.add(lbleTime1);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setBounds(33, 190, 116, 20);
		panel_1.add(lblFee);
		
		lblFee1 = new JLabel("");
		lblFee1.setBorder(b);
		lblFee1.setBounds(210, 190, 157, 20);
		panel_1.add(lblFee1);
		
		JLabel lblTeacher = new JLabel("Teacher:");
		lblTeacher.setBounds(33, 232, 116, 20);
		panel_1.add(lblTeacher);
		
		lblTeacher1 = new JLabel("");
		lblTeacher1.setBorder(b);
		lblTeacher1.setBounds(210, 232, 157, 20);
		panel_1.add(lblTeacher1);
		
		JLabel lblRoom = new JLabel("Room:");
		lblRoom.setBounds(33, 277, 116, 20);
		panel_1.add(lblRoom);
		
		lblRoom1 = new JLabel("");
		lblRoom1.setBorder(b);
		lblRoom1.setBounds(210, 277, 157, 20);
		panel_1.add(lblRoom1);
		
		JLabel lblEfee = new JLabel("Enrollment Fee:");
		lblEfee.setBounds(33, 369, 116, 20);
		panel_1.add(lblEfee);
		
		txtEfee = new JTextField();
		txtEfee.setBounds(210, 369, 157, 20);
		panel_1.add(txtEfee);
		txtEfee.setColumns(10);
		
		JLabel lblDate = new JLabel("Enrollment Date:");
		lblDate.setBounds(33, 324, 116, 20);
		panel_1.add(lblDate);
		
		lblDate1 = new JLabel("");
		lblDate1.setBorder(b);
		lblDate1.setBounds(210, 324, 157, 20);
		panel_1.add(lblDate1);
		
		cboCourse = new JComboBox();
		cboCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCourse();				
			}
		});
		cboCourse.setBounds(210, 10, 157, 22);
		panel_1.add(cboCourse);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(cbosName.getSelectedIndex()==0)
			            JOptionPane.showMessageDialog(null,"Please choose Student Name!");
				 
			        else if(cboCourse.getSelectedIndex()==0)
			          JOptionPane.showMessageDialog(null,"Please choose course Name!");
				 
			        else if(Checking.IsNull(txtEfee.getText()))
				          JOptionPane.showMessageDialog(null,"Please enter enrollment fee!");
				 
			        else if(!Checking.IsAllDigit(txtEfee.getText()))
				          JOptionPane.showMessageDialog(null,"Please enter only number!");
				       
				 
			        else if(Long.parseLong(txtEfee.getText())>Long.parseLong(lblFee1.getText()))
				          JOptionPane.showMessageDialog(null,"Enrollment fee must not greater than course fee!");
				 
			        else
			        {
			            String st[]=new String[3];
			            
			           // String studentname=msql.getStudentid(cbosName.getSelectedItem().toString());
			            //System.out.println(studentname);
			            
			           // String course=msql.getCourseid(cboCourse.getSelectedItem().toString());
			            
			            st[0]=msql.getStudentid(cbosName.getSelectedItem().toString());
			            
			            st[1]=msql.getCourseid(cboCourse.getSelectedItem().toString());
			            
			            //st[2]=lblDate1.getText();
			            //st[3]=txtEfee.getText();
			            		
			           boolean br=msql.isduplicate("registrationtb",st);
			            if(!br)
			                JOptionPane.showMessageDialog(null,"Studnet register duplicate courses!");
			                
			            else
			            {
			                String[] str=new String[5];
			                str[0]=lblrid.getText();
			                str[1]=msql.getStudentid(cbosName.getSelectedItem().toString());
			                str[2]=msql.getCourseid(cboCourse.getSelectedItem().toString());
			                str[3]=lblDate1.getText();
			                str[4]=txtEfee.getText();
			               
			                boolean save=(msql.insertData("registrationtb",str));
			                if(save)
			                    JOptionPane.showMessageDialog(null,"Successfully save record!","Save Record",JOptionPane.INFORMATION_MESSAGE);
			                else
			                    JOptionPane.showMessageDialog(null,"Failed to save record!","Save Failed",JOptionPane.INFORMATION_MESSAGE);
			            }
			            
			            AutoID();
			            
			            clear();
			            cbosName.requestFocus();
			        }
			        
			}
		});
		btnRegister.setBounds(94, 471, 132, 34);
		contentPanel.add(btnRegister);
		btnRegister.setBackground(Color.CYAN);
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setMnemonic('R');
		btnRegister.setFont(new Font("Sitka Small", Font.BOLD, 14));
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setForeground(Color.BLACK);
		btnClose.setBounds(556, 471, 132, 34);
		contentPanel.add(btnClose);
		btnClose.setBackground(Color.CYAN);
		btnClose.setMnemonic('C');
		btnClose.setFont(new Font("Sitka Small", Font.BOLD, 14));
		
		AutoID();
		fillStudent();
		fillCourse();
		lblDate1.setText(d.getMySQLDateFormat());
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnCancel.setBackground(Color.CYAN);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(332, 471, 132, 34);
		contentPanel.add(btnCancel);
	}
	
	public void AutoID()
	{
		try {
			lblrid.setText((String.valueOf(msql.getAutoid("registrationid","registrationtb","REG-"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clear()
	{
		cbosName.setSelectedIndex(0);
		lblnrc1.setText("");
		lblPh1.setText("");
		lblEmail1.setText("");
		lblAddress1.setText("");
		lblGender1.setText("");
		lbldob1.setText("");
		lblFather1.setText("");
		cboCourse.setSelectedIndex(0);;
		lblDay1.setText("");
		lblsTime1.setText("");
		lbleTime1.setText("");
		lblFee1.setText("");
		lblTeacher1.setText("");
		lblRoom1.setText("");
		//lblDate1.setText("");
		txtEfee.setText("");
		
		
	}
	
	public void showStudent()
	{
		String result1[]=new String[7];
        result1 = msql.getStudentData(cbosName.getSelectedItem().toString());
        lblnrc1.setText(result1[0]);
        lblPh1.setText(result1[1]);
        lblEmail1.setText(result1[2]);
        lblAddress1.setText(result1[3]);
        lblGender1.setText(result1[4]);
		lbldob1.setText(result1[5]);		
		lblFather1.setText(result1[6]);
		
	}
	
	public void showCourse()
	{
	
		String result1[]=new String[6];
        result1 = msql.getCourseData(cboCourse.getSelectedItem().toString());
        lblDay1.setText(result1[0]);
        lblsTime1.setText(result1[1]);
        lbleTime1.setText(result1[2]);
        lblFee1.setText(result1[3]);
    	//String teacherid=msql.getTeacherid(lblTeacher1.setText(result1[2]));
        lblTeacher1.setText(result1[4]);
        lblRoom1.setText(result1[5]);
        
	}
	
	public void fillStudent()
	{
		String str[]=msql.getNameForChoice("studenttb");
        cbosName.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbosName.addItem(str[i].toString());
		
	}
	
	public void fillCourse()
	{
		String str[]=msql.getNameForChoice("coursesctb");
        cboCourse.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cboCourse.addItem(str[i].toString());
		
	}
	public class date {
	    private Date today;

	    public date() {
	        this.today = new Date();
	    }

	    public String getMySQLDateFormat() {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        return formatter.format(this.today);
	    }
	}
	
	}



	

