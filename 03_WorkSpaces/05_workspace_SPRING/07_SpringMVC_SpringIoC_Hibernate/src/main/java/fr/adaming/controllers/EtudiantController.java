package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;
import fr.adaming.service.IEtudiantService;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

	// Transformer l'association UML en Java
	@Autowired
	private IEtudiantService etudiantService;

	private Formateur formateur;

	@PostConstruct // Permet d'ex�cuter cette m�thode juste apr�s l'instanciation de
					// EtudiantController afin d'initialiser ses attributs
	public void init() {

		this.formateur = new Formateur(1, "a@a", "a");
	}

	@GetMapping("/list")
	public String afficheAccueil(Model modelMVC) {

		// R�cup�rer la liste du formateur connect�
		List<Etudiant> liste = etudiantService.getAllEtudiant(this.formateur);

		// Ajouter la liste r�cup�r�e comme attribut du model MVC pour que la page
		// accueil puisse l'afficher
		modelMVC.addAttribute("etudiants", liste);

		return "accueil";
	}

}
