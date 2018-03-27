package gameoflife;

import javax.swing.*;
import java.awt.*;



public class GameOfLife{
	
	
	
	private static void createAndShowGUI() {
		new View();
	}
	
	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		
		
	}
}

