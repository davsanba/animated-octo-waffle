package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.CandidateFactory;

public class Prueba {

	
	public static void main(String[] args) {
		List<PuntoColor> rectangulos = new ArrayList<PuntoColor>();
		rectangulos.add(new PuntoColor(8,3,0));
		rectangulos.add(new PuntoColor(5,1,1));
		rectangulos.add(new PuntoColor(2,2,2));
		rectangulos.add(new PuntoColor(1,1,3));
		rectangulos.add(new PuntoColor(9,4,4));
		rectangulos.add(new PuntoColor(6,2,5));
		rectangulos.add(new PuntoColor(4,3,6));
		rectangulos.add(new PuntoColor(5,7,7));
		rectangulos.add(new PuntoColor(3,2,8));
		rectangulos.add(new PuntoColor(4,2,9));
		CandidateFactory<List<PuntoColor>> factory = new PiecesFactory(rectangulos);
		Random rnd = new Random();
		List<List<PuntoColor>> lista = factory.generateInitialPopulation(100, rnd);
		System.out.println(lista.size());
		while(true){
			List<PuntoColor> lst = factory.generateRandomCandidate(rnd);
			System.out.println(lst.size());
		}
	}


		
	
	
		
		
}
