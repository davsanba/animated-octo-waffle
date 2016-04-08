package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.App;
import model.*;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow  {

	private JFrame frame;
	private Surface surface;
	private Menu menu;
	private Grid grid;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		grid = new Grid();
		menu = new Menu();
		
		frame.setBounds(100, 100, 634, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        grid.setBounds(200,0,420,420);
        frame.getContentPane().add(grid);
        
        menu.setBounds(0, 0, 200, 340);
		frame.getContentPane().add(menu);
		
		JButton iniciar = new JButton("Iniciar");
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamar();
			}
		});
		iniciar.setBounds(55, 351, 90, 30);
		frame.getContentPane().add(iniciar);
	}

	protected void llamar() {
		int dato;
		int pobInicial = Integer.parseInt(menu.getPoblacionInicial());
		char modo = menu.Activo();
		int elitismo = Integer.parseInt(menu.getElitismo());
		boolean mostrar = menu.getProceso();
		double prob = Double.parseDouble(menu.getProb());
		if(modo == '1'){
			dato = Integer.parseInt(menu.getNumGen());
		}else{
			dato = Integer.parseInt(menu.gettFitness());
		}
		App.getInstance().evolve(pobInicial,modo,dato,elitismo, mostrar, prob);
	}

	public void draw(List<PuntoColor> list) {
		grid.fillCell(list);
	}
}
