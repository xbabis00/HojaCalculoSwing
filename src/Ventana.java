import java.awt.*;

import javax.swing.*;

public class Ventana extends JFrame {

	int filas;
	int columnas;
	JTextField[][] campos;
	JPanel panelCentral;
	JPanel panelInferior;
	static JLabel celdaActual;
	
	public Ventana(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		
		panelCentral = new JPanel();
		
		setTitle("Hoja De Cálculo");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(filas, columnas));
		
		inicializarPanelInferior();
		
		char[] abecedario = createArray();
		
		this.campos = new JTextField[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				if(j==0) {
					if(i==0) {
						this.campos[i][j] = new JTextField();
						this.campos[i][j].setEditable(false);
					}else {
						this.campos[i][j] = new JTextField(""+i);
						this.campos[i][j].setEditable(false);
					}
				}
				else if(i==0){
					this.campos[i][j] = new JTextField(""+abecedario[j-1]);
					this.campos[i][j].setEditable(false);
				}
				else {
					String iString = i +"";
					String nombreCelda = abecedario[j-1] + iString + "";
					this.campos[i][j] = new Celda(nombreCelda,"");
				}
				panelCentral.add(this.campos[i][j]);
			}
		}
	}
	
	private void inicializarPanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		add(panelInferior, BorderLayout.SOUTH);
		celdaActual = new JLabel();
		celdaActual.setHorizontalAlignment(JLabel.CENTER);
		panelInferior.add(celdaActual);
	}

	public char[] createArray() {
		char[] s;
		s=new char[26];
		for ( int i=0; i<26; i++) {
		s[i] = (char) ('A' + i );
		}
		return s;
		}
}
