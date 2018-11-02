package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author WILME
 *
 * This class represents a JPanel containing three buttons, each making a different action
 */
public final class ButtonPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    /**
     * <i>JButton(s)</i> : the three JButton of this panel
     */
	private JButton b1, b2, b3;

    /**
     * <i>TextPanel</i> : the textPanel of the main frame. This panel is added as an attribute of this ButtonPanel so
     * the button can easily calls function of the TextArea
     */
	private TextPanel textPanel;

    /**
     * <b>Constructor</b> : Constructs the buttonPanel by setting as an attribute a specified textPanel, by creating three
     * Jbuttons, by setting for those all three buttons an action and finally, placing the thre buttons following a grid layout
     * of 3 lines and 2 rows.
     *
     * @param textPanel The <i>TextPanel</i> associated with this ButtonPanel
     */
	public ButtonPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
		
		b1 = new JButton("Ajout Ligne");
		b2 = new JButton("Ajout ligne");
		b3 = new JButton("Quitter");

		this.setActionListener();

		this.setLayout(new GridLayout(1,3));

		this.add(b1);
		this.add(b2);
		this.add(b3);
	}

    /**
     * This private method sets the action listener for the three button of the panel
     * It is only called when the panel is constructed
     */
	private void setActionListener(){
        b1.addActionListener(e -> textPanel.printText("C'est le bouton 1"));
        b2.addActionListener(e -> textPanel.printText("C'est le bouton 2"));
        b3.addActionListener(e -> System.exit(1));
    }
}
