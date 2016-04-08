package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import model.PuntoColor;

public class Grid extends JPanel {
	
	private List<PuntoColor> fillCells;
    public Grid() {
        fillCells = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuntoColor fillCell : fillCells) {
            int cellX = 10 + (fillCell.getX() * 40);
            int cellY = 10 + (fillCell.getY() * 40);
            g.setColor(colorDict.get(fillCell.getColor()));
            g.fillRect(cellX, cellY, 40, 40);
        }
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 400, 400);

        for (int i = 10; i <= 410; i += 40) {
            g.drawLine(i, 10, i, 410);
        }

        for (int i = 10; i <= 410; i += 40) {
            g.drawLine(10, i, 410, i);
        }
    }

    public void fillCell(int x, int y, int c) {
        fillCells.add(new PuntoColor(x, y, c));
        repaint();
    }
    
    public void fillCell(List<PuntoColor> lista){
    	fillCells = lista;
    	repaint();
    }
    
    public static Map<Integer, Color> colorDict = new HashMap<Integer, Color>() {
        {
        	put(0,Color.YELLOW);
            put(1,Color.BLACK);
            put(2,Color.BLUE);
            put(3,Color.CYAN);
            put(4,Color.LIGHT_GRAY);
            put(5,Color.GREEN);
            put(6,Color.MAGENTA);
            put(7,Color.ORANGE);
            put(8,Color.PINK);
            put(9,Color.RED);
        };
    };
    	
}
