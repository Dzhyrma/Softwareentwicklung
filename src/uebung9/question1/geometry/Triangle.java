package uebung9.question1.geometry;

import java.awt.Color;

import uebung9.question1.turtle.Turtle;

/** Triangle.java
 * 
 * This class provides the basic functionality to draw a equilateral triangle.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner, Andrii Dzhyrma */
public class Triangle extends Geometry {

	private double length;

	/** Initializes a triangle.
	 * 
	 * @param posX - the minimal X coordinate of the triangle
	 * @param posY - the minimal Y coordinate of the triangle
	 * @param length - the side size of the triangle
	 * @param color - the color of the triangle */
	public Triangle(int posX, int posY, double length, Color color) {
		super(posX, posY, color);
		this.length = length;
	}

	@Override
	public void paint() {
		// calculate a scaled side length
		double newLength = length * scaleFactor;
		// draw the triangle
		Turtle.setColor(color);
		Turtle.setAngle(0);
		Turtle.setPos(posX, posY);
		Turtle.forward(newLength);
		Turtle.left(120);
		Turtle.forward(newLength);
		Turtle.left(120);
		Turtle.forward(newLength);
	}
}