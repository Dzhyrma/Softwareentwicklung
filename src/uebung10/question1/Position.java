package uebung10.question1;

/** The Position class gives possibility to go through the maze and check whether
 * a path is blocked or a position is out of bounds.
 * 
 * @author Andrii Dzhyrma */
public class Position {
	/** The maze */
	public static final char[][] MAZE = {
	    { '_', '_', '_', '_', '_', '_', '_', '_', '#', '_', '_', '_' },
	    { '_', '_', '_', '_', '_', '_', '_', '_', '#', '#', '_', '_' },
	    { '_', '_', '_', '_', '_', '_', '_', '_', '#', '_', '_', '_' },
	    { '_', '_', '_', '_', '_', '_', '_', '_', '#', '_', '#', '_' },
	    { '_', '#', '#', '#', '_', '_', '_', '_', '#', '_', '#', '_' },
	    { '_', '#', '_', '#', '_', '_', '#', '_', '_', '_', '#', '_' },
	    { '_', '#', '#', '#', '_', '_', '#', '_', '_', '_', '_', '_' },
	    { '_', '_', '_', '_', '_', '_', '_', '_', '#', '#', '#', '_' },
	    { '_', '_', '_', '_', '_', '#', '_', '_', '_', '_', '_', '_' } };
	private final boolean isBlocked;
	private final boolean isOutOfBounds;
	private final int x;
	private final int y;

	/** Initializes the position.
	 * 
	 * @param x - the X coordinate
	 * @param y - the Y coordinate */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		// checks for the blocked cell and is it out of bounds
		isOutOfBounds = y < 0 || y >= MAZE.length || x < 0 || x >= MAZE[y].length;
		isBlocked = !isOutOfBounds && MAZE[y][x] == '#';
	}

	/** @return is current cell blocked. */
	public boolean blocked() {
		return isBlocked;
	}

	/** @return the cell with Y coordinate greater by one. */
	public Position down() {
		return new Position(x, y + 1);
	}

	/** @return the X coordinate. */
	public final int getX() {
		return this.x;
	}

	/** @return the Y coordinate. */
	public final int getY() {
		return this.y;
	}

	/** @return the cell with X coordinate less by one. */
	public Position left() {
		return new Position(x - 1, y);
	}

	/** @return true if current cell is out of bounds. */
	public boolean outOfBounds() {
		return isOutOfBounds;
	}

	/** @return the cell with X coordinate greater by one. */
	public Position right() {
		return new Position(x + 1, y);
	}

	/** @return the cell with Y coordinate less by one. */
	public Position up() {
		return new Position(x, y - 1);
	}
}
