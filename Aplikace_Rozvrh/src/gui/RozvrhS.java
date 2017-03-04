package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Student;
import table.RozvrhModel;
import table.StudentModel;

public class RozvrhS extends JFrame {
	private JTable rozvrhTable;
	private JScrollPane rozvrhScroll;
	private RozvrhModel rozvrhModel;

	public RozvrhS(Student s1, Student s2) {
		setTitle(s1.getLastName() + " + " + s2.getLastName());
		rozvrhModel = new RozvrhModel(s1);
		rozvrhTable = new JTable(rozvrhModel);
		rozvrhScroll = new JScrollPane(rozvrhTable);
		rozvrhModel.addPredmety(s2.getRegisterPredemt());
		add(rozvrhScroll, BorderLayout.WEST);
		pack();
	}

}
