
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarFile;

public class ListeJar {

    ArrayList<JarFile> jar = new ArrayList<JarFile>();

	/**
	 * 
	 * @param cheminDossier
	 */
	public ListeJar(String cheminDossier) {
        File f = new File(cheminDossier);
		for(File i : f.listFiles())
		{
			if(isJar(i.getName()))
			{
				try {
					this.jar.add(new JarFile(i));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		assert !jar.isEmpty();
	}

	/**
	 * 
	 * @param nom
	 */
	public boolean isJar(String nom) {
        return nom.contains(".jar");
	}

	public ArrayList<JarFile> getListe() {
		return this.jar;
	}


}