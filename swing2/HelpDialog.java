import javax.swing.*;
import java.awt.*;

public class HelpDialog extends JDialog{
    private static final long serialVersionUID = 1L;

    public HelpDialog(Frame frame){
        super(frame, "Help", true);
        this.setLayout(new GridLayout(1,1));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        this.setSize(800, 200);

        createLabels();

        this.setVisible(true);
    }

    private void createLabels(){
        JTextArea tx = new JTextArea();
        this.add(tx);
        tx.setEditable(false);
        tx.setSize(800,200);

        tx.append("HELP \n");
        tx.append("\n");
        tx.append("Cette télécommande est composée de trois parties: \nLa première, composé des différents boutons " +
                "permet de générer rapidement les lignes de commande. \n" +
                "Play et Print sont comme spécifiés dans l'énoncé.\n" +
                "Fetch permet de récupérer le nom de tous les medias et de les stocker dans le menu défilant. " +
                "\nPlease permet d'envoyer la requête." +
                "\nClear permet d'effacer ce qui est écrit en ligne de commande\n ");
        tx.append("\n");
        tx.append("Si jamais l'aide aux commandes ne vous plaît pas, vous pouvez rentrer les commandes à la main, directement\n" +
                "dans le premier JTextArea");
        tx.append("\n\n");
        tx.append("Le dernier TextArea affiche les requêtes envoyées et les réponses à ces requêtes");
    }
}
