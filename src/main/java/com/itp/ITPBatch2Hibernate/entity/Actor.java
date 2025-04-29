package com.itp.ITPBatch2Hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Actor {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ano;
	private String aname;
	private int age;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			   name = "netflix",
	           joinColumns = @JoinColumn(name = "fano"),
	           inverseJoinColumns = @JoinColumn(name = "fmno")
			)
	List<Movie> portfolio;
	
	
	
}
