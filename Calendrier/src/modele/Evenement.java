package modele;

/**
* 
* Voici la classe évènement qui peut être utilisée afin de stokcer un nouvel évènement dans l'agenda.
* 
* @author Kenan HAMZIC
* @version 1.0
* 
*/

import java.io.Serializable;

public class Evenement implements Comparable <Evenement>,Serializable {
  private Date date;
  private String nom;
  private String lieu;
  private static int nombreDobjets ; // les champs entiers sont initialisés par défaut à 0
				// on peut quand même faire l'initialisation ici avec la déclaration
  public Evenement (){ 
    	nombreDobjets ++;    
  }
  
  /**
   * 
   * Méthode permettant de créer un évènement avec un nom, une date et un lieu tous donnés
   * 
   * @param parDate Date de l'évènement
   * @param parNom Nom de l'évènement
   * @param parLieu Lieu de l'évènement
   * 
   */
  
  public Evenement (Date parDate, String parNom , String parLieu) {
    date = parDate;
	nom = parNom;
	lieu = parLieu ;
	nombreDobjets ++;     
  }
  
  
  
  // 3) Accesseurs et modifieurs
  
  /**
   * 
   * Méthode permettant de récupérer la date d'un évènement donné
   * 
   * @return retourne la date d'un évènement
   * 
   */
  
  public Date getDate ()  {
    return date;
  }
  
  /**
   * 
   * Méthode permettant de récupérer le nom d'un évènement donné
   * 
   * @return retourne le nom de l'évènement
   * 
   */
  
  public String getNom () {
	  return nom;
  }
  
   public static int getNombreDobjets () { // accesseur sur un champ static
   return nombreDobjets;
  }
  
   /**
    * 
    * Méthode permettant de donner un lieu à un évènement
    * 
    */
   
  public void setLieu (String parLieu) {
   lieu = parLieu;
  }

  /**
   * 
   * Méthode permettant de comparer 2 évènements
   * 
   */
 
  public int compareTo (Evenement parEvt) {
  // retourne -1 si this précède parEvt, 1 si parEvt précède this
  // la comparaison est faite sur les dates puis sur le nom de l'événement
    int precede = this.date.compareTo(parEvt.date);
	if (precede == 0)
		// les dates sont égales on compare les noms des événements par ordre alphabétique
		 return  (this.nom+this.lieu).compareTo (parEvt.nom+parEvt.lieu);		
	else return precede;
  } 
  
  /**
   * 
   * Méthode permettant de transformer un évènement en une chaîne de caractères
   * 
   */
  
  public String toString () {
    return /*date + " - " +*/ nom + " - " + lieu ;
  }
} // classe Evenement