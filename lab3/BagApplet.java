package lab3;

//File: BagApplet.java
//This applet is a small example to illustrate how to write an interactive 
//Applet to test the methods of another class. This first version tests
//three of the IntArrayBag methods.
//-- Michael Main (main@colorado.edu)

//import edu.colorado.collections.IntArrayBag;
import java.applet.Applet;
import java.awt.*; // Imports Button, Canvas, TextArea, TextField
import java.awt.event.*; // Imports ActionEvent, ActionListener

public class BagApplet extends Applet {
	// An IntArrayBag for this Applet to manipulate:
	private IntArrayBag b1 = new IntArrayBag();
	private IntArrayBag b2 = new IntArrayBag();

	// These are the interactive Components that will appear in the Applet.
	// We declare one Button for each IntArrayBag method that we want to be able
	// to
	// test. If the method has an argument, then there is also a TextField
	// where the user can enter the value of the argument.
	// At the bottom, there is a TextArea to write messages.

	// private Button sizeButton = new Button("size( )");

	private Button addButton1 = new Button("b1.add( )");
	private TextField elementText = new TextField(10);
	// private Button countOccurrencesButton = new
	// Button("countOccurrences( )");
	private Button addButton2 = new Button("b2.add()");
	// private TextField elementText2 = new TextField(10);

	private Button removeButton1 = new Button("b1.remove()");
	// private TextField targetText1 = new TextField(10);
	private Button removeButton2 = new Button("b2.remove()");
	// private TextField targetText2 = new TextField(10);

	private Button toStringButton1 = new Button("b1.toString()");
	// private TextField toStringText1 = new TextField(10);

	private Button toStringButton2 = new Button("b2.toString()");
	// private TextField toStringText2 = new TextField(10);

	private Button equalsButton = new Button("b1.equals(b2)");
	// private TextField equalsText = new TextField(10);

	private TextArea feedback = new TextArea(7, 60);

	public void init() {
		// Some messages for the top of the Applet:
		add(new Label("This test program has created two bags."));
		add(new Label("Press buttons to activate methods."));
		addHorizontalLine(Color.blue);

		// The Button for testing the size method:
		// add(sizeButton);
		// addNewLine();

		// The Button for testing the add method for bag1:
		add(addButton1);

		// The Button for testing the remove method for bag1:
		add(removeButton1);

		// The TextField for testing all methods for bag1 and bag2:
		add(elementText);
		
		// The Button for testing the add method for bag2:
		add(addButton2);

		// The Button for testing the remove method for bag2:
		add(removeButton2);

		addNewLine();

		// The Button for testing the toString method for bag1:
		add(toStringButton1);

		// The Button for testing the toString method for bag2:
		add(toStringButton2);
		addNewLine();

		// The Button for testing the equals method for bag1 and
		// bag2:
		add(equalsButton);
		// add(equalsText);
		addNewLine();

		// A TextArea at the bottom to write messages:
		addHorizontalLine(Color.blue);
		addNewLine();
		feedback.setEditable(false);
		feedback.append("I am ready for your first action.\n");
		add(feedback);

		// Tell the Buttons what they should do when they are clicked:
		addButton1.addActionListener(new AddListener1());
		addButton2.addActionListener(new AddListener2());

		removeButton1.addActionListener(new RemoveListener1());
		removeButton2.addActionListener(new RemoveListener2());

		toStringButton1.addActionListener(new toStringListener1());
		toStringButton2.addActionListener(new toStringListener2());

		equalsButton.addActionListener(new equalsListener());

	}

	class AddListener1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String userInput = elementText.getText();
				int element = Integer.parseInt(userInput);
				b1.add(element);
				feedback.append(element + " has been added to the bag1.\n");

			} catch (NumberFormatException e) {
				feedback.append("Type an integer before clicking button.\n");
				elementText.requestFocus();
				elementText.selectAll();
			}
		}
	}

	class AddListener2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String userInput = elementText.getText();
				int element = Integer.parseInt(userInput);
				b2.add(element);
				feedback.append(element + " has been added to the bag2.\n");

			} catch (NumberFormatException e) {
				feedback.append("Type an integer before clicking button.\n");
				elementText.requestFocus();
				elementText.selectAll();
			}
		}
	}

	class RemoveListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String userInput = elementText.getText();
				int element = Integer.parseInt(userInput);
				b1.remove(element);
				feedback.append(element + " has been removed from the bag1.\n");
			} catch (NumberFormatException e1) {
				feedback.append("Type an integer before clicking button.\n");
				elementText.requestFocus();
				elementText.selectAll();
			}
		}

	}

	class RemoveListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String userInput = elementText.getText();
				int element = Integer.parseInt(userInput);
				b2.remove(element);
				feedback.append(element + " has been removed from the bag1.\n");
			} catch (NumberFormatException e1) {
				feedback.append("Type an integer before clicking button.\n");
				elementText.requestFocus();
				elementText.selectAll();
			}
		}

	}

	class toStringListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String result = b1.toString();
			feedback.append("The output of toString() is " + result + ".\n");
		}

	}

	class toStringListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String result = b2.toString();
			feedback.append("The output of toString() is " + result +".\n");
		}

	}

	class equalsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (b1.equals(b2)) {
				feedback.append("b1 is equal to b2.\n");
			} else {
				feedback.append("b1 is not equal to b2.\n");
			}

		}
	}

	private void addHorizontalLine(Color c) {
		// Add a Canvas 10000 pixels wide but only 1 pixel high, which acts
		// as
		// a horizontal line to separate one group of components from the
		// next.
		Canvas line = new Canvas();
		line.setSize(10000, 1);
		line.setBackground(c);
		add(line);
	}

	private void addNewLine() {
		// Add a horizontal line in the background color. The line itself is
		// invisible, but it serves to force the next Component onto a new
		// line.
		addHorizontalLine(getBackground());
	}

}
