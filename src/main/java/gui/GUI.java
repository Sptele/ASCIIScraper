package gui;

import browser.masssearch.MassSearchEnabler;

import javax.swing.*;

public class GUI {
	JFrame frame;

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	public GUI(String title) {
		frame = new JFrame(title);

		frame.setSize(WIDTH, HEIGHT); // 640 x 480
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init(MassSearchEnabler enabler) {

	}

	public void show() {
		frame.setVisible(true);
	}


}
