package ModuleLoader;

public class SingClassLoader
{

	/**
	 * l'instance du singleton
	 */
	private static SingClassLoader instance;
	/**
	 * Le classloader charge de contenir les classes des IA charge par le programme. C'est un URLClassLoader ce qui permet de charger des Jar grace a leur URL
	 */
	private static URLClassLoader chargeur = ModuleLoader.SingClassLoader.SingClassLoader();

	/**
	 * Ajoute les URL vers les jar contenant les IA
	 * @param url Les URL a ajouter
	 */
	public static void ajouterURL(URL[] url)
	{
		// TODO - implement SingClassLoader.ajouterURL
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne l'instance du songleton
	 * @return L'instance du singleton
	 */
	public static SingClassLoader getInstance()
	{
		return this.instance;
	}

	/**
	 * Permet de charger une classe dans un objet Class
	 * @param name Le nom de la classe a charger
	 * @return La classe demandee en parametre
	 */
	public static Class chargerClass(String name)
	{
		// TODO - implement SingClassLoader.chargerClass
		throw new UnsupportedOperationException();
	}

	/**
	 * Le constructeur du singleton
	 */
	private SingClassLoader()
	{
		// TODO - implement SingClassLoader.SingClassLoader
		throw new UnsupportedOperationException();
	}

}