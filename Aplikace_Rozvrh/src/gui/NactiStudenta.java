package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import table.StudentModel;

public class NactiStudenta extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane sPane;
	private StudentModel studentModel;
	private JTable studentTable;
	private JButton ok = new JButton("Ok");
	private MainFrame mf;

	public NactiStudenta(MainFrame mf, StudentModel studentModel) {
		this.mf = mf;
		setTitle("Načti studenta");
		this.studentModel = studentModel;
		studentTable = new JTable(studentModel);
		sPane = new JScrollPane(studentTable);
		studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(sPane, BorderLayout.CENTER);
		add(ok, BorderLayout.SOUTH);
		pack();

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = studentTable.getSelectedRow();
				if (row >= 0) {
					mf.setStudent(studentModel.getStudent(row));
					mf.refreash();
					dispose();
				}
			}
		});

	}
}
