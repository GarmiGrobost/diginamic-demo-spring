package fr.diginamic.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.demospring.entites.Ville;
import fr.diginamic.demospring.exception.AnomalieException;
import fr.diginamic.demospring.repositories.VilleRepository;

@Service
public class VilleService {
	@Autowired
	private VilleRepository villeRepository;

	public Iterable<Ville> extractVilles() {
		return villeRepository.findAll();
	}

	public List<Ville> extractVilleByNomStartingWith(String nom) throws AnomalieException {
		if (villeRepository.findByNomStartingWith(nom).isEmpty()) {
			throw new AnomalieException("Aucune ville dont le nom commence par " + nom + " n’a été trouvée");
		}
		return villeRepository.findByNomStartingWith(nom);
	}

	public List<Ville> extractVilleByNombreHabitantsGreaterThan(int min) throws AnomalieException {
		if (villeRepository.findByNombreHabitantsGreaterThan(min).isEmpty()) {
			throw new AnomalieException("Aucune ville n’a une population supérieure à " + min);
		}
		return villeRepository.findByNombreHabitantsGreaterThan(min);
	}

	public List<Ville> extractVilleByNombreHabitantsBetween(int min, int max) throws AnomalieException {
		if (villeRepository.findByNombreHabitantsBetween(min, max).isEmpty()) {
			throw new AnomalieException(" Aucune ville n’a une population comprise entre " + min + " et " + max);
		}
		return villeRepository.findByNombreHabitantsBetween(min, max);
	}

	@Transactional
	public void insertVille(Ville nvVille) throws AnomalieException {
		if (nvVille.getCodeDepartement().length() != 2) {
			throw new AnomalieException("Le code département doit obligatoire avoir 2 caractères");
		}
		if (nvVille.getNom().length() <= 2) {
			throw new AnomalieException("La ville doit avoir un nom contenant au moins deux lettres");
		}
		if (nvVille.getNombreHabitants() <= 10) {
			throw new AnomalieException("La ville doit avoir au moins 10 habitants");
		}
		villeRepository.save(nvVille);
	}

	@Transactional
	public Iterable<Ville> modiiferVille(int id, Ville villeModifiee) throws AnomalieException {
		Optional<Ville> ville = villeRepository.findById(id);
		if (ville.isPresent()) {
			ville.get().setCodeDepartement(villeModifiee.getCodeDepartement());
			if (villeModifiee.getCodeDepartement().length() != 2) {
				throw new AnomalieException("Le code département doit obligatoire avoir 2 caractères");
			}
			ville.get().setNom(villeModifiee.getNom());
			if (villeModifiee.getNom().length() <= 2) {
				throw new AnomalieException("La ville doit avoir un nom contenant au moins deux lettres");
			}
			ville.get().setNombreHabitants(villeModifiee.getNombreHabitants());
			if (villeModifiee.getNombreHabitants() <= 10) {
				throw new AnomalieException("La ville doit avoir au moins 10 habitants");
			}
			villeRepository.save(ville.get());
		}
		return extractVilles();
	}

}
