package es.deusto.prog3.cap03.ejemplos;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;

public class Utils {
	public static void aumentarTamanoFuente(int tamano) {
        // Obtener el conjunto de todas las propiedades de UIManager
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);

            // Cambiar la fuente si el valor actual es de tipo fuente (Font)
            if (value instanceof Font) {
                Font fuenteActual = (Font) value;
                Font fuenteNueva = fuenteActual.deriveFont((float) tamano);
                UIManager.put(key, fuenteNueva);
            }
        }
	}

}
