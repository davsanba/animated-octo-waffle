package model;

import java.util.List;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import controller.App;

public class MatrixEvaluator implements FitnessEvaluator<List<PuntoColor>> {

	private boolean show;
	public MatrixEvaluator(boolean show) {
		this.show = show;
	}
	
	@Override
	public double getFitness(List<PuntoColor> candidate, List<? extends List<PuntoColor>> population) {
		System.out.println("tamaño: " +candidate.size());
		for(PuntoColor x: candidate){
			System.out.print(x.toChar() + " ");
		}
		System.out.println("....");
		Matrix evaluator = new Matrix(candidate);
		if(show){
			List<PuntoColor>draw = evaluator.drawMatrix();
			App.getInstance().draw(draw);
		}
		int fitness = evaluator.getEspacioLibre()+evaluator.getFichasPuestas();
		return fitness;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

}
