
import IAPackage.Parler;

import java.lang.reflect.Array;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class Core {


    private ArrayList<Parler> ia = new ArrayList<>();

    public Core(ArrayList<Parler> listeIA)
    {
        this.ia=listeIA;
    }

    public String discuter()
    {
        String str= "";
        for(Parler ia : this.ia)
        {
            str += ia.dire("coucou");
        }
        return str;
    }

}