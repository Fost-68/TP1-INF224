package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	
	private JButton b1, b2, b3;
	private TextPanel textPanel;
	
	public ButtonPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
		
		b1 = new JButton("Ajout Ligne");
		b2 = new JButton("Ajout ligne");
		b3 = new JButton("Quitter");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		this.setLayout(new GridLayout(1,3));
	}

}

class AddLine1Listenener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
