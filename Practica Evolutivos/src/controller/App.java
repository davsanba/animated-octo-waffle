package controller;

import java.util.ArrayList;
import java.util.List;

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
		c.add(new PuntoColor(0, 0, 1));
		c.add(new PuntoColor(1, 1, 2));
		c.add(new PuntoColor(1, 2, 2));
		c.add(new PuntoColor(9, 9, 3));
		draw(c);
		
	}

	private App() {}
	 
    public static App getInstance() {
        return _instance;
    }

	public void evolve(int pobInicial, char modo, int dato, int elitismo, boolean mostrar, double prob) {
		surface.evolve(pobInicial, modo, dato, elitismo, mostrar, prob);
	}
	
	public void draw(List<PuntoColor> list){
		window.draw(list);
	}

	public List<PuntoColor> getRectangulos() {
		return surface.getRectangulos();
	}
}
