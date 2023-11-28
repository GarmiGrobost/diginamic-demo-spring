package fr.diginamic.demospring.daos;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class VilleDao {

	@PersistenceContext
	private EntityManager em;
//
//	public List<Ville> extractVille() {
//		TypedQuery<Ville> query = em.createQuery("SELECT v FROM Ville v, Ville.class");
//		return query.getResultList();
//	}

}
