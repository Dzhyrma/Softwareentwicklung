package uebung9.question1.model;

import java.util.ArrayList;
import java.util.Vector;

import uebung9.question1.geometry.Geometry;
import uebung9.question1.turtle.Turtle;

/** Model.java
 * 
 * This class maintains a list of all existing geometric shapes and represents
 * the data model.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner, Andrii Dzhyrma */
public class Model {

	private Vector<Geometry> geometries;
	private static Model instance;
	private ArrayList<ModelChangedListener> listeners;

	public static Model instance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	public void add(Geometry g) {
		geometries.add(g);
		refreshPanel();
		fireModelChanged();
	}

	public void addModelChangedListener(ModelChangedListener l) {
		listeners.add(l);
	}

	private void fireModelChanged() {
		for (ModelChangedListener l : listeners) {
			l.modelChanged();
		}
		System.out.println(geometries);
	}

	private Model() {
		geometries = new Vector<Geometry>();
		listeners = new ArrayList<ModelChangedListener>();
	}

	public void createGui() {
		Turtle.showGraphics("Drawing Panel");
	}

	public Vector<Geometry> getGeometries() {
		return geometries;
	}

	public void remove(int id) {
		// search for the geometry with the given id and remove it
		int i = 0;
		for (; i < geometries.size(); i++)
			if (geometries.get(i).getId() == id) {
				geometries.remove(i);
				break;
			}
		// do not refresh panel if nothing was removed
		if (i == geometries.size())
			return;
		// --- do not change source code below this line ---
		refreshPanel(); // refresh panel only if scaling was successful
		fireModelChanged(); // refresh tree view only if moving was successful
	}

	private void refreshPanel() {
		Turtle.erase();
		// --- do not change source code above this line ---
		// paint all the geometries
		for (Geometry g : geometries)
			g.paint();
		// --- do not change source code below this line ---
		Turtle.showGraphics("Drawing Panel");
	}

	public void scale(int id, double factor) {
		// search for the geometry with the given id and scale it
		int i = 0;
		for (; i < geometries.size(); i++)
			if (geometries.get(i).getId() == id) {
				geometries.get(i).scale(factor);
				break;
			}
		// do not refresh panel if nothing was scaled
		if (i == geometries.size())
			return;
		// --- do not change source code below this line ---
		refreshPanel(); // refresh panel only if scaling was successful
	}

	public void move(int id, int moveX, int moveY) {
		int i = 0;
	// search for the geometry with the given id and move it
		for (; i < geometries.size(); i++)
			if (geometries.get(i).getId() == id) {
				geometries.get(i).move(moveX, moveY);
				break;
			}
		// do not refresh panel if nothing was moved
		if (i == geometries.size())
			return;
		// --- do not change source code below this line ---
		refreshPanel(); // refresh panel only if scaling was successful
		fireModelChanged(); // refresh tree view only if moving was successful
	}
}