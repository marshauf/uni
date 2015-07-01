package de.hsrm.cs.oose13;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;

public class ScenePanel extends JPanel {
	
	private final CollisionScene scene;
	private final Timer timer;
	
	public ScenePanel(final CollisionScene scene) {
		this.scene = scene;
		timer = new Timer((int)(1000 / 36), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene.move();
				scene.collisions();
				repaint();
			}
		});
		timer.start();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(scene.getWidth(), scene.getHeight());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		scene.paintAll(g);
	}

	public boolean isRunning() {
		return timer.isRunning();
	}
	
	public void toggleTimer() {
		if (timer.isRunning()) {
			timer.stop();
			return;
		}
		timer.start();
	}
}
