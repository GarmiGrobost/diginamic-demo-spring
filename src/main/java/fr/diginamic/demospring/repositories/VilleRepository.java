package fr.diginamic.demospring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.demospring.entites.Ville;

@Repository
public interface VilleRepository extends CrudRepository<Ville, Integer> {

	public List<Ville> findByNomStartingWith(String nom);

	public List<Ville> findByNombreHabitantsGreaterThan(int min);

	public List<Ville> findByNombreHabitantsBetween(int min, int max);

}
