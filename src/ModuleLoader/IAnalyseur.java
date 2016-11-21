package ModuleLoader;

public interface IAnalyseur
{

	/**
	 * Teste si une chaine correspond a un predicat
	 * @param sujet la chaine a tester
	 * @param predicat le predicat
	 */
	boolean contient(String sujet, String predicat);

}