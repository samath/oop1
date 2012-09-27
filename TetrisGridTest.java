import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class TetrisGridTest {

	// Provided simple clearRows() test
	// width 2, height 3 grid
	@Test
	public void testClear1() {
		boolean[][] before =
			{	
				{true, true, false, },
				{false, true, true, }
			};

		boolean[][] after =
			{	
				{true, false, false},
				{false, true, false}
			};

		TetrisGrid tetris = new TetrisGrid(before);
		assertTrue(Arrays.deepEquals(before, tetris.getGrid()));

		tetris.clearRows();
		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	@Test
	public void testClear2() {
		boolean[][] before = {
				{true, true, false, false, true, true, },
				{true, false, true, false, true, false, },
				{true, true, false, false, true, true }
		};
		boolean[][] after = {
				{true, false, false, true, false, false, },
				{false, true, false, false, false, false, },
				{true, false, false, true, false, false }
		};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(after,  tetris.getGrid()));

	}

	@Test
	public void testClear3() {
		boolean[][] before = { 
				{true, true, }, 
				{true, true, }, 
				{true, true }
		};
		boolean[][] after = {
				{false, false, }, 
				{false, false, }, 
				{false, false }
		};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(after,  tetris.getGrid()));
	}
	
	@Test
	public void testClear4() {
		boolean [][] before = {
				{false, false, true, },
				{false, true, false, },
				{true, false, false }
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(before,  tetris.getGrid()));
		
	}
	
	@Test
	public void testEmpty() {
		boolean[][] before = new boolean[0][0];
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue(Arrays.deepEquals(before,  tetris.getGrid()));
	}
	
	
}
