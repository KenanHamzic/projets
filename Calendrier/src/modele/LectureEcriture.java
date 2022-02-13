package modele;

/**
* 
* Voici la classe permettant de lire et écrire le fichier texte contenant l'agfenda afin de ne pas perdre ses évènements.
* 
* @author Kenan HAMZIC
* @version 1.0
* 
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;

public class LectureEcriture {
	
	/**
	 * Méthode de lecture d’un fichier
	 * @param parFichier : le fichier lu
	 * @return l’objet lu
	 */
	
	public static Object lecture (File parFichier) {
			ObjectInputStream flux ;
			Object objetLu = null;
			
			// Ouverture du fichier en mode lecture
			try {
				flux = new ObjectInputStream(new FileInputStream (parFichier));
				objetLu = (Object)flux.readObject ();
				flux.close ();
			}
			
			catch (ClassNotFoundException parException) {
				System.err.println (parException.toString ());
				System.exit (1);
			}
			
			catch (IOException parException) {
				System.err.println ("Erreur lecture du fichier " + parException.toString ());
				System.exit (1);
			}
			
			return objetLu ;
	}
	
	/* Méthode d’écriture dans un fichier
	 * @param parFichier : le fichier dans lequel on écrit
	 * @param parObjet : l’objet écrit dans le fichier
	 */
	
	public static void ecriture (File parFichier, Object parObjet) {
		ObjectOutputStream flux = null;
		// Ouverture du fichier en mode écriture
		try {
			flux = new ObjectOutputStream (new FileOutputStream (parFichier));
			flux.writeObject (parObjet);
			flux.flush ();
			flux.close ();
		}

		catch (IOException parException) {
			System.err.println ("Probleme a l’ecriture\n" + parException.toString ());
			System.exit (1);
		}
	}

}