package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Predmet extends TimeLine {
	private String abrev;
	private String name;
	private String lectorName;
	private Days weekDay;
	private int roomNo;
	private int hour;
	private List<Student> registedStudents = new ArrayList<>();

	public Predmet(String abrev, String name, String lectorName, int roomNo, Days weekDay, int hour) {
		this.abrev = abrev;
		this.name = name;
		this.lectorName = lectorName;
		this.roomNo = roomNo;
		this.weekDay = weekDay;
		this.hour = hour;
	}

	public void addStudent(Student s) {
		registedStudents.add(s);
	}

	public void removeStudent(Student s) {
		for (int i = 0; i < registedStudents.size(); i++) {
			if (s.equals(registedStudents.get(i))) {
				removeStudent(i);
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Student nebyl nalezen");
			}
		}
	}

	public boolean equals(Predmet p) {
		if (p == this)
			return true;
		if (abrev.equals(p.getAbrev()) && name.equals(p.getName()) && lectorName.equals(p.getLectorName())
				&& weekDay.equals(p.getWeekDay()) && roomNo == p.getRoomNo() && hour == p.getHour()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return abrev.hashCode() + name.hashCode() + lectorName.hashCode() + roomNo + weekDay.hashCode() + hour;
	}

	public void removeStudent(int index) {
		registedStudents.remove(index);
	}

	public List<Student> getRegistedStudents() {
		return registedStudents;
	}

	public void setRegistedStudents(List<Student> registedStudents) {
		this.registedStudents = registedStudents;
	}

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLectorName() {
		return lectorName;
	}

	public void setLectorName(String lectorName) {
		this.lectorName = lectorName;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Days getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(Days weekDay) {
		this.weekDay = weekDay;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

}
