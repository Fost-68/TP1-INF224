import javax.swing.*;
import java.awt.*;
import java.io.IOException;


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

    private Client client = null;
    private RequestThread rt;

    public Frame(){

        textPanel = new TextPanel();
        toolbarPanel = new ToolbarPanel(textPanel);
        myMenuBar = new MyMenuBar(this);

        try {
            client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        rt = new RequestThread(textPanel, client, toolbarPanel);
        rt.start();

        this.setSize(800, 400);
        this.setLayout(new BorderLayout());

        this.add(textPanel, BorderLayout.CENTER);
        this.add(toolbarPanel, BorderLayout.NORTH);

        this.setJMenuBar(myMenuBar);

        this.setResizable(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
