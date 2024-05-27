package modelo;

import java.util.ArrayList;

public class Mano extends Mazo {

	public Mano() {
		//ceramos una list de cartas vacía
		this.cartas = new ArrayList<Carta>();
	}

	public int valorMano() {
		int valor=0;
		for(Carta c : this.cartas) {
			valor = valor + c.getValor();
		}
		return valor;
	}
}
