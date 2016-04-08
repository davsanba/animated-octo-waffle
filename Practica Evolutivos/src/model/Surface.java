package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.CandidateFactory;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.operators.ListCrossover;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.GenerationCount;
import org.uncommons.watchmaker.framework.termination.TargetFitness;

import controller.App;
import operators.*;

public class Surface {
	private  List<PuntoColor> rectangulos = new ArrayList<PuntoColor>();
	
	public Surface(){
		rectangulos.add(new PuntoColor(8,3,0));
		rectangulos.add(new PuntoColor(5,1,1));
		rectangulos.add(new PuntoColor(2,2,2));
		rectangulos.add(new PuntoColor(1,1,3));
		rectangulos.add(new PuntoColor(9,4,4));
		rectangulos.add(new PuntoColor(6,2,5));
		rectangulos.add(new PuntoColor(4,3,6));
		rectangulos.add(new PuntoColor(5,7,7));
		rectangulos.add(new PuntoColor(3,2,8));
		rectangulos.add(new PuntoColor(4,2,9));
	}
	
	
	public void evolve(int pobInicial, char modo, int dato, int elitismo, boolean mostrar, double prob){
		
		List<PuntoColor> result;
		
		CandidateFactory<List<PuntoColor>> factory = new PiecesFactory(rectangulos);
		
		List<EvolutionaryOperator<List<PuntoColor>>> operators = new LinkedList<EvolutionaryOperator<List<PuntoColor>>>();
        
        operators.add(new ListCrossoverN());
        operators.add(new SwapMutation(prob));
        operators.add(new TurnMutation(prob));                                                  
        
        EvolutionaryOperator<List<PuntoColor>> pipeline = new EvolutionPipeline<>(operators);
		
		
		 EvolutionEngine<List<PuntoColor>> engine = new GenerationalEvolutionEngine<>(
	     	       /*candidateFactory*/ factory,
	     	       /*evolutionaryOperator*/ pipeline,
	     	       /*fitnessEvaluator*/ new MatrixEvaluator(mostrar),
	     	       /*selectionStrategy*/ new RouletteWheelSelection(),
	     	       /*rng*/ new MersenneTwisterRNG()
	     	 );
		if(modo == '1'){
			//Stagnation 
			result = engine.evolve(pobInicial, elitismo, new GenerationCount(dato));
	        System.out.println("mostrando " + result.size());
	        Matrix rst = new Matrix(result);
	        App.getInstance().draw(rst.drawMatrix());
			
		}else{
			//ElapsedTime
	        result = engine.evolve(pobInicial, elitismo, new TargetFitness(dato, false));
	        App.getInstance().draw(result);
		}
		
        
	}


	public List<PuntoColor> getRectangulos() {
		System.out.println(rectangulos.size());
		return rectangulos;
	}

}
