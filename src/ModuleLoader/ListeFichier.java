package ModuleLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarFile;

public class ListeFichier
{

	private JarFile[] liste;


	/**
	 * Permet d'obtenir une liste de fichiers en fonction d'un chemin
	 * @param chemin
	 */
	public ListeFichier(String chemin)
	{
		//Permet d'avancer dans le tableau
		int avancement = 0;
        File repertoire = new File(chemin);
        File[] fichiers = repertoire.listFiles();
		liste = new JarFile[nbJar(fichiers)];
		Analyseur analyseur = new Analyseur();
        for(File f : fichiers)
		{
			if(analyseur.contient(f.getName(), ".jar"))
			{
				try {
					liste[avancement] = new JarFile(f);
                    avancement++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Retourne le nombre de jar contenu dans un tableau de fichier
	 * @return un nombre de jar
	 */
	public int nbJar(File[] tab)
	{
		Analyseur a = new Analyseur();
		int nb = 0;
		for(File f : tab)
		{
			if(a.contient(f.getName(), ".jar"))
			{
				nb++;
			}
		}
		return nb;
	}

	/**
	 * Renvoie une liste de Jar en fonction d'un tableau de fichiers
	 */
	public JarFile[] getJarFile()
	{
		return this.liste;
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
				tab[i] = new URL("file:" + liste[i].getName());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		return tab;
	}

}