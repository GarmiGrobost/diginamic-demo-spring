package fr.diginamic.demospring.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.diginamic.demospring.entites.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class VilleDao {

	@PersistenceContext
	private EntityManager em;

	public List<Ville> extractVilles() {
		TypedQuery<Ville> query = em.createQuery("SELECT v FROM Ville v", Ville.class);
		return query.getResultList();
	}

	public Ville extractVille(int id) {
		TypedQuery<Ville> query = em.createQuery("SELECT v FROM Ville v WHERE v.id = ?1", Ville.class);
		query.setParameter(1, id);
		return query.getSingleResult();
	}

	public Ville extractVilleByNom(String nom) {
		TypedQuery<Ville> query = em.createQuery("SELECT v FROM Ville v WHERE v.nom = : name", Ville.class);
		query.setParameter("name", nom);
		return query.getSingleResult();
	}

	@Transactional
	public void insertVille(Ville nvVille) {
		em.persist(nvVille);
	}

	@Transactional
	public List<Ville> modifierVille(int id, Ville villeModifiee) {
		Ville villeAModifier = em.find(Ville.class, id);
		if (villeAModifier != null) {
			villeAModifier.setNom(villeModifiee.getNom());
			villeAModifier.setCodeDepartement(villeModifiee.getCodeDepartement());
			villeAModifier.setNombreHabitants(villeModifiee.getNombreHabitants());
		}
		return extractVilles();
	}

	@Transactional
	public List<Ville> supprimerVille(int id) {
		Ville ville = em.find(Ville.class, id);
		if (ville != null) {
			em.remove(ville);
		}
		return extractVilles();
	}
}
