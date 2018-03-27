package gameoflife;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel implements ActionListener{

	private Cell[][] cells;
	private Model model;
	private Controller controller;
	
	private JButton playButton,stepButton,fiveStepButton;
	
	private final int width = 30;
	private final int height = 30;
		
	public View(){
		
		model = new Model(height,width,this);
		controller = new Controller(this,model);
		
		this.setLayout(new BorderLayout());
		//main area
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(height, width));
		this.add(mainPanel,BorderLayout.NORTH);
		//setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
				
		cells = new Cell[height][width];
		
		//get states for cells from model
		for (int i  = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j] = new Cell(i,j,model.getState(i, j));
				cells[i][j].addActionListener(controller);
				mainPanel.add(cells[i][j]);
			}
		}
		
		//bottom controls-area
		JPanel ctrlPanel = new JPanel();
		ctrlPanel.setLayout(new BoxLayout(ctrlPanel, BoxLayout.X_AXIS));
		this.add(ctrlPanel,BorderLayout.SOUTH);
		
		playButton = new JButton(">");
		playButton.addActionListener(controller);
		stepButton = new JButton("+1");
		stepButton.addActionListener(controller);
		fiveStepButton = new JButton("+5");
		fiveStepButton.addActionListener(controller);
		
		ctrlPanel.add(playButton);
		ctrlPanel.add(stepButton);
		ctrlPanel.add(fiveStepButton);
		
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		frame.add(this);
		//frame.add(new Controls(), BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		setVisible(true);
	}
	
	//update cell states from data
	public void updateView(){
		for (int i  = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j].setLifeState(model.getState(i,j));
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
