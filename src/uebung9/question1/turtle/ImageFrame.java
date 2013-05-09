package uebung9.question1.turtle;

import uebung9.question1.gui.ConsolePanel;
import uebung9.question1.gui.ImagePanel;
import uebung9.question1.gui.TreePanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;

/**
 * ImageFrame.java
 * 
 * This class represents the main frame of the application.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner
 * 
 */
public class ImageFrame extends JFrame {
	private static final long serialVersionUID = -3961613485615270343L;

	private ImagePanel imagePanel;
	private TreePanel treePanel;
	private ConsolePanel consolePanel;

	public ImageFrame(Image image) {
		setLayout(new BorderLayout());
		treePanel = new TreePanel();
		imagePanel = new ImagePanel(image);
		consolePanel = new ConsolePanel();

		add(imagePanel, BorderLayout.CENTER);
		add(treePanel, BorderLayout.WEST);
		add(consolePanel, BorderLayout.SOUTH);
		setResizable(false);
		setLocation(300, 200);
		setSize(800, 370);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setCanvasSize(int width, int height) {
		imagePanel.setPreferredSize(new Dimension(width, height));
	}

	public void updateImage(Image image) {
		imagePanel.updateImage(image);
		imagePanel.repaint();
	}
}