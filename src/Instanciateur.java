import IAPackage.Parler;

import java.util.ArrayList;

/**
 * Created by Baptiste on 20/10/2016.
 */
public class Instanciateur {

    public ArrayList<Parler> instancier(ArrayList<Class> classes)
    {
        ArrayList<Parler> ia = new ArrayList<>();
        for(int i = 0; i < classes.size(); i++)
        {
            try {
                ia.add((Parler)classes.get(i).newInstance()) ;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ia;
    }
}
