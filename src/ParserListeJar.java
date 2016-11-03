import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Classe permetant de recuperer la liste des classe contenues dans les jar charges
 */
public class ParserListeJar {

	/**
	 * Une liste de Jar
	 */
	private ListeJar lsJar;
	/**
	 * Une liste associant des Url de jar et des nom de classe
	 */
	private JarEtClass jarClass;
	/**
	 * Constructeur de la classe
	 * @param liste La liste de jar a traiter
	 */
	public ParserListeJar(ListeJar liste) {
		this.lsJar = liste;
		this.jarClass = new JarEtClass() ;
        this.analyser();
	}


	/**
	 * Permet d'ajouter un nom de Jar
	 * @param nom Le nom du jar a ajouter
	 */
	public void ajouterJar(String nom) {
		this.jarClass.ajouterNomJar(nom);
	}

	/**
	 * Permet d'ajouter un nom de classe en fonction d'un nom de Jar
	 * @param nomJar Le nom du Jar
	 * @param nomClass le nom de la class
	 */
	public void ajouterClasse(String nomJar, String nomClass) {
		this.jarClass.ajouterNomClasse(nomClass);
	}


	/**
	 * Renvoie la liste des jar associe a leurs classes
	 * @return un JarEtClass
	 */
	public JarEtClass getJarClass() {
		return this.jarClass;
	}

	/**
	 * Permet de recuperer l'ensemble des classes de tous les jar charges
	 */
	public void analyser() {
		AnalyseEntree a = new AnalyseEntree();
		ToURL url = new ToURL();
		for(JarFile j : this.lsJar.getListe())
		{
			this.ajouterJar(j.getName());
			Enumeration<JarEntry> entree = j.entries();
			while(entree.hasMoreElements())
			{
				JarEntry courant = entree.nextElement();
				String nomCourant = courant.getName();
				if(a.isClass(nomCourant))
				{
					if(a.isInsidePackage(nomCourant))
					{
						nomCourant = a.slashToDot(nomCourant);
					}
					nomCourant = a.toClassName(nomCourant);
					this.ajouterClasse(j.getName(), nomCourant);
				}
			}
		}
	}

}