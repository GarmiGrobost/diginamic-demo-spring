package fr.diginamic.demospring.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ville {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private Integer nombreHabitants;

	public Ville(Integer id, String nom, Integer nombreHabitants) {
		super();
		this.id = id;
		this.nom = nom;
		this.nombreHabitants = nombreHabitants;
	}

	public Ville() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNombreHabitants() {
		return nombreHabitants;
	}

	public void setNombreHabitants(Integer nombreHabitants) {
		this.nombreHabitants = nombreHabitants;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", nombreHabitants=" + nombreHabitants + "]";
	}

}
