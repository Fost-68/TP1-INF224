package ihm;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author WILME
 *
 * This class represents a JPanel containing three buttons, each making a different action
 * Basically, this represents a toolbar.
 *
 */
public final class ToolbarPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    /**
     * <i>JButton(s)</i> : the three JButton of this panel
     */
	private JButton b1, b2, b3;

    /**
     * <b>Constructor</b> : Constructs the buttonPanel by creating three Jbuttons, setting for each of the a specific
	 * action an action and finally, placing the three buttons following a grid layout of 3 lines and 2 rows.
     *
     */
	public ToolbarPanel() {

	    b1 = new JButton(Actions.getAction(Actions.PRINT_LINE_1));
		b2 = new JButton(Actions.getAction(Actions.PRINT_LINE_2));
		b3 = new JButton(Actions.getAction(Actions.EXIT));

		this.setLayout(new GridLayout(1,3));

		this.add(b1);
		this.add(b2);
		this.add(b3);
	}

}
