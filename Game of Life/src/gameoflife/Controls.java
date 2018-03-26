package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Controls extends JPanel implements ActionListener{
	
	private JButton playButton,stepButton,fiveStepButton;

	public Controls() {
		
		//setOpaque(true);
		
		playButton = new JButton(">");
		playButton.addActionListener(this);
		stepButton = new JButton("->");
		stepButton.addActionListener(this);
		fiveStepButton = new JButton("--->");
		fiveStepButton.addActionListener(this);
		
		
		add(playButton);
		add(stepButton);
		add(fiveStepButton);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button == playButton)
		{
			if(button.getText() == ">") {
				button.setText("II");
			}else {
				button.setText(">");
			}
		}else if(button == stepButton){
			//TODO stepbutton-click
			
		}else if(button == fiveStepButton){
			//TODO fivestepbutton-click
		}
	}
	
	
}
