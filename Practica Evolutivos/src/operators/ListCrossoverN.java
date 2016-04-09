package operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.uncommons.maths.number.NumberGenerator;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import model.PuntoColor;

public class ListCrossoverN<PuntoColor> extends AbstractCrossover<List<PuntoColor>> {

	 public ListCrossoverN()
	    {
	        this(1);
	    }
	
	public ListCrossoverN(int crossoverPoints)
    {
        super(crossoverPoints);
    }

	  public ListCrossoverN(int crossoverPoints, Probability crossoverProbability)
	    {
	        super(crossoverPoints, crossoverProbability);
	    }



	    public ListCrossoverN(NumberGenerator<Integer> crossoverPointsVariable)
	    {
	        super(crossoverPointsVariable);
	    }


	    public ListCrossoverN(NumberGenerator<Integer> crossoverPointsVariable,
	                           NumberGenerator<Probability> crossoverProbabilityVariable)
	    {
	        super(crossoverPointsVariable, crossoverProbabilityVariable);
	    }

	@Override
	protected List<List<PuntoColor>> mate(List<PuntoColor> parent1, List<PuntoColor> parent2,
			int numberOfCrossoverPoints, Random rng) {
		List<PuntoColor> p1 = new ArrayList<PuntoColor>(parent1); // Use a random-access list for performance.
        List<PuntoColor> p2 = new ArrayList<PuntoColor>(parent2);
        List<PuntoColor> offspring1 = new ArrayList<PuntoColor>(); // Use a random-access list for performance.
        List<PuntoColor> offspring2 = new ArrayList<PuntoColor>();
        int tamaño = p1.size();
        for (int i = 0; i < tamaño; i++)
        {
        	PuntoColor a = p1.remove(0);
        	PuntoColor b = p2.remove(0);
        	if(offspring1.contains(a)){
				offspring2.add(a);
			}
			else{
				offspring1.add(a);
			}
			if(offspring1.contains(b)){
				offspring2.add(b);
			}
			else{
				offspring1.add(b);
			}
        }
        List<List<PuntoColor>> result = new ArrayList<List<PuntoColor>>(2);
        result.add(offspring1);
        result.add(offspring2);
        return result;
	}
	
}
