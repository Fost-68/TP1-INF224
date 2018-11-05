package ihm;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author WILME
 *
 * This class represents a MenuBar which includes three exact same menu
 */
public class MyMenuBar extends JMenuBar{

    private Frame frame;

    /**
     * <b>Constructor</b> : Creates the Menu bar, add all 3 MyMenu to it and set itself visible
     *
     * @see Menu
     */
    public MyMenuBar(Frame frame){
        this.add(new Menu("?", frame));
        this.frame = frame;
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
    public Menu(String menuName, Frame frame) {
        super(menuName);
        JMenuItem jmi = new JMenuItem("Help");

        jmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new HelpDialog(frame);
            }
        });

        this.add(jmi);

    }

}
