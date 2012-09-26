// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	
	private class Grid {
		private char[][] grid;
		private int width;
		private int height;
		
		public Grid(char[][] grid) {
			this.grid = grid;
			height = grid.length;
			width = (height == 0) ? 0 : grid[0].length; 
		}
	}
	
	private Grid g;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		g = new Grid(grid);
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		if(g.height == 0) return 0;
		int left = g.width, right = -1, up = g.height, down = -1;
		for(int i = 0; i < g.height; i++) {
			for(int j = 0; j < g.width; j++) {
				if(g.grid[i][j] == ch) {
					if(j < left) left = j;
					if(j > right) right = j;
					if(i < up) up = i;
					if(i > down) down = i;
				}
			}
		}
		if(right == -1) return 0;
		else return (right - left + 1) * (down - up + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count = 0;
		for(int i = 2; i < g.height - 2; i++) {
			char ch = g.grid[i][0];
			int size = 1;
			for(int j = 1; j < g.width; j++) {
				char next = g.grid[i][j];
				if(next == ch) size++;
				else {
					if(checkPlus(i, j - size / 2 - 1, ch, size)) {
						count++;
					}
					ch = next;
					size = 1;
				}
			}
			if(checkPlus(i, g.width - size / 2 - 1, ch, size)) {
				count++;		
			}
		}
		return count;
	}
	
	private boolean checkPlus(int row, int col, char ch, int size) {
		if(size < 5 || size % 2 == 0) return false;
		int arm = size / 2;
		if(row < arm || row + arm >= g.height) return false;
		for(int i = row - arm; i <= row + arm; i++) {
			if(g.grid[i][col] != ch) return false;
		}
		return true;
	}
	
}
