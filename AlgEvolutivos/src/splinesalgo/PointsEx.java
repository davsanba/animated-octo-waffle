package splinesalgo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.CandidateFactory;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.factories.NumbreFactory;
import org.uncommons.watchmaker.framework.factories.StringFactory;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.operators.IntArrayCrossover;
import org.uncommons.watchmaker.framework.operators.StringCrossover;
import org.uncommons.watchmaker.framework.operators.StringMutation;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.GenerationCount;
import org.uncommons.watchmaker.framework.termination.TargetFitness;


/**
 *
 * @author Alfr3
 */
public class PointsEx extends JFrame{
    Surface surface;
    JPanel holder;
    JPanel buttons;
    public PointsEx() {
        initUI();
    }

    private void initUI() {
        /*final JFrame frame = new JFrame(PointsEx.class.getSimpleName());*/
        //frame.
          
        //frame.
              
        holder = new JPanel();
        //holder.setLayout(new BoxLayout(holder, BoxLayout.PAGE_AXIS));
        holder.setLayout(new BorderLayout(50,50));
        
        
        JButton calc =  new JButton("Calcular");
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcBezier();
            }
        });
        buttons = new JPanel();
        
        buttons.add(calc);
        buttons.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        buttons.setSize(new Dimension(100,50));
        holder.add(buttons);
        
        
        surface = new Surface();
        //surface.setPreferredSize(new Dimension(100, 100));
        //add(surface);
        holder.add(surface);
        add(holder);
        setTitle("Points");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
        
        
        surface.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    
                }
                public void mouseEntered(MouseEvent evt) {
                    
                }
                public void mouseExited(MouseEvent evt) {
                    
                }
                public void mousePressed(MouseEvent evt) {
                    addPoint(evt);
                }
                public void mouseReleased(MouseEvent evt) {
                    
                }
            });
    }

    public void calcBezier(){
    	
    	CandidateFactory<int[]> factory = new NumbreFactory(2000, -2000);
    	NumberGenerator numGen = new NumberGenerator();
    	/* char[] chars = new char[27];
        for (char c = 'A'; c <= 'Z'; c++)
        {
            chars[c - 'A'] = c;
        }
        chars[26] = ' ';
        */
        //Factory for random 11-char Strings
        //CandidateFactory<String> agsdg = new StringFactory(chars, 11);
        //extend AbstractCandidateFactory 
        
        //operators.add(new StringMutation(chars, new Probability(0.02)));
        
    	
        EvolutionaryOperator<int[]> pipeline = new IntMutation();
        
        
        EvolutionEngine<int[]> engine = new GenerationalEvolutionEngine<>(
     	       /*candidateFactory*/ factory,
     	       /*evolutionaryOperator*/ pipeline,
     	       /*fitnessEvaluator*/ new CoeficienteEvaluator(surface.puntos),
     	       /*selectionStrategy*/ new RouletteWheelSelection(),
     	       /*rng*/ new MersenneTwisterRNG()
     	 );
        
        //
        
        //ElapsedTime
        //int[] result = engine.evolve(100, 3, new TargetFitness(1000, false));
        //Stagnation 
        int[] result = engine.evolve(100, 4, new GenerationCount(100));
		for(int i = 0; i<6;i++){
			System.out.println("Resultado -->"+result[i]);
		}
		
		surface.drawBezier(result[0],result[1],result[2],result[3],result[4],result[5]);
		holder.repaint();
    }
    public void addPoint(MouseEvent e){
        surface.setNextPoint(new Point(e.getX(), e.getY() ));
        holder.repaint();
    }
    
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PointsEx ex = new PointsEx();
                
                ex.setVisible(true);
            }
        });
    }

   
}
