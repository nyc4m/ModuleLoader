package ModuleLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarFile;

public class ListeFichier
{

    private File[] liste;
	/**
	 * Permet d'obtenir une liste de fichiers en fonction d'un chemin
	 * @param chemin
	 */
	public void listeFichier(String chemin)
	{
        this.liste = new File(chemin).listFiles();
	}

	/**
	 * Renvoie une liste de Jar en fonction d'un tableau de fichiers
	 */
	public JarFile[] getJarFIle()
	{
        JarFile[] listeJar = new JarFile[this.liste.length];
		for(int i = 0; i < this.liste.length; i++)
		{
			try {
				listeJar[i] = new JarFile(liste[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return listeJar;
	}

	/**
	 * Retourne un tableau d'URL. Ces URL correspondents a des JAR
	 */
	public URL[] toURLTab()
	{
		// TODO - implement ListeFichier.toURLTab
		throw new UnsupportedOperationException();
	}

}