package model;

import java.util.ArrayList;
import java.util.List;

public class Day {
	private List<Boolean> obsazenost = new ArrayList<>(8);

	public boolean jeObazena(int hodina) {
		try {
			return obsazenost.get(hodina);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public String jeObazenaS(int hodina) {
		try {
			if (obsazenost.get(hodina))
				return "ZAPSANY";
			return "";
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}

	public void setObsazenost(int hodina, boolean y) {
		obsazenost.set(hodina, y);
	}

	public List<Boolean> getObsazenost() {
		return obsazenost;
	}

	public void setObsazenost(List<Boolean> obsazenost) {
		this.obsazenost = obsazenost;
	}

	public static Days stringToDays(String day) {
		switch (day) {
		case "Pondělí":
			return Days.Pondeli;
		case "Úterý":
			return Days.Utery;
		case "Středa":
			return Days.Streda;
		case "Čtvrtek":
			return Days.Ctvrtek;
		case "Pátek":
			return Days.Patek;
		}
		return null;
	}

	public static String dayToString(Days day) {
		switch (day) {
		case Pondeli:
			return "Pondělí";
		case Utery:
			return "Úterý";
		case Streda:
			return "Středa";
		case Ctvrtek:
			return "Čtvrtek";
		case Patek:
			return "Pátek";
		}
		return "N/A";
	}
}
