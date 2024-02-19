// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MyFunctions.java

package com.ewheelz;

import java.io.PrintStream;
import java.sql.*;
import java.util.StringTokenizer;

// Referenced classes of package com.ewheelz:
//            ConnectionPool

public class MyFunctions
{

    public MyFunctions()
    {
    }

    public static Connection openConnection()
        throws Exception
    {
        conn = ConnectionPool.getConnection();
        return conn;
    }

    public static void closeConnection()
        throws Exception
    {
        conn.close();
    }

    public static String genNextID(String s, String s1, String s2) throws Exception
    {
        String s3 = "";
        String s4 = s2;
        System.out.println("Gen NextID method is called");
        ResultSet resultset;
        int i;
        try
        {
            openConnection();
            Statement statement = conn.createStatement();
            resultset = null;
            String s5 = (new StringBuilder()).append("select max(`").append(s1).append("`) from `").append(s).append("`").toString();
            
            StringBuilder s41 = new StringBuilder();
 
           // String s43= s41.append("select max(cast(substring('").append(s1).append("', 2,").append(" length('").append(s1).append("'").append(")-1) as INT)) from '").append(s).append("`").toString();
            String s43= s41.append("select max(cast(substring(").append(s1).append(", 2,").append(" length(").append(s1).append(")-1) as INT)) from ").append(s).toString();
           System.out.println("print of s43 is " + s43);
            // String s5 = (new StringBuilder()).append("select max(cast(substring(`").append(s1).append("`, 2, length('".append()) from `").append(s).append("`").toString();
            System.out.println("S5 is "+s5);
            
            resultset = statement.executeQuery(s43);
           
            if(resultset == null) {
                System.out.println("Resultset is null");
            	return (new StringBuilder()).append(s2).append("1").toString();
            }
        }
        catch(Exception exception)
        {
            System.out.println((new StringBuilder()).append("Exception in genNextID").append(exception).toString());
            exception.printStackTrace();
            return (new StringBuilder()).append(s2).append("1").toString();
        }
        try {
			if(resultset.next()) {
			    System.out.println("Result set is not empty");
				s3 = resultset.getString(1);
				System.out.println("S3 is "+s3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("We are attempting to parse integer ");
        String string_output=s3.replaceAll("[^A-Za-z]", "");  
        
        System.out.println("string_output = "+string_output);   
        i =Integer.parseInt(s3.replaceAll("[^0-9]", ""));  
        System.out.println("number_output = "+i); 
        
      //  i = Integer.parseInt(s3);
        //i = 8;
        System.out.println("I is "+i);
        
        i++;
        s4 = (new StringBuilder()).append(s4).append(i).toString();
        System.out.println("S4 is " + s4);
        closeConnection();
        if(i != 0)
            return s4;
        return (new StringBuilder()).append(s2).append("1").toString();
    }

    public static String[] MyTokenizer(String s, String s1)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s, s1);
        int i = stringtokenizer.countTokens();
        int j = 0;
        String as[] = new String[i];
        while(stringtokenizer.hasMoreTokens()) 
        {
            as[j] = stringtokenizer.nextToken();
            j++;
        }
        return as;
    }

    private static Connection conn;
    private static Statement stmt = null;
    private static Statement stmt1 = null;
    private static ResultSet rs = null;

}
