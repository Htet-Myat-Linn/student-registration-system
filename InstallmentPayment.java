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
import javax.swing.border.TitledBorder;

import student.RegistrationEntry.date;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class InstallmentPayment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtiFee;
	private JTextField txtSearch;
	mySQLQueries msql=new mySQLQueries();
	JLabel lblstuid1,lblefee1,lblstuName1, lblnrc1,lblcname1,lblcfee1,lbledate1,lblidate1,lblramount1,tamount1,lblcid1,lblid;
	date d=new date();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InstallmentPayment dialog = new InstallmentPayment();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InstallmentPayment() {
		setTitle("InstallmentPayment:");
		setBounds(100, 100, 600, 588);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Installment Payments in Student Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 162, 584, 338);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblstuid = new JLabel("Student ID:");
		lblstuid.setBounds(37, 73, 86, 19);
		panel.add(lblstuid);
		
		JLabel lblstuName = new JLabel("Student Name:");
		lblstuName.setBounds(37, 117, 86, 19);
		panel.add(lblstuName);
		
		JLabel lblnrc = new JLabel("NRC No:");
		lblnrc.setBounds(37, 162, 86, 19);
		panel.add(lblnrc);
		Border b=BorderFactory.createLineBorder(Color.BLACK);
		
	    lblstuid1 = new JLabel("");
		lblstuid1.setBorder(b);
		lblstuid1.setBounds(154, 73, 128, 19);
		panel.add(lblstuid1);
		
		lblstuName1 = new JLabel("");
		lblstuName1.setBorder(b);
		lblstuName1.setBounds(154, 117, 128, 19);
		panel.add(lblstuName1);
		
		lblnrc1 = new JLabel("");
		lblnrc1.setBorder(b);
		lblnrc1.setBounds(154, 162, 128, 19);
		panel.add(lblnrc1);
		
		JLabel lblcname = new JLabel("Course Name:");
		lblcname.setBounds(37, 251, 86, 19);
		panel.add(lblcname);
		
		JLabel lblcfee = new JLabel("Course Fee:");
		lblcfee.setBounds(37, 290, 86, 19);
		panel.add(lblcfee);
		
		JLabel lbledate = new JLabel("Enrollment Date:");
		lbledate.setBounds(314, 73, 96, 19);
		panel.add(lbledate);
		
		JLabel efee = new JLabel("Enrollment Fee:");
		efee.setBounds(314, 117, 96, 19);
		panel.add(efee);
		
		JLabel ifee = new JLabel("Installment Fee:");
		ifee.setBounds(314, 162, 96, 19);
		panel.add(ifee);
		
		JLabel idate = new JLabel("Installment Date:");
		idate.setBounds(314, 251, 96, 19);
		panel.add(idate);
		
		JLabel lblramount = new JLabel("Rest of Amount:");
		lblramount.setBounds(314, 290, 96, 19);
		panel.add(lblramount);
		
		lblcname1 = new JLabel("");
		lblcname1.setBorder(b);
		lblcname1.setBounds(154, 251, 128, 19);
		panel.add(lblcname1);
		
		lblcfee1 = new JLabel("");
		lblcfee1.setBorder(b);
		lblcfee1.setBounds(154, 290, 128, 19);
		panel.add(lblcfee1);
		
		lbledate1 = new JLabel("");
		lbledate1.setBorder(b);
		lbledate1.setBounds(432, 73, 128, 19);
		panel.add(lbledate1);
		
		lblefee1 = new JLabel("");
		lblefee1.setBorder(b);
		lblefee1.setBounds(432, 117, 128, 19);
		panel.add(lblefee1);
		
		lblidate1 = new JLabel("");
		lblidate1.setBorder(b);
		lblidate1.setBounds(432, 251, 128, 19);
		panel.add(lblidate1);
		
		lblramount1 = new JLabel("");
		lblramount1 .setBorder(b);
		lblramount1.setBounds(432, 290, 128, 19);
		panel.add(lblramount1);
		
		txtiFee = new JTextField();
		txtiFee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				if(Long.parseLong(lblramount1.getText())==0)
				{
					 JOptionPane.showMessageDialog(null, " You cannot add because of your payment is successful.");
					
				}
					
				else
				{
				tamount1.setText(String.valueOf(Long.parseLong(lblefee1.getText())+Long.parseLong(txtiFee.getText())));
				lblramount1.setText(String.valueOf(Long.parseLong(lblcfee1.getText())-(Long.parseLong(tamount1.getText()))));

				//lblefee1.setText(String.valueOf(Long.parseLong(lblefee1.getText())+Long.parseLong(txtiFee.getText())));
				}
			}
			}
				
		});
		txtiFee.setBounds(432, 161, 128, 20);
		panel.add(txtiFee);
		txtiFee.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBorder(new TitledBorder(null, "Searching Student Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 11, 584, 138);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblsearch = new JLabel("Search By Registration ID :");
		lblsearch.setBounds(116, 32, 177, 21);
		panel_1.add(lblsearch);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(314, 32, 111, 21);
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnSearch.setBackground(Color.BLUE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Checking.IsNull(txtSearch.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter registration ID.");
		            txtSearch.requestFocus();
		            txtSearch.selectAll();
		        }
				else if(Checking.IsAllDigit(txtSearch.getText()))
				{
					JOptionPane.showMessageDialog(null, "Please enter valid id no");
					txtSearch.requestFocus();
		            txtSearch.selectAll();
				}
				
				
				
				
				else
				
				{
					
					
					String result[]=new String[4];
					result=msql.getRegistrationData(txtSearch.getText());
					//lblid.setText(result[0]);
					lblstuid1.setText(result[0]);
				
					String student[]=new String[2];
					student=msql.getRegisterStudent(lblstuid1.getText());
					lblstuName1.setText(student[0]);
					lblnrc1.setText(student[1]);
					
					lblcid1.setText(result[1]);
					lbledate1.setText(result[2]);
					lblefee1.setText(result[3]);
					
					String course[]=new String[2];
					course=msql.getCourseInstallment(lblcid1.getText());
					lblcname1.setText(course[0]);
					lblcfee1.setText(course[1]);
					
					lblidate1.getText();
					
					/*
				    int something=msql.getTotalInstallmentFee(txtSearch.getText().toString() );	 
				    long total=something+Long.parseLong(txtiFee.getText());
					tamount1.setText(total+"");				
					lblramount1.setText(String.valueOf(Long.parseLong(lblcfee1.getText())-Long.parseLong(lblefee1.getText())));
					*/
					
					 int something=msql.getTotalInstallmentFee(txtSearch.getText().toString() );
					    long total=something+Long.parseLong(lblefee1.getText());
						tamount1.setText(total +"");
						
				  	    //lblramount1.setText(String.valueOf(Long.parseLong(lblcfee1.getText())-Long.parseLong(tamount1.getText())));
						long a=Long.parseLong(lblcfee1.getText())-Long.parseLong(tamount1.getText());
						if(a<0)
						{
							lblramount1.setText("0");
						}
						else
						{
							lblramount1.setText(String.valueOf(Long.parseLong(lblcfee1.getText())-Long.parseLong(tamount1.getText())));
						}
			  	    
					
					
					/*
					lblcname1.setText(result[3]);
					lblcfee1.setText(result[4]);
					lbledate1.setText(result[5]);
					
					*/
					
					
					
					
					
					
					
					
					
					
				//	lblidate1.getText();
					
				//	Long amount=Long.parseLong(lblcfee1.getText())-Long.parseLong(lblefee1.getText());
					
				//	lblramount1.setText(String.valueOf(Long.parseLong(lblcfee1.getText())-Long.parseLong(lblefee1.getText())));
					
					
					
				//installment[1]=String.valueOf(amount);
					
				
					
					
					
					
				
					
									
				
				
				}
			
			}
		});
		btnSearch.setMnemonic('S');
		btnSearch.setBounds(314, 89, 111, 23);
		panel_1.add(btnSearch);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.BLUE);
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Checking.IsNull(txtiFee.getText()))
				{
					JOptionPane.showMessageDialog(null, "Please enter installment amount");
				}
				else if(!Checking.IsAllDigit(txtiFee.getText()))
				{
					JOptionPane.showMessageDialog(null, "Please enter only digit");
				}
				
				
				
				else
				{
					//Long totalamount=Long.parseLong(tamount1.getText());
					
					
					//lblramount1.setText(String.valueOf(Long.parseLong(lblcfee1.getText())-Long.parseLong(lblefee1.getText())));
					
					Long totalamount=Long.parseLong(tamount1.getText());
					
					String[] str=new String[6];
					//String id=lblregid.getText().toString();
					str[0]=lblid.getText();
					//str[1]=lblstuid1.getText().toString();
					str[1]=msql.getRegistrationID(lblstuid1.getText().toString());
				    str[2]=txtiFee.getText();
				    str[3]=totalamount.toString();
				    str[4]=lblidate1.getText();
				    str[5]=lblramount1.getText();
					
					
					 boolean save=(msql.insertData("installmenttb",str));
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null,"Successfully save record!","Save Record",JOptionPane.INFORMATION_MESSAGE);
		                   AutoID();
		                   clear();
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"Failed to save record!","Save Failed",JOptionPane.INFORMATION_MESSAGE);
		                    AutoID();
		                }
				
				}
			//	tamount1.getText();
	            
	            
	            txtSearch.requestFocus();
					
				}
						
			
	
		});
		
		btnSave.setMnemonic('S');
		btnSave.setBounds(121, 511, 89, 29);
		contentPanel.add(btnSave);
		
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
		btnCancel.setBounds(247, 511, 89, 29);
		contentPanel.add(btnCancel);
		
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
		btnClose.setBounds(380, 511, 89, 29);
		contentPanel.add(btnClose);
		
		
		lblidate1.setText(d.getMySQLDateFormat());
		
		JLabel tamount = new JLabel("Total Amount:");
		tamount.setBounds(314, 209, 96, 19);
		panel.add(tamount);
		
	    tamount1 = new JLabel("");
		tamount1.setBorder(b);
		tamount1.setBounds(432, 209, 128, 19);
		panel.add(tamount1);
		
		JLabel lblcid = new JLabel("Course ID:");
		lblcid.setBounds(37, 209, 86, 19);
		panel.add(lblcid);
		
		lblcid1 = new JLabel("");
		lblcid1.setBorder(b);
		lblcid1.setBounds(154, 209, 128, 19);
		panel.add(lblcid1);
		
		JLabel lblreg = new JLabel("Installment ID:");
		lblreg.setBounds(37, 36, 86, 19);
		panel.add(lblreg);
		
		lblid = new JLabel("");
		lblid.setBorder(b);
		lblid.setBounds(154, 36, 128, 19);
		panel.add(lblid);
		
		JLabel lblNewLabel = new JLabel("Enter press key:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(432, 184, 108, 14);
		panel.add(lblNewLabel);
		
		AutoID();
	}
	
	

	
	public void fillRegistrationData(String str)
	{
		String result1[]=new String[6];
        
        /*lblnrc1.setText(result1[0]);
        lblPh1.setText(result1[1]);
        lblEmail1.setText(result1[2]);
        lblAddress1.setText(result1[3]);
        lblGender1.setText(result1[4]);
		lbldob1.setText(result1[5]);		
		lblFather1.setText(result1[6]);
		*/
        
		
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
	
	public void AutoID()
	{
		try {
			lblid.setText((String.valueOf(msql.getAutoid("installmentid","installmenttb","INS_"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	
	public void clear()
	{
		txtSearch.setText("");
		//lblid.setText("");
		lblstuid1.setText("");
		lblstuName1.setText("");
		lblnrc1.setText("");
		lblcid1.setText("");
		lblcname1.setText("");
		lblcfee1.setText("");
		lbledate1.setText("");
		lblefee1.setText("");
		txtiFee.setText("");
		tamount1.setText("");
		//lblidate1.setText("");
		lblramount1.setText("");
			
	}
}
	

	
