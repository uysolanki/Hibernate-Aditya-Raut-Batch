package com.itp.ITPBatch2Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.ITPBatch2Hibernate.entity.Student;

public class AppForGet 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	
    	
    	Session session1=factory.openSession();  //fresh session - zero objects
    	Transaction tx=session1.beginTransaction(); //DMl queries
    	
    	Student s1=new Student();
    	s1.setRno(22);
    	s1.setSname("David");
    	s1.setPer(98.5);
    	
    	session1.save(s1);						//one object 20
    	tx.commit();
    	
    	Student student1=session1.get(Student.class, 22); //select query will be displayed
    	Student student2=session1.get(Student.class, 22);
    	System.out.println(student1==student2);
    	
    

    	
    	
    	session1.close();
    	factory.close();
    }
}
