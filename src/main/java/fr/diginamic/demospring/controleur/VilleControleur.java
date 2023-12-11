package fr.diginamic.demospring.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.demospring.entites.Ville;
import fr.diginamic.demospring.exception.AnomalieException;
import fr.diginamic.demospring.services.VilleService;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

	@Autowired
	VilleService villeService;

	@GetMapping
	public Iterable<Ville> getVilles() {
		return villeService.extractVilles();

	}

	@GetMapping("/nom/{nom}")
	public List<Ville> getVilleByNomStartingWith(@PathVariable String nom) throws AnomalieException {
		return villeService.extractVilleByNomStartingWith(nom);
	}

	@GetMapping("/{min}")
	public List<Ville> getVilleByNombreHabitantsGraeterThan(@PathVariable int min) throws AnomalieException {
		return villeService.extractVilleByNombreHabitantsGreaterThan(min);
	}

	@GetMapping("/{min}/{max}")
	public List<Ville> getVilleByNombreHabitantsBetween(@PathVariable int min, @PathVariable int max)
			throws AnomalieException {
		return villeService.extractVilleByNombreHabitantsBetween(min, max);
	}

	@PutMapping
	public Iterable<Ville> insertVille(@RequestBody Ville nvVille) throws AnomalieException {
		villeService.insertVille(nvVille);
		return villeService.extractVilles();

	}

	@PostMapping("/{id}")
	public Iterable<Ville> modifierVille(@PathVariable int id, @RequestBody Ville villeModifiee)
			throws AnomalieException {
		villeService.modiiferVille(id, villeModifiee);
		return villeService.extractVilles();
	}

//	@Autowired
//	private VilleDao villeDao;
//
//	@GetMapping
//	public List<Ville> getVilles() {
//
//		return villeDao.extractVilles();
//	}
//
//	@GetMapping("/{id}")
//	public Ville getVillEById(@PathVariable Integer id) {
//
//		return villeDao.extractVille(id);
//	}
//
//	@GetMapping("/nom/{nom}")
//	public Ville getVilleByNom(@PathVariable String nom) {
//		return villeDao.extractVilleByNom(nom);
//
//	}
//
//	@PutMapping
//	public String insertVille(@RequestBody Ville nvVille) {
//		villeDao.insertVille(nvVille);
//		return "La ville a été insérée avec succès";
//	}
//
//	@PostMapping("/{id}")
//	public String modifierVille(@PathVariable int id, @RequestBody Ville villeModifiee) {
//		villeDao.modifierVille(id, villeModifiee);
//		return "La ville a été mise à jour";
//
//	}
//
//	@DeleteMapping("/{id}")
//	public String supprimerVille(@PathVariable int id) {
//		villeDao.supprimerVille(id);
//		return "La ville a été supprimée";
//
//	}

}
