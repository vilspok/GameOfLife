package gameoflife;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JPanel implements ActionListener{

	private Cell[][] cells;
	private Dimension viewSize;
		
	public View(int width, int height){
		viewSize = new Dimension(width,height);
		setLayout(new GridLayout(viewSize.height,viewSize.width));
		
		cells = new Cell[viewSize.height][viewSize.width];
		
		for (int i  = 0; i < viewSize.height; i++) {
			for (int j = 0; j < viewSize.width; j++) {
				Random random = new Random();
				int randomInt = random.nextInt(100);
				if(randomInt < 26) {
					cells[i][j] = new Cell(i,j,1);
				}
				else {
					cells[i][j] = new Cell(i,j,0);
				}
				cells[i][j].addActionListener(this);
				add(cells[i][j]);
			}
		}
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Cell c = (Cell)e.getSource();
		if(c.getLifeState() == 1)
		{
			c.setLifeState(0);
		} else {
			c.setLifeState(1);
		}
	}

}
