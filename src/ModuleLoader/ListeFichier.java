package ModuleLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarFile;

public class ListeFichier
{

	private File[] liste;


	/**
	 * Permet d'obtenir une liste de fichiers en fonction d'un chemin
	 * @param chemin
	 */
	public ListeFichier(String chemin)
	{
		this.liste = new File(chemin).listFiles();
	}

	/**
	 * Renvoie une liste de Jar en fonction d'un tableau de fichiers
	 */
	public JarFile[] getJarFile()
	{
        Analyseur a = new Analyseur();
		JarFile[] listeJar = new JarFile[this.liste.length];
		for(int i = 0; i < this.liste.length; i++)
		{
			try {
				if(a.contient(liste[i].getName(), ".jar"))
				{
					listeJar[i] = new JarFile(liste[i]);
				}
			} catch (IOException e) {
				System.err.println("[Erreur] Le Jar n'est pas valide");
			}
		}

		return listeJar;
	}

	/**
	 * Retourne un tableau d'URL. Ces URL correspondents a des JAR
	 */
	public URL[] toURLTab()
	{
		URL[] tab = new URL[liste.length];
		for(int i = 0; i < liste.length; i++)
		{
			try {
				tab[i] = new URL("file:" + liste[i].getAbsolutePath());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		return tab;
	}

}