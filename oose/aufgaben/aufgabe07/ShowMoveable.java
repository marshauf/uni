package de.hsrm.cs.oose13;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ShowMoveable extends JPanel {
	MoveAndPaintable mvpt;
	Timer t;
	
	public ShowMoveable(MoveAndPaintable mvpt) {
		this.mvpt = mvpt;
		t = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				move();
				repaint();
			}
		});
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		mvpt.paintMeTo(g);
	}

	public void move() {
		mvpt.move();
	}
	
	
	public void show() {
		JFrame f = new JFrame();
		f.add(this);
		f.pack();
		f.setVisible(true);
		//f.start(); // deprecated
	}
}

