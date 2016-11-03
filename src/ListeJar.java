
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarFile;

public class ListeJar {

    ArrayList<JarFile> jar = new ArrayList<JarFile>();

	/**
	 * Constructeur de la liste de jar
	 * @param cheminDossier le dossier a traiter
	 * @throws Exception Si aucun jar n'est trouve
	 */
	public ListeJar(String cheminDossier) throws Exception {
        File f = new File(cheminDossier);
		for(File i : f.listFiles())
		{
			if(isJar(i.getName()))
			{
				try {
					this.jar.add(new JarFile(i));
				} catch (IOException e) {
					System.err.println("[Erreur] " + i.getName() + " n'a pas pu etre ajoute...");
				}
			}
		}
		assert !jar.isEmpty();
		if(jar.isEmpty()) throw new Exception("[ERREUR] Aucun jar...");
	}

	/**
	 * Indique si le fichier passe en parametre est un Jar
	 * @param nom Le nom du fichier a traiter
	 * @return Vrai si c'est un jar, faux dans le cas contraire
	 */
	public boolean isJar(String nom) {
        return nom.contains(".jar");
	}

	/**
	 * Permet d'obtenir la liste des jar
	 * @return Retourne une ArrayList de JarFile
	 */
	public ArrayList<JarFile> getListe() {
		return this.jar;
	}


}