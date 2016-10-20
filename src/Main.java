/**
 * Created by Baptiste on 20/10/2016.
 */
public class Main {

    public static void main(String[] args)
    {
        ListeJar listeJar = new ListeJar("MODULE_A_CHARGER");
        ParserListeJar parserListeLar = new ParserListeJar(listeJar);
        ParserClasse parserClasse = new ParserClasse(parserListeLar.getJarClass());
        Core c = new Core(parserClasse.getListe());
        System.out.println(c.discuter());
    }
}
