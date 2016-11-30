package ModuleLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipException;

public class ListeFichier
{

	private List<JarFile> liste = new ArrayList<>();


	/**
	 * Permet d'obtenir une liste de fichiers en fonction d'un chemin
	 * @param chemin
	 */
	public ListeFichier(String chemin)
	{
		//Permet d'avancer dans le tableau
		File repertoire = new File(chemin);
		File[] fichiers = repertoire.listFiles();
		Analyseur analyseur = new Analyseur();
		for(File f : fichiers)
		{
			if(analyseur.contient(f.getName(), ".jar"))
			{
				try {
					liste.add(new JarFile(f));
				} catch(ZipException zip)
				{
					System.err.println("[Attention] "+f.getName()+" est un jar vide");
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
	public List<JarFile> getJarFile()
	{
		return this.liste;
	}

	/**
	 * Retourne un tableau d'URL. Ces URL correspondents a des JAR
	 */
	public URL[] toURLTab()
	{
		URL[] tab = new URL[liste.size()];
		for(int i = 0; i < liste.size(); i++)
		{
			try {
				tab[i] = new URL("file:" + liste.get(i).getName());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		return tab;
	}

}