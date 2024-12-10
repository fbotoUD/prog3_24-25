package es.deusto.prog3.cap06.resueltos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

public class RecorrerDirectorios {

	private static final String RUTA_POR_DEFECTO = "";

	/**
	 * Genera una lista con los nombres de los archivos y directorios a partir de la
	 * ruta de un fichero. Realiza el proceso de manera recursiva.
	 * 
	 * @param result List<String> con los nombres de lor archivos y directorios que
	 *               están dentro de la ruta inicial.
	 * @param file   File con la ruta inicial.
	 * @param tab    String con espacios en blanco representar profundidad respecto
	 *               a la ruta inicial.
	 */
	private static void recorrer(List<String> result, File file, String tab) {
		//Si el fichero actual es un directorio
		if (file.isDirectory()) {
			//Se añade el directorio 
			result.add(String.format("%s+ %s", tab, file.getName()));

			for (File f : file.listFiles()) {
				recorrer(result, f, tab + "  ");
			}
		} else {
			result.add(String.format("%s- %s", tab, file.getName()));
		}
	}

	/**
	 * Recorre un directorio y retorna una lista con los nombres de los archivos y
	 * subdirectorios que contiene.
	 * 
	 * @param root File con el directorio raiz a analizar.
	 * @return List<String> con los nombre de los archivos y subdirectorios que
	 *         cotiene el directorio raiz.
	 */
	public static List<String> recorrer(File root) {
		List<String> result = new ArrayList<>();
		recorrer(result, root, "");
		
		return result;
	}

	public static void main(String[] args) {
		// Se crea un JFileChooser para seleccionar una carpeta.
		JFileChooser fileChooser = new JFileChooser(new File(RUTA_POR_DEFECTO));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Selecciona una carpeta");
		int click = fileChooser.showOpenDialog(null);
		//Se crea un fichero a partir de la selección
		File file = fileChooser.getSelectedFile();		

		if (click == JFileChooser.APPROVE_OPTION && file != null) {
			//Se recorren las carpetas desde la raiz
			recorrer(file).forEach(f -> System.out.println(f));
		}
	}
}