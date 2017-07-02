package maze.route;

import java.util.ArrayList;
import java.util.List;

public class Location {

	private int xCoordinate;
	private int yCoordinate;
	private boolean finalLocation;
	private List<Location> linkedLocations;

	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public List<Location> getLinkedLocations() {
		if(linkedLocations == null) {
			linkedLocations = new ArrayList<>();
		}
		return linkedLocations;
	}

	public void setLinkedLocations(List<Location> linkedLocations) {
		this.linkedLocations = linkedLocations;
	}

	public boolean isFinalLocation() {
		return finalLocation;
	}

	public void setFinalLocation(boolean finalLocation) {
		this.finalLocation = finalLocation;
	}

	@Override
	public String toString() {
		return "Location [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", finalLocation="
				+ finalLocation + ", linkedLocations=" + linkedLocations + "]";
	}

}