package ihm;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends JPanel{
	
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea(); 
	}
	
	public void printText(String msg){
		textArea.append(msg);
	}
	

}
