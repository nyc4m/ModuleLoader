public class AnalyseEntree {

	/**
	 * 
	 * @param nom
	 */
	public boolean isClass(String nom) {
		return nom.contains(".class");
	}

	/**
	 * 
	 * @param nom
	 */
	public boolean isInsidePackage(String nom) {
		return nom.contains("/");
	}

	/**
	 * 
	 * @param nom
	 */
	public String slashToDot(String nom) {
		return nom.replace("/", ".");
	}

	public String toClassName(String nom) {
        return nom.substring(0, nom.length()-".class".length());
	}
}