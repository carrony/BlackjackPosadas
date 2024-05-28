package modelo;

import java.util.ArrayList;

public class Mano extends Mazo {

	public Mano() {
		//ceramos una list de cartas vacía
		this.cartas = new ArrayList<Carta>();
	}

	public int valorMano() {
		int valor=0;
		int numAses=0;
		for(Carta c : this.cartas) {
			if (c.getNumero()==1) {
				numAses++;
			}
			valor = valor + c.getValor();
		}
		// comprobamos si me he pasado de 21 
		while (numAses>0 && valor>21) {
			valor=valor-10;
			numAses--;
		}
	
		
		return valor;
	}
	
	 // Version del método que lanza la excepción Masde21Exception
	public boolean finDeJuego() {
		if (valorMano()>=21) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Mano [" + cartas + "] Valor de la mano:"+valorMano();
	}

	public void pedirCarta(Mazo baraja) 
			throws NoHayMasCartasException, Masde21Exception, 
			HayBlackjackException {
		// Recoge la carta que se encuentra en el principio del Mazo
		Carta c = baraja.solicitarCarta();
		this.cartas.add(c);
		if (valorMano()>21) {
			throw new Masde21Exception();
		}
		if (valorMano()==21) {
			throw new HayBlackjackException();
		}
	}
	
}
