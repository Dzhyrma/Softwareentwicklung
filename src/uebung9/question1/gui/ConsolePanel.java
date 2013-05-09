package uebung9.question1.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uebung9.question1.geometry.Circle;
import uebung9.question1.geometry.Rectangle;
import uebung9.question1.geometry.Triangle;
import uebung9.question1.model.Model;
import uebung9.question1.util.Text;

/** ConsolePanel.java
 * 
 * This class represents the console window at the bottom of the frame to enter
 * user commands.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner, Andrii Dzhyrma */
public class ConsolePanel extends JPanel {

	private static final long serialVersionUID = 5788032037315903578L;
	private JTextField commandWindow;
	private JLabel label;

	public ConsolePanel() {
		label = new JLabel("Enter command:");
		commandWindow = new JTextField();
		commandWindow.setPreferredSize(new Dimension(550, 25));
		add(label);
		add(commandWindow);
		Button buttonRefresh = new Button("Execute");
		buttonRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] args = commandWindow.getText().split(" ");
				// call read command method
				readCommand(args);
			}
		});
		add(buttonRefresh);
	}

	/* Checks whether amount of parameter is enough */
	private boolean checkParametersAmount(String[] args, int num) {
		if (args == null || args.length < num) {
			JOptionPane.showMessageDialog(getParent(), "Not enough parameters.",
			    "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/* Parses args for the command "create" */
	private void createGeometry(String[] args) {
		// if it is a circle
		if (args[1].equalsIgnoreCase(Text.CIRCLE)) {
			if (checkParametersAmount(args, 6)) {
				try {
					int posX = Integer.parseInt(args[2]);
					int posY = Integer.parseInt(args[3]);
					double radius = Double.parseDouble(args[4]);
					if (radius <= 0) {
						JOptionPane.showMessageDialog(getParent(),
						    "Radius of the circle should be a postivie number.", "Error",
						    JOptionPane.ERROR_MESSAGE);
						return;
					}
					Color color = parseColor(args[5]);
					if (color == null)
						return;
					Model.instance().add(new Circle(posX, posY, radius, color));
				} catch (NumberFormatException e) {
					showParseErrorMessage();
				}
			}
		} else
		// if it is a rectangle
		if (args[1].equalsIgnoreCase(Text.RECTANGLE)) {
			if (checkParametersAmount(args, 8)) {
				try {
					int posX = Integer.parseInt(args[2]);
					int posY = Integer.parseInt(args[3]);
					double width = Double.parseDouble(args[4]);
					double height = Double.parseDouble(args[5]);
					if (width <= 0 || height <= 0) {
						JOptionPane
						    .showMessageDialog(
						        getParent(),
						        "Width and height of the rectangle should be positive numbers.",
						        "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Color color = parseColor(args[6]);
					if (color == null)
						return;
					boolean isFilled = Boolean.parseBoolean(args[7]);
					Model.instance().add(
					    new Rectangle(posX, posY, width, height, color, isFilled));
				} catch (NumberFormatException e) {
					showParseErrorMessage();
				}
			}
		} else
		// if it is a triangle
		if (args[1].equalsIgnoreCase(Text.TRIANGLE)) {
			if (checkParametersAmount(args, 6)) {
				try {
					int posX = Integer.parseInt(args[2]);
					int posY = Integer.parseInt(args[3]);
					double length = Double.parseDouble(args[4]);
					if (length <= 0) {
						JOptionPane.showMessageDialog(getParent(),
						    "Length of the triangle should be a postivie number.", "Error",
						    JOptionPane.ERROR_MESSAGE);
						return;
					}
					Color color = parseColor(args[5]);
					if (color == null)
						return;
					Model.instance().add(new Triangle(posX, posY, length, color));
				} catch (NumberFormatException e) {
					showParseErrorMessage();
				}
			}
		} else
			// print an error otherwise
			JOptionPane.showMessageDialog(getParent(),
			    "Unknown name of the geometry to crate.\nPlease use one from the follows: ["
			        + Text.CIRCLE + ", " + Text.RECTANGLE + ", " + Text.TRIANGLE
			        + "].", "Error", JOptionPane.INFORMATION_MESSAGE);
	}

	/* Parses args for the command "move" */
	private void moveGeometry(String[] args) {
		if (checkParametersAmount(args, 4)) {
			try {
				int id = Integer.parseInt(args[1]);
				int moveX = Integer.parseInt(args[2]);
				int moveY = Integer.parseInt(args[3]);
				Model.instance().move(id, moveX, moveY);
			} catch (NumberFormatException e) {
				showParseErrorMessage();
			}
		}
	}

	/* Parses color to return a object of type Color */
	private Color parseColor(String colorString) {
		if (colorString.equalsIgnoreCase(Text.BLUE))
			return Color.BLUE;
		if (colorString.equalsIgnoreCase(Text.GREEN))
			return Color.GREEN;
		if (colorString.equalsIgnoreCase(Text.RED))
			return Color.RED;
		if (colorString.equalsIgnoreCase(Text.YELLOW))
			return Color.YELLOW;
		JOptionPane.showMessageDialog(getParent(),
		    "Unknown color.\nPlease use one from the follows: [" + Text.BLUE + ", "
		        + Text.RED + ", " + Text.GREEN + ", " + Text.YELLOW + "].",
		    "Error", JOptionPane.INFORMATION_MESSAGE);
		return null; // return null if the color is not blue, green, red or yellow
	}

	/* Parses args for the commands and call the correspondent methods */
	private void readCommand(String[] args) {
		if (!checkParametersAmount(args, 2))
			return;
		if (args[0].equalsIgnoreCase(Text.CREATE))
			createGeometry(args);
		else if (args[0].equalsIgnoreCase(Text.SCALE))
			scaleGeometry(args);
		else if (args[0].equalsIgnoreCase(Text.MOVE))
			moveGeometry(args);
		else if (args[0].equalsIgnoreCase(Text.REMOVE))
			removeGeometry(args);
		else
			JOptionPane.showMessageDialog(getParent(), "Unknown command.", "Error",
			    JOptionPane.ERROR_MESSAGE);
	}

	/* Parses args for the command "remove" */
	private void removeGeometry(String[] args) {
		if (checkParametersAmount(args, 2)) {
			try {
				int id = Integer.parseInt(args[1]);
				Model.instance().remove(id);
			} catch (NumberFormatException e) {
				showParseErrorMessage();
			}
		}
	}

	/* Parses args for the command "scale" */
	private void scaleGeometry(String[] args) {
		if (checkParametersAmount(args, 3)) {
			try {
				int id = Integer.parseInt(args[1]);
				double scaleFactor = Double.parseDouble(args[2]);
				if (scaleFactor <= 0) {
					JOptionPane.showMessageDialog(getParent(),
					    "Scale factor should be a postivie number.", "Error",
					    JOptionPane.ERROR_MESSAGE);
					return;
				}
				Model.instance().scale(id, scaleFactor);
			} catch (NumberFormatException e) {
				showParseErrorMessage();
			}
		}
	}

	/* Shows an error message about parsing */
	private void showParseErrorMessage() {
		JOptionPane.showMessageDialog(getParent(),
		    "Some numbers were not parsed correctly.", "Error",
		    JOptionPane.ERROR_MESSAGE);
	}
}