package com.itp.ITPBatch2Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.ITPBatch2Hibernate.entity.Student;

public class AppForSecondLevelCache 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	Session session1=factory.openSession();
    	Session session2=factory.openSession();
    	Transaction tx=session1.beginTransaction(); //DMl queries
    	
    	Student stud1=session1.get(Student.class, 18);  //db query
    	System.out.println(stud1);
    	Student stud2=session1.get(Student.class, 18);  //no query
    	System.out.println(stud2);
    	Student stud3=session2.get(Student.class, 18);  //no query
    	System.out.println(stud2);
    	tx.commit();
  
    	session1.close();
    	factory.close();
    }
}
