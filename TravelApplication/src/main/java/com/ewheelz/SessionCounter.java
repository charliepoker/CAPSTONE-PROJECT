// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SessionCounter.java

package com.ewheelz;
import jakarta.servlet.http.HttpServlet;
//import jakarta
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionCounter
    implements HttpSessionListener
{

    public SessionCounter()
    {
    }

    public void sessionCreated(HttpSessionEvent httpsessionevent)
    {
        activeSessions++;
    }

    public void sessionDestroyed(HttpSessionEvent httpsessionevent)
    {
        if(activeSessions > 0)
            activeSessions--;
    }

    public static int getActiveSessions()
    {
        return activeSessions;
    }

    private static int activeSessions = 0;

}
