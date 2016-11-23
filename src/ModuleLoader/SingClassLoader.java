package ModuleLoader;

import java.net.URL;
import java.net.URLClassLoader;

public class SingClassLoader
{

	/**
	 * l'instance du singleton
	 */
	private static SingClassLoader instance = new SingClassLoader();
	/**
	 * Le classloader charge de contenir les classes des IA charge par le programme. C'est un URLClassLoader ce qui permet de charger des Jar grace a leur URL
	 */
	private static URLClassLoader chargeur;

	/**
	 * Ajoute les URL vers les jar contenant les IA
	 * @param url Les URL a ajouter
	 */
	public static void ajouterURL(URL[] url)
	{
        chargeur = new URLClassLoader(url);
	}

	/**
	 * Retourne l'instance du songleton
	 * @return L'instance du singleton
	 */
	public static SingClassLoader getInstance()
	{
		return instance;
	}

	/**
	 * Permet de charger une classe dans un objet Class
	 * @param name Le nom de la classe a charger
	 * @return La classe demandee en parametre
	 */
	public static Class chargerClass(String name) throws ClassNotFoundException {
        return chargeur.loadClass(name);
	}

	/**
	 * Le constructeur du singleton
	 */
	private SingClassLoader()
	{
	}

}