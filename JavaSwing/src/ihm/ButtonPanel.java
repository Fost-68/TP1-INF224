package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class ButtonPanel extends JPanel{
	
	private JButton b1, b2, b3;
	private TextPanel textPanel;
	
	public ButtonPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
		
		b1 = new JButton("Ajout Ligne");
		b2 = new JButton("Ajout ligne");
		b3 = new JButton("Quitter");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPanel.printText("C'est le bouton 1 \n");
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPanel.printText("C'est le bouton 2 \n");
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		
		this.setLayout(new GridLayout(1,3));

		this.add(b1);
		this.add(b2);
		this.add(b3);
	}

}
