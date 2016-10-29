import java.net.URLClassLoader;
import java.util.ArrayList;
import  IAPackage.Parler;

/**
 * Analyse L'ensemble des classes trouvee pour les instancier grace a l'interface imposee
 */
public class ParserClasse {

	/**
	 * La liste des jar et leurs classe associees
	 */
	private JarEtClass jarClass;
	/**
	 * Permet de "presenter" des nouvelles classes a la JVM (Cf la javadoc d'oracle pour plus d'info)
	 */
	private URLClassLoader chargeur;
	/**
	 * La liste finale contenant les ia pretes a l'emploie
	 */
	private ArrayList<Parler> iaAInctancier = new ArrayList();

	/**
	 * Permet d'obtenir la liste des ia
	 * @return Une liste d'IA prete a l'emploie
	 * @throws Exception Si une erreur est survenue lors du traitement
	 */
	public ArrayList<Parler> getListe() throws Exception {
		try {
			if (this.iaAInctancier.isEmpty()) {
				this.preparerIA();
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return this.iaAInctancier;
	}

	/**
	 * Constructeur de la classe
	 * @param jarClass La liste des jar associe a leurs classes
	 */
	public ParserClasse(JarEtClass jarClass) {
        this.jarClass = jarClass;
		this.chargeur = new URLClassLoader(this.jarClass.urlJar());
	}

	/**
	 * Permet de determiner si une class implemente l'interface imposee
	 * @param c la classe a analyser
	 * @return Vrai si la classe implemente ce au'il faut, faux dans le cas contraire
	 */
	public boolean hasInterface(Class c){
	 	boolean res = false;
        int i = 0;
		Class[] interfaces = c.getInterfaces();
		while(i < interfaces.length && res == false)
		{
			if(interfaces[i].getName().contains("Parler"))
			{
				res = true;
			}
			i++;
		}
		 return res;
	}


	/**
	 * Analyse toutes les classes, les charge dans le classloader, et instancie celles qui implemente l'interface imposee
	 * @throws Exception Si aucune classe n'implemente l'interface
	 */
	public void preparerIA() throws Exception {
        for(ArrayList<String> liste : this.jarClass.getAllJarClasses()) {
			for (String s : liste) {
				try {
					Class c = chargeur.loadClass(s);
					if (hasInterface(c)) {
						this.iaAInctancier.add((Parler)c.newInstance());
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}
		if(this.iaAInctancier.isEmpty()) throw new Exception("[Erreur] Pas de classe valide...");
	}

}