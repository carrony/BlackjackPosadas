package modelo;

import java.util.ArrayList;
import java.util.Collections;

import modelo.Carta.Palo;

public class Mazo {
	
	// Variables miembro
	protected ArrayList<Carta> cartas;
	
	public Mazo() {
		// Creamos la lista de cartas vacía
		this.cartas = new ArrayList<Carta>(); 
		// recorre la lista de palos
		for (Palo p: Palo.values()) {
			// recorre tod s los valores de carta
			for (int i=1; i<=13; i++) {
				Carta carta = new Carta(i, p);
				this.cartas.add(carta);
			}
		}
	}

	@Override
	public String toString() {
		return "Mazo [cartas=" + cartas + "]";
	}
	
	public void barajar() {
		Collections.shuffle(cartas);
	}
	
	public Carta solicitarCarta() throws NoHayMasCartasException {
		if (this.cartas.size()==0) {
			throw new NoHayMasCartasException();
		}
		// recogemos la primera carta del mazo de cartas
		Carta c = this.cartas.get(0);
		// eliminamos la carta recogida del mazo
		this.cartas.remove(0);
		return c;
	}

		
	
	
	
}
