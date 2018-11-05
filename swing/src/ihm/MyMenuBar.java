package ihm;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author WILME
 *
 * This class represents a MenuBar which includes three exact same menu
 */
public class MyMenuBar extends JMenuBar{

    /**
     * <b>Constructor</b> : Creates the Menu bar, add all 3 MyMenu to it and set itself visible
     *
     * @see Menu
     */
    public MyMenuBar(){
        this.add(new Menu("?"));

        this.setVisible(true);
    }
}

/**
 * This class represents a Menu in which we add three MenuItem associated with an action declared
 * in the Actions class
 *
 * @see Actions
 */
class Menu extends JMenu{

    /**
     * <b>Constructor</b> :
     *
     * @param menuName
     */
    public Menu(String menuName){
        super(menuName);
        this.add(new JMenuItem("Help"));
    }

}
