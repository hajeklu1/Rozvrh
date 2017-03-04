package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import exportImport.Reader;
import exportImport.Writer;
import model.Predmet;
import model.Student;
import table.PredmetyModel;
import table.RozvrhModel;
import table.StudentModel;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable rozvrhTable;
	private JScrollPane rozvrhScroll;
	private RozvrhModel rozvrhModel;
	private PredmetyModel predmetyModel;
	private JTabbedPane tPane = new JTabbedPane();
	private JLabel predmety = new JLabel("");
	private JTextField sJmeno = new JTextField(20);
	private JTextField slogin = new JTextField(20);
	private JTextField sEmail = new JTextField(20);
	private JPanel panel1 = new JPanel(new FlowLayout(10));
	private JPanel panel2 = new JPanel(new FlowLayout(10));
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JButton sNacti = new JButton("Načti studenta");
	private JButton pNacti = new JButton("Předměty");
	private JButton volnyCas = new JButton("Volný čas S:");
	private JButton rozvrhViceStudentu = new JButton("Ok");
	private Student student;
	private MainFrame mf;
	private JButton admin = new JButton("Adminisitrator");
	private JButton uloz = new JButton("Ulož");
	private StudentModel studentModel = new StudentModel();
	private JComboBox<Integer> pocetStudentu = new JComboBox<>();
	private Writer writer = new Writer();
	private Reader reader = new Reader();

	public MainFrame() {
		pNacti.setEnabled(false);
		volnyCas.setEnabled(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		student = new Student("", "", "", "");
		add(panel3, BorderLayout.EAST);
		panel2.add(pNacti);
		panel2.add(volnyCas);
		panel3.add(admin);
		panel3.add(uloz);
		add(panel1, BorderLayout.NORTH);
		sJmeno.setEditable(false);
		slogin.setEditable(false);
		sEmail.setEditable(false);
		panel1.add(sJmeno);
		panel1.add(slogin);
		panel1.add(sEmail);
		panel1.add(sNacti);
		add(tPane, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Rozvrh více studentů najednou", TitledBorder.CENTER, TitledBorder.TOP));
		panel4.add(rozvrhViceStudentu);
		panel4.add(pocetStudentu);
		panel2.add(panel4);
		setTitle("Rozvrh Hodin");
		panel4.setPreferredSize(new Dimension(200, 60));
		rozvrhModel = new RozvrhModel(student);
		rozvrhTable = new JTable(rozvrhModel);
		rozvrhScroll = new JScrollPane(rozvrhTable);
		tPane.add(rozvrhScroll, "Rozvrh");
		tPane.add(predmety, "Predmety");
		predmetyModel = new PredmetyModel(student);
		for (int i = 2; i < 11; i++) {
			pocetStudentu.addItem(i);
		}
		sNacti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NactiStudenta st = new NactiStudenta(mf, studentModel);
				st.setVisible(true);
				sJmeno.setText(student.getFirstName() + " " + student.getLastName());
			}
		});

		pNacti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VyberPredmet vp = new VyberPredmet(student, mf, predmetyModel);
				vp.setVisible(true);

			}
		});

		admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin ad = new Admin(studentModel, predmetyModel);
				ad.setVisible(true);

			}
		});

		volnyCas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RoszvrhSeStudentem r = new RoszvrhSeStudentem(studentModel, student);
				r.setVisible(true);
			}
		});

		rozvrhViceStudentu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VyberViceStudentu v = new VyberViceStudentu(studentModel.getStudenti(),
						(int) pocetStudentu.getSelectedItem());
				v.setVisible(true);
			}
		});

		uloz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				writer.writeStudent(studentModel.getStudenti());
				writer.writePredmet(predmetyModel.getPredmety());
			}
		});
		studentModel.setStudenti(reader.readStudet(predmetyModel));
		//doplníme nezapsané předměty
		reader.readPredmet(predmetyModel);
		pack();
	}

	public void refreash() {
		sJmeno.setText(student.getFirstName() + " " + student.getLastName());
		slogin.setText(student.getUserName());
		sEmail.setText(student.getEmail());
		String buffer = "<html>";
		for (Predmet predmet : student.getRegisterPredemt()) {
			buffer += predmet.getAbrev() + " " + predmet.getName() + " " + predmet.getLectorName() + " "
					+ predmet.getWeekDay() + " " + predmet.getRoomNo() + " " + predmet.getHour() + "h<br>";
		}
		buffer += "</html>";
		predmety.setText(buffer);
		volnyCas.setEnabled(true);
		pNacti.setEnabled(true);
		rozvrhModel.setStudent(student);
		rozvrhModel.fireTableDataChanged();
		predmetyModel.setStudent(student);
		predmetyModel.fireTableDataChanged();
	}

	public JTextField getsJmeno() {
		return sJmeno;
	}

	public void setsJmeno(JTextField sJmeno) {
		this.sJmeno = sJmeno;
	}

	public JTextField getsPrijmeni() {
		return slogin;
	}

	public void setsPrijmeni(JTextField sPrijmeni) {
		this.slogin = sPrijmeni;
	}

	public JTextField getsEmail() {
		return sEmail;
	}

	public void setsEmail(JTextField sEmail) {
		this.sEmail = sEmail;
	}

	public MainFrame getMf() {
		return mf;
	}

	public void setMf(MainFrame mf) {
		this.mf = mf;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
