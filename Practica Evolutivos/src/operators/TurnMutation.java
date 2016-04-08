package operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import model.PuntoColor;

public class TurnMutation implements EvolutionaryOperator<List<PuntoColor>> {

	private double probabilidad;
	
	public TurnMutation(double p) {
		probabilidad = p;
	}
	
	@Override
	public List<List<PuntoColor>> apply(List<List<PuntoColor>> selectedCandidates, Random rng) {
		List<List<PuntoColor>> mutatedCandidates = new ArrayList<>();
		for(List<PuntoColor> candidate : selectedCandidates){
			if(candidate.size() > 0){
				double p = rng.nextDouble();
				if(p <= probabilidad){
					int a = rng.nextInt(selectedCandidates.size());
					candidate.get(a).Swap();
					mutatedCandidates.add(candidate);
				}
			}
		}
		return mutatedCandidates;
	}

}
