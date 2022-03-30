package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

public interface IBoutiqueService {

	// ============== 1 : R�cup�ration des cat�gories

	// Retour d'une liste de toutes les cat�gories de la BD
	public List<Categorie> getAllCategories();

	// Retour d'une cat�gorie en la cherchant par son Id
	public Categorie getCategoryById(Categorie categorie);

	// ============== 2 : R�cup�ration des produits

	// Retour d'une liste de tous les produits de la BD
	public List<Produit> getAllProducts();

	// Retour d'une liste de tous les produits d'une cat�gorie
	public List<Produit> getAllProducts(Categorie categorie);

	// Retour des produits dont la designation/description contient un mot-clef
	public List<Produit> getAllProducts(Produit produit);

	// Retour des produits contenus dans le panier
	public List<Produit> getAllProducts(Panier panier);

	// Retour d'un produit par son id
	public Produit getProductById(Produit produit);

	// ============== 3 : Gestion du panier

	// Ajout d'un produit du panier
	public void addProductToCart(Panier panier, Produit produit, int quantite);

	// Suppression d'un produit du panier
	public void removeProductFromCart(Panier panier, Produit produit);

	// ============== 4 : Gestion de la commande

	// Enregistrement de la commande
	public boolean saveOrder(Commande commande);
}
