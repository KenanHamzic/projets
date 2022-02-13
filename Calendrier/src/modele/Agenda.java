package modele;

/**
* 
* Voici la classe Agenda qui peut stocker des évènements.
* 
* @author Kenan HAMZIC
* @version 1.0
* 
*/

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;


public class Agenda implements Serializable {
  
  /**
   * 
   * Voici les paramètres crée en dehors des méthodes afin qu'ils puissent être utilisés par toutes les méthodes.
   * 
   * Paramètres utilisés dans les méthodes de la classe Agenda.
   * 
   */
  
  private ArrayList <Evenement> listeEvts ;
  private TreeSet <Evenement> arbreEvts;
  private HashMap <Integer, ArrayList <Evenement>> hashMapEvts;
  private TreeMap <Date, ArrayList <Evenement>> treeMapEvts;
   
  public Agenda () {
   
   listeEvts = new ArrayList <> ();
   arbreEvts = new TreeSet <> ();
   hashMapEvts = new  HashMap <>();
   treeMapEvts = new TreeMap <> ();
  }
  
  
  /**
   * 
   * Méthode permettant d'ajouter un évènement à un agenda.
   * 
   * @param parEvt récupère l'évènement rentré par l'utilisateur afin de l'ajouter à l'agenda.
   * 
   */
  
  public void ajout (Evenement parEvt) {   	
	
	// Ajout dans la ArrayList
	listeEvts.add (parEvt);
	// Ajout dans le TreeSet
	arbreEvts.add (parEvt);
	
	// Ajout dans la HashMap :
	// clef : le numero de semaine
	// valeur : les événements qui ont lieu cette semaine
	// nous servira en IHM pour afficher l'agenda semaine par semaine
	
	Date date = parEvt.getDate();
	GregorianCalendar calendar = new GregorianCalendar(date.getAnnee(),
											date.getMois()-1, date.getJour());
	int numeroDeSemaine = calendar.get(Calendar.WEEK_OF_YEAR);
	
	 
 	if (hashMapEvts.containsKey(numeroDeSemaine)) { 		
 		hashMapEvts.get(numeroDeSemaine).add (parEvt);	
		 }
	else {
		 ArrayList <Evenement> liste = new ArrayList <Evenement> ();
		 liste.add (parEvt);
		 getHashMapEvts().put (numeroDeSemaine, liste);		 
	}
  }  
  
  
  // parcours de la hashmap avec un iterateur sur l'ensemble des clefs
  
  /**
   * Méthode permettant de transformer des données en une chaîne de caractères de type String
   * 
   * @return retourne une chaîne de type String
   * 
   */
  
  @Override
  public String toString () {
    String chaine =  "\n" + listeEvts + "\n" + arbreEvts + "\n\n" ;
	
	Set <Integer> clefs = getHashMapEvts().keySet ();
	Iterator <Integer> iterateur =clefs.iterator(); 
	while (iterateur.hasNext()) {
		 Integer clef = iterateur.next();
		 ArrayList <Evenement> liste = getHashMapEvts().get(clef);
		 chaine += clef + " : " + liste + "\n";
		 }
	return chaine;
	
	
  }
   
  
  
   
  
  
   
  /**
  * 
  * retourne le nombre d'événements de l'agenda qui ont lieu à la date parDate
  * 
  * @param parDate prend en paramètre une date donnée par l'utilisateur
  * 
  * @return retourne le ombre d'évènements ayant la date donnée en paramètres
  * 
  **/
  
  public int compteNbEvt (Date parDate)
  { int nbEvt = 0;
    Iterator <Evenement> iterateur = arbreEvts.iterator();
	while (iterateur.hasNext()) {
		 Evenement evt = iterateur.next();
		 if (evt.getDate().compareTo (parDate) == 0)
					nbEvt++;
		}  // while	
	return nbEvt;
  } // compteNbEvt
  
  /**
  * retourne le nombre d'événements de l'agenda dont le titre contient la chaîne de caracatères parString
  * 
  * @param parString prend une chaîne de caractères donnée par l'utilisateur
  * 
  * @return retourne le nombre d'évènements ayant la chaîne de caractères donnée dans leur nom
  * 
  **/
  
  public int compteNbEvt (String parString) {
    int nbEvt = 0;
    for (Evenement evt : listeEvts) {
		if (evt.getNom().contains (parString)) {
					nbEvt++;         
		}
	}	 	
	return nbEvt;
  } // compteNbEvt
  
   // à tester
  public void triFusion (){
	 // listeEvts =
			  triFusion (listeEvts, 0,listeEvts.size());
			  
  }
  
  public ArrayList <Evenement>  triFusion (ArrayList <Evenement>  list, int indiceDebut, int longueur) {
	if (longueur == 1){
		  
		 ArrayList <Evenement> arrayList =new ArrayList <Evenement> ();
		 arrayList.add(list.get(indiceDebut));
		 return arrayList;
		
	}
	else 
			return fusion (triFusion(list,indiceDebut ,longueur/2),
			        triFusion (list, indiceDebut + longueur/2, longueur-longueur/2)
					);
				
		 
  }
  
  public ArrayList <Evenement> fusion (ArrayList <Evenement> liste1, ArrayList <Evenement> liste2){
  	if (liste1.isEmpty()) {
               return liste2;
	}
    if (liste2.isEmpty()) {
               return liste1;
	}
	ArrayList <Evenement> arrayList =new ArrayList <Evenement> (); 
	Evenement premierDeListe1 = liste1.get(0);
	Evenement premierDeListe2 = liste2.get(0);
    if (premierDeListe1.compareTo(premierDeListe2) <= 0) {
			liste1.remove(0);			
            arrayList = fusion(liste1,liste2);
			arrayList.add(0,premierDeListe1);
			
	}
	else {  liste2.remove(0);
            arrayList = fusion(liste1,liste2);
			arrayList.add(0,premierDeListe2);
			
			}
	return arrayList;		  
    }

public HashMap <Integer, ArrayList <Evenement>> getHashMapEvts() {
	return hashMapEvts;
}

public void setHashMapEvts(HashMap <Integer, ArrayList <Evenement>> hashMapEvts) {
	this.hashMapEvts = hashMapEvts;
}

public Collection <Evenement>getEvenements() { 
	return arbreEvts;
}

public Collection <Evenement> getEvenementsSemaine (int numSemaine) {
	return hashMapEvts.get(numSemaine);
}

public Collection <Evenement> getEvenementsSemaine (Date date){
	GregorianCalendar calendar = new GregorianCalendar(date.getAnnee(),
			 date.getMois()-1, date.getJour());
	int numSemaine = calendar.get(Calendar.WEEK_OF_YEAR);
	return hashMapEvts.get(numSemaine);
}
}