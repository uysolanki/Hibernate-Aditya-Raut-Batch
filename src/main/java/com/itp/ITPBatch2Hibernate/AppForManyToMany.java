package com.itp.ITPBatch2Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.ITPBatch2Hibernate.entity.Actor;
import com.itp.ITPBatch2Hibernate.entity.Movie;

public class AppForManyToMany 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction(); //DMl queries
    	
    	Actor a1=Actor.builder()
    			.aname("SRK")
    			.age(59)
    			.build();
    	
    	Actor a2=Actor.builder()
    			.aname("DP")
    			.age(40)
    			.build();
    	
    	Actor a3=Actor.builder()
    			.aname("AK")
    			.age(55)
    			.build();
    	
    	Movie m1=Movie.builder()
    			.mname("CE")
    			.ryear(2010)
    			.build();
    	
    	Movie m2=Movie.builder()
    			.mname("Don")
    			.ryear(2007)
    			.build();
    	
    	Movie m3=Movie.builder()
    			.mname("RR")
    			.ryear(2006)
    			.build();
    	
    	List<Movie> srkMovies=new ArrayList();
    	srkMovies.add(m1);
    	srkMovies.add(m2);
    	
    	List<Movie> dpMovies=new ArrayList();
    	dpMovies.add(m1);
    	
    	List<Movie> akMovies=new ArrayList();
    	akMovies.add(m3);
    	
    	a1.setPortfolio(srkMovies);
    	a2.setPortfolio(dpMovies);
    	a3.setPortfolio(akMovies);
    	
    	session1.save(a1);
    	session1.save(a2);
    	session1.save(a3);
    	
    	tx.commit();
    	
    	session1.close();
    	factory.close();
    }
}
