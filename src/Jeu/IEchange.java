package Jeu;

/**
 * Interface commune au jeu et aux modules permettant de transmettre une information de l'un � l'autre.
 */
public interface IEchange
{

	/**
	 * Renvoie un tableau repr�sentatif du Plateau.
	 * @return ledit tableau
	 */
	String[] getTabCarte();

	String[] getTab();

}