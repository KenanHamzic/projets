package vue;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JPanel;

import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.Agenda;
import modele.Date;
import modele.Evenement;
import modele.LectureEcriture;

public class PanelAgenda extends JPanel implements ConstantesCouleursFontes {
	PanelFormulaire panelFormulaire ;
	 
	 public PanelAgenda () {
	  
		setLayout(new FlowLayout(FlowLayout.CENTER,25, 25));
		
		 /*Agenda agenda = new Agenda (); 
		 agenda.ajout(new Evenement (new Date(),"TP IHM", "i21"));
		 agenda.ajout(new Evenement (new Date(12,5,2021),"CC IHM", "g25"));
		 agenda.ajout(new Evenement (new Date(12,5,2021),"CC IHM", "g26"));*/
		
		File sauvegardeAgendas = new File("agendas" + File.separator + "agenda_liste_2021.ser");
		
		Agenda agenda;
		
		if(sauvegardeAgendas.length() == 0){
			agenda = new Agenda (); 
		}
		else{
			agenda = (Agenda) LectureEcriture.lecture(sauvegardeAgendas);
		}
		
		System.out.println(agenda);
		
		panelFormulaire = new PanelFormulaire (agenda);
		
		PanelCalendrier panelCalendrier = new PanelCalendrier ();
				
		this.add (panelCalendrier);		
		this.add (panelFormulaire);
		
		Controleur controleur = new Controleur(agenda, panelFormulaire, panelCalendrier);
		
		
		
		setBackground(VANILLE);
	 }
	 
	 
	 
	public void donneFocus() {
		panelFormulaire.donneFocus();	
	}

	

}