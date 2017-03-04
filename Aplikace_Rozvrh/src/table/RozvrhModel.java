package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Days;
import model.Predmet;
import model.Student;

public class RozvrhModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private List<Predmet> studentsPredmets;

	public RozvrhModel(Student student) {
		this.student = student;
		studentsPredmets = student.getRegisterPredemt();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	public void addPredmety(List<Predmet> predmety) {
		for (Predmet predmet : predmety) {
			studentsPredmets.add(predmet);
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "";
		}
		return Integer.toString(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		studentsPredmets = student.getRegisterPredemt();
		switch (columnIndex) {
		case 0:
			switch (rowIndex) {
			case 0:
				return "Pondělí";
			case 1:
				return "Úterý";
			case 2:
				return "Středa";
			case 3:
				return "Čtvrtek";
			case 4:
				return "Pátek";
			default:
				return "N/A";
			}
		case 1:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 1) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 1) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 1) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 1) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 1) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		case 2:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 2) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 2) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 2) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 2) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 2) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		case 3:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 3) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 3) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 3) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 3) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 3) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		case 4:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 4) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 4) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 4) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 4) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 4) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		case 5:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 5) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 5) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 5) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 5) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 5) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		case 6:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 6) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 6) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 6) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 6) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 6) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		case 7:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 7) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 7) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 7) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 7) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 7) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		case 8:
			switch (rowIndex) {
			case 0:

				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Pondeli) && predmet.getHour() == 8) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 1:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Utery) && predmet.getHour() == 8) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 2:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Streda) && predmet.getHour() == 8) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 3:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Ctvrtek) && predmet.getHour() == 8) {
						return predmet.getAbrev();
					}
				}
				return "";
			case 4:
				for (Predmet predmet : studentsPredmets) {
					if (predmet.getWeekDay().equals(Days.Patek) && predmet.getHour() == 8) {
						return predmet.getAbrev();
					}
				}
				return "";
			default:
				return "N/A";
			}
		}
		return "";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
