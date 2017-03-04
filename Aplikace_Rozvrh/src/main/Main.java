package main;

import javax.swing.SwingUtilities;

import gui.MainFrame;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
				mf.setMf(mf);
			}
		});
	}

}
