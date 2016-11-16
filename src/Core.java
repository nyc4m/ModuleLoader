import IAPackage.IEchange;
import IAPackage.IIA;

import java.util.ArrayList;

public class Core {


    private ArrayList<IIA> ia = new ArrayList<>();


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
    public ArrayList<String> notifierToutesLesIa(IEchange message)
    {
        ArrayList<String> reponses = new ArrayList<>();
        for(IIA ia : this.ia)
        {
            reponses.add(ia.jouerTour(message));
        }
        return reponses;
    }

    /**
     * Permet de s'adresser a une ia en particulier
     * @param numero le numero de l'ia a laquelle on veut s'adresser
     * @param message le message a adresser l'ia
     * @return la reponse de l'ia
     */
    public String interrogerIa(int numero, IEchange message)
    {
        return this.ia.get(numero).jouerTour(message);
    }

}