package com.itp.ITPBatch2Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	//System.out.println(factory.isClosed()); //false
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction(); //DML queries
    	
    	
    

    	
    	
    	session1.close();
    	factory.close();
    }
}
