package student;

import java.util.Vector;

import javax.swing.JOptionPane;

public class Checking {
	
	public static boolean IsValidName(String str)
	{
	    if(IsNull(str)||str.startsWith(""))
	        return false;
	    if(!IsLetter(str))
	        return false;
	    return true;
	}
	public static boolean IsNull(String str)
	{
	    if(str.trim().equals("")||str.trim().equals(null))
	        return true;
	    else
	        return false;
	}
	public static boolean IsLetter(String str)
	{
	    boolean b = false ;
	    for(int i=0 ; i<str.length() ; i++)
	    {
	        if(Character.isLetter(str.charAt(i)))b = true ;
	        else { b = false ; break ;}
	    }
	  return b;
	}
	public static boolean IsEformat(String str)
	{
	    boolean b = false ;
	    int t = str.indexOf(".");
	    int a = str.indexOf("@");
	    if((t< 0)|| (a<0) || (str.indexOf(" ")>0) )
	    {
	        return b ; 
	    }
	    String st1 = str.substring(0,a);
	    String st = str.substring(t+1);
	    if((!st1.trim().equals(""))&&(st.equals("com")))
	    {
	        b=true;
	        return b;
	    }
	    else
	        return b ;
	   }
	public static boolean IsAllDigit(String str)
	{
	    boolean b = false ;
	    for(int i = 0 ; i<str.length() ; i++)
	    {
	        if(Character.isDigit(str.charAt(i)))b=true;
	        else { b=false ; break ;}

	    }
	    return b;
	}
	

	public static void main(String[] args) {
		
		

	}

}
