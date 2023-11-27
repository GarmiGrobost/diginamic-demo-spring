package fr.diginamic.demospring.controleur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.demospring.entites.Ville;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

	ArrayList<Ville> listeVille = new ArrayList<>();

	@GetMapping
	public List<Ville> getVilles() {

		Collections.addAll(listeVille, new Ville(1, "Nice", 343000), new Ville(2, "Carcassone", 47000),
				new Ville(3, "Narbonne", 53400), new Ville(4, "Lyon", 484000), new Ville(5, "Foix", 9700),
				new Ville(6, "Pau", 77200), new Ville(7, "Marseille", 850700), new Ville(8, "Tarbes", 40600));
		return listeVille;
	}

	@GetMapping("/{id}")
	public Ville getVillEById(@PathVariable Integer id) {
		for (Ville ville : listeVille) {
			if (ville.getId().equals(id)) {
				return ville;
			}
		}
		return null;
	}

	@PutMapping
	public String insertNewVille(@RequestBody Ville newVille) {
		if (newVille.getId() == 0) {
			return "La ville doit obligatoirement avoir un id";
		}
		for (Ville ville : listeVille) {
			if (ville.getId() == newVille.getId()) {
				return "Une ville avec le même id existe déjà";
			}
		}
		listeVille.add(newVille);
		return "La ville a été ajoutée avec succès";
	}

	@PostMapping("/{id}")
	public String modifierVille(@PathVariable Integer id, @RequestBody Ville ville) {
		if (id <= 0) {
			return "L'id est incorrect";
		}
		for (Ville v : listeVille) {
			if (v.getId() == id) {
				v.setNom(ville.getNom());
				v.setNombreHabitants(ville.getNombreHabitants());
				return "La ville a été modifiée";
			}
		}
		return "La ville n'existe pas";
	}

	@DeleteMapping("/{id}")
	public String supprimerVille(@PathVariable Integer id) {
		Iterator<Ville> iter = listeVille.iterator();
		while (iter.hasNext()) {
			Ville ville = iter.next();
			if (ville.getId() == id) {
				iter.remove();
				return "La ville a été supprimée";
			}
		}
		return "La ville dont l'id " + id + "n'a pas été trouvée";
	}
}
