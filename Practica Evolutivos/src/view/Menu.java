package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Menu extends JPanel  {
	private JTextField poblacionInicial;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField numGen;
	private JTextField tFitness;
	private JTextField elitismo;
	private JCheckBox proceso;
	private JTextField textProb;
	
	/**
	 * Create the panel.
	 */
	public Menu() {
		
		poblacionInicial = new JTextField();
		poblacionInicial.setText("100");
		poblacionInicial.setBounds(116, 55, 74, 20);
		poblacionInicial.setColumns(10);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(35, 11, 130, 14);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 180, 2);
		
		JLabel lblNewLabel = new JLabel("Poblacion Inicial");
		lblNewLabel.setBounds(10, 58, 122, 14);
		
		JRadioButton rdbtnGeneraciones = new JRadioButton("Generaciones");
		rdbtnGeneraciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tFitness.setEnabled(false);
			numGen.setEnabled(true);	
			}
		});
		buttonGroup.add(rdbtnGeneraciones);
		rdbtnGeneraciones.setSelected(true);
		rdbtnGeneraciones.setBounds(10, 89, 180, 23);
		rdbtnGeneraciones.setMnemonic('1');
		
		JRadioButton rdbtnFitness = new JRadioButton("Fitness");
		rdbtnFitness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFitness.setEnabled(true);
				numGen.setEnabled(false);	
			}
		});
		rdbtnFitness.setBounds(10, 115, 180, 23);
		rdbtnFitness.setMnemonic('2');
		buttonGroup.add(rdbtnFitness);
		setLayout(null);
		add(lblMenu);
		add(separator);
		add(poblacionInicial);
		add(rdbtnGeneraciones);
		add(lblNewLabel);
		add(rdbtnFitness);
		
		JLabel lblNum = new JLabel("Num Generaciones");
		lblNum.setBounds(10, 160, 130, 14);
		add(lblNum);
		
		numGen = new JTextField();
		numGen.setText("10");
		numGen.setColumns(10);
		numGen.setBounds(140, 157, 50, 20);
		add(numGen);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 145, 180, 1);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 296, 180, 1);
		add(separator_2);
		
		JLabel lblTargetFitness = new JLabel("Target Fitness");
		lblTargetFitness.setBounds(10, 234, 130, 14);
		add(lblTargetFitness);
		
		tFitness = new JTextField();
		tFitness.setColumns(10);
		tFitness.setEnabled(false);
		tFitness.setBounds(140, 231, 50, 20);
		add(tFitness);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 259, 180, 1);
		add(separator_3);
		
		JLabel lblElitismo = new JLabel("Elitismo");
		lblElitismo.setBounds(10, 271, 46, 14);
		add(lblElitismo);
		
		elitismo = new JTextField();
		elitismo.setText("2");
		elitismo.setColumns(10);
		elitismo.setBounds(140, 265, 50, 20);
		add(elitismo);
		
		proceso = new JCheckBox("Mostrar proceso");
		proceso.setSelected(true);
		proceso.setBounds(10, 304, 180, 23);
		add(proceso);
		
		textProb = new JTextField();
		textProb.setText("0.3");
		textProb.setColumns(10);
		textProb.setBounds(140, 189, 50, 20);
		add(textProb);
		
		JLabel lblProbabilidad = new JLabel("Probabilidad");
		lblProbabilidad.setBounds(10, 192, 130, 14);
		add(lblProbabilidad);
		
	}

	public String getPoblacionInicial() {
		return poblacionInicial.getText();
	}

	public String getNumGen() {
		return numGen.getText();
	}

	public String gettFitness() {
		return tFitness.getText();
	}
	public String getProb() {
		return textProb.getText();
	}

	public String getElitismo() {
		return elitismo.getText();
	}

	public boolean getProceso() {
		return proceso.isSelected();
	}

	public char Activo() {
		return (char) buttonGroup.getSelection().getMnemonic();
	}
}
