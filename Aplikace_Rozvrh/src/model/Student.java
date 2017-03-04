package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Student extends TimeLine {
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private List<Predmet> registerPredemet = new ArrayList<>();
	private int count = 1;

	public Student(String userName, String firstName, String lastName, String email) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}
	public Student(String userName, String firstName, String lastName, String email,int cout) {
		this(userName,firstName,lastName,email);
		this.count = cout;
	}

	public Student(String firstName, String lastName, String email) {
		this.userName = generateUserName(lastName, firstName);
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String generateUserName(String last, String first) {
		if (last.length() >= 5 && first.length() >= 2) {
			return last.substring(0, 5) + first.substring(0, 2) + count;
		}
		return last.substring(0, last.length()) + first.substring(0, last.length()) + count;
	}

	public String generateUserName() {
		return generateUserName(lastName, firstName);
	}

	public boolean equals(Student s) {
		if (this == s)
			return true;
		if (s.getUserName().equals(userName) && s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)
				&& count == s.getCount()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return userName.hashCode() + firstName.hashCode() + lastName.hashCode() + count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addPredmet(Predmet p) {
		registerPredemet.add(p);
	}

	public void removePredmet(int index) {
		registerPredemet.remove(index);
	}

	public void removePredmet(Predmet p) {
		for (int i = 0; i < registerPredemet.size(); i++) {
			if (registerPredemet.get(i).equals(p)) {
				removePredmet(i);
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Predmet nebyl nalezen");
			}
		}
	}

	public List<Predmet> getRegisterPredemt() {
		return registerPredemet;
	}

	public void setRegisterPredemt(List<Predmet> registerPredemt) {
		this.registerPredemet = registerPredemt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
