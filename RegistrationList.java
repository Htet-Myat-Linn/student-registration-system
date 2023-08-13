package student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RegistrationList extends JDialog {
	private JButton btnprint;
	private JButton btnClose;
	private JTable tblreg;
	private JScrollPane scrollPane;
	DefaultTableModel dtm = new DefaultTableModel();
	Statement ste = null ;
	Connection con = null ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrationList dialog = new RegistrationList();
			   
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrationList() throws ClassNotFoundException {
		setTitle("Registration List");
		setBounds(100, 100, 889, 308);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration List:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 853, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnprint = new JButton("Print");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            tblreg.print();
		        }catch(Exception e1) {
		            JOptionPane.showMessageDialog(null, e1);
		        }

			}
		});
		btnprint.setBounds(272, 216, 89, 23);
		panel.add(btnprint);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(511, 216, 89, 23);
		panel.add(btnClose);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 814, 180);
		panel.add(scrollPane);
		
		tblreg = new JTable();
		scrollPane.setViewportView(tblreg);

        try{
        	clsDBConnection c=new clsDBConnection();
          con=c.getConnection();
      }catch(SQLException sqle)
      {
          System.out.println(sqle);
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      createtable();
      fillreg();

	}

    public void createtable()
    {
        dtm.addColumn("Registration ID");
       
        dtm.addColumn("Student ID");
        dtm.addColumn("Course ID");
       
        
        dtm.addColumn("Date");
        
        
        dtm.addColumn("Enrollment Fee");
        tblreg.setModel(dtm);
        setColumnWidth(0,400);
        setColumnWidth(1,400);
        setColumnWidth(2,400);
        setColumnWidth(3,400);
        setColumnWidth(4,400);
      
        
    }
    public void fillreg()
    {
        String strdatareg[]=new String[5];
        
        try{
            Statement ste = (Statement) con.createStatement();
            String str = "select * from registrationtb";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
            	strdatareg[0]=rs.getString(1);

            	strdatareg[1]=rs.getString(2);
            	strdatareg[2]=rs.getString(3);
            	strdatareg[3]=rs.getString(4);
            	strdatareg[4]=rs.getString(5);
            	
            	
            	
               dtm.addRow(strdatareg);
            }
            tblreg.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblreg.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

}
