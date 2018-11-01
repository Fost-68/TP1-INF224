package ihm;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.*;

public final class TextPanel extends JPanel{
	
	private JTextArea textArea;
	
	public TextPanel() {
	    this.setLayout(new BorderLayout());
		textArea = new JTextArea();
		textArea.setSize(200, 200);
		this.add(textArea, BorderLayout.CENTER);
	}
	
	public void printText(String msg){
	    textArea.append(msg);
	}
}
