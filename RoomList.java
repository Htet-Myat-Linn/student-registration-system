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

public class RoomList extends JDialog {
	private JTable tblroom;
	private JButton btnPrint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	java.sql.Statement ste = null ;
	Connection con;
	 //clsDBConnection connect=new clsDBConnection();
	clsDBConnection c=new clsDBConnection();
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RoomList dialog = new RoomList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RoomList() throws ClassNotFoundException {
		setBounds(100, 100, 639, 366);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Room List:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 608, 305);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 24, 580, 240);
				panel.add(scrollPane);
				{
					tblroom = new JTable();
					
					scrollPane.setViewportView(tblroom);
				}
			}
			{
				btnPrint = new JButton("Print");
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
				            tblroom.print();
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
		fillRoom();
	}
	public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblroom.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

    public void createtable()
   {
       dtm.addColumn("Room ID");
       dtm.addColumn("Room Name");
       
       
       tblroom.setModel(dtm);
       setColumnWidth(0,50);
       setColumnWidth(1,80);
       
      

   }

    public void fillRoom()
    {
        String strdataroom[]=new String[2];
        
        try{
        	con=c.getConnection();
            Statement ste = (Statement) con.createStatement();
            String str = "select * from roomtb";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
            	strdataroom[0]=rs.getString(1);
            	strdataroom[1]=rs.getString(2);
                
                
               dtm.addRow(strdataroom);
            }
            tblroom.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

  

}