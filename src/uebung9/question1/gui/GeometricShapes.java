package uebung9.question1.gui;

import uebung9.question1.model.Model;

/**
 * GeometricShapes.java
 * 
 * This class contains the main method and starts the program.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner
 * 
 */
public class GeometricShapes {

	public static void main(String[] args) {
		Model model = Model.instance();
		model.createGui();
	}
}