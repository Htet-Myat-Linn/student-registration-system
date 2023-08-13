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

public class InstallmentList extends JDialog {
	private JButton btnprint;
	private JButton btnClose;
	private JTable tblinstallment;
	private JScrollPane scrollPane;
	DefaultTableModel dtm = new DefaultTableModel();
	Statement ste = null ;
	Connection con = null ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InstallmentList dialog = new InstallmentList();
			   
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InstallmentList() throws ClassNotFoundException {
		setTitle("Registration List");
		setBounds(100, 100, 889, 308);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Installment List:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 853, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnprint = new JButton("Print");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            tblinstallment.print();
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
		
		tblinstallment = new JTable();
		scrollPane.setViewportView(tblinstallment);

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
      fillinstallment();

	}

    public void createtable()
    {
        dtm.addColumn("Installment ID");

        dtm.addColumn("Registration ID");
       
        dtm.addColumn("Installment Fee");
        
        dtm.addColumn("Total Amount");
        dtm.addColumn("Installment Date");
        dtm.addColumn("Rest of Amount");

        
        tblinstallment.setModel(dtm);
        setColumnWidth(0,400);
        setColumnWidth(1,400);
        setColumnWidth(2,400);
        setColumnWidth(3,400);
        setColumnWidth(4,500);
        setColumnWidth(5,400);
        
      
        
    }
    public void fillinstallment()
    {
        String strdatainstallment[]=new String[6];
        
        try{
            Statement ste = (Statement) con.createStatement();
            String str = "select * from installmenttb";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
            	strdatainstallment[0]=rs.getString(1);

            	strdatainstallment[1]=rs.getString(2);
            	strdatainstallment[2]=rs.getString(3);
            	strdatainstallment[3]=rs.getString(4);
            	strdatainstallment[4]=rs.getString(5);
            	strdatainstallment[5]=rs.getString(6);
            	
            	
            	
            	
               dtm.addRow(strdatainstallment);
            }
            tblinstallment.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblinstallment.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

}