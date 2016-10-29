
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.jar.JarFile;

/**
 * Classe permetant de convertir un nom de fichier en URL
 */
public class ToURL {

	/**
	 * Convertie un nom de fichier en URL
	 * @param nom le nom du fichier a convertir
	 * @return un URL correspondant au chemin du jar
	 */
	public URL toURL(String nom) {
		URL url = null;
		try {
			url =new  URL("file:"+nom);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}


}