package com.itp.ITPBatch2Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.ITPBatch2Hibernate.entity.Dept;
import com.itp.ITPBatch2Hibernate.entity.Emp;

public class AppForOneToMany 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction(); //DMl queries
    	
    	
    	Dept d1=new Dept();
    	d1.setDname("IT");
    	d1.setCity("Pune");
    	
    	Dept d2=new Dept();
    	d2.setDname("HR");
    	d2.setCity("Delhi");

    	
    	Emp e1=new Emp();
    	e1.setEname("Alice");
    	e1.setSalary(8000);
    	
    	Emp e2=Emp.builder()
    			.ename("Ben")
    			.salary(9000)
    			.build();
    	

    	Emp e3=Emp.builder()
    			.ename("Chris")
    			.salary(900)
    			.build();
    	

    	Emp e4=Emp.builder()
    			.ename("David")
    			.salary(900)
    			.build();
    	
    	List<Emp> itdeptEmps=new ArrayList<Emp>();
    	itdeptEmps.add(e1);
    	itdeptEmps.add(e2);
    	
    	List<Emp> hrdeptEmps=new ArrayList<Emp>();
    	hrdeptEmps.add(e3);
    	hrdeptEmps.add(e4);
    	
    	d1.setEmployees(itdeptEmps);
    	d2.setEmployees(hrdeptEmps);
    	
    	session1.save(d1);
    	session1.save(d2);
    	
    
    	tx.commit();
    	
    	session1.close();
    	factory.close();
    }
}
