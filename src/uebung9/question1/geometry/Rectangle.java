package uebung9.question1.geometry;

import java.awt.Color;

import uebung9.question1.turtle.Turtle;

/** Rectangle.java
 * 
 * This class provides the basic functionality to draw a rectangle.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner, Andrii Dzhyrma */
public class Rectangle extends Geometry {

	private double width;
	private double height;
	private boolean isFilled;

	/** Initializes a rectangle.
	 * 
	 * @param posX - the minimal X coordinate of the rectangle
	 * @param posY - the minimal Y coordinate of the rectangle
	 * @param width - the width of the rectangle
	 * @param height - the height of the rectangle
	 * @param color - the color of the rectangle
	 * @param isFilled - if true the rectangle fills */
	public Rectangle(int posX, int posY, double width, double height,
	    Color color, boolean isFilled) {
		super(posX, posY, color);
		this.width = width;
		this.height = height;
		this.isFilled = isFilled;
	}

	@Override
	public void paint() {
		// calculate scaled sides
		double newWidth = width * scaleFactor;
		double newHeight = height * scaleFactor;
		Turtle.setColor(color);
		Turtle.setAngle(0);
		// if isFilled is true, in loop draw height amount of lines
		if (isFilled) {
			int maxPosY = posY + (int) newHeight;
			for (int y = posY; y < maxPosY; y++) {
				Turtle.setPos(posX, y);
				Turtle.forward(newWidth);
			}
			return;
		}
		// otherwise just draw borders of the rectangle
		Turtle.setPos(posX, posY);
		Turtle.forward(newWidth);
		Turtle.left(90);
		Turtle.forward(newHeight);
		Turtle.left(90);
		Turtle.forward(newWidth);
		Turtle.left(90);
		Turtle.forward(newHeight);
	}
}