
import IAPackage.Parler;

import java.util.ArrayList;

public class Core {


    private ArrayList<Parler> ia = new ArrayList<>();


    /**
     * Constructeur du coeur du chargeur de module
     * @param dossier le dossier a charger
     * @throws Exception renvoie l'exception potentiellement soulevee durant le traitement
     */
    public Core(String dossier) throws Exception {
        ListeJar listeJar = new ListeJar(dossier);
        ParserListeJar parserListeLar = new ParserListeJar(listeJar);
        ParserClasse parserClasse = new ParserClasse(parserListeLar.getJarClass());
        this.ia=parserClasse.getListe();
    }


    /**
     * Permt de s'adresser a toutes les ia
     * @return la reponse des ia
     */
    public String discuter()
    {
        String str= "";
        for(Parler ia : this.ia)
        {
            str += ia.dire("coucou");
            str += "\n";
        }
        return str;
    }

    /**
     * Permet de s'adresser a une ia en particulier
     * @param numero le numero de l'ia a laquelle on veut s'adresser
     * @param message le message a adresser l'ia
     * @return la reponse de l'ia
     */
    public String interrogerIa(int numero, String message)
    {
        return this.ia.get(numero).dire(message);
    }

}