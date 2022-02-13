package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.Agenda;
import modele.CalendrierDuMois;
import modele.Date;
import modele.Evenement; 


public class PanelFormulaire extends JPanel implements ConstantesCouleursFontes, ConstantesCalendrier { 
    Agenda agenda;
	Date date;
	
	JLabel labelDate ;
	JButton boutonAjout = new JButton ("+");
	JTextField champTitre = new JTextField (4);
	JTextField champLieu = new JTextField (4);
	JComboBox <String> champDebutH = new JComboBox <String> (HEURES);

	JComboBox <String> champDebutMn = new JComboBox <String> (MINUTES);

	JComboBox <String> champFinH = new JComboBox <String> (HEURES);

	JComboBox <String> champFinMn = new JComboBox <String> (MINUTES);

	JTextArea champDescription = new JTextArea (8,8);
	
	/**
	 * 
	 * Méthode permettant de créer un formulaire
	 * 
	 * @param parAgenda prend en paramètre un agenda afin d'avoir un endroit où stocker les évènements qui vont être entrés
	 * 
	 */
	
	public PanelFormulaire ( Agenda parAgenda) {
		
	    agenda = parAgenda; 
		date = new Date();   
	 
		// à l'ouverture le formulaire de saisie contient la date courante
		labelDate = new JLabel (date.toString(), JLabel.LEFT);
		
		
		// Le gestionnaire de répartition
		setLayout (new GridBagLayout ());	
		GridBagConstraints contraintes = new GridBagConstraints ();
	  	contraintes.insets = new Insets (6,6,6,6); 
		contraintes.anchor = GridBagConstraints.WEST;
		
	
	 	JLabel labelTitre = new JLabel ("Titre", JLabel.LEFT);
		JLabel labelLieu = new JLabel ("Lieu", JLabel.LEFT);
		JLabel labelDebut = new JLabel ("Début", JLabel.LEFT);
		JLabel deuxPointsD = new JLabel (" : ");
		JLabel labelFin = new JLabel ("Fin", JLabel.LEFT);
		JLabel deuxPointsF = new JLabel (" : ");
		JLabel labelDescription = new JLabel ("Description", JLabel.LEFT);
		
	    // labelDate
		contraintes.gridy=0; contraintes.gridwidth = 4;	contraintes.gridx=0;
		this.add(labelDate, contraintes);
		
		// boutonAjout
		contraintes.gridwidth = 1;	contraintes.gridx=4;
		this.add(boutonAjout, contraintes);
		
		
		// labelTitre et champTitre
		contraintes.gridy++; 
		contraintes.gridx=0;
		this.add (labelTitre,contraintes); 
		contraintes.gridx++; contraintes.gridwidth =4 ; 
		contraintes.fill = GridBagConstraints.HORIZONTAL;		
		this.add (champTitre, contraintes); 
		contraintes.fill = GridBagConstraints.NONE;
		
		// // labelLieu et champLieu
		
		contraintes.gridy++; contraintes.gridx =0 ; contraintes.gridwidth = 1;
		this.add (labelLieu,contraintes);  
		contraintes.gridx++; contraintes.gridwidth = 4;
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		
		this.add (champLieu, contraintes); 
		contraintes.fill = GridBagConstraints.NONE;
		
		// éléments pour heure de début
		contraintes.gridy++; contraintes.gridx =0 ; contraintes.gridwidth = 1;
		this.add (labelDebut,contraintes);  contraintes.gridx++;
		this.add(champDebutH,contraintes);  contraintes.gridx++; 
		//contraintes.fill=GridBagConstraints.NONE;
		this.add (deuxPointsD,contraintes);  contraintes.gridx++;
		//contraintes.fill=GridBagConstraints.HORIZONTAL;
		this.add(champDebutMn,contraintes);
		
		// éléments pour heure de fin
		contraintes.gridy++; contraintes.gridx =0 ;
		this.add (labelFin,contraintes);  contraintes.gridx++;
		this.add(champFinH,contraintes);   contraintes.gridx++; 
		//contraintes.weightx = 0.1;
		this.add (deuxPointsF,contraintes);  contraintes.gridx++;
		this.add(champFinMn,contraintes);
		
		// labelDescription et champDescription
		contraintes.gridy++; contraintes.gridx =0 ;
		contraintes.anchor = GridBagConstraints.NORTHWEST;
		this.add (labelDescription,contraintes);
		contraintes.gridx++; contraintes.gridwidth = 4;
		contraintes.fill = GridBagConstraints.BOTH;
		this.add(new JScrollPane(champDescription),contraintes);
		
		// fontes, couleurs, aspect, accessibilité
		
		labelDate.setFont(FONT_14);
		
		boutonAjout.setFont (FONT_14); 
		boutonAjout.setBackground(MASTIC.darker());
		boutonAjout.setForeground(CREAM);
		boutonAjout.setFocusPainted(false);
	//	boutonAjout.setMnemonic('+');
		
		labelTitre.setFont(FONT_12);
		labelTitre.setDisplayedMnemonic('T');
		labelTitre.setLabelFor(champTitre);
		champTitre.setOpaque(false);
		
		labelLieu.setFont(FONT_12);
		labelLieu.setDisplayedMnemonic('L');
		labelLieu.setLabelFor(champLieu);		
		champLieu.setOpaque(false);
		
		labelDebut.setFont(FONT_12);
		labelDebut.setDisplayedMnemonic('D');
		labelDebut.setLabelFor(champDebutH);		
	
		champDebutH.setBackground(VANILLE); 	
		champDebutMn.setBackground(VANILLE);	
		champDebutH.setFont(FONT_11);
		champDebutMn.setFont(FONT_11);
		deuxPointsD.setFont(FONT_11);
		
		labelFin.setFont(FONT_12);
		labelFin.setDisplayedMnemonic('F');
		labelFin.setLabelFor(champFinH);		
	
		champFinH.setBackground(VANILLE);
		champFinMn.setBackground(VANILLE);
		champFinH.setFont(FONT_11);
		
		champFinMn.setFont(FONT_11);
		deuxPointsF.setFont(FONT_11);
		
		labelDescription.setFont(FONT_12);
		labelDescription.setDisplayedMnemonic('e');
		labelDescription.setLabelFor(champDescription);		
	
		champDescription.setBackground(VANILLE);
		setBackground(VANILLE );
	//	champTitre.hasFocus();
		reset (); 
	//.hasFocus();
		setPreferredSize(new Dimension (300,340));
	}

	/**
	 * 
	 * Méthode permettant de vider les cases du formulaire
	 * 
	 */
	
	public void reset () {
		
		 champTitre.setText(new String()); 
		 champLieu.setText(new String());
		 champDescription.setText(new String());
			
		// l'heure en cours est sélectionnée
		GregorianCalendar calendar = new GregorianCalendar();
		champDebutH.setSelectedIndex(calendar.get(GregorianCalendar.HOUR_OF_DAY));
		champFinH.setSelectedIndex(calendar.get(GregorianCalendar.HOUR_OF_DAY)+2);
		champDebutMn.setSelectedIndex(0);
		champFinMn.setSelectedIndex(0);
		
		// le focus est donné au premier champ de saisie
		champTitre.requestFocusInWindow ();
				
	}
	
	/**
	 * 
	 * Méthode permettant de changer la date affichée à l'écran
	 * 
	 * @param parDate prend en paramètre la date sélectionnée à l'appui d'un bouton
	 * 
	 */
	
	// quand on ajoute le calendrier (tp 5) 
	// la date du formulaire doit changer pour recevoir la date cliquée par l'utilisateur
	public void setDate (Date parDate) {
		date = parDate;
		//date = panelCalendrier.;
		labelDate.setText(date.toString());
	}

	/**
	 * 
	 * Méthode récupérant le contenu du champ où l'utilisateur rentre le titre de l'évènement
	 * 
	 * @return retourne le contenu du champ pour le titre de l'évènement
	 * 
	 */
	
	public JTextField getChampTitre() {
		return champTitre;
	}
 
	/**
	 * 
	 * Méthode permettant à l'utilisateur de gagner du temps en lui donnant la possibilité d'écrire directement dans une case
	 * 
	 */
	
	public void donneFocus() {
		champTitre.requestFocusInWindow();
		
	}
	
	/**
	 * 
	 * Méthode permettant de récupérer n évènement
	 * 
	 * @return retourne l'évènement choisi selon certains paramètres
	 * 
	 */
	
	public Evenement getEvenement(){
		Evenement evt = new Evenement (date, champTitre.getText(), champLieu.getText());
		return evt;
	}

	/**
	 * 
	 * Méthode permettant de mettre sous écoute les boutons du calendrier à leur création
	 * 
	 * @param controleur contrôleur qui écoutera les boutons
	 * 
	 */
	
	public void enregistreEcouteur(Controleur controleur) {
		boutonAjout.addActionListener(controleur);
	}
}