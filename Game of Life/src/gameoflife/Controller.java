package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



public class Controller implements ActionListener {

	private View view;
	private Model model;	
	
	public Controller(View v, Model m) {
		view = v;
		model = m;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Cell) {
			Cell c = (Cell)e.getSource();
			model.toggleState(c.getRow(),c.getCol());
		}else if(e.getSource() instanceof JButton) {
			JButton b = (JButton)e.getSource();
			if(b.getText() == "+1") {
				model.nextGeneration();
			}
				
		
			
		}
		
		
		
	}

}
