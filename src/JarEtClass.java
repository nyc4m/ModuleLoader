
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class JarEtClass {

	private HashMap<URL, ArrayList<String>> jarClass = new HashMap();

	/**
	 * 
	 * @param nom
	 */
	public void ajouterNomJar(String nom) {
        ToURL tourl = new ToURL();
		this.jarClass.put(tourl.toURL(nom), new ArrayList<String>());
	}

	/**
	 * 
	 * @param nomJar
	 * @param nomClass
	 */
	public void ajouterNomClasse(String nomJar, String nomClass) {
		this.jarClass.get(nomJar).add(nomClass);
	}

	public boolean estVide(){
		return this.jarClass.isEmpty();
	}
	public URL[] urlJar(){
		return this.jarClass.keySet().toArray(new URL[this.jarClass.size()]);
	}

	public Collection<ArrayList<String>> getAllJarClasses()
	{
		return this.jarClass.values();
	}
}