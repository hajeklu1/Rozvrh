package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Predmet;
import table.ModelPredmetu;

public class PredmetyStudentu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ModelPredmetu predmetModel;
	private JTable table;
	private JScrollPane sPane;

	public PredmetyStudentu(Predmet predmet) {
		predmetModel = new ModelPredmetu(predmet);
		setTitle("Studenti kteří mají zapsaný: " + predmet.getAbrev());
		table = new JTable(predmetModel);
		sPane = new JScrollPane(table);
		add(sPane, BorderLayout.CENTER);
		pack();
	}

}
