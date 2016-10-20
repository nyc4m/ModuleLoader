import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ParserListeJar {

	private ListeJar lsJar;
	private JarEtClass jarClass;
	/**
	 *
	 * @param liste
	 */
	public ParserListeJar(ListeJar liste) {
		this.lsJar = liste;
		this.jarClass = new JarEtClass() ;
	}



	/**
	 *
	 * @param nom
	 */
	public void ajouterJar(String nom) {
		this.jarClass.ajouterNomJar(nom);
	}

	/**
	 *
	 * @param nomJar
	 * @param nomClass
	 */
	public void ajouterClasse(String nomJar, String nomClass) {
		this.jarClass.ajouterNomClasse(nomJar, nomClass);
	}

	public boolean isAnalysed(){
		return !this.jarClass.estVide();
	}

	public JarEtClass getJarClass() {
		if(!isAnalysed())
		{
			this.analyser();
		}
		return this.jarClass;
	}

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