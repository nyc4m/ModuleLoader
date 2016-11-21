package ModuleLoader;

import java.util.jar.JarFile;

public class Joueur
{

	private Class cerveau;

	/**
	 * Le constructeur du joueur. Le joueur s'initialise lui meme grace a un Jar contenant les classes de son IA
	 * @param jar Le Jar associe au joueur
	 */
	public Joueur(JarFile jar)
	{
		// TODO - implement Joueur.Joueur
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajoute le Cerveau du Joueur pour qu'il puisse dialoguer avec le jeu. Le cerveau est une classe contenu dans son IA, celle aui implemente IIA
	 * @param cerveau
	 */
	public void ajouterCerveau(Class cerveau)
	{
		// TODO - implement Joueur.ajouterCerveau
		throw new UnsupportedOperationException();
	}

	/**
	 * Indique si le joueur est idiot ou pas (s'il a un cerveau...)
	 */
	public boolean isJoueurIdiot()
	{
		// TODO - implement Joueur.isJoueurIdiot
		throw new UnsupportedOperationException();
	}

}