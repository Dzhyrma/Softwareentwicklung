package uebung9.question1.gui;

import uebung9.question1.geometry.Geometry;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import uebung9.question1.model.Model;
import uebung9.question1.model.ModelChangedListener;

/**
 * TreePanel.java
 * 
 * This class provides the tree view of the existing geometric shapes.
 * 
 * Institute for Pervasive Computing Johannes Kepler University Linz, Austria
 * http://www.pervasive.jku.at
 * 
 * Copyright (c) 2013 IPC
 * 
 * @author Thomas Schmittner
 * 
 */
public class TreePanel extends JPanel implements ModelChangedListener {

	private static final long serialVersionUID = -5555791111661307939L;
	private static final int DEFAULT_WIDTH = 277;
	private static final int DEFAULT_HEIGHT = 303;
	private Model model;
	private JTree tree;
	private DefaultMutableTreeNode root;

	public TreePanel() {
		root = new DefaultMutableTreeNode("Geometries");
		tree = new JTree(root);
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		scrollPane
				.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		add(scrollPane);
		model = Model.instance();
		model.addModelChangedListener(this);
	}

	@Override
	public void modelChanged() {
		root.removeAllChildren();
		for (Geometry g : model.getGeometries()) {
			root.add(new DefaultMutableTreeNode(g));
		}
		tree.expandPath(new TreePath(root.getPath()));
		tree.updateUI();
	}
}