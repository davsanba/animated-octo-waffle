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
		int fitness = evaluator.getEspacioLibre()+evaluator.getFichasPuestas();
		return fitness;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
