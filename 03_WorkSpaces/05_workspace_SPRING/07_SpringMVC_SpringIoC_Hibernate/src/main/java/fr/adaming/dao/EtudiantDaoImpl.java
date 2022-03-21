package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Repository // Pour que le conteneur IoC puisse l'instancier comme Dao
public class EtudiantDaoImpl implements IEtudiantDao {

	@Autowired // Pour injecter le sessionFactoryBean instanci� par le conteneur Spring IoC
				// (collaborateur)
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiant(Formateur fIn) {

		// R�cup�rer la session Hibernate
		Session s = sf.getCurrentSession(); // Cr�er une nouvelle session il elle n'existe pas

		// �crire la requ�te HQL
		String req = "FROM Etudiant AS e WHERE e.formateur.id=:pId";

		// R�cup�rer le Query
		Query query = s.createQuery(req);

		// Passage des params de la requ�te HQL
		query.setParameter("pId", fIn.getId());

		return query.list();
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {
		return null;
	}

	@Override
	public int updateEtudiant(Etudiant eIn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteEtudiant(Etudiant eIn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Etudiant getEtudiantById(Etudiant eIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
