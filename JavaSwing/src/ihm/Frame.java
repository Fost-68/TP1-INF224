package ihm;

import javax.swing.*;
import java.awt.*;


/**
 * @author WILME
 *
 * This object represents a JFrame containing a TextPanel and a ButtonPanel
 *
 * @see ButtonPanel
 * @see TextPanel
 */
public final class Frame extends JFrame{

    private static final long serialVersionUID = 1L;

    /**
     * <i>TextPanel</i> : The TextPanel of the Frame
     */
    private TextPanel textPanel;

    /**
     * <i>ButtonPanel</i> : The ButtonPanel of the Frame
     */
    private ButtonPanel buttonPanel;

    /**
     * <b>Constructor</b> : This constructs the textPanel and the JPanel, create a new layout for the current frame, and
     * sets up the usual settings of JFrame such as the size, the default close operation and so on...
     */
    public Frame(){
        textPanel = new TextPanel();
        buttonPanel = new ButtonPanel(textPanel);

        this.setSize(400, 250);
        this.setLayout(new BorderLayout());

        this.add(textPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.NORTH);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
