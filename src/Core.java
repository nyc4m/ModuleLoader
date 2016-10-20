
import IAPackage.Parler;

import java.util.ArrayList;

public class Core {


    private ArrayList<Parler> ia = new ArrayList<>();

    public Core(String dossier)
    {
        ListeJar listeJar = new ListeJar(dossier);
        ParserListeJar parserListeLar = new ParserListeJar(listeJar);
        ParserClasse parserClasse = new ParserClasse(parserListeLar.getJarClass());
        this.ia=parserClasse.getListe();
    }


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

}