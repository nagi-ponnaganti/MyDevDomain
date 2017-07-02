package maze.builder;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeBuilder {

	public Maze readFromConsole() {

		System.out.println("Enter the Maze Line By Line and type 'DONE' at the end");
		List<String> lines = new ArrayList<>();
		String line = null;
		while (!(line = scanner.nextLine()).equalsIgnoreCase("DONE")) {
			if (line.trim().length() > 0)
				lines.add(line);
		}

		System.out.println("Maze Read As Below");
		lines.forEach(System.out::println);

		if (!validateLines(lines)) {
			return readFromConsole();
		}

		return build(lines);
	}

	private boolean validateLines(List<String> lines) {

		System.out.println("\n Validating The Maze For Some Basic Criteria");
		System.out.println("Check For S(Start), F(Finish) In Maze ");

		boolean isValid = true;

		int sCount = (int) lines.stream().filter(l -> l.contains("S")).count();
		if (sCount != 1) {
			System.out.println("1. Start position is not single");
			isValid = false;
		}

		int fCount = (int) lines.stream().filter(l -> l.contains("F")).count();
		if (fCount != 1) {
			System.out.println("2. Finish position is not single");
			isValid = false;
		}

		if (lines.size() < 3) {
			System.out.println("3. Maze id Not valid");
			isValid = false;
		}

		return isValid;
	}

	public Maze readDefaultMazeFromFile() throws Exception {

		List<String> lines = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("ExampleMaze.txt").toURI()),
				Charset.defaultCharset());

		return build(lines);
	}

	private Maze build(List<String> rawLines) {

		int widthOfMaze = rawLines.stream().map(s -> s.length()).max(Integer::compare).get();
		int heightOfMaze = rawLines.size();
		String startCoordinate = null;
		String finishCoordinate = null;

		char[][] maze = new char[widthOfMaze][heightOfMaze];

		for (int i = 0; i < heightOfMaze; i++) {
			for (int j = 0; j < widthOfMaze; j++) {

				char tempChar = rawLines.get(i).charAt(j);

				if ('S' == tempChar) {
					startCoordinate = i + "," + j;
				} else if ('F' == tempChar) {
					finishCoordinate = i + "," + j;
				}

				maze[i][j] = tempChar;
			}
		}

		Maze mazeObj = new Maze();
		mazeObj.setHeightOfMaze(heightOfMaze);
		mazeObj.setWidthOfMaze(widthOfMaze);
		mazeObj.setMaze(maze);
		mazeObj.setRawLines(rawLines);
		mazeObj.setStartCoordinate(startCoordinate);
		mazeObj.setFinishCoordinate(finishCoordinate);

		return mazeObj;

	}

	private static MazeBuilder mazeBuilder;

	public static MazeBuilder getInstance() {
		if (mazeBuilder == null)
			mazeBuilder = new MazeBuilder();

		return mazeBuilder;
	}

	static Scanner scanner = new Scanner(System.in);

	private MazeBuilder() {

	}

}
