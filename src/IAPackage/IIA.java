package IAPackage;

/**
 * Interface commune au jeu et aux modules. Cette interface permet au jeu d'appeler la fonction "jouer" d'une IA.
 */
public interface IIA {

	/**
	 * Demande à l'IA de jouer son tour et de renvoyer un String contenant ce qu'elle a décidé de faire.
	 * @param m Informations n�cessaires � l'IA pour qu'elle puisse jouer son tour.
         * @return 
	 */
	String jouerTour(IEchange m);

}