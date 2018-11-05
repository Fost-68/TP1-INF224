

/**
 *
 */
public class RequestThread extends Thread{
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private TextPanel panel;

    /**
     *
     */
    private Client client;

    private ToolbarPanel toolbarPanel;

    /**
     *
     * @param panel
     * @param client
     */
    public RequestThread(TextPanel panel, Client client, ToolbarPanel toolbarPanel){
        this.panel = panel;
        this.client = client;
        this.toolbarPanel = toolbarPanel;
    }

    @Override
    public void run() {
        String request = "";

        while(true){
            request = panel.getOutputText();

            if(request == null){
                request = "";
            }

            if(request.length() > 0) {
                if (request.endsWith("\n")) {
                    panel.printInputText("Sent :\t " + (request.replace("\n", "")));
                    panel.clearOutputText();
                    processReply(client.send(request));
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param reply
     */
    private void processReply(String reply){
        panel.printInputText(("Received :\n\t " +reply).replace("$", "\n\t"));
        panel.printInputText("\n-------------------------------------\n");

        if(reply.contains("fetch")){
            String[] splitReply = reply.split(" ");
            splitReply[0] = "";

            toolbarPanel.setJComboBox(splitReply);
        }

    }
}
