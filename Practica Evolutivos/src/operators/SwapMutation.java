package operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import model.PuntoColor;

public class SwapMutation implements EvolutionaryOperator<List<PuntoColor>> {
	private double probabilidad;
	
	public SwapMutation(double p) {
		probabilidad = p;
	}
	
	@Override
	public List<List<PuntoColor>> apply(List<List<PuntoColor>> selectedCandidates, Random rng) {
		List<List<PuntoColor>> mutatedCandidates = new ArrayList<>();
		for(List<PuntoColor> candidate : selectedCandidates){
			if(candidate.size() > 0){
				double p = rng.nextDouble();
				if(p <= probabilidad){
					int a = rng.nextInt(candidate.size());
					int b = rng.nextInt(candidate.size());
					Collections.swap(candidate, a, b);
					mutatedCandidates.add(candidate);
				}
			}
		}
		return mutatedCandidates;
	}

}
