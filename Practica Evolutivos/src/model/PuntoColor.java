package model;

import java.awt.Color;

import org.uncommons.watchmaker.framework.selection.TournamentSelection;

public class PuntoColor {

	private int x, y;
	private Integer numero;
	
	public PuntoColor(int x, int y, int n){
		this.x = x;
		this.y = y;
		this.numero = n;
	}
	
	public void Swap(){
		int aux = x;
		x = y;
		y = aux;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Integer getColor() {
		return numero;
	}

	public void setColor(int numero) {
		this.numero = numero;
	}
	
	public char toChar(){
		return numero.toString().charAt(0);
		
	}


}
