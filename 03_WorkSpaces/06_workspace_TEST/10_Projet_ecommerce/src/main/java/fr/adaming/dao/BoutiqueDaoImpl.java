package fr.adaming.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

//Annotation pour d�clarer la classe comme un component Dao
@Repository
public class BoutiqueDaoImpl implements IBoutiqueDao {

	@Autowired
	private SessionFactory sf;

	// ============== 1 : R�cup�ration des cat�gories

	// Retour d'une liste de toutes les cat�gories de la BD
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategories() {

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Cr�ation de la requ�te HQL
		Query req = s.createQuery("FROM Categorie");

		// R�cup�ration de la liste
		List<Categorie> catOut = req.list();

		// Retour de la liste
		return catOut;
	}

	// Retour d'une cat�gorie en la cherchant par son Id
	public Categorie getCategoryById(Categorie categorie) {

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// R�cup�ration de la cat�gorie par son id
		Categorie catOut = s.get(Categorie.class, categorie.getIdCategorie());

		// Retour de la cat�gorie
		return catOut;
	}

	// ============== 2 : R�cup�ration des produits

	// Retour d'une liste de tous les produits de la BD
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProducts() {

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Cr�ation de la requ�te HQL
		Query req = s.createQuery("FROM Produit");

		// R�cup�ration de la liste
		List<Produit> prodOut = req.list();

		// Retour de la liste
		return prodOut;
	}

	// Retour d'une liste de tous les produits d'une cat�gorie
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProducts(Categorie categorie) {
		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Cr�ation de la requ�te HQL
		Query req = s.createQuery("FROM Produit AS p WHERE p.categorie.id=:pId");

		// Donner l'attribut pId
		req.setParameter("pId", categorie.getIdCategorie());

		// R�cup�ration de la liste
		List<Produit> prodOut = req.list();

		// Retour de la liste
		return prodOut;
	}

	// Retour des produits dont la designation/description contient un mot-clef
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProducts(Produit produit) {
		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Cr�ation de la requ�te HQL
		Query req = s
				.createQuery("FROM Produit AS p WHERE p.designation LIKE %pKeyword% OR p.description LIKE %pKeyword%");

		// Donner l'attribut pId
		req.setParameter("pKeyword", produit.getMotClef());

		// R�cup�ration de la liste
		List<Produit> prodOut = req.list();

		// Retour de la liste
		return prodOut;
	}

	// Retour des produits contenus dans le panier
	public List<Produit> getAllProducts(Panier panier) {

		// R�cup�ration des lignes de commande du panier
		Collection<LigneCommande> lc = panier.getLignecommande();

		// D�claration et instanciation d'une liste de produits
		List<Produit> lp = new ArrayList<Produit>();

		// Parcour des lignes de commande pour en extraire les produits
		for (LigneCommande l : lc) {
			lp.add(l.getProduit());
		}

		// Retour de la liste de produits
		return lp;
	}

	public Produit getProductById(Produit produit) {
		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// R�cup�ration de la cat�gorie par son id
		Produit prodOut = s.get(Produit.class, produit.getIdProduit());

		// Retour de la cat�gorie
		return prodOut;

	}

	// ============== 3 : Gestion du panier

	// Ajout d'un produit du panier
	public void addProductToCart(Panier panier, Produit produit, int quantite) {

		// Ajout du produit au panier avec sa quantit�
		panier.addProduits(produit, quantite);

	}

	// Suppression d'un produit du panier
	public void removeProductFromCart(Panier panier, Produit produit) {

		// Suppression du produit du panier
		panier.deleteProduit(produit.getIdProduit());
	}

	// ============== 4 : Gestion de la commande

	// Enregistrement de la commande
	public boolean saveOrder(Commande commande) {

		// Variables pour v�rifier si la commande poss�de un id
		Long idOld = commande.getIdCommande();
		Long idNew;

		// R�cup�ration de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(commande);

		// R�cup�rer l'id mis � jour
		idNew = commande.getIdCommande();

		// Si l'id mis � jour est diff�rent de l'ancien id, op�ration r�ussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, op�ration �chou�e
		return false;
	}

}
