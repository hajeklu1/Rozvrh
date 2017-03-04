package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Predmet;
import model.Student;

public class ModelPredmetu extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> registStudent;

	public ModelPredmetu(Predmet predmet) {
		registStudent = predmet.getRegistedStudents();
	}

	@Override
	public int getRowCount() {
		return registStudent.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Jméno";
		case 1:
			return "Příjmení";
		case 2:
			return "Login";
		case 3:
			return "Email";
		default:
			return "N/A";
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return registStudent.get(rowIndex).getFirstName();
		case 1:
			return registStudent.get(rowIndex).getLastName();
		case 2:
			return registStudent.get(rowIndex).getUserName();
		case 3:
			return registStudent.get(rowIndex).getEmail();
		default:
			return "N/A";
		}
	}

}
