package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Produit;

//Annotation pour d�clarer la classe comme un component Dao
@Repository
public class AdminProduitDaoImpl implements IAdminProduitDao {

	@Autowired
	protected SessionFactory sf; // protected afin d'h�riter la SessionFactory dans AdminCategorieDaoImpl

	// ============== Gestion des produits

	// Cr�er un produit dans la base de donn�es
	public boolean addProduct(Produit prodIn) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = prodIn.getIdProduit();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(prodIn);

		// R�cup�rer l'id mis � jour
		idNew = prodIn.getIdProduit();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// Modifier un produit dans la base de donn�es
	public boolean updateProduct(Produit prodIn) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = prodIn.getIdProduit();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(prodIn);

		// R�cup�rer l'id mis � jour
		idNew = prodIn.getIdProduit();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// Retour d'un produit de la base de donn�es selon son Id
	public Produit getProductById(Produit prodIn) {

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		return s.get(Produit.class, prodIn.getIdProduit());
	}

	// Suppression d'un produit dans le base de donn�es
	public boolean deleteProduct(Produit prodIn) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = prodIn.getIdProduit();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.delete(prodIn);

		// R�cup�rer l'id mis � jour
		idNew = prodIn.getIdProduit();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

}
