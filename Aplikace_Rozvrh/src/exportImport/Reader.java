package exportImport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Days;
import model.Predmet;
import model.Student;
import table.PredmetyModel;

public class Reader {
	public List<Student> readStudet(PredmetyModel predmetModel) {
		List<Student> studenti = new ArrayList<>();
		try (BufferedReader bf = new BufferedReader(new FileReader("Studenti.txt"))) {
			String temp;
			while (!"?".equals(temp = bf.readLine())) {
				boolean zapis = true;
				String[] arry = temp.split("%");
				String[] student = arry[0].split(";");
				Student s = new Student(student[2], student[0], student[1], student[3], Integer.parseInt(student[4]));
				studenti.add(s);
				if (arry.length > 1) {
					String[] p = arry[1].split("&");
					for (int i = 0; i < p.length; i++) {
						String[] predmet = p[i].split(";");
						Predmet pr = new Predmet(predmet[0], predmet[4], predmet[3], Integer.parseInt(predmet[5]),
								savetoDay(predmet[2]), Integer.parseInt(predmet[1]));
						for (int j = 0; j < predmetModel.getPredmety().size(); j++) {
							Predmet predmet1 = predmetModel.getPredmet(j);
							if (predmet1.equals(pr)) {
								zapis = false;
							}
						}
						if (zapis) {
							predmetModel.addPredmet(pr);
						}
						s.addPredmet(pr);
						pr.addStudent(s);
					}
				}
			}
			return studenti;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studenti;
	}

	public void readPredmet(PredmetyModel predmetModel) {
		try (BufferedReader bf = new BufferedReader(new FileReader("Predmety.txt"))) {
			String temp;
			while (!"?".equals(temp = bf.readLine())) {
				boolean zapis = true;
				String[] arry = temp.split("%");
				String[] predmet = arry[0].split(";");
				Predmet p = new Predmet(predmet[0], predmet[4], predmet[3], Integer.parseInt(predmet[5]),
						savetoDay(predmet[2]), Integer.parseInt(predmet[1]));
				for (int i = 0; i < predmetModel.getPredmety().size(); i++) {
					Predmet predmet1 = predmetModel.getPredmet(i);
					if (predmet1.equals(p)) {
						zapis = false;
					}
				}
				if (zapis) {
					predmetModel.addPredmet(p);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Days savetoDay(String day) {
		switch (day) {
		case "Pondeli":
			return Days.Pondeli;
		case "Utery":
			return Days.Utery;
		case "Ctvrtek":
			return Days.Ctvrtek;
		case "Streda":
			return Days.Streda;
		case "Patek":
			return Days.Patek;
		}
		return null;
	}

}
