package com.itp.ITPBatch2Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.ITPBatch2Hibernate.entity.Student;

public class AppForObjectStates 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction(); //DMl queries

    	Student s1=new Student();
    	s1.setRno(32);
    	s1.setSname("Tom");
    	s1.setPer(78.5);				//Transient
    	
    	session1.save(s1);				//Persistent
    	tx.commit();
    	Student student1=session1.get(Student.class, 32);//Not query the DB
    	System.out.println(student1);
    	
    
    	session1.clear();				//Detached

    	Student student2=session1.get(Student.class, 32);//query the DB
    	System.out.println(student2);
    	
    	Transaction tx2=session1.beginTransaction();
    	session1.delete(student2);		//Removed
    	tx2.commit();
    	
    	session1.close();
    	factory.close();
    }
}
