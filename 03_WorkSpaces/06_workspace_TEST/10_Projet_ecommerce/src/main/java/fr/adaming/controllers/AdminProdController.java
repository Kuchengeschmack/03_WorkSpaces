package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminProduitService;
import fr.adaming.service.IBoutiqueService;

@Controller
@Scope("session")
@RequestMapping("/adminProd")
public class AdminProdController {

	@Autowired
	private IBoutiqueService boutiqueService;

	@Autowired
	private IAdminProduitService adminProduitService;

	@GetMapping("/displayAdminProd")
	public String afficherEspaceAdminProd() {

		return "adminProduit";
	}

	// R�cup�ration des produits d'une cat�gorie sous forme de liste
	@GetMapping("/listProduit")
	public String afficheProduit(Model modelMVC, @RequestParam("pCat") Categorie categorie) {

		// R�cup�re le liste des produits de la cat�gorie (les images sont d�j�
		// r�cup�r�es)
		List<Produit> listeProduit = boutiqueService.getAllProducts(categorie);

		// Ajoute la liste des produits au modele MVC
		modelMVC.addAttribute("produits", listeProduit);

		// Redirection vers l'espace admin Produit
		return "adminProduit";

	}

	// ============= Fonctionnalit� Ajout =============

	@GetMapping("/displayAddProduit")
	public ModelAndView afficherProduitAjout() {
		return new ModelAndView("ajoutProduit", "produit", new Produit());
	}

	// Ajout d'un produit � sa cat�gorie, avec sa photo
	@PostMapping("/addProduit")
	public String soumettreProduitAjout(ModelMap modelMVC, @ModelAttribute("pAdd") Produit produit,
			@RequestParam("picture") CommonsMultipartFile file, @RequestParam("pCat") Categorie categorie) {

		// Si une photo est upload�e, la socker dans la base de donn�es comme un byte[]
		if (file != null) {
			produit.setPhoto(file.getBytes());
		}

		// Ajouter le produit � la base de donn�es dans sa cat�gorie
		boolean verif = adminProduitService.addProduct(produit, categorie);

		// Afficher la liste des produits

		if (verif) {
			return "redirect:listProduit";
		} else {
			// ajouter un message d'erreur
			modelMVC.addAttribute("msg", "L'ajout � �chou�");
			return "adminProd";
		}

	}

	// ============= Fonctionnalit� Modif =============

	@GetMapping("/displayUpdateProduit")
	public ModelAndView afficherProduitModif() {
		return new ModelAndView("modifProduit", "produit", new Produit());
	}

	@PostMapping("/updateProduit")
	public String soumettreProduitModif(ModelMap modelMVC, @ModelAttribute("pModif") Produit produit,
			@RequestParam("picture") CommonsMultipartFile file) {

		// Si une photo est upload�e, la socker dans la base de donn�es comme un byte[]
		if (file != null) {
			produit.setPhoto(file.getBytes());
		}

		// Modifier l'entit�e produit
		boolean verif = adminProduitService.updateProduct(produit);

		// Afficher la liste des produits
		if (verif) {
			return "redirect:listProduit";
		}
		// ajouter un message d'erreur
		modelMVC.addAttribute("msg", "La modification � �chou�");
		return "modifProd";
	}

	// ================ Fonctionnalit� Recherche ============

	@GetMapping("/displaySearchProduit")
	public ModelAndView afficherProduitRecherche() {
		return new ModelAndView("rechercheProduit", "produit", new Produit());
	}

	@PostMapping("/searchProduit")
	public String soumettreProduitRecherche(ModelMap modelMVC, @ModelAttribute("pSearch") Produit produit) {

		Produit pOut = adminProduitService.getProductById(produit);

		if (pOut != null) {
			modelMVC.addAttribute("produit", pOut);
			modelMVC.addAttribute("pSearch", new Produit());
		} else {
			modelMVC.addAttribute("msg", "La recherche a �chou� !");

			modelMVC.addAttribute("pSearch", new Produit());
		}

		return "adminProduit";

	}

	// =============== Fonctionnalit� Supprimer ======

	@GetMapping("/displayDeleteProduit")
	public ModelAndView afficherProduitSuppression() {
		return new ModelAndView("suppressionProduit", "produit", new Produit());
	}

	@PostMapping("/deleteProduit")
	public String soumettreProduitSupp(ModelMap modelMVC, @ModelAttribute("pSupp") Produit produit) {

		// Supprimer le produit
		boolean verif = adminProduitService.deleteProduct(produit);

		// Afficher la liste des produits
		if (verif) {
			return "redirect:listProduit";
		}
		// ajouter un message d'erreur
		modelMVC.addAttribute("msg", "La suppression � �chou�");
		return "adminProduit";
	}

	// QUE FAIT CETTE FONCTION ???
	@RequestMapping(value = "/updateLink", method = RequestMethod.GET)
	public String modifLink(Model modeleMVC, @RequestParam("pId") Long idProduit, Produit produit,
			@RequestParam("picture") CommonsMultipartFile file) {

		if (file != null) {
			produit.setPhoto(file.getBytes());
		}

		Produit pModif = new Produit();
		pModif.setIdProduit(idProduit);

		// Appel la m�thode service afin de rechercher l'etudiant dans la BD
		Produit pOut = adminProduitService.getProductById(pModif);
		modeleMVC.addAttribute("pUpdate", pOut);

		return "modifProduit";
	}

	// sauvegarder la cat dans le formulaire � partir de l'ordi

//		@RequestMapping(value="/saveProd")
//		public String saveProd(Categorie produit, Model modelMVC,MultipartFile file) throws IOException{
//			modelMVC.addAttribute("produit", new Categorie());
//			modelMVC.addAttribute("produit", boutiqueService.consulterProduits(produit));
//			
//			if(!file.isEmpty()) {
//				produit.setPhoto(file.getBytes()); 
//				//categorie.setNomPhoto(file.getOriginalFilename());
//			}
//			adminProduitService.ajouterProduit(produit, null);
//			return "produit";		
//	}

}
