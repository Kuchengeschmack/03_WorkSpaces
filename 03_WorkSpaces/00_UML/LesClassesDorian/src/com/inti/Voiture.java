package com.inti;

import java.text.DecimalFormat;

public class Voiture {

	// Attributs (propri�t�s, caract�ristiques,...)
	// Par d�faut, les attributs sont en public
	private int numSerie;
	private String marque;
	private double prix;
	
	// Constructeur vide
	public Voiture()
	{
		
	}
	
	
	
	// Fonctions (m�thodes)
	// Constructeur surcharg� (surcharg� car il prend des param�tres)
	public Voiture(int numSerie, String marque, double prix)
	{
		// super(); // Sert � appeler le constructeur de la classe m�re
		this.numSerie = numSerie;
		this.marque = marque;
		this.prix = prix;
	}
	
	public Voiture(int numSerie, String marque)
	{
		// super(); // Sert � appeler le constructeur de la classe m�re
		this.numSerie = numSerie;
		this.marque = marque;
	}

	public void promotion(int pourcentage, boolean choixPromotion)
	{
		if(choixPromotion)
		{
			DecimalFormat df = new DecimalFormat("0.##");
			double prixPromo = (prix * ( 1 - (double)pourcentage/100));
			String p = df.format(prixPromo).replace(",", ".");
			prix = Double.parseDouble(p);
		}
	}


	public int getNumSerie() {
		return numSerie;
	}



	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	// getter and setters
	
}
