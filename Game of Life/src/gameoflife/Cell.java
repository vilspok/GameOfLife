package gameoflife;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JButton;

public class Cell extends JButton {

	private int lifeState;
	private int row, col;
	
	Cell(int row, int col, int l) {
		setPreferredSize(new Dimension(10, 10));
		//setMargin(new Insets(1,1,1,1));
		
		this.row = row;
		this.col = col;
		this.setLifeState(l);
	}
	
	public int getLifeState() {
		return lifeState;
	}
	
	public void setLifeState(int l){
		lifeState = l;
		if(lifeState == 1) { this.setBackground(new Color(0,0,0)); } //live cells turn black
		else { this.setBackground(new Color(255,255,255)); } //dead cells turn white
	}
	
	public boolean isAlive() {
		if(lifeState == 1) { return true; }
		return false;
	}
	
}
