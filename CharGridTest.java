
// Test cases for CharGrid -- a few basic tests are provided.
import static org.junit.Assert.*;
import org.junit.Test;

public class CharGridTest {
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
		assertEquals(0, cg.countPlus());
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(0, cg.charArea('d'));
		assertEquals(0, cg.countPlus());
	}
	
	@Test
	public void testEmpty() {
		char[][] grid = new char[0][0];
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.charArea('a'));
		assertEquals(0, cg.countPlus());
	}
	
	@Test
	public void testPlus1() {
		char[][] grid = new char[][] {
				{' ', ' ', 'x', ' ', ' ', } ,
				{' ', ' ', 'x', ' ', ' ', } ,
				{'x', 'x', 'x', 'x', 'x', } ,
				{' ', ' ', 'x', ' ', ' ', } ,
				{' ', ' ', 'x', ' ', ' '} ,
		};
		
		CharGrid cg = new CharGrid(grid);
		assertEquals(25, cg.charArea('x'));
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testPlus2() {
		char[][] grid = new char[][] {
				{'a', 'b', 'c', 'c', 'c', 'c', 'g', },
				{'a', 'b', 'c', 'd', 'c', 'f', 'g', },
				{'a', 'a', 'a', 'd', 'c', 'f', 'g', },
				{'a', 'd', 'd', 'd', 'd', 'd', 'g', },
				{'a', 'b', 'c', 'd', 'e', 'f', 'g', },
				{'a', 'b', 'c', 'd', 'e', 'f', 'g', },
				{'a', 'b', 'c', 'h', 'e', 'f', 'g', },
				{'a', 'b', 'c', 'h', 'g', 'g', 'g', },
		};
		
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
		assertEquals(32, cg.charArea('c'));
	}
	
	@Test
	public void testPlus3() {
		char[][] grid = new char[][] {
				{'1','2','3','4','5','6','7','8','9','0','a','b', }, 
				{'1','2','3','4','5','6','7','8','9','0','a','b', }, 
				{'3','3','3','3','3','6','0','0','0','0','0','0', }, 
				{'1','2','3','4','5','6','7','8','x','0','a','b', }, 
				{'1','2','3','4','5','6','7','8','9','0','a','b', }, 
				{'2','2','2','2','5','6','7','8','9','0','a','b', }, 
				{'1','2','3','4','5','6','7','8','9','k','a','b', }, 
				{'1','2','3','4','5','9','9','9','9','9','9','9', },
				{'3','3','3','3','3','3','7','8','9','0','a','b', },
				{'1','2','3','4','5','6','7','8','9','0','a','b', }, 
				{'1','2','3','4','5','6','7','8','9','0','a','b', }, 
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2, cg.countPlus());
	}
	
}
