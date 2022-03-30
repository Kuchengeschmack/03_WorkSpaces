package fr.adaming.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

// Annotation pour d�clarer la classe comme un component Dao
@Repository
public class AdminCategorieDaoImpl extends AdminProduitDaoImpl implements IAdminCategorieDao {

	// ============== 1 : Gestion des cat�gories

	// Cr�er une cat�gorie dans la base de donn�es
	public boolean addCategory(Categorie catIn) {
		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = catIn.getIdCategorie();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(catIn);

		// R�cup�rer l'id mis � jour
		idNew = catIn.getIdCategorie();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// Modifier une cat�gorie dans la base de donn�es
	public boolean updateCategory(Categorie catIn) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = catIn.getIdCategorie();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(catIn);

		// R�cup�rer l'id mis � jour
		idNew = catIn.getIdCategorie();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// Retour d'une cat�gorie de la base de donn�es selon son Id
	public Categorie getCategoryById(Categorie catIn) {

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		return s.get(Categorie.class, catIn.getIdCategorie());
	}

	// Suppression d'une cat�gorie dans la base de donn�es
	public boolean deleteCategory(Categorie catIn) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = catIn.getIdCategorie();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.delete(catIn);

		// R�cup�rer l'id mis � jour
		idNew = catIn.getIdCategorie();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// ============== 2 : Gestion des clients

	// Ajout d'un client � la base de donn�es
	public boolean addClient(Client client) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = client.getIdClient();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(client);

		// R�cup�rer l'id mis � jour
		idNew = client.getIdClient();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// Modification d'un client � la base de donn�es
	public boolean updateClient(Client client) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = client.getIdClient();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(client);

		// R�cup�rer l'id mis � jour
		idNew = client.getIdClient();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// ============== 3 : Gestion des admins produit

	// Ajout d'un admin prod
	public boolean addAdminProduct(Admin admin) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(admin);

		// R�cup�rer l'id mis � jour
		idNew = admin.getIdAdmin();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// Modification d'un admin prod
	public boolean updateAdminProduct(Admin admin) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(admin);

		// R�cup�rer l'id mis � jour
		idNew = admin.getIdAdmin();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// ============== 4 : Gestion des admins cat�gorie

	// Ajout d'un admin cat�gorie
	public boolean addAdminCategory(Admin admin) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(admin);

		// R�cup�rer l'id mis � jour
		idNew = admin.getIdAdmin();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

	// Modification d'un admin cat�gorie
	public boolean updateAdminCategory(Admin admin) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(admin);

		// R�cup�rer l'id mis � jour
		idNew = admin.getIdAdmin();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

}
