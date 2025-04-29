package com.itp.ITPBatch2Hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mno;
	private String mname;
	private int ryear;
}
