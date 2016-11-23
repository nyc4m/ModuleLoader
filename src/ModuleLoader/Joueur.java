package ModuleLoader;

import Jeu.IEchange;
import Jeu.IIA;

import java.util.Collection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Joueur
{

	private IIA cerveau = null;

	/**
	 * Le constructeur du joueur. Le joueur s'initialise lui meme grace a un Jar contenant les classes de son IA
	 * @param jar Le Jar associe au joueur
	 */
	public Joueur(JarFile jar)
	{
		Enumeration<JarEntry> e = jar.entries();
        while(isJoueurIdiot() && e.hasMoreElements())
		{
			new traiterEntree(e.nextElement().getName(), this);
		}
	}

	/**
	 * Ajoute le Cerveau du Joueur pour qu'il puisse dialoguer avec le jeu. Le cerveau est une classe contenu dans son IA, celle aui implemente IIA
	 * @param cerveau
	 */
	public void ajouterCerveau(Class cerveau)
	{
		try {
			this.cerveau = (IIA)cerveau.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Indique si le joueur est idiot ou pas (s'il a un cerveau...)
	 */
	public boolean isJoueurIdiot()
	{
        return this.cerveau == null? true: false;
	}

	public String reagir(IEchange message)
	{
		return this.cerveau.jouerTour(message);
	}

}