package application;
import javax.swing.*;
import java.awt.*;

public void

/** This class represents a bar graph.
 * 
 * @author CS219-user
 *
 */
public class VisualBar{

private JFrame frame = new JFrame();
private JVisualBar bar = new JVisualBar();
	   
/** This constructor constructs an object of type VisualBar.
 * 
 */
VisualBar(){
		   
		   bar.setValue(0);
		   bar.setBounds(0,0,200,50);
		   bar.setStringPainted(true);
		   
		   frame.add(bar);
		   frame.setDefaultCloseOperattion(JFrame.EXIT_ON_CLOSE);
		   frame.setSize(200,200);
		   frame.setLayout(Null);
		   frame.setVisible(true);
		
	}
	   
}