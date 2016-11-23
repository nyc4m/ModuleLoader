package ModuleLoader;

import Jeu.*;

import java.net.URL;
import java.util.*;
import java.util.jar.JarFile;

public class ListeIA implements ICommuniquer
{

	private ArrayList<Joueur> ia = new ArrayList<>();

	/**
	 * constructeur de la liste D'IA. Les IA sont cherchees a l'endroit indique en parametre
	 * @param chemin Le chemin ou le programme doit aller chercher les IA
	 */
	public ListeIA(String chemin)
	{
        ListeFichier l = new ListeFichier(chemin);
        JarFile[] tab = l.getJarFile();
        chargerDansClassLoader(l.toURLTab());
		construireJoueur(tab);
	}

	/**
	 * Construit la liste des Joueurs
	 * @param jar Le tableau de Jar contenant les IA
	 */
	public void construireJoueur(JarFile[] jar)
	{
		for(JarFile j : jar)
		{
            Joueur joueur = new Joueur(j);
			ia.add(joueur);
		}
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
        return ia.get(numJoueur).reagir(message);
	}

}