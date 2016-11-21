package ModuleLoader;

public class Analyseur implements IAnalyseur
{

	/**
	 * Teste si une chaine correspond a un predicat
	 * @param sujet la chaine a tester
	 * @param predicat le predicat
	 */
	public boolean contient(String sujet, String predicat)
	{
        return sujet.contains(predicat)? true: false;
	}

}