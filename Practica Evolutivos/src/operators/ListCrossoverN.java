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

public class ListCrossoverN extends AbstractCrossover<List<PuntoColor>> {

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
	protected List<List<PuntoColor>> mate(List<PuntoColor> parent1, 
										  List<PuntoColor> parent2,
										  int numberOfCrossoverPoints, 
										  Random rng) {
		
		List<PuntoColor> hijo1 = new ArrayList<PuntoColor>();
		List<PuntoColor> hijo2 = new ArrayList<PuntoColor>();
		String p1 = "";
		String p2 = "";
		
		if (parent1.size() != parent2.size())
            throw new IllegalArgumentException("Cannot perform cross-over with different length parents.");
		
		
		while(parent1.size() != 0){
			PuntoColor a = parent1.remove(0);
			PuntoColor b = parent2.remove(0);
			if(!p1.contains(a.getColor().toString())){
				hijo1.add(a);
				p1 = p1 + a.getColor().toString();
			}
			else{
				hijo2.add(a);
				p2 = p2+ a.getColor().toString();
			}
			if(!p1.contains(b.getColor().toString())){
				hijo1.add(b);
				p1 = p1 + b.getColor().toString();
			}
			else{
				hijo2.add(b);
				p2 = p2+ b.getColor().toString();
			}
			
		}
		List<List<PuntoColor>> rt = new ArrayList<List<PuntoColor>>();
		rt.add(hijo1);
		rt.add(hijo2);
		return rt;
	}
	
}
