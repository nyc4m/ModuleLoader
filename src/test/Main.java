package test;

import Jeu.ICommuniquer;
import Jeu.IIA;
import Jeu.Message;
import ModuleLoader.ListeIA;

/**
 * Created by baptiste on 21/11/16.
 */
public class Main {

    public static void main(String args[])
    {
        ICommuniquer liste = new ListeIA("MODULES_A_CHARGER/");
        System.out.println(liste.jouerTour(0, new Message()));
        System.out.println(liste.jouerTour(1, new Message()));
    }
}
