package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.CalendrierDuMois;
import modele.Date;

public class PanelMois extends JPanel implements ActionListener,ConstantesCalendrier, ConstantesCouleursFontes {

	BoutonDate boutonSelectionne ;	 	
	
	ArrayList <BoutonDate> listeBoutons = new ArrayList();
	
	/**
	 * 
	 * Méthode permettant d'afficher les boutons d'un mois (un bouton représente un jour)
	 * 
	 * @param mois prend un mois en paramètres afin de l'afficher avec des boutons
	 * 
	 */
	
	public PanelMois (int mois)  {
		Date today = new Date();
		 
		Collection <Date> datesDuMois = new CalendrierDuMois(mois,today.getAnnee()).getDates();
		//System.out.println(datesDuMois);		
		this.setLayout(new GridLayout (0,7,8,8));
		for (int i= 0; i < 7 ; i++) {
			JLabel labeljour = new  JLabel (JOURS_SEMAINE_ABR[i],JLabel.CENTER);
			this.add(labeljour);			
		}
		
		BoutonDate boutonJour;
		
		Iterator <Date> iterateur = datesDuMois.iterator();
		while (iterateur.hasNext()) {
				Date date = iterateur.next() ;
				boutonJour = new  BoutonDate (date);
				
				listeBoutons.add(boutonJour);
				
				boutonJour.addActionListener(this);  // gestion des couleurs des boutons 
				this.add(boutonJour);
				 
				boutonJour.setBackground (VANILLE);
				
			
				if (date.isToday()) {
					boutonJour.setBackground(VERT);
				}	
				if (date.getMois()!=mois)
					boutonJour.setForeground(BLEU);		
					
		}		
		
		setBackground (VANILLE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (boutonSelectionne != null && !boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(VANILLE);			
		}
		boutonSelectionne = (BoutonDate) evt.getSource();
		if (!boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(MASTIC);
			}		
	}
	
	/**
	 * 
	 * Méthode permettant de récupérer le bouton sélectionné
	 * 
	 * @return retourne le bouton qui a été sélectionné
	 * 
	 */
	
	public JButton getBoutonSelectionne () {
		return boutonSelectionne;	
	}

	/**
	 * 
	 * Méthode écoutant les boutons du calendrier afin de détecter un clique de l'utilisateur sur l'un d'eux
	 * 
	 * @param controleur prend en paramètre le contrôleur qui gère lorsqu'un bouton est appuyé
	 * 
	 */
	
	public void enregistreEcouteur(Controleur controleur) {
		for(BoutonDate bouton : listeBoutons){
			bouton.addActionListener(controleur);
			
		}
	}
}
