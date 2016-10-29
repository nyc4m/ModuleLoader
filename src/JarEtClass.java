
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class JarEtClass {

	/**
	 * Cet attribut permet de stocker les noms de classes en fonction d'un adresse de jar
	 */
	private HashMap<URL, ArrayList<String>> jarClass = new HashMap();

	public JarEtClass()
	{

	}

	/**
	 * Permet d'ajouter un nom de jar et d'instancier une nouvelle ArrayList (pour stocker les chemins de classe)
	 * @param nom Le nom du jar a ajouter (il sera convertit en URL)
	 */
	public void ajouterNomJar(String nom) {
        ToURL tourl = new ToURL();
		this.jarClass.put(tourl.toURL(nom), new ArrayList<String>());
	}

	/**
	 * Ajoute une nouvelle classe
	 * @param nomJar le nom du jar auquel il faut associer la classe
	 * @param nomClass le nom de la classe a ajouter
	 */
	public void ajouterNomClasse(String nomJar, String nomClass) {
        ToURL tourl = new ToURL();
		this.jarClass.get(tourl.toURL(nomJar)).add(nomClass);
	}

	/**
	 * Indique si la HashMap est vide
	 * @return Vrai si la hashmap est vide, faux dans le cas contraire
	 */
	public boolean estVide(){
		return this.jarClass.isEmpty();
	}

	/**
	 * Permet d'obtenir une liste d'URL
	 * @return Une liste d'URL correspondant aux Jar
	 */
	public URL[] urlJar(){
		return this.jarClass.keySet().toArray(new URL[this.jarClass.size()]);
	}

	/**
	 * Permet d'obtenir la liste de toutes les classes repertoriee
	 * @return Une Collection d'ArrayList contenant l'ensemble des classes
	 */
	public Collection<ArrayList<String>> getAllJarClasses()
	{
		return this.jarClass.values();
	}
}