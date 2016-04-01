package splinesalgo;
import java.awt.Point;
import java.util.List;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

public class CoeficienteEvaluator implements FitnessEvaluator<int[]> {
	double ax, ay, bx, by, cx, cy;
	double dax, day, dbx, dby, dcx, dcy;
	
	public CoeficienteEvaluator(Point[] puntos) {
		 cx = (double) (3.0 * (puntos[1].x - puntos[0].x));
	     bx = (double) (3.0 * (puntos[2].x - puntos[1].x) - cx);
	     ax = puntos[3].x - puntos[0].x - cx - bx;

	     cy = (double) (3.0 * (puntos[1].y - puntos[0].y));
	     by = (double) (3.0 * (puntos[2].y - puntos[1].y) - cy);
	     ay = puntos[3].y - puntos[0].y - cy - by;
	}

	@Override
	public boolean isNatural() {
		return false;
	}

	@Override
	public double getFitness(int[] candidate, List<? extends int[]> population) {

		dax = Math.pow(candidate[0]-ax,2);
		dbx = Math.pow(candidate[2]-bx,2);
		day = Math.pow(candidate[1]-ay,2);
		dby = Math.pow(candidate[3]-by,2);
		dcx = Math.pow(candidate[4]-cx,2);
		dcy = Math.pow(candidate[5]-cy,2);
		
		//System.out.println(dax + ", " + day + ", " + dbx + ", " + dby + ", " + dcx + ", " + dcy);
		
		return dax+day+dbx+dby+dcx+dcy;
	}

}
