
import java.net.URL;
import java.util.ArrayList;

public class JarEtClass {

	/**
	 * Cet attribut permet de stocker les noms de classes en fonction d'un adresse de jar
	 */
	private ArrayList<URL> jarUrl = new ArrayList<>();
	private ArrayList<String> className = new ArrayList<>();

	public JarEtClass()
	{

	}

	/**
	 * Permet d'ajouter un nom de jar et d'instancier une nouvelle ArrayList (pour stocker les chemins de classe)
	 * @param nom Le nom du jar a ajouter (il sera convertit en URL)
	 */
	public void ajouterNomJar(String nom) {
        ToURL tourl = new ToURL();
		this.jarUrl.add(tourl.toURL(nom));
	}

	/**
	 * Ajoute une nouvelle classe
	 * @param nomClass le nom de la classe a ajouter
	 */
	public void ajouterNomClasse(String nomClass) {
		this.className.add(nomClass);
	}


	/**
	 * Permet d'obtenir une liste d'URL
	 * @return Une liste d'URL correspondant aux Jar
	 */
	public URL[] urlJar(){
        URL[] tab = new URL[0];
        tab = this.jarUrl.toArray(tab);
	}

	/**
	 * Permet d'obtenir la liste de toutes les classes repertoriee
	 * @return Une Collection d'ArrayList contenant l'ensemble des classes
	 */
	public ArrayList<String> getClassNames()
	{
		return this.className;
	}
}