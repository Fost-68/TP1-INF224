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
	private JTextArea inputTextArea;
	private JTextArea outputTextArea;

    /**
     * <b>Constructor</b> : Constructs the JPanel, the textArea and the scrollable Pane :
     * Place the Component following a BorderLayout
     */
	public TextPanel() {
	    this.setLayout(new BorderLayout());

	    JPanel commandPanel = new JPanel();
        commandPanel.setLayout(new BorderLayout());

        JTextArea commandTextArea = new JTextArea("Command > ");
        commandTextArea.setEditable(false);
        commandTextArea.setSize(30,40);



	    inputTextArea = new JTextArea();
		inputTextArea.setEditable(false);
	    inputTextArea.setSize(200, 200);

		outputTextArea = new JTextArea();
		outputTextArea.setSize(30,300);


		commandPanel.add(commandTextArea, BorderLayout.WEST);
		commandPanel.add(outputTextArea, BorderLayout.CENTER);

        JScrollPane scroller = new JScrollPane(inputTextArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(commandPanel, BorderLayout.NORTH);
		this.add(scroller, BorderLayout.CENTER);

	}

    /**
     * Display a message in the JTextArea
     *
     * @param msg <i>String</i> : Message to display in the Text Area
     */
	public void printInputText(String msg){
		inputTextArea.append(msg + "\n");
        inputTextArea.setCaretPosition(inputTextArea.getText().length());
	}

    /**
     *
     */
	public void clearOutputText(){
        outputTextArea.setText("");
	}


	public void setOutputText(String msg){
	    outputTextArea.setText(msg);
    }
	/**
     *
     * @param msg
     */
	public void printOutputText(String msg){
        outputTextArea.append(msg);
    }



    public String getOutputText(){
		return outputTextArea.getText();
	}

}
