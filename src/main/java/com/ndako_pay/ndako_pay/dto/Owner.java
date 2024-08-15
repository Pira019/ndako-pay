package com.ndako_pay.ndako_pay.dto;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Owner extends Person {

	private static final long serialVersionUID = 1L;
	private String adresse;
	@OneToMany(mappedBy = "owner")
	private Set<Maison> maisons;
}
