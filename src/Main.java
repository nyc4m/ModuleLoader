/**
 * Created by Baptiste on 20/10/2016.
 */
public class Main {

    public static void main(String[] args)
    {

        Core c = null;
        try {
            c = new Core("MODULES_A_CHARGER");
            System.out.println(c.discuter());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
