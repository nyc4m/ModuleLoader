package test;

import Jeu.IServer;
import Jeu.Message;
import ModuleLoader.Joueur;
import ModuleLoader.ListeIA;

/**
 * Created by baptiste on 21/11/16.
 */
public class Main {

    public static void main(String args[])
    {
        IServer liste = null;
        try {
            liste = new ListeIA("MODULES_A_CHARGER/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Joueur j : liste.listeIA())
        {
            System.out.println(j.nomJoueur() + " dit :");
            System.out.println("\t"+j.reagir(new Message()));
        }
    }
}
