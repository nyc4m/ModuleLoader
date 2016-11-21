package ModuleLoader;

import Jeu.*;
import java.util.*;

public class ListeIA implements ICommuniquer
{

	private ArrayList<Joueur> ia;

	/**
	 * constructeur de la liste D'IA. Les IA sont cherchees a l'endroit indique en parametre
	 * @param chemin Le chemin ou le programme doit aller chercher les IA
	 */
	public ListeIA(String chemin)
	{
		// TODO - implement ListeIA.ListeIA
		throw new UnsupportedOperationException();
	}

	/**
	 * Construit la liste des Joueur
	 * @param jar Le tableau de Jar contenant les IA
	 */
	public void construireJoueur(JarFile[] jar)
	{
		// TODO - implement ListeIA.construireJoueur
		throw new UnsupportedOperationException();
	}

	/**
	 * Permet de charger les Jar dans le classLoader afin d'instancier les IA des joueurs
	 * @param url
	 */
	public void chargerDansClassLoader(URL[] url)
	{
		// TODO - implement ListeIA.chargerDansClassLoader
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param message
	 */
	public String jouerTour(IEchange message)
	{
		// TODO - implement ListeIA.jouerTour
		throw new UnsupportedOperationException();
	}

}