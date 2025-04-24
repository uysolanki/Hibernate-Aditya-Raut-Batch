package com.itp.ITPBatch2Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.ITPBatch2Hibernate.entity.Student;

public class AppForLoad 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	
    	
    	Session session1=factory.openSession();  //fresh session - zero objects
    	Transaction tx=session1.beginTransaction(); //DMl queries
    	
    	Student student1=session1.load(Student.class, 25);  //will select query be disp : NO
    	System.out.println("Hi");
    	System.out.println(student1.getRno()); //will select query be disp : NO
    	System.out.println("Bye");
    	
    	System.out.println(student1.getSname()); //query will be displayed
    											 //Virat
    	
    	
    	
    

    	
    	
    	session1.close();
    	factory.close();
    }
}
