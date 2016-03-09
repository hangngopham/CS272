package myprograms;

import javax.swing.*;

public class WelcomeApplet extends JApplet{
	/**
	 * Initialize the applet
	 */
	public void init() {
		getContentPane().add(new JLabel("Welcome to Java", JLabel.CENTER));
	}
}
