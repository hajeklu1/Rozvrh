package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import model.Student;
import table.PredmetyModel;
import table.RozvrhModel;
import table.StudentModel;

public class VyberViceStudentu extends JFrame {
	public VyberViceStudentu(List<Student> studenti, int pocetStudentu) {
		setLayout(new BorderLayout());
		JPanel panelall = new JPanel();
		for (int i = 0; i < pocetStudentu; i++) {
			JComboBox<Student> comboStudenti = new JComboBox<>();
			JButton btn = new JButton("Ok");
			RozvrhModel predmetyModel = new RozvrhModel(new Student("", "", ""));
			JTable table = new JTable(predmetyModel);
			JScrollPane sc = new JScrollPane(table);
			JPanel panel = new JPanel(new BorderLayout());
			JPanel p = new JPanel(new FlowLayout());
			for (Student student : studenti) {
				comboStudenti.addItem(student);
			}
			p.add(comboStudenti);
			p.add(btn);
			panel.add(p, BorderLayout.NORTH);
			panel.add(sc, BorderLayout.CENTER);
			panelall.add(panel);

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					predmetyModel.setStudent((Student) comboStudenti.getSelectedItem());
					predmetyModel.fireTableDataChanged();
				}
			});

		}
		add(new JScrollPane(panelall), BorderLayout.CENTER);
		pack();
	}

}
