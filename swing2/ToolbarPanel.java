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
    private JButton pleaseButton, clearButton;

    /**
     * <b>Constructor</b> : Constructs the buttonPanel by creating three Jbuttons, setting for each of the a specific
	 * action an action and finally, placing the three buttons following a grid layout of 3 lines and 2 rows.
     *
     */
	public ToolbarPanel(TextPanel textPanel) {

	    this.setLayout(new GridLayout(1,4));
	    JPanel requestPanel = new JPanel();
	    requestPanel.setLayout(new GridLayout(3,1));

        Actions.setActions(textPanel, this);

	    r1 = new JRadioButton("Play");
	    r1.addActionListener(Actions.getAction(3));

	    r2 = new JRadioButton("Print");
	    r2.addActionListener(Actions.getAction(3));

	    r3 = new JRadioButton("Fetch");
	    r3.addActionListener(Actions.getAction(3));

	    requestPanel.add(r1);
	    requestPanel.add(r2);
	    requestPanel.add(r3);

	    bg = new ButtonGroup();
	    bg.add(r1);
	    bg.add(r2);
	    bg.add(r3);

	    cBox = new JComboBox();
	    cBox.addActionListener(Actions.getAction(3));

	    pleaseButton = new JButton("Please");
	    pleaseButton.addActionListener(Actions.getAction(4));

	    clearButton = new JButton("Clear");
	    clearButton.addActionListener(Actions.getAction(5));

	    this.add(requestPanel);
	    this.add(cBox);
	    this.add(pleaseButton);
	    this.add(clearButton);
	}

	public void setJComboBox(String [] fetchResult){
	    cBox.removeAllItems();
	    for(String s : fetchResult){
	        cBox.addItem(s);
        }
        cBox.addActionListener(Actions.getAction(4));
    }

    public int getSelectedRadio(){
	    if(r1.isSelected()){
	        return 1;
        }

        else if(r2.isSelected()){
	        return 2;
        }

        else if(r3.isSelected()){
	        return 3;
        }

        else{
	        return 0;
        }
    }

    public String getSelectedMulti(){

        if(cBox.getSelectedItem() == null){
            return "";
        }

        return (String)cBox.getSelectedItem();
    }
}
