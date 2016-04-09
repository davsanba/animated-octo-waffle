package model;

import java.util.List;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import controller.App;

public class MatrixEvaluator implements FitnessEvaluator<List<PuntoColor>> {

	public MatrixEvaluator() {
	}
	
	@Override
	public double getFitness(List<PuntoColor> candidate, List<? extends List<PuntoColor>> population) {
		Matrix evaluator = new Matrix(candidate);
		
		//normal
		//double fitness = evaluator.getEspacioLibre()+ (10-evaluator.getFichasPuestas());
		
		//solo espacios
		double fitness = evaluator.getEspacioLibre();
		
		//optimizar espacio
		//double fitness = Math.pow(evaluator.getEspacioLibre(),2)+ 10-evaluator.getFichasPuestas();
		
		//optmizar cantidad de fichas
		//double fitness = evaluator.getEspacioLibre()+ Math.pow(10-evaluator.getFichasPuestas(),2);
		return fitness;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
