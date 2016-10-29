import java.net.URLClassLoader;
import java.util.ArrayList;
import  IAPackage.Parler;

public class ParserClasse {

	private JarEtClass jarClass;
	private URLClassLoader chargeur;
	private ArrayList<Parler> iaAInctancier = new ArrayList();

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
	 * 
	 * @param jarClass
	 */
	public ParserClasse(JarEtClass jarClass) {
        this.jarClass = jarClass;
		this.chargeur = new URLClassLoader(this.jarClass.urlJar());
	}

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