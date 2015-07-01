package de.hsrm.cs.oose13;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;

public class StartStopScenePanel extends JPanel {
	
	ScenePanel panel;
	JButton toggleButton;
	
	private static final String toggleActionCommand = "TOGGLE";
	
	public StartStopScenePanel(final CollisionScene scene) {
		panel = new ScenePanel(scene);
		toggleButton = new JButton("Stop");
		toggleButton.setActionCommand(toggleActionCommand);
		toggleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				switch(cmd) {
				case toggleActionCommand:					
					panel.toggleTimer();
					if (panel.isRunning()) {
						toggleButton.setText("Stop");
					} else {
						toggleButton.setText("Start");
					}
				}
			}
		});
		add(panel);
		add(toggleButton);
	}
}
