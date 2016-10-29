public class AnalyseEntree {

	/**
	 * Determine si un nom de fichier correspond a une classe
	 * @param nom le nom du fichier
	 * @return True si c'est une classe, faux dans le cas contraire
	 */
	public boolean isClass(String nom) {
		return nom.contains(".class");
	}

	/**
	 * Determine si la classe est dans un paquetage
	 * @param nom le nom de la classe
	 * @return Vraie si la classe est dans un package, faux dans le cas contraire
	 */
	public boolean isInsidePackage(String nom) {
		return nom.contains("/");
	}

	/**
	 * Convertit les '/' en '.'
	 * @param nom le nom de fichier a traiter
	 * @return Un string traite comme decris
	 */
	public String slashToDot(String nom) {
		return nom.replace("/", ".");
	}

	/**
	 * Supprimer le ".class" contenu dans un string
	 * @param nom le nom de fichier a traiter
	 * @return Une string traite comme decris ci-dessus
	 */
	public String toClassName(String nom) {
        return nom.substring(0, nom.length()-".class".length());
	}
}