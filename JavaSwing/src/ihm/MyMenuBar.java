package ihm;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar{

    public MyMenuBar(){
        this.add(new myMenu("Menu1"));
        this.add(new myMenu("Menu2"));
        this.add(new myMenu("Menu3"));

        this.setVisible(true);
    }
}

class myMenu extends JMenu{

    public myMenu(String menuName){
        super(menuName);
        this.add(new JMenuItem(Actions.getAction(Actions.PRINT_LINE_1)));
        this.add(new JMenuItem(Actions.getAction(Actions.PRINT_LINE_2)));
        this.add(new JMenuItem(Actions.getAction(Actions.EXIT)));
    }

}
