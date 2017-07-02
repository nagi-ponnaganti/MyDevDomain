package maze.builder;

import static org.junit.Assert.*;

import org.junit.Test;

import maze.builder.Maze;
import maze.builder.MazeBuilder;

public class MazeBuilderTest {

	@Test
	public void testReadDefaultMazeFromFile() throws Exception {
		
//		XXXXXXX
//		XSXXXFX
//		X  XX X
//		XX XX X
//		XX  X X
//		XXX   X
//		XXXXXXX
		
//		XXXXXXXXXXXXXXX
//		X             X
//		X XXXXXXXXXXX X
//		X XS        X X
//		X XXXXXXXXX X X
//		X XXXXXXXXX X X
//		X XXXX      X X
//		X XXXX XXXX X X
//		X XXXX XXXX X X
//		X X    XXXXXX X
//		X X XXXXXXXXX X
//		X X XXXXXXXXX X
//		X X         X X
//		X XXXXXXXXX   X
//		XFXXXXXXXXXXXXX

		Maze maze = MazeBuilder.getInstance().readDefaultMazeFromFile();

		assertEquals(maze.getFinishCoordinate(), "14,1");
		assertEquals(maze.getHeightOfMaze(), 15);
		assertEquals(maze.getRawLines().size(), 15);
		assertEquals(maze.getStartCoordinate(), "3,3");
		assertEquals(maze.getWidthOfMaze(), 15);

	}

}
