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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class TeacherList extends JDialog {
	private JTable tblteacher;
	private JButton btnPrint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	java.sql.Statement ste = null ;
	Connection con;
	 //clsDBConnection connect=new clsDBConnection();
	clsDBConnection c=new clsDBConnection();
	TeacherUpdate i=new TeacherUpdate();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TeacherList dialog = new TeacherList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TeacherList() throws ClassNotFoundException {
		setBounds(100, 100, 639, 366);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.menu);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Teacher List:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 608, 305);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 24, 580, 240);
				panel.add(scrollPane);
				{
					tblteacher = new JTable();
					tblteacher.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int r=tblteacher.getSelectedRow();
							i.cboteacherid.setSelectedItem(tblteacher.getValueAt(r,0));
							i.txttname.setText((String)tblteacher.getValueAt(r,1));
							i.txttphno.setText((String)tblteacher.getValueAt(r,2));
							i.txttemail.setText((String)tblteacher.getValueAt(r,3));
							
							i.show();
						}
						});
					scrollPane.setViewportView(tblteacher);
				}
			}
			{
				btnPrint = new JButton("Print");
				btnPrint.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				btnPrint.setForeground(Color.WHITE);
				btnPrint.setBackground(Color.BLUE);
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
				            tblteacher.print();
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
				btnClose.setBackground(Color.BLUE);
				btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				btnClose.setForeground(Color.WHITE);
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
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblteacher.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

    public void createtable()
   {
       dtm.addColumn("Teacher ID");
       dtm.addColumn("Teacher Name");
       dtm.addColumn("Teacher Phone");
       dtm.addColumn("Teacher Email");
       
       tblteacher.setModel(dtm);
       setColumnWidth(0,50);
       setColumnWidth(1,80);
       setColumnWidth(2,30);
       setColumnWidth(3,20);
      

   }

    public void fillItem()
    {
        String strdatateacher[]=new String[4];
        
        try{
        	con=c.getConnection();
            Statement ste = (Statement) con.createStatement();
            String str = "select * from teachertb";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
                strdatateacher[0]=rs.getString(1);
                strdatateacher[1]=rs.getString(2);
                strdatateacher[2]=rs.getString(3);
                strdatateacher[3]=rs.getString(4);
                
               dtm.addRow(strdatateacher);
            }
            tblteacher.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

  

}
