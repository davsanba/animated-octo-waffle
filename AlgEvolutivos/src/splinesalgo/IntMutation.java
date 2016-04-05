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
			String bin = Integer.toBinaryString(Math.abs(i[j]));
			double prob = 1.0/bin.length();
			double random = rng.nextDouble();
			if(random <= prob){
				System.out.println("FUNCIONA!!!");
				System.out.println("antes: " + bin );
				int pos = rng.nextInt(bin.length());
				System.out.println("posicion: " + pos);
				String[] ary = bin.split("");
				if(ary[pos].equals("1")){
					ary[pos] = "0";
				}else{
					System.out.println(ary[pos]);
					ary[pos] = "1";
					System.out.println(ary[pos]);
				}
				StringBuilder builder = new StringBuilder();
				for(String s : ary) {
				    builder.append(s);
				}
				bin = builder.toString();
				System.out.println("despues: "+ bin);
			}
		}
		return i;
	}
	
		
}
