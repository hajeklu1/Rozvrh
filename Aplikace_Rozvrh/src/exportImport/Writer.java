package exportImport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.swing.JOptionPane;

import model.Predmet;
import model.Student;

public class Writer {

	private PrintStream fileStream;

	public void writeStudent(List<Student> studenti) {
		try {
			fileStream = new PrintStream(new File("Studenti.txt"));
			for (Student student : studenti) {
				fileStream.print(student.getFirstName() + ";" + student.getLastName() + ";" + student.getUserName()
						+ ";" + student.getEmail() + ";" + student.getCount() + "%");
				for (Predmet predmet : student.getRegisterPredemt()) {
					fileStream.print(predmet.getAbrev() + ";" + predmet.getHour() + ";" + predmet.getWeekDay() + ";"
							+ predmet.getLectorName() + ";" + predmet.getName() + ";" + predmet.getRoomNo() + "&");
				}
				fileStream.println();
			}
			fileStream.println("?");
			fileStream.flush();
			fileStream.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ulození se nezdařilo");
			e.printStackTrace();
		}
	}

	public void writePredmet(List<Predmet> predmety) {
		try {
			fileStream = new PrintStream(new File("Predmety.txt"));
			for (Predmet predmet : predmety) {
				fileStream.print(predmet.getAbrev() + ";" + predmet.getHour() + ";" + predmet.getWeekDay() + ";"
						+ predmet.getLectorName() + ";" + predmet.getName() + ";" + predmet.getRoomNo() + "%");
				fileStream.println();
			}
			fileStream.println("?");
			fileStream.flush();
			fileStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
