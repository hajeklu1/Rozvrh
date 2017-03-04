package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.Predmet;
import model.Student;

public class PredmetyModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Predmet> predmety = new ArrayList<>();
	private Student student;
	private int count = 7;

	public PredmetyModel(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		fireTableDataChanged();
		this.count = count;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void addPredmet(Predmet p) {
		predmety.add(p);
	}

	public void removePredmet(int index) {
		predmety.remove(index);
	}

	public boolean existPredmet(Predmet p) {
		for (Predmet predmet : predmety) {
			if (p.equals(predmet)) {
				return true;
			}
		}
		return false;
	}

	public void removePredmet(Predmet p) {
		for (int i = 0; i < predmety.size(); i++) {
			if (predmety.get(i).equals(p)) {
				removePredmet(i);
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Predmet nebyl nalezen");
			}
		}
	}

	public Predmet getPredmet(int index) {
		return predmety.get(index);
	}

	public Predmet getPredmet(String zkratka) {
		for (Predmet predmet : predmety) {
			if (predmet.getAbrev().equals(zkratka)) {
				return predmet;
			}
		}
		JOptionPane.showMessageDialog(null, "Predmet nebyl nalezen");
		return null;

	}

	public List<Predmet> getPredmety() {
		return predmety;
	}

	public void setPredmety(List<Predmet> predmety) {
		this.predmety = predmety;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return predmety.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Zkratka";
		case 1:
			return "Název";
		case 2:
			return "Učitel";
		case 3:
			return "Vyučovací den";
		case 4:
			return "Místnost";
		case 5:
			return "Hodina";
		case 6:
			return "Zapsáno";
		default:
			return "N/A";
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 6) {
			return Boolean.class;
		}
		return super.getColumnClass(columnIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return predmety.get(rowIndex).getAbrev();
		case 1:
			return predmety.get(rowIndex).getName();
		case 2:
			return predmety.get(rowIndex).getLectorName();
		case 3:
			return predmety.get(rowIndex).getWeekDay();
		case 4:
			return predmety.get(rowIndex).getRoomNo();
		case 5:
			return predmety.get(rowIndex).getHour();
		case 6:
			return isSelect(rowIndex);
		default:
			return "N/A";
		}
	}

	private Object isSelect(int rowIndex) {
		for (Predmet predmet : student.getRegisterPredemt()) {
			if (predmety.get(rowIndex).equals(predmet))
				return true;
		}
		return false;
	}

}
