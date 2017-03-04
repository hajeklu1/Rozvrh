package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Student;
import table.StudentModel;

public class PridejStudenta extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jmeno = new JTextField("Jmeno..", 20);
	private JTextField prijmeni = new JTextField("Příjmení..", 20);
	private JTextField email = new JTextField("Email..", 20);
	private JTextArea aJmeno = new JTextArea("Zadej jmeno: ");
	private JTextArea aprijmeni = new JTextArea("Zadej příjmení: ");
	private JTextArea aEmail = new JTextArea("Zadej Email: ");
	private JPanel panel1 = new JPanel(new FlowLayout());
	private JPanel panel2 = new JPanel(new FlowLayout());
	private JButton ok = new JButton("OK");
	private StudentModel studentModel;

	public PridejStudenta(StudentModel studentModel) {
		this.studentModel = studentModel;
		setTitle("Přidej Studenta");
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		panel1.add(aJmeno);
		panel1.add(jmeno);
		panel1.add(aprijmeni);
		panel1.add(prijmeni);
		panel2.add(aEmail);
		panel2.add(email);
		panel2.add(ok);
		pack();
		aJmeno.setEditable(false);
		aprijmeni.setEditable(false);
		aEmail.setEditable(false);

		jmeno.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if ("".equals(jmeno.getText()))
					jmeno.setText("Jmeno..");

			}

			@Override
			public void focusGained(FocusEvent e) {
				jmeno.setText("");
			}
		});

		prijmeni.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if ("".equals(prijmeni.getText())) {
					prijmeni.setText("Příjmení..");
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				prijmeni.setText("");
			}
		});
		email.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if ("".equals(email.getText())) {
					email.setText("Email..");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				email.setText("");
			}
		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student(jmeno.getText(), prijmeni.getText(), email.getText());
				zajistiJedinecnosti(s, studentModel.getStudenti());
				studentModel.pridejStudenta(s);
				studentModel.fireTableDataChanged();
				dispose();
			}
		});
	}

	private void zajistiJedinecnosti(Student s, List<Student> studenti) {
		for (Student student : studenti) {
			if (s.equals(student)) {
				s.setCount((s.getCount() + 1));
				s.setUserName(s.generateUserName());
				zajistiJedinecnosti(s, studentModel.getStudenti());
			}
		}
	}
}
