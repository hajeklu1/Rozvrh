package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Day;
import model.Predmet;
import table.PredmetyModel;

public class UpravPredmet extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField abrev = new JTextField("", 20);
	private JTextField jmeno = new JTextField("", 20);
	private JTextField ucitel = new JTextField("", 20);
	private JTextArea aRoomNo = new JTextArea("Zadej čislo učebny: ");
	private JComboBox<Integer> roomNo = new JComboBox<>();
	private JComboBox<Integer> hodina = new JComboBox<>();
	private JComboBox<String> day = new JComboBox<>();
	private JTextArea aabrev = new JTextArea("Zadej zkratku: ");
	private JTextArea aJmeno = new JTextArea("Zadej název: ");
	private JTextArea aUcitel = new JTextArea("Zadej učitele: ");
	private JTextArea aHodina = new JTextArea("Zadej hodinu: ");
	private JTextArea aDay = new JTextArea("Zadej den: ");
	private JPanel panel1 = new JPanel(new FlowLayout());
	private JPanel panel2 = new JPanel(new FlowLayout());
	private JButton ok = new JButton("OK");

	public UpravPredmet(Predmet predmet, PredmetyModel predmetModel) {
		for (int i = 1; i < 31; i++) {
			roomNo.addItem(i);
		}
		for (int i = 1; i < 9; i++) {
			hodina.addItem(i);
		}
		day.addItem("Pondělí");
		day.addItem("Úterý");
		day.addItem("Středa");
		day.addItem("Čtvrtek");
		day.addItem("Pátek");
		setTitle("Uprav studenta");
		abrev.setText(predmet.getAbrev());
		jmeno.setText(predmet.getName());
		ucitel.setText(predmet.getLectorName());
		roomNo.setSelectedItem(predmet.getRoomNo());
		hodina.setSelectedItem(predmet.getHour());
		day.setSelectedItem(Day.dayToString(predmet.getWeekDay()));
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		panel1.add(aabrev);
		panel1.add(abrev);
		panel1.add(aJmeno);
		panel1.add(jmeno);
		panel1.add(aUcitel);
		panel1.add(ucitel);
		panel2.add(aRoomNo);
		panel2.add(roomNo);
		panel2.add(aHodina);
		panel2.add(hodina);
		panel2.add(aDay);
		panel2.add(day);
		panel2.add(ok);

		aabrev.setEditable(false);
		aJmeno.setEditable(false);
		aUcitel.setEditable(false);
		aRoomNo.setEditable(false);
		aHodina.setEditable(false);
		aDay.setEditable(false);

		pack();

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				predmet.setAbrev(abrev.getText());
				predmet.setName(jmeno.getText());
				predmet.setHour(hodina.getSelectedIndex() + 1);
				predmet.setLectorName(ucitel.getText());
				predmet.setWeekDay(Day.stringToDays((String) day.getSelectedItem()));
				predmet.setRoomNo(roomNo.getSelectedIndex() + 1);
				predmetModel.fireTableDataChanged();
				dispose();
			}
		});
	}

}
