package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

public class PiecesFactory extends AbstractCandidateFactory<List<PuntoColor>> {
	
	private List<PuntoColor> candidatos;
	
	public PiecesFactory(List<PuntoColor> modelo){
		candidatos = new ArrayList<>(modelo);
	}
	
	@Override
	public List<PuntoColor> generateRandomCandidate(Random rng) {
		List<PuntoColor> cnd = candidatos;
		Collections.shuffle(cnd);
		int swaps = rng.nextInt(9);
		for(int i = 0; i <= swaps; i++){
			int pos = rng.nextInt(9);
			cnd.get(pos).Swap();
		}
		return cnd;
	}

}
