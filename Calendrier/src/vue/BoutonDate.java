package vue;

import javax.swing.JButton;

import modele.Date;

public class BoutonDate extends JButton {

	private Date date;
	
	/**
	 * 
	 * Méthode permettant de créer un bouton prenant une date en paramètre
	 * 
	 * @param date date qui sera affichée dans le bouton
	 * 
	 */
	
	public BoutonDate(Date date) {
		super (Integer.toString(date.getJour()));
		this.date= date;
	}

	/**
	 * 
	 * Méthode permettant de récupérer la date contenue dans un bouton
	 * 
	 * @return retourne la date contenue dans le bouton choisi
	 * 
	 */
	
	public Date getDate() {		 
		return date;
	}

}
