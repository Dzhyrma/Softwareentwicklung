package uebung10.question1;

import io.Input;

public class Main {

	// array to store visited cells
	private static int[][] visited;

	/** @param args - no arguments will evaluate */
	public static void main(String[] args) {
		// if the maze is invalid, do nothing
		if (Position.MAZE == null || Position.MAZE.length == 0) {
			System.out.println("The Maze is empty!");
			return;
		}
		// initialize the array for visited states
		visited = new int[Position.MAZE.length][];
		for (int i = 0; i < visited.length; i++)
			visited[i] = new int[Position.MAZE[i].length];
		// print the maze on the screen
		System.out.println("The Maze");
		for (int i = 0; i < Position.MAZE[0].length + 2; i++)
			System.out.print('-');
		System.out.println();
		for (int i = 0; i < Position.MAZE.length; i++) {
			String line = String.copyValueOf(Position.MAZE[i]);
			System.out.println('|' + line + '|');
		}
		for (int i = 0; i < Position.MAZE[Position.MAZE.length - 1].length + 2; i++)
			System.out.print('-');
		// read coordinates for start and destination points
		int x, y;
		System.out.println();
		System.out.print("Find a passage from start [x]: ");
		x = Input.readInt();
		System.out.print("Find a passage from start [y]: ");
		y = Input.readInt();
		Position start = new Position(x, y);
		System.out.print("To destination [x]: ");
		x = Input.readInt();
		System.out.print("To destination [y]: ");
		y = Input.readInt();
		Position destination = new Position(x, y);

		// if a passage exists do next
		if (findPassage(start, destination)) {
			System.out.println("A passage from [" + start.getX() + "," + start.getY()
			    + "] to [" + destination.getX() + "," + destination.getY()
			    + "] could be found!");
			// print the maze with the passage
			System.out.println("The passage through the maze is:");
			for (int i = 0; i < Position.MAZE[0].length + 2; i++)
				System.out.print('-');
			System.out.println();
			for (int i = 0; i < Position.MAZE.length; i++) {
				String line = "";
				for (int j = 0; j < Position.MAZE[i].length; j++)
					line += (visited[i][j] == 1) ? '+' : Position.MAZE[i][j];
				System.out.println('|' + line + '|');
			}
			for (int i = 0; i < Position.MAZE[Position.MAZE.length - 1].length + 2; i++)
				System.out.print('-');
		} else {
			// no passage was found
			System.out.println("A passage from [" + start.getX() + "," + start.getY()
			    + "] to [" + destination.getX() + "," + destination.getY()
			    + "] could not be found!");
		}
	}

	/** Finds a passage from the start position to the destination position.
	 * 
	 * @param start - the start position
	 * @param destination - the destination position
	 * @return - return true is the passage was found */
	public static boolean findPassage(Position start, Position destination) {
		// if blocked, out of bounds, start position is on the right side of the
		// destination or visited, return false
		if (destination.blocked() || destination.outOfBounds() || start.blocked()
		    || start.outOfBounds() || start.getX() > destination.getX()
		    || visited[start.getY()][start.getX()] > 0)
			return false;
		// mark as visited
		visited[start.getY()][start.getX()] = 2;
		boolean result = start.getX() == destination.getX()
		    && start.getY() == destination.getY()
		    || findPassage(start.right(), destination)
		    || findPassage(start.down(), destination)
		    || findPassage(start.up(), destination);
		// mark as correct path
		if (result)
			visited[start.getY()][start.getX()] = 1;
		return result;
	}
}
