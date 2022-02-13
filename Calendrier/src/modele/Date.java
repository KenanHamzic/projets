package modele;

/**
* 
* Voici la classe date qui peut stocker une Date afin de l'utiliser pour créer un évènement.
* 
* @author Kenan HAMZIC
* @version 1.0
* 
*/

import java.io.Serializable;
import java.util.GregorianCalendar;

import constantes.ConstantesCalendrier;

import java.util.Calendar;

public class Date implements Comparable <Date>,ConstantesCalendrier,Serializable {
  private int jour;
  private int mois;
  private int annee;
  private int jourSemaine ;
  
   
  public Date ()   { 
	  GregorianCalendar dateAuj = new GregorianCalendar ();
	  annee = dateAuj.get (Calendar.YEAR);
	  mois = dateAuj.get (Calendar.MONTH) + 1; 
	  jour = dateAuj.get (Calendar.DAY_OF_MONTH);
	  jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
	  if (jourSemaine == 1)
		  jourSemaine = 7;
	  else jourSemaine -= 1; 
  }
  
  /**
   * 
   * Méthode créant une date en prenant plusieurs paramètres
   * 
   * @param parJour prend un jour donné par l'utilisateur afin de créer un objet de type Date
   * @param parMois prend un jmoisour donné par l'utilisateur afin de créer un objet de type Date
   * @param parAnnee prend une année donnée par l'utilisateur afin de créer un objet de type Date
   * 
   */
  
  public Date (int parJour, int parMois, int parAnnee)   {   
	jour = parJour;
	mois = parMois;
	annee = parAnnee; 
	GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
	jourSemaine = date.get (Calendar.DAY_OF_WEEK);		
	if (jourSemaine == 1)
		  jourSemaine = 7;
	else jourSemaine -= 1; 
  }
  
 
   
  /**
   * retourne 0 si this et parDate sont égales, 
   * -1 si this précède parDate,
   *  1 si parDate précède this
   */
  public int compareTo (Date parDate) {
    if (annee < parDate.annee)
		return -1;
	if (annee > parDate.annee)
		return 1;
	// les années sont =
	if (mois < parDate.mois)
		return -1;
	if (mois > parDate.mois)
		return 1;
	// les mois sont =
	if (jour < parDate.jour)
		return -1;
	if (jour > parDate.jour)
		return 1;
	return 0;	
  }
 
  /**
   * 
   * Méthode donnant le lendemain de la Date sélectionnée
   * 
   * @return retourne la Date du lendemain de la Date sélectionné
   * 
   */
  
  public Date dateDuLendemain ()   {	
    if (jour < dernierJourDuMois(mois,annee))
		     return  new Date (jour+1,mois,annee);
		else if (mois < 12)
				return new Date (1,mois+1,annee);
			 else return new Date (1,1,annee+1);	
  }  
  
  /**
   * 
   * Méthode donnant la veille de la Date sélectionnée
   * 
   * @return retourne la Date de la veille de la Date sélectionné
   * 
   */
  
  public Date dateDeLaVeille () {    
	if (jour > 1)
			return  new Date (jour-1,mois,annee);
	else if (mois > 1)
			   return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
		 else return  new Date (31,12,annee-1);
  }	 
  
  /**
   * 
   * Méthode donnant le dernier jour du mois sélectionné
   * 
   * @return retourne le dernier jour du mois sélectionné
   * 
   */
  
  public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
			 case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			 case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			 default : return 31 ;
			}  // switch
	  } 
	 
  /**
   * 
   * Méthode déterminant si l'année choisie est bissextile ou non
   * 
   * @return retourne si l'année est bissextile ou non
   * 
   */
  
  private static boolean estBissextile(int parAnnee) {
			return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	  }
    
  /**
   * 
   * Méthode permettant de transformer des jours donnés en int en une chaîne de caractères de type String
   * 
   * @return retourne un String
   * 
   */
  
  public String toString () {
    return  JOURS_SEMAINE [jourSemaine -1] + " " + jour + " " + MOIS [mois-1];	  
  }  

  /**
  * 
  * Méthode donnant l'année d'une Date
  *   
  * @return retourne l'année de la date donnée
  * 
  */
  
public int getAnnee() { 
	return annee;
}

/**
* 
* Méthode donnant le jour d'une Date
*   
* @return retourne le jour de la date donnée
* 
*/

public int getJour() { 
	return jour;
}

/**
* 
* Méthode donnant le mois d'une Date
*   
* @return retourne le mois de la date donnée
* 
*/

public int getMois() { 
	return mois;
}

/**
* 
* Méthode donnant le nom du jour donné
*   
* @return retourne le nom du jour donné dans un objet de type String
* 
*/

public int getJourSemaine () {
	return jourSemaine;
}

/**
* 
* Méthode permettant de savoir si une date donnée est égale à la date d'aujourd'hui
*   
* @return retourne la date si elle est égale à celle d'aujourd'hui
* 
*/

public boolean isToday() {
	return new Date().compareTo(this) == 0;
}
}  // class Date