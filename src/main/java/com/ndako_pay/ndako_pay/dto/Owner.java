package com.ndako_pay.ndako_pay.dto;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  
@Entity
public class Owner extends Person { 
	 
	private static final long serialVersionUID  = 1L;
	private String adresse;
	@OneToMany(mappedBy = "owner")
	private Set<Maison> maisons;
}
