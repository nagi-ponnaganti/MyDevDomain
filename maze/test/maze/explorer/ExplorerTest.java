package maze.explorer;

import static org.junit.Assert.*;

import org.junit.Test;

import maze.builder.Maze;
import maze.builder.MazeBuilder;
import maze.explorer.Explorer;
import maze.route.Route;

public class ExplorerTest {

	@Test
	public void testExploreMaze() throws Exception {

		Maze maze = MazeBuilder.getInstance().readDefaultMazeFromFile();
		
		Route route = Explorer.getInstance().exploreMaze(maze);
		
		assertNotNull(route.getPoints().size());
		assertEquals(route.getPoints().size(), 74);

	}

}
