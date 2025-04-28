package com.itp.ITPBatch2Hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	private String sname;
	private String capcity;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "fkcmno",referencedColumnName = "cmno")
	ChiefMinister chiefMinister;
	
	public State() {}
	
	
	public State(int sno, String sname, String capcity, ChiefMinister chiefMinister) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.capcity = capcity;
		this.chiefMinister = chiefMinister;
	}


	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCapcity() {
		return capcity;
	}
	public void setCapcity(String capcity) {
		this.capcity = capcity;
	}
	
	
	public ChiefMinister getChiefMinister() {
		return chiefMinister;
	}


	public void setChiefMinister(ChiefMinister chiefMinister) {
		this.chiefMinister = chiefMinister;
	}


	@Override
	public String toString() {
		return "State [sno=" + sno + ", sname=" + sname + ", capcity=" + capcity + ", chiefMinister=" + chiefMinister
				+ "]";
	}


	

}
