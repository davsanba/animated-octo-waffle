package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import model.*;
import view.*;

public class App {

	private static App _instance = new App();
	private MainWindow window;
	private Surface surface;

	
	public static void main(String[] args) {
		App.getInstance().start();
	}
		
	public void start(){
		window = new MainWindow();
		surface = new Surface();
		prueba();
	}
	
	
    private void prueba() {
		List<PuntoColor> c = new ArrayList<>();
		c.add(new PuntoColor(0,0,1));
		c.add(new PuntoColor(1,0,1));
		c.add(new PuntoColor(8,0,1));
		c.add(new PuntoColor(9,0,1));
		c.add(new PuntoColor(0,1,1));
		c.add(new PuntoColor(9,1,1));
		c.add(new PuntoColor(1,4,1));
		c.add(new PuntoColor(2,4,1));
		c.add(new PuntoColor(7,4,1));
		c.add(new PuntoColor(8,4,1));
		c.add(new PuntoColor(1,5,1));
		c.add(new PuntoColor(2,5,1));
		c.add(new PuntoColor(3,5,1));
		c.add(new PuntoColor(6,5,1));
		c.add(new PuntoColor(7,5,1));
		c.add(new PuntoColor(8,5,1));
		c.add(new PuntoColor(2,6,1));
		c.add(new PuntoColor(7,6,1));
		c.add(new PuntoColor(0,7,1));
		c.add(new PuntoColor(4,7,1));
		c.add(new PuntoColor(5,7,1));
		c.add(new PuntoColor(9,7,1));
		c.add(new PuntoColor(0,8,1));
		c.add(new PuntoColor(1,8,1));
		c.add(new PuntoColor(8,8,1));
		c.add(new PuntoColor(9,8,1));
		c.add(new PuntoColor(0,9,1));
		c.add(new PuntoColor(1,9,1));
		c.add(new PuntoColor(3,9,1));
		c.add(new PuntoColor(6,9,1));
		c.add(new PuntoColor(8,9,1));
		c.add(new PuntoColor(9,9,1));

		
		draw(c,"Hola","Mundo");
		
	}

	private App() {}
	 
    public static App getInstance() {
        return _instance;
    }

	public void evolve(int pobInicial, char modo, int dato, int elitismo, double prob) {
		surface.evolve(pobInicial, modo, dato, elitismo, prob);
	}
	
	public void draw(List<PuntoColor> list, String vacios, String fichas){
		window.draw(list, vacios, fichas);
	}

	public List<PuntoColor> getRectangulos() {
		return surface.getRectangulos();
	}
}
