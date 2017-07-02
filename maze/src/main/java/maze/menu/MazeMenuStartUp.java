/**
 * 
 */
package maze.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import maze.builder.Maze;
import maze.builder.MazeBuilder;
import maze.explorer.Explorer;

/**
 * @author nageswararao
 *
 */
public class MazeMenuStartUp {

	public void loadMenu() throws Exception {

		System.out.println("########################");
		System.out.println("######### Maze #########");
		System.out.println("########################\n");

		System.out.print("Maze Menu :");
		System.out.println(" Please pick an option from Below Menu (Use Number before Option) : ");

		menuOptions.forEach(System.out::println);

		int choice = getValidInput();

		switch (choice) {
		case 1:
			System.out.println("Load the Default Sample Maze");
			DefaultMazeMenuStartUp.getInstance().load();
			loadMenu();
			break;
		case 2:
			System.out.println("Input a New Maze, Explorer Will Give the Directions to Finish Line");
			Maze maze = MazeBuilder.getInstance().readFromConsole();
			Explorer.getInstance().exploreMaze(maze);
			loadMenu();
			break;
		case 3:
			System.out.println("Quit app selected, Bye");
			break;
		}
	}

	private static int getValidInput() {

		int choice = readNextInput();

		if (!(0 < choice && choice <= menuOptions.size())) {
			System.out.println("Incorrect Option, Enter the Correct Option:");
			return getValidInput();
		}

		return choice;
	}

	private static int readNextInput() {

		try {
			String input = scanner.nextLine();
			return Integer.parseInt(input);
		} catch (Exception e) {
			return 0;
		}
	}

	static Scanner scanner = new Scanner(System.in);

	static final List<String> menuOptions = Arrays
			.asList(new String[] { "1. Use the default Maze", "2. Input your own Maze ", "3. Quit " });
	
	public static MazeMenuStartUp getInstance() {
		
		if (mazeMenuStartUp == null) {
			mazeMenuStartUp = new MazeMenuStartUp();
		}

		return mazeMenuStartUp;
	}
	
	private static MazeMenuStartUp mazeMenuStartUp;
	private MazeMenuStartUp() {
		
	}

}
