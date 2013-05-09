package uebung9.question1.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * ImagePanel.java
 * 
 * This class contains the image showing different geometric shapes.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner
 * 
 */
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 2481133924901847011L;

	private Image image;

	public ImagePanel(Image image) {
		this.image = image;
		setBorder(new CompoundBorder(new EmptyBorder(5, 0, getHeight(), 5),
				new LineBorder(Color.BLACK)));
	}

	public void updateImage(Image image) {
		this.image = image;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 1, 6, this);
	}
}
