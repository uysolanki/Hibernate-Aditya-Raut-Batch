package com.itp.ITPBatch2Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.ITPBatch2Hibernate.entity.Student;

public class AppForSave 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction(); //DMl queries
    	
    	Student s1=new Student();
    	s1.setRno(18);
    	s1.setSname("Virat");
    	s1.setPer(78.5);
    	
    	session1.save(s1);
    	tx.commit();
    	
    	
    

    	
    	
    	session1.close();
    	factory.close();
    }
}
