package maze.main;

import maze.menu.MazeMenuStartUp;

public class MazeAppStartUp {

	public static void main(String[] args) throws Exception {

		System.out.println("Loading Maze Main Menu");
		MazeMenuStartUp.getInstance().loadMenu();

	}
}
