
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.jar.JarFile;

public class ToURL {

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