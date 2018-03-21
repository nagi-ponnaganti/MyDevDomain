package maze.explorer;

import maze.builder.Maze;
import maze.builder.MazeBuilder;
import maze.route.Route;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExplorerTest {

	@Test
	public void testExploreMaze() throws Exception {

		Maze maze = MazeBuilder.getInstance().readDefaultMazeFromFile();
		
		Route route = Explorer.getInstance().exploreMaze(maze);
		
		assertNotNull(route.getPoints().size());
		assertEquals(route.getPoints().size(), 74);

	}

}
