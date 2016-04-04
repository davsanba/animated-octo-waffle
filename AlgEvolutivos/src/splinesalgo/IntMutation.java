package splinesalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

public class IntMutation implements EvolutionaryOperator<int[]> {

	public List<int[]> apply(List<int[]> selectedCandidates, Random rng) {
		 List<int[]> mutatedPopulation = new ArrayList<int[]>(selectedCandidates.size());
	        for (int[] i : selectedCandidates)
	        {
	            mutatedPopulation.add(mutateList(i, rng));
	        }
	        return mutatedPopulation;
	}

	private int[] mutateList(int[] i, Random rng) {
		for(int j = 0; j < 6; j++){
			int aux = i[j];
			int num = rng.nextInt(100);
			int operador = rng.nextInt(2);
			switch (operador) {
			case 0:
				aux = aux + num;
				break;
			case 1:
				aux = aux - num;
				break;
			case 2:
				aux = aux * num;
				break;
			case 3:
				if(num != 0)
					aux = aux / num;
				else
					aux = aux - num;
				break;
			default:
				break;
			}
			if(aux > 2000 || aux < -2000){
				aux = aux%2000;
				if(rng.nextBoolean())
					aux = aux * -1;
			}
			
			i[j] = aux;
		}
		return i;
	}
	
		
}
