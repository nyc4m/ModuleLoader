import java.net.URLClassLoader;
import java.util.ArrayList;
import  IAPackage.Parler;

public class ParserClasse {

	private JarEtClass jarClass;
	private URLClassLoader chargeur;
	private ArrayList<Parler> iaAInctancier = new ArrayList();

	public ArrayList<Parler> getListe() {
        if(this.iaAInctancier.isEmpty()){
			this.preparerIA();
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


	public void preparerIA(){
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
	}

}