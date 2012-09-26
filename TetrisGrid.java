//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

	private Grid g;
	
	private class Grid {
		private boolean[][] grid;
		private int width;
		private int height;
		
		public Grid(boolean[][] grid) {
			this.grid = grid;
			width = grid.length;
			height = (width == 0) ? 0 : grid[0].length; 
		}
	}
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		g = new Grid(grid);
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int curr = 0;
		for(int i = 0; i < g.height; i++) {
			if(!checkRow(i)) {
				if(curr != i) copyRow(curr, i);
				curr++;
			}
		}
		for(int i = curr; i < g.height; i++) {
			copyRow(i, g.height);
		}
	}
	
	private boolean checkRow(int row) { 
		for(int i = 0; i < g.width; i++) {
			if(!g.grid[i][row]) { 
				return false;
			}
		}
		return true;
	}
	
	private void copyRow(int dest, int src) {
		for(int i = 0; i < g.width; i++) {
			g.grid[i][dest] = (src < g.height) ? g.grid[i][src] : false;  
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return g.grid;
	}
}
