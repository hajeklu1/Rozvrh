package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import table.PredmetyModel;
import table.StudentModel;

public class Admin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel(new BorderLayout());
	private JPanel panel3 = new JPanel(new BorderLayout());
	private JPanel panel4 = new JPanel();
	private JButton pridejStudenta = new JButton("Přidej studenta");
	private JButton upravStudenta = new JButton("Uprav studenta");
	private JButton smazStudenta = new JButton("Smaž studenta");
	private JButton pridejPredmet = new JButton("Přidej předmět");
	private JButton upravPredmet = new JButton("Uprav přemět");
	private JButton smazPredmet = new JButton("Smaž předmět");
	private JScrollPane scrolStudent;
	private JTable studentTable;
	private JTable predmetTable;
	private JScrollPane scrolPredmet;
	private JScrollPane scrol1;
	private JScrollPane scrol2;

	public Admin(StudentModel studentModel, PredmetyModel predmetModel) {
		setTitle("Administrátor");
		studentTable = new JTable(studentModel);
		predmetModel.setCount(6);
		studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrolStudent = new JScrollPane(studentTable);
		predmetTable = new JTable(predmetModel);
		predmetTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrolPredmet = new JScrollPane(predmetTable);
		panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PŘEDMĚTY",
				TitledBorder.CENTER, TitledBorder.TOP));
		panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "STUDENTI",
				TitledBorder.CENTER, TitledBorder.TOP));
		scrol1 = new JScrollPane(panel3);
		scrol2 = new JScrollPane(panel2);
		add(scrol2, BorderLayout.WEST);
		add(scrol1, BorderLayout.EAST);
		panel4.add(pridejPredmet);
		panel4.add(upravPredmet);
		panel4.add(smazPredmet);
		panel2.add(scrolPredmet, BorderLayout.CENTER);
		panel3.add(scrolStudent, BorderLayout.CENTER);
		panel3.add(panel1, BorderLayout.NORTH);
		panel2.add(panel4, BorderLayout.NORTH);
		panel1.add("Student", pridejStudenta);
		panel1.add(upravStudenta);
		panel1.add(smazStudenta);
		pack();

		pridejStudenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PridejStudenta ps = new PridejStudenta(studentModel);
				ps.setVisible(true);
			}
		});

		upravStudenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = studentTable.getSelectedRow();
				if (row >= 0) {
					EditStudent es = new EditStudent(studentModel.getStudent(row), studentModel);
					es.setVisible(true);
				}
			}
		});
		smazStudenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = studentTable.getSelectedRow();
				if (row >= 0) {
					studentModel.smazStudenta(row);
					studentModel.fireTableDataChanged();
				}

			}
		});

		pridejPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PridejPredmet pr = new PridejPredmet(predmetModel);
				pr.setVisible(true);

			}
		});
		upravPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = predmetTable.getSelectedRow();
				if (row >= 0) {
					UpravPredmet up = new UpravPredmet(predmetModel.getPredmet(row), predmetModel);
					up.setVisible(true);
				}

			}
		});
		smazPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = predmetTable.getSelectedRow();
				if (row >= 0) {
					predmetModel.getPredmety().remove(row);
					predmetModel.fireTableDataChanged();
				}
			}
		});

	}

}
