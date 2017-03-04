package model;

import java.util.ArrayList;
import java.util.List;

public class TimeLine {
	private List<Day> time = new ArrayList<>(5);

	public List<Day> getTime() {
		return time;
	}

	public Day getDay(int index) {
		return time.get(index);
	}

	public void setTime(List<Day> time) {
		this.time = time;
	}

}
