package maze.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import maze.builder.Maze;
import maze.builder.MazeBuilder;
import maze.explorer.Explorer;

public class DefaultMazeMenuStartUp {

	public void load() throws Exception {

		Maze maze = loadSampleMaze();
		loadMenu(maze);

	}

	private Maze loadSampleMaze() throws Exception {

		System.out.println("###############################");
		System.out.println("######### Sample Maze #########");
		System.out.println("###############################\n");

		System.out.println("\n Load the Default Sample Maze \n");
		Maze maze = MazeBuilder.getInstance().readDefaultMazeFromFile();
		maze.getRawLines().forEach(System.out::println);

		return maze;
	}

	private void loadMenu(Maze maze) throws Exception {

		System.out.print("\n \n Sample Maze Menu :");
		System.out.println(" Please pick an option from Below Menu (Use Number before Option) : ");

		menuOptions.forEach(System.out::println);

		int choice = getValidInput();

		switch (choice) {
		case 1:
			System.out.println("\n Input Coordinate(comma separated numbers)");

			String coordinateInputs = getValidInputCoordinates();
			String[] coordinates = coordinateInputs.split(",");
			System.out.format(" For coordinates x:%s y:%s and the Value in Maze is: %s ", coordinates[0],
					coordinates[1],
					maze.getRawLines().get(Integer.parseInt(coordinates[0])).charAt(Integer.parseInt(coordinates[1])));
			loadMenu(maze);
			break;
		case 2:
			System.out.println("Back To Main Menu");
			MazeMenuStartUp.getInstance().loadMenu();
			break;
		case 3:
			System.out.println("Start Explore in Maze");
			Explorer.getInstance().exploreMaze(maze);
			break;		
		default:
			System.out.println("Good-Bye");
		}
	}

	private static int getValidInput() {

		int choice = readNextInput();

		if (!(0 < choice && choice <= menuOptions.size())) {
			System.out.println("Incorrect Option, Enter the Correct Option:");
			getValidInput();
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

	private static String getValidInputCoordinates() {

		String coordinateInputs = scanner.nextLine();

		if (coordinateInputs != null && coordinateInputs.length() > 0 && coordinateInputs.contains(",")
				&& coordinateInputs.split(",").length == 2 && !checkIfValidNumbersInCoordinates(coordinateInputs)) {

			System.out.println("Not a valid input, please enter comma seprated coordinates");
			return getValidInputCoordinates();
		}

		return coordinateInputs;
	}

	private static boolean checkIfValidNumbersInCoordinates(String coordinates) {

		String[] coords = coordinates.split(",");
		boolean isValid = true;
		try {
			Integer.parseInt(coords[0]);
			Integer.parseInt(coords[1]);
		} catch (Exception ex) {
			isValid = false;
		}

		return isValid;
	}

	static Scanner scanner = new Scanner(System.in);

	static final List<String> menuOptions = Arrays.asList(new String[] { "1. Input Coordinate(comma separated numbers)",
			"2. Back To Main Menu ", "3. Start To Explore in Maze ", "4. Quit " });

	private DefaultMazeMenuStartUp() {

	}

	private static DefaultMazeMenuStartUp defaultMazeMenuStartUp;

	public static DefaultMazeMenuStartUp getInstance() {
		if (defaultMazeMenuStartUp == null) {
			defaultMazeMenuStartUp = new DefaultMazeMenuStartUp();
		}
		return defaultMazeMenuStartUp;
	}

}
