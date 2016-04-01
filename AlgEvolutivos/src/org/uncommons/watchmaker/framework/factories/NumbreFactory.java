package org.uncommons.watchmaker.framework.factories;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumbreFactory extends AbstractCandidateFactory<int[]> {

	private final Integer max;
	private final Integer min;
	
	public NumbreFactory(int max, int min ){
			this.max = max;
			this.min = min;
	}
	
	public int[] generateRandomCandidate(Random rng) {
		int[] puntos = new int[6];	
		for(int i = 0; i<6; i++ ){
			int p =  rng.nextInt(max - min) + min;
			puntos[i] = p;
		}
		return puntos;
	}

}
