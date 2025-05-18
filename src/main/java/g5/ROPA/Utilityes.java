package g5.ROPA;

import java.net.MalformedURLException;
import java.net.URL;

public class Utilityes {
	
	public boolean urlValida(String url) {
		boolean res = true;
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			System.err.println("Excepción al cargar la imagen: " + e.getMessage());
			res = false;
		}
		return res;
	}
	
}
