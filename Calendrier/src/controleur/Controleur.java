package controleur;

/**
* 
* Voici la classe permettant de gérer les boutons du calendrier.
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
	 * Paramètres de la classe Controleur.
	 * 
	 * @param Paramètres nécessaires afin de récupérer les données du venant du reste de la fenêtre.
	 * 
	 */
	
	Agenda agenda;
	PanelFormulaire panelFormulaire;
	PanelCalendrier panelCalendrier;
		
	public Controleur (Agenda parAgenda, PanelFormulaire parPanelFormulaire, PanelCalendrier parPanelCalendrier) {
		
		/**
		 * 
		 * Paramètres de la méthode Controleur.
		 * 
		 * @param Paramètres nécessaires afin de gérer les boutons du calendrier affiché à l'écran.
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