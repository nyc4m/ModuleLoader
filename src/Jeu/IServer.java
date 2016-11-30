package Jeu;


import ModuleLoader.Joueur;

import java.util.List;

public interface IServer
{

    /**
     * Retourne la liste complete des IA
     * @return
     */
    List<Joueur> listeIA();

    /**
     * Permet d'obtenir une IA indexee par un entier
     * @param i l'indexe de l'ia
     * @return une ia
     */
    Joueur obtenirIA(int i);

}