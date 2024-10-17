package es.deusto.prog3.cap03.resueltos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// Este ejemplo ha sigo creado a partir de una versión generada con ChatGPT 4o
public class CalculadoraEventos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField display;

	public CalculadoraEventos() {
		// Configuración básica de la ventana
		setTitle("Calculadora Básica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));

		// Crear el display de la calculadora
		display = new JTextField();
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setFont(new Font("Courier", Font.BOLD, 24));
		add(display, BorderLayout.NORTH);

		// Panel de botones numéricos y de operaciones
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

		// Crear los textos mostrados en los botones
		String[] buttonsText = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

		// Se define una varaible auxiliar para crear los botones
		JButton button = null;

		// Crear los botones y añadir los listeners
		for (String text : buttonsText) {
			// Se crea un botón con el texto correspondiente
			button = new JButton(text);
			//Modificar la fuente para el botón
			button.setFont(new Font("Arial", Font.PLAIN, 18));

			// En función del texto, se añade al botón el listener correspondiente
			if ("0123456789".contains(text)) {
				button.addActionListener(new NumeroListener());
			} else if (text.equals(".")) {
				button.addActionListener(new DecimalListener());
			} else if (text.equals("=")) {
				button.addActionListener(new IgualListener());
			} else {
				button.addActionListener(new OperadorListener());
			}
			buttonPanel.add(button);
		}

		// Añadir el panel de botones al centro de la ventana
		add(buttonPanel, BorderLayout.CENTER);
	}

	// Listener para los números
	public class NumeroListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String valor = e.getActionCommand();
			String textoActual = display.getText();
			
			System.out.println(valor);

			// Si el texto actual es vacío o tiene menos de 6 caracteres, siempre se puede
			// añadir un dígito
			if (textoActual.length() < 6) {
				display.setText(textoActual + valor);
				return;
			}

			// Obtener los últimos 6 caracteres del display
			String ultimosCaracteres = textoActual.substring(textoActual.length() - 6);

			// Intentar convertir a entero para verificar si es un número válido de 6
			// dígitos
			try {
				Integer.parseInt(ultimosCaracteres);
				JOptionPane.showMessageDialog(null, "No se pueden introducir más de 6 dígitos consecutivos.");
				return;
			} catch (NumberFormatException ex) {
			}

			// Si no hubo excepción, añadir el número al display
			display.setText(textoActual + valor);
		}
	}

	// Listener para el botón decimal
	public class DecimalListener implements ActionListener {

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String textoActual = display.getText();

	        // Encontrar la posición del último operador o punto decimal
	        int indiceUltimoOperador = Math.max(
	            Math.max(textoActual.lastIndexOf('+'), textoActual.lastIndexOf('-')),
	            Math.max(textoActual.lastIndexOf('*'), textoActual.lastIndexOf('/'))
	        );
	        
	        // Extraer la parte después del último operador
	        String ultimaParte = textoActual.substring(indiceUltimoOperador + 1);

	        // Si la última parte ya contiene un punto decimal, no se puede añadir otro
	        if (ultimaParte.contains(".")) {
	            JOptionPane.showMessageDialog(null, "No se puede añadir más de un punto decimal en un número.");
	            return;
	        }

	        // Verificar si el último carácter es un operador, si lo es se permite añadir el punto
	        char ultimoCaracter = textoActual.charAt(textoActual.length() - 1);
	        if ("+-/*".contains(String.valueOf(ultimoCaracter))) {
	            display.setText(textoActual + ".");
	            return;
	        }

	        // Si no hay un punto en la parte numérica actual, añadir el punto decimal
	        display.setText(textoActual + ".");
	    }
	}

	// Listener para los operadores
	public class OperadorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String operador = e.getActionCommand();
			String textoActual = display.getText();

			// Verificar si el último carácter es un operador o un punto decimal
			char ultimoCaracter = textoActual.charAt(textoActual.length() - 1);

			if ("+-/*".contains(String.valueOf(ultimoCaracter))) {
				// No permitir dos operadores seguidos
				JOptionPane.showMessageDialog(null, "No se pueden poner dos operadores seguidos.");
				return;
			} else if (ultimoCaracter == '.') {
				// No permitir un operador después de un punto decimal
				JOptionPane.showMessageDialog(null, "No se puede poner un operador después de un punto decimal.");
				return;
			}

			// Si todo es válido, añadir el operador al display
			display.setText(textoActual + operador);
		}
	}

	// Listener para el botón igual
	public class IgualListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String textoActual = display.getText();

			// Verificar si la secuencia es válida: dígito/decimal, operador,
			// dígito/decimal...
			if (!esSecuenciaValida(textoActual)) {
				JOptionPane.showMessageDialog(null, "Secuencia inválida. Debe ser 'dígito, operador, dígito'.");
				return;
			}

			// Realizar las operaciones en orden de izquierda a derecha
			try {
				double resultado = evaluarSecuencia(textoActual);				
				// Mostrar el resultado en el display redondeado a 2 decimales
				display.setText(String.format("%.2f", resultado).replace(",", "."));				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al calcular la expresión.");
			}
		}

		// Verificar si la secuencia es válida
		private boolean esSecuenciaValida(String texto) {
			// Permitir secuencias con dígitos y decimales, alternando entre números y
			// operadores
			return texto.matches("\\d+(\\.\\d+)?([\\+\\-\\*/]\\d+(\\.\\d+)?)*");
		}

		// Evaluar la secuencia sin aplicar la prioridad de operadores (de izquierda a
		// derecha)
		private double evaluarSecuencia(String texto) {
			// Dividir la secuencia en partes usando operadores como separadores
			String[] partes = texto.split("(?=[\\+\\-\\*/])|(?<=[\\+\\-\\*/])");
			double resultado = Double.parseDouble(partes[0]); // El primer número (puede ser decimal)

			// Iterar sobre la secuencia y evaluar de izquierda a derecha
			for (int i = 1; i < partes.length; i += 2) {
				String operador = partes[i];
				double siguienteNumero = Double.parseDouble(partes[i + 1]); // Números decimales

				switch (operador) {
				case "+":
					resultado += siguienteNumero;
					break;
				case "-":
					resultado -= siguienteNumero;
					break;
				case "*":
					resultado *= siguienteNumero;
					break;
				case "/":
					if (siguienteNumero == 0) {
						JOptionPane.showMessageDialog(null, "Error de división entre 0.");
						return 0;
					}
					resultado /= siguienteNumero;
					break;
				}
			}
			
			return resultado;
		}
	}

	// Método principal
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CalculadoraEventos calculadora = new CalculadoraEventos();
			calculadora.setVisible(true);
		});
	}
}