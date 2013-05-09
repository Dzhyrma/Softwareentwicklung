package uebung9.question1.geometry;

import java.awt.Color;

import uebung9.question1.turtle.Turtle;

/** Circle.java
 * 
 * This class provides the basic functionality to draw a circle.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner, Andrii Dzhyrma */
public class Circle extends Geometry {

	private double radius;

	/** Initializes a circle.
	 * 
	 * @param posX - the minimal X coordinate of the circle
	 * @param posY - the minimal Y coordinate of the circle
	 * @param radius - the radius of the circle
	 * @param color - the color of the circle */
	public Circle(int posX, int posY, double radius, Color color) {
		super(posX, posY, color);
		this.radius = Math.abs(radius);
	}

	@Override
	public void paint() {
		Turtle.setColor(color);
		// calculate scaled radius
		double scaledRadius = radius * scaleFactor;
		// if radius is less then 0.5, put just a dot
		if (scaledRadius < 0.5) {
			Turtle.setPos(posX, posY);
			Turtle.forward(0);
			return;
		}
		int max = 180;
		double side = 2.0 * Math.PI * scaledRadius / max;
		int angle = 360 / max;
		// if side is less than 2, choos bigger angle
		if (side < 2) {
			angle = (int) Math.round(2 * angle / side);
			while (90 % angle != 0)
				angle--;
			max = 360 / angle;
			side = side / 2 * angle;
		}
		// put turtle on the first position
		Turtle.setPos((int) Math.round(posX - side / 2.0 + scaledRadius), posY);
		Turtle.setAngle(0);
		// draw a circle
		for (int i = 0; i < max; i++) {
			Turtle.forward(side);
			Turtle.left(angle);
		}

	}
}