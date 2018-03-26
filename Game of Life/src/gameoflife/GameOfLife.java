package gameoflife;

import javax.swing.*;
import java.awt.*;



public class GameOfLife{
	
	private static int width = 10;
	private static int height = 10;
	private static char life = '*';
	private static char dead = '.';
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Game of Life");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.setLayout(new BoxLayout(frame,  BoxLayout.Y_AXIS));
		
		//menubar
		JMenuBar menubar = new JMenuBar();
		menubar.setOpaque(true);
		menubar.setPreferredSize(new Dimension(200,20));
		
		//filemenu
		JMenu menu = new JMenu("File");
		menubar.add(menu);
		
		JMenuItem openMenuItem = new JMenuItem("Open...");
		menu.add(openMenuItem);
		frame.setJMenuBar(menubar);
		
		JPanel contentpane = new JPanel(new BorderLayout());
		contentpane.add(new View(30,30), BorderLayout.NORTH);
		contentpane.add(new Controls(), BorderLayout.SOUTH);
		
		frame.add(contentpane);
		//mainview
		//frame.add(new View(30,30));
		
		//controls
		//frame.add(new Controls());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		
		
		/*
		int luku = 0;
		t = new GoL(width, height,life,dead);
		//table.randomize();
		
		t.printTable();
		t.nextGeneration();
		t.printTable();
		t.nextGeneration();
		t.printTable();
		t.nextGeneration();
		t.printTable();
		t.nextGeneration();
		t.printTable();
		*/
	}
}

