package se.mooldi.otherclasses;

public class Player {
	String name = "";
	int points = 0;
	int completed = 0;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void increasePoints() {
		points++;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}
	
}
