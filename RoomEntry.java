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

public class RoomEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtrno;
	JLabel lblrid;
	mySQLQueries msql=new mySQLQueries();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RoomEntry dialog = new RoomEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RoomEntry() {
		setTitle("Room Entry:");
		setBounds(100, 100, 450, 284);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.CYAN);
			panel.setBorder(new TitledBorder(null, "Room Entry", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 414, 184);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblRoom = new JLabel("Room ID:");
				lblRoom.setBounds(10, 48, 112, 25);
				panel.add(lblRoom);
			}
			{
				lblrid = new JLabel("");
				Border b=BorderFactory.createLineBorder(Color.BLACK);
				lblrid.setBorder(b);
				lblrid.setBounds(151, 48, 112, 25);
				panel.add(lblrid);
			}
			{
				JLabel lblrno = new JLabel("Room No:");
				lblrno.setBounds(10, 107, 112, 25);
				panel.add(lblrno);
			}
			{
				txtrno = new JTextField();
				txtrno.setBounds(151, 107, 112, 24);
				panel.add(txtrno);
				txtrno.setColumns(10);
			}
		}
		{
			JButton btnSave = new JButton("Save");
			btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnSave.setBackground(Color.BLUE);
			btnSave.setForeground(Color.WHITE);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(Checking.IsNull(txtrno.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter room number.");
			            txtrno.requestFocus();
			            txtrno.selectAll();
			        }
			        
					
			        else{
			        	 String st[] = new String[1];
							st[0]=(String)txtrno.getText();					
							
				            boolean ee=msql.isduplicate("roomtb", st);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txtrno.requestFocus();
				                txtrno.selectAll();
				            }
				            else
							       {
						            String str[]=new String[2];
						            str[0]=lblrid.getText();
						            str[1]=txtrno.getText();
						            
						            boolean save=msql.insertData("roomtb", str);
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
			btnSave.setBounds(47, 206, 89, 30);
			contentPanel.add(btnSave);
		}
		{
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnCancel.setBackground(Color.BLUE);
			btnCancel.setForeground(Color.WHITE);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			btnCancel.setMnemonic('C');
			btnCancel.setBounds(173, 206, 89, 30);
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
			btnClose.setBounds(296, 206, 89, 30);
			contentPanel.add(btnClose);
		}
		
		AutoID();
	}
	
	public void AutoID()
	{
		try {
			lblrid.setText((String.valueOf(msql.getAutoid("roomid","roomtb","RNo_"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clear()
	{
		 txtrno.setText("");      
	     txtrno.requestFocus();
		
	}

}
