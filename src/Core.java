
import IAPackage.Parler;

import java.util.ArrayList;

public class Core {


    private ArrayList<Parler> ia = new ArrayList<>();

    public Core(String dossier) throws Exception {
        ListeJar listeJar = null;
        try {
            listeJar = new ListeJar(dossier);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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