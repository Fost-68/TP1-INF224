package ihm;

import javax.swing.*;
import java.awt.*;



public final class Frame extends JFrame{

    private static final long serialVersionUID = 1L;

    private TextPanel textPanel;
    private ButtonPanel buttonPanel;

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
