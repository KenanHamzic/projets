package modele;

/**
* 
* Voici la classe �v�nement qui peut �tre utilis�e afin de stokcer un nouvel �v�nement dans l'agenda.
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
  private static int nombreDobjets ; // les champs entiers sont initialis�s par d�faut � 0
				// on peut quand m�me faire l'initialisation ici avec la d�claration
  public Evenement (){ 
    	nombreDobjets ++;    
  }
  
  /**
   * 
   * M�thode permettant de cr�er un �v�nement avec un nom, une date et un lieu tous donn�s
   * 
   * @param parDate Date de l'�v�nement
   * @param parNom Nom de l'�v�nement
   * @param parLieu Lieu de l'�v�nement
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
   * M�thode permettant de r�cup�rer la date d'un �v�nement donn�
   * 
   * @return retourne la date d'un �v�nement
   * 
   */
  
  public Date getDate ()  {
    return date;
  }
  
  /**
   * 
   * M�thode permettant de r�cup�rer le nom d'un �v�nement donn�
   * 
   * @return retourne le nom de l'�v�nement
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
    * M�thode permettant de donner un lieu � un �v�nement
    * 
    */
   
  public void setLieu (String parLieu) {
   lieu = parLieu;
  }

  /**
   * 
   * M�thode permettant de comparer 2 �v�nements
   * 
   */
 
  public int compareTo (Evenement parEvt) {
  // retourne -1 si this pr�c�de parEvt, 1 si parEvt pr�c�de this
  // la comparaison est faite sur les dates puis sur le nom de l'�v�nement
    int precede = this.date.compareTo(parEvt.date);
	if (precede == 0)
		// les dates sont �gales on compare les noms des �v�nements par ordre alphab�tique
		 return  (this.nom+this.lieu).compareTo (parEvt.nom+parEvt.lieu);		
	else return precede;
  } 
  
  /**
   * 
   * M�thode permettant de transformer un �v�nement en une cha�ne de caract�res
   * 
   */
  
  public String toString () {
    return /*date + " - " +*/ nom + " - " + lieu ;
  }
} // classe Evenement