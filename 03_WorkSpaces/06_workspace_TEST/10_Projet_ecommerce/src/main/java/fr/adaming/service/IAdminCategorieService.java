package fr.adaming.service;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

public interface IAdminCategorieService {

	// ============== 1 : Gestion des cat�gories

	// Cr�er une cat�gorie dans la base de donn�es
	public boolean addCategory(Categorie catIn);

	// Modifier une cat�gorie dans la base de donn�es
	public boolean updateCategory(Categorie catIn);

	// Retour d'une cat�gorie de la base de donn�es selon son Id
	public Categorie getCategoryById(Categorie catIn);

	// Suppression d'une cat�gorie dans la base de donn�es
	public boolean deleteCategory(Categorie catIn);

	// ============== 2 : Gestion des clients

	// Ajout d'un client � la base de donn�es
	public boolean addClient(Client client);

	// Modification d'un client � la base de donn�es
	public boolean updateClient(Client client);

	// ============== 3 : Gestion des admins produit

	// Ajout d'un admin prod
	public boolean addAdminProduct(Admin admin);

	// Modification d'un admin prod
	public boolean updateAdminProduct(Admin admin);

	// ============== 4 : Gestion des admins cat�gorie

	// Ajout d'un admin cat�gorie
	public boolean addAdminCategory(Admin admin);

	// Modification d'un admin cat�gorie
	public boolean updateAdminCategory(Admin admin);
}
