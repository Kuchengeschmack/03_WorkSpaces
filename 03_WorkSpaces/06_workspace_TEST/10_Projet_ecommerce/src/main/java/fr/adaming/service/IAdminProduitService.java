package fr.adaming.service;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IAdminProduitService {

	// ============== Gestion des produits

	// Cr�er un produit dans la base de donn�es
	public boolean addProduct(Produit prodIn, Categorie catIn);

	// Modifier un produit dans la base de donn�es
	public boolean updateProduct(Produit prodIn);

	// Retour d'un produit de la base de donn�es selon son Id
	public Produit getProductById(Produit prodIn);

	// Suppression d'un produit dans le base de donn�es
	public boolean deleteProduct(Produit prodIn);
}
