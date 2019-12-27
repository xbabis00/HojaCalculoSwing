import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class Celda extends JTextField {
	private String nombre;
	private String valor;

	public Celda() {

	}

	public Celda(String nombre, String valor) {
		this.nombre = nombre;
		this.valor = valor;
		this.setText(this.valor);
		obtenerNombreCelda();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor + "";
	}

	public void obtenerNombreCelda() {
		addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//System.out.println("Perdido foco");
				setValor(((JTextField) e.getSource()).getText());
			}
			public void focusGained(FocusEvent e) {
				//System.out.println("Foco ganado");
				Ventana.celdaActual.setText(getNombre());
				System.out.println(getValor());
			}
		});
	}
}
