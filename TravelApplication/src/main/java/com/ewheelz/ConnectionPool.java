// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConnectionPool.java
package com.ewheelz;
import jakarta.servlet.http.HttpServlet;


import java.io.PrintStream;
import java.sql.*;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServlet;

public class ConnectionPool extends HttpServlet
    implements Servlet
{

    public ConnectionPool()
    {
    }

    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsdb", "root", "root");
            if(con != null)
                System.out.println("Connection Pool Database Connection Success");
        }
        catch(ClassNotFoundException classnotfoundexception) { }
        catch(SQLException sqlexception) { }
        return con;
    }

    private static Connection con = null;

}
