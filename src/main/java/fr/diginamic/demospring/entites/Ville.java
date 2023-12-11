package fr.diginamic.demospring.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ville {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "code_departement")
	private String codeDepartement;
	private String nom;
	@Column(name = "nombre_habitants")
	private int nombreHabitants;

	public Ville(int id, String codeDepartement, String nom, int nombreHabitants) {
		super();
		this.id = id;
		this.codeDepartement = codeDepartement;
		this.nom = nom;
		this.nombreHabitants = nombreHabitants;
	}

	public Ville() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreHabitants() {
		return nombreHabitants;
	}

	public void setNombreHabitants(int nombreHabitants) {
		this.nombreHabitants = nombreHabitants;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", codeDepartement=" + codeDepartement + ", nom=" + nom + ", nombreHabitants="
				+ nombreHabitants + "]";
	}

}
