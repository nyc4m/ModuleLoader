package ModuleLoader;

public class traiterEntree
{

	private Joueur joueur;

	/**
	 * Convertie un nom de class provenant d'un Jar en nom de class interpretable par le classloader
	 * @param nom Le nom a traiter
	 */
	public String toClassName(String nom)
	{
		// TODO - implement traiterEntree.toClassName
		throw new UnsupportedOperationException();
	}

	/**
	 * Indique la chaine en entree est un fichier contenant l'extention ".class".
	 * @param nom Le nom a tester
	 */
	public boolean isClass(String nom)
	{
		// TODO - implement traiterEntree.isClass
		throw new UnsupportedOperationException();
	}

	/**
	 * Indique si le fichier teste est dans un package
	 * @param nom le nom a tester
	 */
	public boolean isInsidePackage(String nom)
	{
		// TODO - implement traiterEntree.isInsidePackage
		throw new UnsupportedOperationException();
	}

	/**
	 * Convertie tous les '/' d'une chaine en '.'.
	 * @param nom La chaine a convertir
	 * @return La chaine traitee
	 */
	public String slashToDot(String nom)
	{
		// TODO - implement traiterEntree.slashToDot
		throw new UnsupportedOperationException();
	}

	/**
	 * Teste un nom de classe et determine si elle implemente la l'interface permettant de dialoguer avec le jeu.
	 * @param nom La classe a tester
	 * @return Vrai si la classe ets le cerveau, faux sinon
	 */
	public boolean isCerveau(String nom)
	{
		// TODO - implement traiterEntree.isCerveau
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructeur de la classe
	 * @param nom
	 */
	public traiterEntree(String nom)
	{
		// TODO - implement traiterEntree.traiterEntree
		throw new UnsupportedOperationException();
	}

	/**
	 * Fonction traitant une entree de Jar pour determiner dans un premier temps si elle est une classe, puis dans un second temps determiner si elle est un cerveau de joueur (une classe implementant IIA). Dans le cas ou l'entree est un cerveau de Joueur, le joueur se voit octroyer la possibiliter de dialoguer (intelligement ?) avec le jeu
	 * @param nom
	 */
	public void traitementClass(String nom)
	{
		// TODO - implement traiterEntree.traitementClass
		throw new UnsupportedOperationException();
	}

}