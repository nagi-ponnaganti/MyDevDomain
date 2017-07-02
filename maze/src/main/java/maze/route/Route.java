package maze.route;

import java.util.ArrayList;
import java.util.List;

public class Route {
	
	private List<Location> points;

	public List<Location> getPoints() {
		
		if(points == null) {
			points = new ArrayList<>();
		}
		
		return points;
	}

	public void setPoints(List<Location> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Route [points=" + points + "]";
	}

}
