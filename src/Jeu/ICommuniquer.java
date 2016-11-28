package Jeu;

import java.util.Iterator;

public interface ICommuniquer
{

	/**
	 * 
	 * @param message
	 */
	String jouerTour(int numJoueur, IEchange message);

}