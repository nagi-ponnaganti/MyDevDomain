package maze.explorer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import maze.builder.Maze;
import maze.route.Direction;
import maze.route.Location;
import maze.route.Route;

public class Explorer {

	public Route exploreMaze(Maze maze) {

		Location startingPointOfMaze = new Location();
		startingPointOfMaze.setxCoordinate(Integer.parseInt(maze.getStartCoordinate().split(",")[0]));
		startingPointOfMaze.setyCoordinate(Integer.parseInt(maze.getStartCoordinate().split(",")[1]));

		Route route = new Route();
		route.getPoints().add(startingPointOfMaze);

		addNextStepTracked(route, startingPointOfMaze, maze);

		System.out.println("Final Route: ");
		printRoute(finalRoute);
		
		return finalRoute;
	}

	private void addNextStepTracked(Route route, Location currentLocation, Maze maze) {

		if (currentLocation.isFinalLocation()) {
			finalRoute = route;
		}

		System.out.println("Current Location: " + currentLocation);

		List<Route> updatedRoutes = new ArrayList<Route>();

		Stream.of(Direction.values()).forEach(dir -> {

			Route updatedRoute = addNeighbourCoordinateIfValidRoute(route, maze, currentLocation, dir);
			if (updatedRoute != null)
				updatedRoutes.add(updatedRoute);

		});

		if (currentLocation.getLinkedLocations() != null) {

			currentLocation.getLinkedLocations().forEach(loc -> {
				int i = 0;
//				System.out.println("Next Location: " + loc);
				addNextStepTracked(updatedRoutes.get(i), loc, maze);
				i++;
			});

		} else {
			System.out.println("No Child Nodes");
		}

	}

	private Route addNeighbourCoordinateIfValidRoute(Route route, Maze m, Location parentNode, Direction d) {

		int x = parentNode.getxCoordinate();
		int y = parentNode.getyCoordinate();

		if (d.equals(Direction.TOP) && (x - 1) >= 0 && !codes.contains(String.valueOf(m.getMaze()[x - 1][y]))) {

			return addChildNode(x - 1, y, parentNode, m, route);

		} else if (d.equals(Direction.BOTTOM) && (x + 1) < m.getHeightOfMaze()
				&& !codes.contains(String.valueOf(m.getMaze()[x + 1][y]))) {

			return addChildNode(x + 1, y, parentNode, m, route);

		} else if (d.equals(Direction.LEFT) && (y - 1) >= 0 && !codes.contains(String.valueOf(m.getMaze()[x][y - 1]))) {

			return addChildNode(x, y - 1, parentNode, m, route);

		} else if (d.equals(Direction.RIGHT) && (y + 1) < m.getWidthOfMaze()
				&& !codes.contains(String.valueOf(m.getMaze()[x][y + 1]))) {

			return addChildNode(x, y + 1, parentNode, m, route);

		}

		return null;

	}

	private Route addChildNode(int x, int y, Location parentNode, Maze m, Route route) {
		Location loc = new Location();
		loc.setxCoordinate(x);
		loc.setyCoordinate(y);
		parentNode.getLinkedLocations().add(loc);
		if (m.getMaze()[x][y] == 'F')
			loc.setFinalLocation(true);
		m.getMaze()[x][y] = 'C';

		Route newRoute = new Route();
		newRoute.getPoints().addAll(route.getPoints());
		newRoute.getPoints().add(loc);

		return newRoute;
	}

	private void printRoute(Route route) {
		route.getPoints().forEach(p -> {
			System.out.format("Position At (X,Y) : (%s, %s) \n", p.getxCoordinate(), p.getyCoordinate());
		});
	}

	final List<String> codes = Arrays.asList(new String[] { "X", "S", "C" });
	private Route finalRoute;
	
	private Explorer() {
		
	}
	
	private static Explorer explorer;	
	
	public static Explorer getInstance() {
		if(explorer == null) explorer = new Explorer();
		return explorer;
	}

}
