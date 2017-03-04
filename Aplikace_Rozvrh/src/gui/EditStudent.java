package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Student;
import table.StudentModel;

public class EditStudent extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jmeno = new JTextField("", 20);
	private JTextField prijmeni = new JTextField("", 20);
	private JTextField email = new JTextField("", 20);
	private JTextField userName = new JTextField("", 20);
	private JTextArea aJmeno = new JTextArea("Zadej jmeno: ");
	private JTextArea aprijmeni = new JTextArea("Zadej příjmení: ");
	private JTextArea aEmail = new JTextArea("Zadej email: ");
	private JTextArea aUserName = new JTextArea("Zadej login: ");
	private JPanel panel1 = new JPanel(new FlowLayout());
	private JPanel panel2 = new JPanel(new FlowLayout());
	private JButton ok = new JButton("OK");

	public EditStudent(Student s, StudentModel studentModel) {
		setTitle("Uprav Studenta");
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		panel1.add(aJmeno);
		panel1.add(jmeno);
		panel1.add(aprijmeni);
		panel1.add(prijmeni);
		panel2.add(aEmail);
		panel2.add(email);
		panel2.add(aUserName);
		panel2.add(userName);
		panel2.add(ok);
		jmeno.setText(s.getFirstName());
		prijmeni.setText(s.getLastName());
		email.setText(s.getEmail());
		userName.setText(s.generateUserName());
		pack();
		aJmeno.setEditable(false);
		aprijmeni.setEditable(false);
		aEmail.setEditable(false);

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s.setFirstName(jmeno.getText());
				s.setLastName(prijmeni.getText());
				s.setEmail(email.getText());
				s.setUserName(userName.getText());
				studentModel.fireTableDataChanged();
				dispose();
			}
		});

	}

}
