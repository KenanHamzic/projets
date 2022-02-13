package constantes;

/**
* 
* Voici la classe permettant de stocker les différentes informations telles que le nom de sjours, les heures, etc... pour le projet.
* 
* @author Kenan HAMZIC
* @version 1.0
* 
*/

import java.awt.Color;

public interface ConstantesCalendrier {
	
	/**
	 * 
	 * Paramètres de la classe ConstantesCalendrier.
	 * 
	 * @param Paramètres nécessaires afin d'afficher le nom des jours de la semaine, le nom des mois, etc... .
	 * 
	 */
	
	final String [] JOURS_SEMAINE = {"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"} ; 
	
	final String [] JOURS_SEMAINE_ABR = {"lu","ma","me","je","ve","sa","di"} ;  
	
	final  String [] MOIS = {"janvier", "février","mars","avril","mai","juin","juillet", "août","septembre","octobre","novembre","décembre"};
	
	final String INTIT_PREMIER = "<<";
	final String INTIT_PRECEDENT = "<";
	final String INTIT_SUIVANT = ">";
	final String INTIT_DERNIER = ">>";
	final  String [] INTITULES_BOUTONS = {INTIT_PREMIER,INTIT_PRECEDENT, INTIT_SUIVANT, INTIT_DERNIER};
	
	final String INTITULE_BOUTON_AJOUT ="+";
	
	public final  String [] HEURES = {"00", "01", "02", "03", "04", "05", "06",
		"07", "08", "09", "10", "11", "12", "13",
		"14", "15", "16", "17", "18", "19", "20",
		"21", "22", "23"};
	public final  String [] MINUTES = {"00", "15", "30", "45"};
	
	 
	
}
