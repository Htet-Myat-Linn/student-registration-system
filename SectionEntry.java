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
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class SectionEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtstime;
	private JTextField txtetime;
	JLabel lblstime;
	JLabel lblsid;
	mySQLQueries msql=new mySQLQueries();
	JPanel panelChkbx;
	String day;
	String time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SectionEntry dialog = new SectionEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SectionEntry() {
		setTitle("Section Entry:");
		setBounds(100, 100, 495, 409);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Section Time", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 414, 260);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblSection = new JLabel("Section ID:");
				lblSection.setBounds(10, 35, 95, 23);
				panel.add(lblSection);
			}
			{
				lblstime = new JLabel("Start Time:");
				lblstime.setBounds(10, 82, 95, 23);
				panel.add(lblstime);
			}
			{
				JLabel lbletime = new JLabel("End Time:");
				lbletime.setBounds(10, 127, 95, 23);
				panel.add(lbletime);
			}
			{
				lblsid = new JLabel("");
				Border b=BorderFactory.createLineBorder(Color.BLACK);
				lblsid.setBorder(b);
				lblsid.setBounds(165, 37, 122, 19);
				panel.add(lblsid);
			}
			{
				txtstime = new JTextField();
				txtstime.setBounds(165, 83, 122, 22);
				panel.add(txtstime);
				txtstime.setColumns(10);
			}
			{
				txtetime = new JTextField();
				txtetime.setColumns(10);
				txtetime.setBounds(165, 128, 122, 22);
				panel.add(txtetime);
			}
			
			JLabel lblNewLabel = new JLabel("Choose Day:");
			lblNewLabel.setBounds(10, 190, 79, 14);
			panel.add(lblNewLabel);
			
			panelChkbx = new JPanel();
			panelChkbx.setBounds(165, 177, 192, 72);
			panel.add(panelChkbx);
			panelChkbx.setLayout(null);
			
			JCheckBox chkbx1 = new JCheckBox("Mon");
			chkbx1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					day="Monday";
				}
			});
			chkbx1.setBounds(6, 7, 55, 23);
			panelChkbx.add(chkbx1);
			
			JCheckBox chkbx3 = new JCheckBox("Wed");
			chkbx3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					day="Wednesday";
				}
			});
			chkbx3.setBounds(104, 7, 55, 23);
			panelChkbx.add(chkbx3);
			
			JCheckBox chkbx4 = new JCheckBox("Fri");
			chkbx4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					day="Friday";
				}
			});
			chkbx4.setBounds(6, 42, 72, 23);
			panelChkbx.add(chkbx4);
			
			JCheckBox chkbx2 = new JCheckBox("Tue");
			chkbx2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					day="Thursday";
				}
			});
			chkbx2.setBounds(104, 42, 50, 23);
			panelChkbx.add(chkbx2);
			
			JRadioButton rdoAM = new JRadioButton("AM");
			rdoAM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdoAM.isSelected())
					{
						time="AM";
					}
				}
			});
			rdoAM.setBounds(299, 82, 58, 23);
			panel.add(rdoAM);
		}
		{
			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Checking.IsNull(txtstime.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please start time.");
			            txtstime.requestFocus();
			            txtstime.selectAll();
			        }
			        else if(Checking.IsAllDigit(txtstime.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid time(AM or PM)");
			            txtstime.requestFocus();
			            txtstime.selectAll();
			        }
			        else if(Checking.IsNull(txtetime.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter end time.");
			            txtetime.requestFocus();
			            txtetime.selectAll();
			        }
			        else if(Checking.IsAllDigit(txtetime.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid time(AM or PM)");
			            txtetime.requestFocus();
			            txtetime.selectAll();
			        }
					
			        else{
			        	
			        	 String result="";
			        	 
				            for(Component c: panelChkbx.getComponents())
				            {
				            	if(c.getClass().equals(JCheckBox.class))
				            	{
				            		JCheckBox jck=(JCheckBox) c;
				            		if(jck.isSelected())
				            		{
				            			result+=jck.getText()+", ";
				            			
				            		}
				            		
				            	}
				            }
				            
				            JOptionPane.showMessageDialog(null, result);
				           
			        	 String st[] = new String[3];
							st[0]=(String)txtstime.getText();
							st[1]=(String)txtetime.getText();
							st[2]=result;
							
							
							
				            boolean ee=msql.isduplicate("sectiontb", st);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null,"Duplicate Record!");
				                txtstime.requestFocus();
				                txtstime.selectAll();
				            }
				            else
							       {
						            String str[]=new String[4];
						            str[0]=lblsid.getText();
						            str[1]=txtstime.getText()+"" +time;
						            str[2]=txtetime.getText();
						            str[3]=result;
						            
						           
						            //str[9]=txtEmail.getText();
						            boolean save=msql.insertData("sectiontb", str);
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
			btnSave.setBounds(43, 282, 89, 29);
			contentPanel.add(btnSave);
		}
		{
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			btnCancel.setMnemonic('C');
			btnCancel.setBounds(174, 282, 89, 29);
			contentPanel.add(btnCancel);
		}
		{
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
			btnClose.setBounds(299, 282, 89, 29);
			contentPanel.add(btnClose);
		}
		
		AutoID();
	}
	
	public void AutoID()
	{
		try {
			lblsid.setText((String.valueOf(msql.getAutoid("sectionid","sectiontb","SID_"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clear()
    {
        txtstime.setText("");
        txtetime.setText("");
        
        txtstime.requestFocus();
    }
}
