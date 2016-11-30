package ModuleLoader;

import Jeu.*;
import java.net.URL;
import java.util.*;
import java.util.jar.JarFile;

public class ListeIA implements IServer
{

	private List<Joueur> ia = new ArrayList<>();

	/**
	 * constructeur de la liste D'IA. Les IA sont cherchees a l'endroit indique en parametre
	 * @param chemin Le chemin ou le programme doit aller chercher les IA
	 */
	public ListeIA(String chemin) throws Exception {
		ListeFichier l = new ListeFichier(chemin);
		List<JarFile> listeJar = l.getJarFile();
        if (listeJar.isEmpty()) throw new Exception("[Erreur] aucun jar trouve");
		chargerDansClassLoader(l.toURLTab());
		construireJoueur(listeJar);
		enleverJoueurIdiot();
	}

	/**
	 * Construit la liste des Joueurs
	 * @param jar Le tableau de Jar contenant les IA
	 */
	public void construireJoueur(List<JarFile> jar)
	{
		for(JarFile j : jar)
		{
			Joueur joueur = new Joueur(j);
			ia.add(joueur);
		}
	}

	public void enleverJoueurIdiot(){
        ia.removeIf(joueur -> joueur.isJoueurIdiot());
	}

	/**
	 * Permet de charger les Jar dans le classLoader afin d'instancier les IA des joueurs
	 * @param url
	 */
	public void chargerDansClassLoader(URL[] url)
	{
		SingClassLoader.ajouterURL(url);
	}

	/**
	 *
	 * @param message
	 */
	public String jouerTour(int numJoueur, IEchange message)
	{
		String str = "";
        if(!ia.isEmpty())
		{
			str += ia.get(numJoueur).reagir(message);
		}
		return str;
	}

	@Override
	public List<Joueur> listeIA() {
        return this.ia;
	}

	@Override
	public Joueur obtenirIA(int i) {
        return ia.get(i);
	}
}