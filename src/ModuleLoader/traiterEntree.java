package ModuleLoader;

import Jeu.IIA;

public class traiterEntree
{

	private Joueur joueur;

	/**
	 * Convertie un nom de class provenant d'un Jar en nom de class interpretable par le classloader
	 * @param nom Le nom a traiter
	 */
	public String toClassName(String nom)
	{
		return nom.substring(0, nom.length() - ".class".length());
	}

	/**
	 * Indique la chaine en entree est un fichier contenant l'extention ".class".
	 * @param nom Le nom a tester
	 */
	public boolean isClass(String nom)
	{
        return new Analyseur().contient(nom, ".class");
	}

	/**
	 * Indique si le fichier teste est dans un package
	 * @param nom le nom a tester
	 */
	public boolean isInsidePackage(String nom)
	{
        return new Analyseur().contient(nom, "/");
	}

	/**
	 * Convertie tous les '/' d'une chaine en '.'.
	 * @param nom La chaine a convertir
	 * @return La chaine traitee
	 */
	public String slashToDot(String nom)
	{
        return nom.replace("/", ".");
	}

	/**
	 * Teste un nom de classe et determine si elle implemente la l'interface permettant de dialoguer avec le jeu.
	 * @param nom La classe a tester
	 * @return Vrai si la classe ets le cerveau, faux sinon
	 */
	public void traitementCerveau(String nom)
	{
		boolean fini = false;
		try {
			IAnalyseur a = new Analyseur();
			Class c = SingClassLoader.chargerClass(nom);
			Class[] inter = c.getInterfaces();
			int i = 0;
            while(i < inter.length && !fini)
			{
				if(a.contient(inter[i].getName(), "IIA"))
				{
					fini = true;
				}
				i++;
			}
			this.joueur.ajouterCerveau(c);

		} catch (ClassNotFoundException e) {
			System.err.println("[Erreur] La classe n'a pas ete trouvee");
		}
	}

	/**
	 * Constructeur de la classe
	 * @param nom
	 */
	public traiterEntree(String nom, Joueur joueur)
	{
		this.joueur = joueur;
        if(isClass(nom))
		{
			traitementClass(nom);
		}
	}

	/**
	 * Fonction traitant une entree de Jar pour determiner dans un premier temps si elle est une classe, puis dans un second temps determiner si elle est un cerveau de joueur (une classe implementant IIA). Dans le cas ou l'entree est un cerveau de Joueur, le joueur se voit octroyer la possibiliter de dialoguer (intelligement ?) avec le jeu
	 * @param nom
	 */
	public void traitementClass(String nom)
	{
        if(isInsidePackage(nom))
		{
			nom = slashToDot(nom);
		}
		nom  = toClassName(nom);
        traitementCerveau(nom);
	}

}