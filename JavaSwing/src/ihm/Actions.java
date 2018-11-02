package ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Actions {

    public static final int NBRE_ACTIONS = 3;

    public static final int PRINT_LINE_1 = 0;
    public static final int PRINT_LINE_2 = 1;
    public static final int EXIT = 2;


    private static AbstractAction actions[];

    public static void setActions(TextPanel textPanel){
        actions = new AbstractAction[NBRE_ACTIONS];

        actions[0] = new Action1(textPanel);
        actions[1] = new Action2(textPanel);
        actions[2] = new Action3();
    }

    public static AbstractAction getAction(int i){
        if(i >= 3 || i < 0){
            System.err.println("Wrong action value : there is only " +NBRE_ACTIONS +" actions");
            System.exit(-1);
        }
        return actions[i];
    }
}


class Action1 extends AbstractAction{

    private static final String text = "Action 1";

    private TextPanel textPanel;

    public Action1(TextPanel textPanel){
        super(text);
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        textPanel.printText("C'est le bouton 1");
    }
}


class Action2 extends AbstractAction{

    private static final String text = "Action 2";

    private TextPanel textPanel;

    public Action2(TextPanel textPanel){
        super(text);
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        textPanel.printText("C'est le bouton 2");
    }
}


class Action3 extends AbstractAction{

    private static final String text = "Quitter";

    public Action3(){
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(1);
    }
}
