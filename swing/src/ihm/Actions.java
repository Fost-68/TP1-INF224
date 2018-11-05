package ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author WILME
 *
 * This class centralizes all actions declared in this project. For each of these actions, there is an inner class
 * inherited from AbstractClass which creates an action with a customized text and a customize ActionPerformed Method.
 *
 * From this Actions Class, it is possible for every class in the project to fetch a specified action in a static way.
 *
 * @see AbstractAction
 */
public class Actions {

    /**
     * <i>int</i> : The number of actions declared in the Actions class
     */
    public static final int NBRE_ACTIONS = 6;

    /**
     * <i>int</i> : This integer is linked to the first action, which is basically printing a message in the JTextArea of
     * the TextPanel
     *
     * @see TextPanel
     */
    public static final int PRINT_LINE_1 = 0;

    /**
     * <i>int</i> : This integer is linked to the second action, which is basically printing a message in the JTextArea of
     * the TextPanel
     *
     * @see TextPanel
     */
    public static final int PRINT_LINE_2 = 1;

    /**
     * <i>int</i> : This integer is linked to the third action, which stops the program and returns value 1
     */
    public static final int EXIT = 2;

    /**
     * <i>AbstractAction[]</i> : This array contains every actions declared in the project. It can be accessed via the
     * getter of the class
     */
    private static AbstractAction actions[];

    /**
     * This static method created all the actions declared in the inner classes and store them in the <i>actions</i> array
     *
     * @param textPanel : the main TextPanel used by serval actions instanciated here
     */
    public static void setActions(TextPanel textPanel, ToolbarPanel toolBarPanel){
        actions = new AbstractAction[NBRE_ACTIONS];

        actions[0] = new Action1(textPanel);
        actions[1] = new Action2(textPanel);
        actions[2] = new Action3();
        actions[3] = new Action4(toolBarPanel, textPanel);
        actions[4] = new Action5(textPanel);
        actions[5] = new Action6(textPanel);
    }

    /**
     * This access method return on the actions declared in subclasses of Actions
     *
     * @param i The identifier of the requested action
     * @return <i>AbstractAction</i> the requested action
     */
    public static AbstractAction getAction(int i){
        if(i >= NBRE_ACTIONS || i < 0){
            System.err.println("Wrong action value : there is only " +NBRE_ACTIONS +" actions");
            System.exit(-1);
        }
        return actions[i];
    }
}


/**
 * @author WILME
 *
 * This class represent the first declared action, which appends a message to a JTextArea
 */
class Action1 extends AbstractAction{

    /**
     * The text to be displayed on every components related to this action
     */
    private static final String text = "Play";

    /**
     * The text to append in the JTextArea
     */
    private static final String msg ="play ";

    /**
     * The TextPanel where the message associated with this action will be displayed
     */
    private TextPanel textPanel;

    /**
     * <b>Constructor</b> : Creates the action according to the constructor of the superclass, and sets the TextPanel
     * of this action
     *
     * @param textPanel The TextPanel where the message will be displayed
     */
    public Action1(TextPanel textPanel){
        super(text);
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        textPanel.clearOutputText();
        textPanel.printOutputText(msg);
    }
}


/**
 * @author WILME
 *
 * This class represent the second declared action, which appends a message to a JTextArea
 */
class Action2 extends AbstractAction{
    /**
     * The text to be displayed on every components related to this action
     */
    private static final String text = "Print";

    /**
     * The text to append in the JTextArea
     */
    private static final String msg = "print ";

    /**
     * The TextPanel where the message associated with this action will be displayed
     */
    private TextPanel textPanel;

    /**
     * <b>Constructor</b> : Creates the action according to the constructor of the superclass, and sets the TextPanel
     * of this action
     *
     * @param textPanel The TextPanel where the message will be displayed
     */
    public Action2(TextPanel textPanel){
        super(text);
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        textPanel.clearOutputText();
        textPanel.printOutputText(msg);
    }
}

/**
 *  @author WILME
 *
 *  This class represents the third declared action, which exit the program when activated
 */
class Action3 extends AbstractAction{

    /**
     * The text to be displayed on every components related to this action
     */
    private static final String text = "Quitter";

    /**
     * <b>Constructor</b> : Creates the action according following the constructor of the superclass.
     */
    public Action3(){
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(1);
    }
}

class Action4 extends AbstractAction{

    private ToolbarPanel tbp;
    private TextPanel tp;

    public Action4(ToolbarPanel tbp, TextPanel tp){
        this.tbp = tbp;
        this.tp = tp;
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent){
        String output = "";

        switch(tbp.getSelectedRadio()){
            case 0:
                tp.clearOutputText();
                System.out.println("MDR");
                return;
            case 1:
                output += "play ";
                break;
            case 2:
                output += "print ";
                break;
            case 3:
                output = "fetch";
                tp.setOutputText(output);
                return;
            default:
                System.exit(-2);
        }

        output += tbp.getSelectedMulti();

        tp.setOutputText(output);
    }
}

class Action5 extends AbstractAction{

    private TextPanel textPanel;

    public Action5(TextPanel textPanel){
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        textPanel.printOutputText("\n");
    }
}

class Action6 extends AbstractAction{
    private TextPanel textPanel;

    public Action6(TextPanel textPanel){
        this.textPanel = textPanel;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        textPanel.setOutputText("");
    }
}