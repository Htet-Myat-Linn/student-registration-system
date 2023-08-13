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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentList extends JDialog {
	private JTable tblstudent;
	private JButton btnPrint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	java.sql.Statement ste = null ;
	Connection con = null ;
	clsDBConnection connect=new clsDBConnection();
StudentUpdate i=new StudentUpdate();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentList dialog = new StudentList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentList() throws ClassNotFoundException {
		setBounds(100, 100, 750, 366);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student List:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 750, 305);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				
				scrollPane.setBounds(20, 24,670, 250);
				panel.add(scrollPane);
				{
					tblstudent = new JTable();
					tblstudent.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int r=tblstudent.getSelectedRow();
							i.cbostudentid.setSelectedItem(tblstudent.getValueAt(r,0));
							i.txtname.setText((String)tblstudent.getValueAt(r,1));
							i.txtNRC.setText((String)tblstudent.getValueAt(r,2));
							i.txtPh.setText((String)tblstudent.getValueAt(r,3));
							i.txtEmail.setText((String)tblstudent.getValueAt(r,4));
							i.txtAddress.setText((String)tblstudent.getValueAt(r,5));
							i.txtgender.setText((String)tblstudent.getValueAt(r,6));
							i.txtFather.setText((String)tblstudent.getValueAt(r,7));
							i.txtdob.setText((String)tblstudent.getValueAt(r,8));
							i.show();
						}
					});
					scrollPane.setViewportView(tblstudent);
				}
			}
			{
				btnPrint = new JButton("Print");
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							tblstudent.print();
				        }catch(Exception e1) {
				            JOptionPane.showMessageDialog(null, e1);
				        }
					}
				});
				btnPrint.setBounds(405, 275, 89, 23);
				panel.add(btnPrint);
			}
			{
				btnClose = new JButton("Close");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
						{	
							dispose();
						}
					}
				});
				btnClose.setBounds(501, 275, 89, 23);
				panel.add(btnClose);
			}
		}
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
		 fillStudent();
	}
	public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblstudent.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

    public void createtable()
   {
       dtm.addColumn("Student ID");
       dtm.addColumn("Student Name");
       dtm.addColumn("NRC No");
       dtm.addColumn("Phone No");
       dtm.addColumn("Email");
       dtm.addColumn("Address");
       dtm.addColumn("Gender");
       dtm.addColumn("Father Name");
       dtm.addColumn("Date Of Birth");
       tblstudent.setModel(dtm);
       setColumnWidth(0,150);
       setColumnWidth(1,180);
       setColumnWidth(2,150);
       setColumnWidth(3,150);
       setColumnWidth(4,150);
       setColumnWidth(5,150);
       setColumnWidth(6,100);
       setColumnWidth(7,180);
       setColumnWidth(8,150);
       
       
      

   }

    public void fillStudent()
    {
        String strdatastudent[]=new String[9];
       
        try{
        	con=connect.getConnection();
            Statement ste = (Statement) con.createStatement();
            String str = "select * from studenttb";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
            	strdatastudent[0]=rs.getString(1);
            	strdatastudent[1]=rs.getString(2);
            	strdatastudent[2]=rs.getString(3);
            	strdatastudent[3]=rs.getString(4);
            	strdatastudent[4]=rs.getString(5);
            	strdatastudent[5]=rs.getString(6);
            	strdatastudent[6]=rs.getString(7);
            	strdatastudent[7]=rs.getString(8);
            	strdatastudent[8]=rs.getString(9);
               dtm.addRow(strdatastudent);
            }
            tblstudent.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

  

}
