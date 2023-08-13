package student;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcName;
	private JTextField txtFee;
	JLabel lblcid;
	mySQLQueries msql=new mySQLQueries();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CourseEntry dialog = new CourseEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseEntry() {
		setTitle("Course Entry:");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.CYAN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setForeground(Color.BLUE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Course Information:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(10, 11, 414, 184);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course ID:");
		lblCourse.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setBounds(21, 32, 100, 20);
		panel.add(lblCourse);
		
		lblcid = new JLabel("");
		Border white=BorderFactory.createLineBorder(Color.WHITE);
		lblcid.setBorder(white);
		lblcid.setBounds(161, 32, 147, 20);
		panel.add(lblcid);
		
		JLabel lblcName = new JLabel("Course Name:");
		lblcName.setForeground(Color.WHITE);
		lblcName.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblcName.setBounds(21, 77, 100, 20);
		panel.add(lblcName);
		
		txtcName = new JTextField();
		txtcName.setBounds(161, 77, 147, 20);
		panel.add(txtcName);
		txtcName.setColumns(10);
		
		JLabel lblcFee = new JLabel("Course Fee:");
		lblcFee.setForeground(Color.WHITE);
		lblcFee.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblcFee.setBounds(21, 126, 100, 20);
		panel.add(lblcFee);
		
		txtFee = new JTextField();
		txtFee.setBounds(161, 126, 147, 20);
		panel.add(txtFee);
		txtFee.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Checking.IsNull(txtcName.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Course Name.");
		            txtcName.requestFocus();
		            txtcName.selectAll();
		        }
		        else if(Checking.IsNull(txtFee.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter couse fee.");;
		            txtFee.requestFocus();
		            txtFee.selectAll();
		        }
		        else if(!Checking.IsAllDigit(txtFee.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter valid course fee.");
		            txtFee.requestFocus();
		            txtFee.selectAll();
		        }
				
		        else{
		        	 String st[] = new String[2];
						st[0]=(String)txtcName.getText();
						st[1]=(String)txtFee.getText();						
						
			            boolean ee=msql.isduplicate("coursetb", st);
			            if(!ee)
			            {
			                JOptionPane.showMessageDialog(null, "Duplicate Record!");
			                txtcName.requestFocus();
			                txtcName.selectAll();
			            }
			            else
						       {
					            String str[]=new String[3];
					            str[0]=lblcid.getText();
					            str[1]=txtcName.getText();
					            str[2]=txtFee.getText();
					           
					            //str[9]=txtEmail.getText();
					            boolean save=msql.insertData("coursetb", str);
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
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.BLUE);
		btnSave.setMnemonic('S');
		btnSave.setBounds(45, 206, 89, 31);
		contentPanel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancel.setBackground(Color.BLUE);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(171, 206, 89, 31);
		contentPanel.add(btnCancel);
		
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
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.BLUE);
		btnClose.setMnemonic('C');
		btnClose.setBounds(294, 206, 89, 31);
		contentPanel.add(btnClose);
		
		AutoID();
		
	}
	public void AutoID()
	{
		try {
			lblcid.setText((String.valueOf(msql.getAutoid("courseid","coursetb","CID_"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void clear()
    {
        txtcName.setText("");
        txtFee.setText("");
        
        txtcName.requestFocus();
    }
    
}
