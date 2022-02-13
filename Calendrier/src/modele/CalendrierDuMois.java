package modele;

/**
* 
* Voici la classe CalendrierDuMois qui permet de générer le calendrier du mois choisi afin de l'afficher.
* 
* @author Kenan HAMZIC
* @version 1.0
* 
*/

import java.util.TreeSet;
import java.util.Collection;

public class CalendrierDuMois {	
  
  private Collection <Date> treeSetDate;	  
  
  /**
   * 
   * Méthode créeant le calendrier du mois sélectionné
   * 
   * @param mois prend en paramètre le mois sélectionné par l'utilisateur
   * @param annee prend en paramètre l'année sélectionné par l'utilisateur
   * 
   */
  
  public CalendrierDuMois ( int mois, int annee) {			   
	    treeSetDate = new TreeSet <Date> ();
	    Date date = new Date (1,mois,annee);
	    int indiceJour = date.getJourSemaine() ;
	    for (int x = indiceJour ; x!=0 ; x--) {	    	 
	    	treeSetDate.add(date);	    	
	    	date = date.dateDeLaVeille();
	    }	    
	    date = new Date (2,mois,annee);
	    indiceJour = indiceJour % 7 ;
	    while (date.getMois () == mois) {
	      while(indiceJour<7) {
	    	treeSetDate.add(date);
	    	date = date.dateDuLendemain();
	    	indiceJour++ ;
	      } 
	      indiceJour=0;
	    }    
	  }
  
public Collection <Date> getDates() {	
	return treeSetDate;	
}	

public String toString () {
	return treeSetDate.toString();
}
    
}