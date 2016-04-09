package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Matrix {

	private char[][] matrix;  
	private List<PuntoColor> lista;
	private int espacioLibre, fichasPuestas;
	
	public Matrix(List<PuntoColor> p){
		matrix = new char[10][10];
		lista = p;
		initialize();
		fichasPuestas = fill();
		espacioLibre = espacios(); 
	}

	private void initialize() {
		for(int i = 0; i < 10; i++){
			for(int j = 0; j< 10; j++){
				matrix[i][j] = 'x' ;
			}
		}
	}
	
	private int fill(){
		Point pos = new Point(0,0);
		int numElements = 0;
		for(PuntoColor ficha: lista){
			boolean puesta = false;
			int ancho = ficha.getX();
			int alto = ficha.getY();
			while(pos.y <= 10 && pos.y + alto < 10 && !puesta){
					while(pos.x <= 10 ){
						if( pos.x + ancho <= 10 && matrix[pos.y][pos.x] == 'x' ){
							char[][] cond = tryAndFill(ficha, pos);
							if(cond != null){
								matrix = cond;
								pos.x += ancho;
								numElements ++;
								puesta = true;
							}
							break;
						}else{
							pos.x += 1;
						}
					}
					if(!puesta){
						pos.y += 1;
						pos.x  = 0;
					}
			}
		}
		return numElements;
	}
	
	private char[][] tryAndFill(PuntoColor ficha, Point pos) {
		int ancho = ficha.getX(), alto = ficha.getY();
		char[][] abr = matrix.clone();
		boolean falla = false;
		for(int i = 0; i < alto; i++){
			for(int j = 0; j< ancho; j++){
				if (abr[i+pos.y][j+pos.x] != 'x'){
					falla = true;
				}
			}
		}
		if(!falla){
			for(int i = 0; i < alto; i++){
				for(int j = 0; j< ancho; j++){
					abr[i+pos.y][j+pos.x] = ficha.toChar();
				}
			}
		}
		abr = (falla ? null: abr);
		return abr;
	}
	
	public Integer getEspacioLibre() {
		return espacioLibre;
	}

	public Integer getFichasPuestas() {
		return fichasPuestas;
	}

	private int espacios(){
		int vacios = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j< 10; j++){
				if (matrix[i][j] == 'x'){
					vacios ++;
				}
			}
		}
		return vacios;
	}
	
	public List<PuntoColor> drawMatrix(){
		List<PuntoColor> draw = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			for(int j = 0; j< 10; j++){
				if (matrix[i][j] != 'x'){
					draw.add(new PuntoColor(i, j, Character.getNumericValue(matrix[i][j])));
				}
			}
		}
		return draw;
	}

	public void print(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j< 10; j++){
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println("");
		}
	}
	
}
