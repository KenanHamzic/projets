package modele;

/**
* 
* Voici la classe date qui peut stocker une Date afin de l'utiliser pour cr�er un �v�nement.
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
   * M�thode cr�ant une date en prenant plusieurs param�tres
   * 
   * @param parJour prend un jour donn� par l'utilisateur afin de cr�er un objet de type Date
   * @param parMois prend un jmoisour donn� par l'utilisateur afin de cr�er un objet de type Date
   * @param parAnnee prend une ann�e donn�e par l'utilisateur afin de cr�er un objet de type Date
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
   * retourne 0 si this et parDate sont �gales, 
   * -1 si this pr�c�de parDate,
   *  1 si parDate pr�c�de this
   */
  public int compareTo (Date parDate) {
    if (annee < parDate.annee)
		return -1;
	if (annee > parDate.annee)
		return 1;
	// les ann�es sont =
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
   * M�thode donnant le lendemain de la Date s�lectionn�e
   * 
   * @return retourne la Date du lendemain de la Date s�lectionn�
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
   * M�thode donnant la veille de la Date s�lectionn�e
   * 
   * @return retourne la Date de la veille de la Date s�lectionn�
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
   * M�thode donnant le dernier jour du mois s�lectionn�
   * 
   * @return retourne le dernier jour du mois s�lectionn�
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
   * M�thode d�terminant si l'ann�e choisie est bissextile ou non
   * 
   * @return retourne si l'ann�e est bissextile ou non
   * 
   */
  
  private static boolean estBissextile(int parAnnee) {
			return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	  }
    
  /**
   * 
   * M�thode permettant de transformer des jours donn�s en int en une cha�ne de caract�res de type String
   * 
   * @return retourne un String
   * 
   */
  
  public String toString () {
    return  JOURS_SEMAINE [jourSemaine -1] + " " + jour + " " + MOIS [mois-1];	  
  }  

  /**
  * 
  * M�thode donnant l'ann�e d'une Date
  *   
  * @return retourne l'ann�e de la date donn�e
  * 
  */
  
public int getAnnee() { 
	return annee;
}

/**
* 
* M�thode donnant le jour d'une Date
*   
* @return retourne le jour de la date donn�e
* 
*/

public int getJour() { 
	return jour;
}

/**
* 
* M�thode donnant le mois d'une Date
*   
* @return retourne le mois de la date donn�e
* 
*/

public int getMois() { 
	return mois;
}

/**
* 
* M�thode donnant le nom du jour donn�
*   
* @return retourne le nom du jour donn� dans un objet de type String
* 
*/

public int getJourSemaine () {
	return jourSemaine;
}

/**
* 
* M�thode permettant de savoir si une date donn�e est �gale � la date d'aujourd'hui
*   
* @return retourne la date si elle est �gale � celle d'aujourd'hui
* 
*/

public boolean isToday() {
	return new Date().compareTo(this) == 0;
}
}  // class Date