package student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;





public class mySQLQueries {
	
	static java.sql.Connection con = null;
	static Statement stmt;
	static String query , query1;
	static ResultSet rs;
	static clsDBConnection connect = new clsDBConnection();
	public mySQLQueries() 
			//throws ClassNotFoundException
	{
	    try{
	        con=(Connection) connect.getConnection();
	    }
	    catch(SQLException sqle)
	    {
	        System.out.println(sqle);
	    }catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	public static boolean insertData(String tbName , String[]data)
	{
	    if(tbName.equals("studenttb"))
	    {
	        query = "insert into studenttb values ('"+data[0]+"','"+data[1]+"',' "+data[2]+ "', "+data[3]+" ,' "+data[4]+" ',' "+data[5]+" ',' "+data[6]+" ',' "+data[7]+" ',' "+data[8]+" ');";
	    }
	  
	    else if(tbName.equals("coursetb"))
	    {
	        query = "insert into coursetb values ('"+data[0]+"','"+data[1]+"','" +data[2]+"')";
	    }
	    
	    else if(tbName.equals("sectiontb"))
	    {
	        query = "insert into sectiontb values ('"+data[0]+"','"+data[1]+"','" +data[2]+"',' " +data[3]+"')";
	    }
	    
	    else if(tbName.equals("teachertb"))
	    {
	        query = "insert into teachertb values ('"+data[0]+"','"+data[1]+"','" +data[2]+"','" +data[3]+"')";
	    }
	    else if(tbName.equals("roomtb"))
	    {
	        query = "insert into roomtb values ('"+data[0]+"','"+data[1]+"')";
	        
	    }
	    else if(tbName.equals("coursesctb"))
	    {
	        query = "insert into coursesctb values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"',"+data[5]+",'"+data[6]+"','"+data[7]+"')";
	        
	    }
	    else if(tbName.equals("registrationtb"))
	    {
	        query = "insert into registrationtb values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"', "+data[4]+" )";
	        
	    }
	    else if(tbName.equals("installmenttb"))
	    {
	        query = "insert into installmenttb values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"')";
	        
	    }
	    
	    
	    
	    
	    
	    try{
	    	con=connect.getConnection();
	        stmt = con.createStatement();
	        System.out.println(query);
	        
	        boolean r = stmt.execute(query);
	        
	       //System.out.println(query+r);
	        if(r)
	        {
	            return false;
	        }
	        else return true;

	    }catch(SQLException e)
	    {
	    	System.out.println("Hello");
	        JOptionPane.showMessageDialog(null,e.getMessage());
	        e.printStackTrace();
	        return true;
	    }
	}
	
	public static String getAutoid(String field , String table , String prefix) throws ClassNotFoundException
    {
        if(table.equals("coursetb")||(table.equals("sectiontb"))||(table.equals("teachertb"))||(table.equals("coursesctb")))
        {
            return connect.getPrimaryKey(field, table, prefix);
        }
        else
        {
            return connect.getPrimaryKey2(field, table, prefix);
        }
    }
	
	/*public static String[] getPassword(String psw,String name)
    {
        try
        {
            String patientname[]=new String[2];
            con=connect.getConnection();
            stmt = con.createStatement();
            query = "select * from patient where password ='"+psw+"'and name='"+name+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            patientname[0]=rs.getString(1);
            patientname[1] = rs.getString(2);
            return patientname;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
    */
    
    
    public boolean isduplicate(String tbName , String []data)
	{
	    if(tbName.equals("studenttb"))
	    {
	        query = "select * from studenttb where stunrc='"+data[0]+"'";
	    }
	    else if(tbName.equals("coursetb"))
	    {
	        query = "select * from coursetb where cname='"+data[0]+"'";
	    }
	    else if(tbName.equals("sectiontb"))
	    {
	        query = "select * from sectiontb where stime='"+data[0]+"' and etime=' " +data[1]+"'";
	    }
	    else if(tbName.equals("teachertb"))
	    {
	        query = "select * from teachertb where tname='"+data[0]+"' and tph=' " +data[1]+"'";
	    }
	    else if(tbName.equals("teachertb"))
	    {
	        query = "select * from teachertb where tname='"+data[0]+"' and tph=' " +data[1]+"'";
	    }
	    else if(tbName.equals("roomtb"))
	    {
	        query = "select * from roomtb where roomno='"+data[0]+"' ";
	    }
	   
	    /*
	    else if(tbName.equals("coursesctb"))
	    {
	        query = "select * from coursesctb where day='"+data[0]+"' and shour='"+data[1]+"' and smin='"+data[2]+"' and stime='"+data[3]+"' and ehour='"+data[4]+"' and emin='"+data[5]+"' and etime='"+data[6]+"'";
	    }
	    */
	    
	    
	    else if(tbName.equals("coursesctb"))
	    {
	    	
	        query = "select * from coursesctb where day='"+data[0]+"' and stime='"+data[1]+"'and etime='"+data[2]+"' and roomid='"+data[3]+"'";
	        System.out.println(query);
	    }
	    else if(tbName.equals("coursesctbStart"))
	    {
	    	
	        query = "select * from coursesctb where day='"+data[0]+"' and stime='"+data[1]+"' and roomid='"+data[2]+"'";
	        System.out.println(query);
	    }
	    else if(tbName.equals("coursesctbEnd"))
	    {
	    	
	        query = "select * from coursesctb where day='"+data[0]+"' and etime='"+data[1]+"' and roomid='"+data[2]+"'";
	        System.out.println(query);
	    }
	    
	    
	    else if(tbName.equals("registrationtb"))
	    {
	        query = "select * from registrationtb where studentid='"+data[0]+"'and coursescid='" +data[1]+"' ";
	    }
	    
	    
	    /*

	    else if(tbName.equals("supplier"))
	    {
	        query = "select * from supplier where Name ='"+data[0]+"'and Address ='"+data[1]+"'and PhoneNo ='"+data[2]+"'and Email='"+data[3]+"'";
	    }
	    
	    else if(tbName.equals("merchandise"))
	    {
	        query = "select * from merchandise where brandid='"+data[0]+"'and typeid='"+data[1]+"'";
	    }
	    else if(tbName.equals("customer"))
	    {
	        query = "select * from customer where Name ='"+data[0]+"'and Address ='"+data[1]+"'and PhoneNo ='"+data[2]+"'and Email='"+data[3]+"'";
	    }
	    else if(tbName.equals("itemdetail"))
	    {
	        query = "select * from itemdetail where itemname ='"+data[0]+"'and merid ='"+data[1]+"'";
	    }
	    */
	    
	    try{
	    	con=connect.getConnection();
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(query);
	        if(rs.next())
	            return false;
	        else
	            return true;
	    }catch(SQLException e){
	        JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	}
    
    public boolean isBetweenTimes( String []data) {
    	 query = "select * from coursesctb where day='"+data[0]+"'";
    	 Boolean result = false;
    	 try{
	    	con=connect.getConnection();
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(query);
	        
	        while(rs.next()) {
	        	String st = rs.getString(4);
				String ed =  rs.getString(5);
				
				String tgstart = data[1];
				String tgend = data[2];
				
				LocalTime start =  LocalTime.parse(st,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
				LocalTime end =  LocalTime.parse(ed,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
				LocalTime targetStart =  LocalTime.parse(tgstart,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
				LocalTime targetEnd =  LocalTime.parse(tgend,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
				
				System.out.println(start + " " + end + " " + targetStart + " " + targetEnd);
				
				if (targetStart.isAfter(start) && targetStart.isBefore(end) || 
						targetEnd.isAfter(start) && targetEnd.isBefore(end)) {
					result = true;
				}
	        
	        }        	      
	        	
			
			
	        
	        return result;
	    }catch(SQLException e){
	        JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
    }

    public static String[] getNameForChoice(String tbName)
    {
        try{
            if((tbName.equals("teachertb")))
                rs = connect.SQLSelect("tname","teachertb");
            else if(tbName.equals("roomtb"))
                rs=connect.SQLSelect("roomno", "roomtb");
            else if(tbName.equals("studenttb"))
                rs=connect.SQLSelect("stuname", "studenttb");
            else if(tbName.equals("coursesctb"))
                rs=connect.SQLSelect("courseName", "coursesctb");
            else if(tbName.equals("registrationtb"))
                rs=connect.SQLSelect("registrationid", "coursesctb");
            
            
            
            /*else if(tbName.equals("type"))
                rs=connect.SQLSelect("typeID", "type");
            else if(tbName.equals("customer"))
                rs=connect.SQLSelect("customerID", "customer");
            else if(tbName.equals("merchandise"))
                rs=connect.SQLSelect("merID", "merchandise");
            else if(tbName.equals("brand"))
                rs=connect.SQLSelect("brandID", "brand");
            else if(tbName.equals("orders"))
                rs=connect.SQLSelect("distinct orderid","orders");
            else if(tbName.equals("orderdetail"))
                rs = connect.SQLSelect("orderid","orderdetail where remark !=0");
                */

            int rowcount = 0 ;
            while(rs.next())
            {
                rowcount++;
            }
            String temp[]=new String[rowcount];
            rs.beforeFirst();
            int i = 0 ;
            while(rs.next())
            {
                temp[i]=rs.getString(1);
                i++;
            }
            return temp;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    
    
    public static String[] getStudentData1(String sid)
    {
        try
        {
       	 con=connect.getConnection();
            stmt = con.createStatement();
            String str[];
            query = "select * from studenttb where studentid='"+sid+"'";
            str = new String[8];
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
                for(int i = 0 ; i<str.length ; i++)
                {
                    str[i]=rs.getString(i+2);
                }
            }
            return str;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }

    public static boolean updateRecord1(String tbName, String id, String[] data) {
		// TODO Auto-generated method stub

		if(tbName.equals("registrationtb"))
		{ 
			query = "update registrationtb set installmentfee='"+data[0]+"' where registrationid='"+id+"' ";
		}
		
		 try{
           	 con=connect.getConnection();
                stmt = con.createStatement();
                if(stmt.executeUpdate(query)==1)
                {
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"The table does not contain the specified ID.","Update Fail",JOptionPane.ERROR_MESSAGE);
                    return false;}
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                return false;
            }
		
    }
    
    public static boolean updateRecord(String tbName, String id, String[] data) {
		// TODO Auto-generated method stub

		if(tbName.equals("coursesctb"))
			
		{ 
			query = "update coursesctb set courseName='"+data[0]+"',day='"+data[1]+"',stime='"+data[2]+"',etime='"+data[3]+"',fee="+data[4]+",teacherid='"+data[5]+"',roomid='"+data[6]+"' where coursescid='"+id+"'";
		}
		
		else  if(tbName.equals("teachertb"))
		{ query = "update teachertb set tname='"+data[0]+"',tph='"+data[1]+"',temail='"+data[2]+"' where teacherid='"+id+"'";
		}
		
		else  if(tbName.equals("installmenttb"))
		{ query = "update installmenttb set totalamount='"+data[0]+"',roamount='"+data[1]+"' where registrationid='"+id+"'";
		}
		
            
            try{
           	 con=connect.getConnection();
                stmt = con.createStatement();
                if(stmt.executeUpdate(query)==1)
                {
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"The table does not contain the specified ID.","Update Fail",JOptionPane.ERROR_MESSAGE);
                    return false;}
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                return false;
            }
	}

	public static void deleteRecord(String tbName, String id) {
		int returnvalue = 0 ;
        String query = "";
        if(tbName.equals("coursesctb"))
        {
            query = "delete from coursesctb where coursescid = '"+id+"' ";
        }
       if(tbName.equals("teachertb"))
        {
            query = "delete from teachertb where teacherid = '"+id+"' ";
        }
        try{
            stmt = con.createStatement();
            if(!query.equals("")&&stmt.executeUpdate(query)==1)
                JOptionPane.showMessageDialog(null, "The record is deleted successfully in"+tbName+"table.");
            else
                JOptionPane.showMessageDialog(null,"The specified ID does not found in the table .","Delete Fail",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
        }
	}
	public static String[] getIDForChoice(String tbName) {
		try{
            if((tbName.equals("coursesctb")))
                rs = connect.SQLSelect("coursescID","coursesctb ");
            else if(tbName.equals("teachertb"))
                rs=connect.SQLSelect("teacherID", "teachertb");
            else if(tbName.equals("studenttb"))
                rs=connect.SQLSelect("studentID", "studenttb");

            int rowcount = 0 ;
            while(rs.next())
            {
                rowcount++;
            }
            String temp[]=new String[rowcount];
            rs.beforeFirst();
            int i = 0 ;
            while(rs.next())
            {
                temp[i]=rs.getString(1);
                i++;
            }
            return temp;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
	}
	public static String[] getIDForChoice1(String tbName) {
		try{
            if((tbName.equals("r")))
                rs = connect.SQLSelect1("registrationID","registrationtb");
           
            int rowcount = 0 ;
            while(rs.next())
            {
                rowcount++;
            }
            String temp[]=new String[rowcount];
            rs.beforeFirst();
            int i = 0 ;
            while(rs.next())
            {
                temp[i]=rs.getString(3);
                i++;
            }
            return temp;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
	}
    public static String []getStudentData(String sname)
    {
        try
        {
       	 con=connect.getConnection();
            stmt = con.createStatement();
            String str[];
            query = "select * from studenttb where stuname='"+sname+"'";
            str = new String[7];
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
                for(int i = 0 ; i<str.length ; i++)
                {
                    str[i]=rs.getString(i+3);
                }
            }
            return str;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }


	public static void main(String[] args) throws ClassNotFoundException {
		

		mySQLQueries q=new mySQLQueries();
   		 System.out.print(con);

		
		
	}

	public String[] getCourseData(String cname) {
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String str[];
	            query = "select * from coursesctb where courseName='"+cname+"'";
	            str = new String[6];
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	           
	            	 for(int i = 0 ; i<str.length ; i++)
	                 {
	                     str[i]=rs.getString(i+3);
	                 }
	            }
	            return str;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}

	
	
	
	public String[] getCourseData1(String cname) {
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String str[];
	            query = "select * from coursesctb where coursescid='"+cname+"'";
	            str = new String[7];
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	           
	            	 for(int i = 0 ; i<str.length ; i++)
	                 {
	                     str[i]=rs.getString(i+2);
	                 }
	            }
	            return str;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}

	
	
	
	
	
	public String getStudentid(String sid) {
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String student= null;
	            query = "select * from studenttb where stuname='"+sid+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            student=rs.getString(1);	
	            
	            }
	            return student;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
		
	}

	public String getCourseid(String cid) {
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String course= null;
	            query = "select * from coursesctb where courseName='"+cid+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            course=rs.getString(1);	
	            
	            }
	            return course;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}

	public static String getTeacherid(String tname1) {
		
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String teaid = null;
	            query = "select * from teachertb where tname='"+tname1+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            teaid=rs.getString(1);	
	            
	            }
	            
	            return teaid;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}
	
	public static String[] getTeacherData(String id) {
		try
        {
       	 con=connect.getConnection();
            stmt = con.createStatement();
            String str[];
            query = "select * from teachertb where teacherid='"+id+"'";
            str = new String[3];
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
                for(int i = 0 ; i<str.length ; i++)
                {
                    str[i]=rs.getString(i+2);
                }
            }
            return str;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
	}

	public String[] getRegistrationData(String id) {
		try
        {
       	 con=connect.getConnection();
            stmt = con.createStatement();
            String str[];
            query = "select * from registrationtb where registrationid='"+id+"'";
            str = new String[4];
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
            //str[0]=rs.getString(1);
          
            str[0]=rs.getString(2);
            str[1]=rs.getString(3);
            str[2]=rs.getString(4);
            str[3]=rs.getString(5);
            
            
            }
            else {
             	JOptionPane.showMessageDialog(null,"Your search id does not contain in registration list");
             	
             	
             }
            return str;
                    
           
           
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
		 
	}
	
	
	
	
	
	public String[] getCourseInstallment(String fee)
	{
		try
        {
       	 con=connect.getConnection();
            stmt = con.createStatement();
            String str[];
            query = "select * from coursesctb where coursescid='"+fee+"'";
            str = new String[8];
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
            str[0]=rs.getString(2);
            str[1]=rs.getString(6);
            
                   
            }
            return str;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
		
	}
	
	public String[] getRegisterStudent(String sid) {
		try
        {
       	 con=connect.getConnection();
            stmt = con.createStatement();
            String str[];
            query = "select * from studenttb where studentid='"+sid+"'";
            str = new String[2];
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
            str[0]=rs.getString(2);
            str[1]=rs.getString(3);
                   
            }
            return str;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
	}
	
	
	public static String getRegistrationid(String regid) {
		
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String teaid = null;
	            query = "select * from registrationtb where studentid='"+regid+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            teaid=rs.getString(2);	
	            
	            }
	            
	            return teaid;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}

	public static String getRegistrationID(String regid) {
		
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String teaid = null;
	            query = "select * from registrationtb where studentid='"+regid+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            teaid=rs.getString(1);	
	            
	            }
	            
	            return teaid;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}
	

	public static String getCouseID(String rid) {
		
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String regid = null;
	            query = "select * from registrationtb where regstrationid='"+rid+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            regid=rs.getString(3);	
	            
	            }
	            
	            return regid;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}
	
	public static int getTotalInstallmentFee(String rid) {
		
		int result =0;
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String regid = null;
	            query = "select * from installmenttb where registrationid='"+rid+"'";
	          
	            rs = stmt.executeQuery(query);
	            while(rs.next()) {
	            result += Integer.parseInt( rs.getString(3));	
	            
	            }
	            
	            return result;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return 0;
	        }
	}
	public String getRoomID1(String rno) {
		
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String teaid = null;
	            query = "select * from roomtb where roomno='"+rno+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            teaid=rs.getString(1);	
	            
	            }
	            
	            return teaid;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}

	public static boolean updateRecord2(String tbName, String id, String[] data) {
		// TODO Auto-generated method stub

		if(tbName.equals("coursesctb"))
			
		{ 
			query = "update coursesctb set courseName='"+data[0]+"',day='"+data[1]+"',stime='"+data[2]+"',etime='"+data[3]+"',fee="+data[4]+",teacherid='"+data[5]+"',roomid='"+data[6]+"' where coursescid='"+id+"'";
		}
		
		else  if(tbName.equals("teachertb"))
		{ query = "update teachertb set tname='"+data[0]+"',tph='"+data[1]+"',temail='"+data[2]+"' where teacherid='"+id+"'";
		}
		else  if(tbName.equals("studenttb"))
		{ 
		query = "update studenttb set stuname='"+data[0]+"',stunrc='"+data[1]+"',stuph='"+data[2]+"',stuemail='"+data[3]+"',stuaddress='"+data[4]+"',stugender='"+data[5]+"',stufather='"+data[6]+"',studob='"+data[7]+"' where studentid='"+id+"'";
		} 
		
		else  if(tbName.equals("installmenttb"))
		{ query = "update installmenttb set totalamount='"+data[0]+"',roamount='"+data[1]+"' where registrationid='"+id+"'";
		}
		
            
            try{
           	 con=connect.getConnection();
                stmt = con.createStatement();
                if(stmt.executeUpdate(query)==1)
                {
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"The table does not contain the specified ID.","Update Fail",JOptionPane.ERROR_MESSAGE);
                    return false;}
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                return false;
            }
	}

	public static void deleteRecord1(String tbName, String id) {
		int returnvalue = 0 ;
        String query = "";
        if(tbName.equals("coursesctb"))
        {
            query = "delete from coursesctb where coursescid = '"+id+"' ";
        }
       if(tbName.equals("teachertb"))
        {
            query = "delete from teachertb where teacherid = '"+id+"' ";
        }
 	if(tbName.equals("studenttb"))
       {
           query = "delete from studenttb where studentid = '"+id+"' ";
       }

        try{
            stmt = con.createStatement();
            if(!query.equals("")&&stmt.executeUpdate(query)==1)
                JOptionPane.showMessageDialog(null, "The record is deleted successfully in"+tbName+"table.");
            else
                JOptionPane.showMessageDialog(null,"The specified ID does not found in the table .","Delete Fail",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"This Student has already registered!Cannot be deleted.");
        }
	}
	
	public String getRoomID(String room) {
		
		 try
	        {
	       	 con=connect.getConnection();
	            stmt = con.createStatement();
	            String teaid = null;
	            query = "select * from roomtb where roomno='"+room+"'";
	          
	            rs = stmt.executeQuery(query);
	            if(rs.next()) {
	            teaid=rs.getString(1);	
	            
	            }
	            
	            return teaid;
	        }catch(SQLException e)
	        {
	            JOptionPane.showMessageDialog(null,e.getMessage());
	            return null;
	        }
	}

	public String[] getCourseInstallment(Object fee) {
		try
        {
       	 con=connect.getConnection();
            stmt = con.createStatement();
            String str[];
            query = "select * from coursesctb where coursescid='"+fee+"'";
            str = new String[8];
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
            str[0]=rs.getString(2);
            str[1]=rs.getString(6);
            
                   
            }
            return str;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
	}

	
//	 public static boolean updateRecord(String tbName,String id , String []data)
//     {
//         if(tbName.equals("supplier"))
//             query = "update supplier set Name='"+data[0]+"',Address='"+data[1]+"',PhoneNo='"+data[2]+"',Email='"+data[3]+"'where supplierID='"+id+"'";
//
//     }
//	
	
	
		
	}

	

	



