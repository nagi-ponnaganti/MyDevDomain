package maze.builder;

import java.util.List;

public class Maze {

	private char[][] maze;
	private int widthOfMaze;
	private int heightOfMaze;
	private List<String> rawLines;
	private String startCoordinate;
	private String finishCoordinate;

	public char[][] getMaze() {
		return maze;
	}

	public int getWidthOfMaze() {
		return widthOfMaze;
	}

	public int getHeightOfMaze() {
		return heightOfMaze;
	}

	public void setMaze(char[][] maze) {
		this.maze = maze;
	}

	public void setWidthOfMaze(int widthOfMaze) {
		this.widthOfMaze = widthOfMaze;
	}

	public void setHeightOfMaze(int heightOfMaze) {
		this.heightOfMaze = heightOfMaze;
	}

	public List<String> getRawLines() {
		return rawLines;
	}

	public void setRawLines(List<String> rawLines) {
		this.rawLines = rawLines;
	}

	public String getStartCoordinate() {
		return startCoordinate;
	}

	public String getFinishCoordinate() {
		return finishCoordinate;
	}

	public void setStartCoordinate(String startCoordinate) {
		this.startCoordinate = startCoordinate;
	}

	public void setFinishCoordinate(String finishCoordinate) {
		this.finishCoordinate = finishCoordinate;
	}

}
