package vue;

import javax.swing.JButton;

import modele.Date;

public class BoutonDate extends JButton {

	private Date date;
	
	/**
	 * 
	 * M�thode permettant de cr�er un bouton prenant une date en param�tre
	 * 
	 * @param date date qui sera affich�e dans le bouton
	 * 
	 */
	
	public BoutonDate(Date date) {
		super (Integer.toString(date.getJour()));
		this.date= date;
	}

	/**
	 * 
	 * M�thode permettant de r�cup�rer la date contenue dans un bouton
	 * 
	 * @return retourne la date contenue dans le bouton choisi
	 * 
	 */
	
	public Date getDate() {		 
		return date;
	}

}
