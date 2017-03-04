package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Student;

public class StudentModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> studenti = new ArrayList<>();

	public List<Student> getStudenti() {
		return studenti;
	}

	public void smazStudenta(int index) {
		studenti.remove(index);
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public StudentModel() {
	}

	public void pridejStudenta(Student s) {
		studenti.add(s);
	}

	public Student getStudent(int index) {
		return studenti.get(index);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studenti.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
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
			return "Email";
		case 3:
			return "Login";
		default:
			return "N/A";
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return studenti.get(rowIndex).getFirstName();
		case 1:
			return studenti.get(rowIndex).getLastName();
		case 2:
			return studenti.get(rowIndex).getEmail();
		case 3:
			return studenti.get(rowIndex).getUserName();
		default:
			return "N/A";
		}
	}

}
