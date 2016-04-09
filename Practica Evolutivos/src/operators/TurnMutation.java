package operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.uncommons.maths.number.ConstantGenerator;
import org.uncommons.maths.number.NumberGenerator;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import model.PuntoColor;

public class TurnMutation implements EvolutionaryOperator<List<PuntoColor>> {

	  private final NumberGenerator<Probability> mutationProbability;

	   
	    public TurnMutation(Probability mutationProbability)
	    {
	        this(new ConstantGenerator<Probability>(mutationProbability));
	    }


	   
	    public TurnMutation(NumberGenerator<Probability> mutationProbability)
	    {
	        this.mutationProbability = mutationProbability;
	    }


	    public List<List<PuntoColor>> apply(List<List<PuntoColor>> selectedCandidates, Random rng)
	    {
	        List<List<PuntoColor>> mutatedPopulation = new ArrayList<List<PuntoColor>>(selectedCandidates.size());
	        for (List<PuntoColor> s : selectedCandidates)
	        {
	            mutatedPopulation.add(mutateList(s, rng));
	        }
	        return mutatedPopulation;
	    }


	    private List<PuntoColor> mutateList(List<PuntoColor> s, Random rng)
	    {
	        List<PuntoColor> buffer = new ArrayList<>(s);
	        for (int i = 0; i < buffer.size(); i++)
	        {
	            if (mutationProbability.nextValue().nextEvent(rng))
	            {
	            	int a = rng.nextInt(buffer.size());
	            	buffer.get(a).Swap();
	            }
	        }
	        return buffer;
	    }	

}
