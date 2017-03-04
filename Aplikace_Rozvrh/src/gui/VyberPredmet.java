package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Predmet;
import model.Student;
import table.PredmetyModel;

public class VyberPredmet extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane pPanel;
	private JTable pTable;
	private PredmetyModel pModel;
	private JButton pridej = new JButton("Zapsat přemět");
	private JButton odeber = new JButton("Odzapsat předmět");
	private JButton studenti = new JButton("Studenti předmětu");
	private JPanel panel1 = new JPanel(new FlowLayout(10));

	public VyberPredmet(Student student, MainFrame mf, PredmetyModel predmetyModel) {
		pModel = predmetyModel;
		predmetyModel.setCount(7);
		pTable = new JTable(pModel);
		pPanel = new JScrollPane(pTable);
		panel1.add(pridej);
		panel1.add(odeber);
		panel1.add(studenti);
		add(panel1, BorderLayout.NORTH);
		add(pPanel, BorderLayout.CENTER);
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pack();

		pTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = pTable.getSelectedRow();
				if (row >= 0) {
					List<Predmet> pr = student.getRegisterPredemt();
					if (pr.isEmpty()) {
						pridej.setEnabled(true);
						odeber.setEnabled(false);
						return;
					}
					for (Predmet predmet : pr) {
						Predmet p = pModel.getPredmet(row);
						if (predmet.equals(p)) {
							pridej.setEnabled(false);
							odeber.setEnabled(true);
							return;
						} else {
							pridej.setEnabled(true);
							odeber.setEnabled(false);
						}
					}
				}
			}
		});

		pridej.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = pTable.getSelectedRow();
				if (row >= 0) {
					Predmet p = pModel.getPredmet(row);
					for (Predmet predmet : student.getRegisterPredemt()) {
						if (predmet.equals(p)) {
							JOptionPane.showMessageDialog(null, "Předmět je již vybrám");
							return;
						}
						if (predmet.getHour() == p.getHour() && predmet.getWeekDay().equals(p.getWeekDay())) {
							JOptionPane.showMessageDialog(null, "V tento den a hodinu je již vybrán jiný předmět");
							return;
						}
					}
					pModel.fireTableDataChanged();
					student.addPredmet(p);
					p.addStudent(student);
					mf.refreash();
					dispose();

				}
			}
		});

		odeber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = pTable.getSelectedRow();
				if (row >= 0) {
					Predmet p = pModel.getPredmet(row);
					for (Predmet predmet : student.getRegisterPredemt()) {
						if (!predmet.equals(p)) {
							JOptionPane.showMessageDialog(null, "Předmět není zapsán");
							return;
						}
					}
					pModel.fireTableDataChanged();
					student.removePredmet(p);
					for (int i = 0; i < p.getRegistedStudents().size(); i++) {
						if (p.getRegistedStudents().get(i).equals(student)) {
							p.removeStudent(i);
						}
					}
					mf.refreash();
					dispose();
				}
			}
		});

		studenti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = pTable.getSelectedRow();
				if (row >= 0) {
					PredmetyStudentu ps = new PredmetyStudentu(predmetyModel.getPredmet(row));
					ps.setVisible(true);
				}
			}
		});

	}

}
