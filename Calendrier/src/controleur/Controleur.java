package controleur;

/**
* 
* Voici la classe permettant de g�rer les boutons du calendrier.
* 
* @author Kenan HAMZIC
* @version 1.0
* 
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import modele.Agenda;
import modele.Date;
import modele.LectureEcriture;
import vue.BoutonDate;
import vue.PanelAgenda;
import vue.PanelCalendrier;
import vue.PanelFormulaire;
import modele.Evenement;

public class Controleur implements ActionListener {
	
	/**
	 * 
	 * Param�tres de la classe Controleur.
	 * 
	 * @param Param�tres n�cessaires afin de r�cup�rer les donn�es du venant du reste de la fen�tre.
	 * 
	 */
	
	Agenda agenda;
	PanelFormulaire panelFormulaire;
	PanelCalendrier panelCalendrier;
		
	public Controleur (Agenda parAgenda, PanelFormulaire parPanelFormulaire, PanelCalendrier parPanelCalendrier) {
		
		/**
		 * 
		 * Param�tres de la m�thode Controleur.
		 * 
		 * @param Param�tres n�cessaires afin de g�rer les boutons du calendrier affich� � l'�cran.
		 * 
		 */
		
		agenda = parAgenda;
		panelFormulaire = parPanelFormulaire;
		panelCalendrier = parPanelCalendrier;
		panelFormulaire.enregistreEcouteur(this);
		panelCalendrier.enregistreEcouteur(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getSource() instanceof BoutonDate){
			BoutonDate boutonClique = (BoutonDate) parEvt.getSource();
			panelFormulaire.setDate(boutonClique.getDate());
			System.out.println(boutonClique.getDate());
		} else {
			Evenement evt = panelFormulaire.getEvenement();
			agenda.ajout(evt);
			LectureEcriture.ecriture(new File("agendas" + File.separator + "agenda_liste_2021.ser"), agenda);
			panelFormulaire.reset();
			JOptionPane.showMessageDialog(null, agenda.toString());
		}
	}
}