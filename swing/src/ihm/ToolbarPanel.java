package ihm;

import javax.swing.*;
import java.awt.*;

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
     * <i>JRadioButtons</i>
     */
    private JRadioButton r1, r2, r3;

    /**
     * <i>JComboBox</i>
     */
    private JComboBox cBox;

    /**
     * <i>ButtonGroup</i>
     */
    private ButtonGroup bg;

    /**
     * <i>JButton</i>
     */
    private JButton pleaseButton;

    /**
     * <b>Constructor</b> : Constructs the buttonPanel by creating three Jbuttons, setting for each of the a specific
	 * action an action and finally, placing the three buttons following a grid layout of 3 lines and 2 rows.
     *
     */
	public ToolbarPanel() {

	    this.setLayout(new GridLayout(1,3));
	    JPanel requestPanel = new JPanel();
	    requestPanel.setLayout(new GridLayout(3,1));


	    r1 = new JRadioButton("Play");
	    r2 = new JRadioButton("Print");
	    r3 = new JRadioButton("Fetch");

	    requestPanel.add(r1);
	    requestPanel.add(r2);
	    requestPanel.add(r3);

	    bg = new ButtonGroup();
	    bg.add(r1);
	    bg.add(r2);
	    bg.add(r3);

	    cBox = new JComboBox();

	    pleaseButton = new JButton("Please");

	    this.add(requestPanel);
	    this.add(cBox);
	    this.add 

	}

	public void setJComboBox(String [] fetchResult){
	    cBox.removeAllItems();
	    for(String s : fetchResult){
	        cBox.addItem(s);
        }
    }





}
