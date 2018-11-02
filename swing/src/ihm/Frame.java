package ihm;

import javax.swing.JFrame;
import java.awt.BorderLayout;


/**
 * @author WILME
 *
 * This object represents a JFrame containing a TextPanel and a ToolbarPanel
 *
 * @see ToolbarPanel
 * @see TextPanel
 */
public final class Frame extends JFrame{

    private static final long serialVersionUID = 1L;

    /**
     * <i>TextPanel</i> : The TextPanel of the Frame
     */
    private TextPanel textPanel;

    /**
     * <i>ToolbarPanel</i> : The ToolbarPanel of the Frame
     */
    private ToolbarPanel toolbarPanel;

    private MyMenuBar myMenuBar;

    /**
     * <b>Constructor</b> : This constructs the textPanel and the JPanel, create a new layout for the current frame, and
     * sets up the usual settings of JFrame such as the size, the default close operation and so on...
     */
    public Frame(){

        textPanel = new TextPanel();
        Actions.setActions(textPanel);
        toolbarPanel = new ToolbarPanel();
        myMenuBar = new MyMenuBar();

        this.setSize(400, 250);
        this.setLayout(new BorderLayout());

        this.add(textPanel, BorderLayout.CENTER);
        this.add(toolbarPanel, BorderLayout.NORTH);

        this.setJMenuBar(myMenuBar);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
