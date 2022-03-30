package fr.adaming.dao;

import fr.adaming.entities.Produit;

/*
 * D�finit les m�thodes propres aux
 * admin produits
 */

public interface IAdminProduitDao {

	// ============== Gestion des produits

	// Cr�er un produit dans la base de donn�es
	public boolean addProduct(Produit prodIn);

	// Modifier un produit dans la base de donn�es
	public boolean updateProduct(Produit prodIn);

	// Retour d'un produit de la base de donn�es selon son Id
	public Produit getProductById(Produit prodIn);

	// Suppression d'un produit dans le base de donn�es
	public boolean deleteProduct(Produit prodIn);

}
