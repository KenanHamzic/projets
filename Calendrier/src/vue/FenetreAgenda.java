package vue;

import javax.swing.JFrame ;

import constantes.ConstantesCouleursFontes;
import modele.Date;
import java.awt.Insets;


public class FenetreAgenda extends JFrame implements ConstantesCouleursFontes { 
	
	int xFenetre = 1280;
	int yFenetre = 720;
	
	public FenetreAgenda (String parTitre) {
	    super (parTitre); 
	    PanelAgenda contentPane  = new PanelAgenda ();
		
		setContentPane (contentPane);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		/*setVisible(true);*/
		
		/*** accessibilité : 
		 	* à l'ouverture du formulaire le focus est donné au premier champ de saisie
	 		* instruction à placer après setVisible(true);  
		*/
		contentPane.donneFocus(); 
		
		/*setLocation(80,50);*/
		setSize(xFenetre,yFenetre); setVisible(true); setLocation((1920-xFenetre)/2,(1080-yFenetre)/2);
		
		setBackground (MASTIC);
		
	} 
	 	
	public static void main (String  [] args) {
	 	new FenetreAgenda ("Agenda " + Integer.toString(new Date().getAnnee()));
		
	}  

	public Insets getInsets() {
		return new Insets(60,20,20,20);
	}
} 