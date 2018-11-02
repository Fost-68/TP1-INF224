package ihm;

import javax.swing.*;
import java.awt.*;

/**
 *  @author WILME
 *
 *  This class represents a JPanel which contains a scrollable JTextArea
 *
 *
 */
public final class TextPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    /**
     * The <i>JTextArea</i> which is contained in this JPanel
     */
	private JTextArea textArea;

    /**
     * <b>Constructor</b> : Constructs the JPanel, the textArea and the scrollable Pane :
     * Place the Component following a BorderLayout
     */
	public TextPanel() {
	    this.setLayout(new BorderLayout());

	    textArea = new JTextArea();
		textArea.setSize(200, 200);

        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		this.add(scroller, BorderLayout.CENTER);
	}

    /**
     * Display a message in the JTextArea
     *
     * @param msg <i>String</i> : Message to display in the Text Area
     */
	public void printText(String msg){
	    textArea.append(msg + "\n");
	}
}
