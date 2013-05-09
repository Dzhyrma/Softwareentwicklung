package uebung9.question1.geometry;

import java.awt.Color;

/** Geometry.java
 * 
 * This abstract class provides useful methods for an arbitrary geometry object
 * like painting, moving and scaling.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner, Andrii Dzhyrma */
public abstract class Geometry {

	/** Paints current geometry on the screen. */
	public abstract void paint();

	private static final String TO_STRING_FORMAT_STRING = "[%d] %s: posX=%d, posY=%d";
	// static id parameter which increases when new geometry was initialized
	private static int uniqueId = 100;
	// id of the current geometry
	private final int id;
	// color of the current geometry
	protected final Color color;
	// coordinates
	protected int posX;
	protected int posY;
	// scale factor for the scaling
	protected double scaleFactor = 1;

	/** Initializes a geometry.
	 * 
	 * @param posX - the minimal X coordinate of the geometry
	 * @param posY - the minimal Y coordinate of the geometry
	 * @param color - the color of the geometry */
	public Geometry(int posX, int posY, Color color) {
		this.id = Geometry.uniqueId++;
		this.color = color;
		this.posX = posX;
		this.posY = posY;
	}

	/** Returns the id of the current geometry.
	 * 
	 * @return the identification number */
	public final int getId() {
		return id;
	}

	/** Moves the current geometry by given coordinates.
	 * 
	 * @param x - the X offset
	 * @param y - the Y offset */
	public void move(int x, int y) {
		posX += x;
		posY += y;
	}

	/** Scales the current geometry by the given scale factor.
	 * 
	 * @param factor - the scale factor */
	public void scale(double factor) {
		scaleFactor *= factor;
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT_STRING, id, this.getClass().getSimpleName(), posX, posY);
	}
}