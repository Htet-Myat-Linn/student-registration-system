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
import java.awt.SystemColor;

public class CourseList extends JDialog {
	private JTable tblcourse;
	private JButton btnPrint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	java.sql.Statement ste = null ;
	Connection con = null ;
	clsDBConnection connect=new clsDBConnection();
	CourseUpdate i=new CourseUpdate();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CourseList dialog = new CourseList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseList() throws ClassNotFoundException {
		i.getContentPane().setBackground(SystemColor.menu);
		setBounds(100, 100, 683, 366);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Course Schedule List:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 647, 305);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				
				scrollPane.setBounds(10, 24, 627, 240);
				panel.add(scrollPane);
				{
					tblcourse = new JTable();
					tblcourse.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int r=tblcourse.getSelectedRow();
							i.cbocoursescid.setSelectedItem(tblcourse.getValueAt(r,0));
							i.txtcname.setText((String)tblcourse.getValueAt(r,1));
							i.txtcourseday.setText((String)tblcourse.getValueAt(r,2));
							i.txtstime.setText((String)tblcourse.getValueAt(r,3));
							i.txtetime.setText((String)tblcourse.getValueAt(r,4));
							i.txtcfee.setText((String)tblcourse.getValueAt(r,5));
							i.txttname.setText((String)tblcourse.getValueAt(r,6));
							i.txtroom.setText((String)tblcourse.getValueAt(r,7));
							i.show();
						}
					});
					scrollPane.setViewportView(tblcourse);
				}
			}
			{
				btnPrint = new JButton("Print");
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
				            tblcourse.print();
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
		 fillItem();
	}
	public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblcourse.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

    public void createtable()
   {
       dtm.addColumn("Course ID");
       dtm.addColumn("Course Name");
       dtm.addColumn("Day");
       dtm.addColumn("Start Time");
       dtm.addColumn("End Time");
       dtm.addColumn("Fee");
       dtm.addColumn("Teacher Name");
       dtm.addColumn("Room ID");
       tblcourse.setModel(dtm);
       setColumnWidth(0,80);
       setColumnWidth(1,80);
       setColumnWidth(2,60);
       setColumnWidth(3,60);
       setColumnWidth(4,60);
       setColumnWidth(5,60);
       setColumnWidth(6,130);
       setColumnWidth(7,80);
      
       
       
      

   }

    public void fillItem()
    {
        String strdatacourse[]=new String[8];
       
        try{
        	con=connect.getConnection();
            Statement ste = (Statement) con.createStatement();
            String str = "select * from coursesctb";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
            	strdatacourse[0]=rs.getString(1);
                strdatacourse[1]=rs.getString(2);
                strdatacourse[2]=rs.getString(3);
                strdatacourse[3]=rs.getString(4);
                strdatacourse[4]=rs.getString(5);
                strdatacourse[5]=rs.getString(6);
                strdatacourse[6]=rs.getString(7);
                strdatacourse[7]=rs.getString(8);
                
               dtm.addRow(strdatacourse);
            }
            tblcourse.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

  

}
