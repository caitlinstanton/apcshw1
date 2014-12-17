import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui2 extends JFrame implements ActionListener {

    private Container pane;
    private JButton b1,b2, labeler;
    private JCheckBox box;
    private JLabel l;
    private JTextArea text;
    private JPanel canvas;

    //INNER CLASS (class within a class)
    private class Key implements KeyListener {

	public void keyPressed(KeyEvent e) {
	    //  System.out.println(e);
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {
	    if (box.isSelected()) {
		String s = text.getText();
		s.toUpperCase();
		text.setText(s);
	    }
	}
    }
    
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == b1) {
	    System.out.println("You clicked 'click me'");
	    System.out.println("By the way, the text box has: " + text.getText());
	} else if (e.getSource() == b2) {
	    System.out.println("Shutting down");
	    System.exit(0);
	} else if (e.getSource() == labeler) {
	    l.setText(text.getText());
	    //JLabel l2 = new JLabel(text.getText());
	    //pane.add(l2);
	}
    }
    
    public Gui2(){
	setTitle("My First Gui");
	setSize(600,600);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = getContentPane();
	//pane.setLayout(new GridLayout(3,3));
	pane.setLayout(new FlowLayout());
	l = new JLabel("The Label:");
	pane.add(l);
	
	b1 = new JButton("click me");
	pane.add(b1);
	b1.addActionListener(this);
	b2 = new JButton("exit");
	pane.add(b2);
	b2.addActionListener(this);
	labeler = new JButton("labeler");
	pane.add(labeler);
	labeler.addActionListener(this);
	box = new JCheckBox("Cap");
	pane.add(box);
	text = new JTextArea();
	text.setColumns(40);
	text.setRows(10);
	text.setBorder(BorderFactory.createLineBorder(Color.red,2));
	text.addKeyListener(new Key());
	pane.add(text);
	
	canvas = new JPanel();
	canvas.setPreferredSize(new Dimension(300,300));
	canvas.setBorder(BorderFactory.createLineBorder(Color.blue,2));
	pane.add(canvas);	
    }
    
    public static void main(String[] args) {
	Gui2 f = new Gui2();
	f.setVisible(true);
    }
}
