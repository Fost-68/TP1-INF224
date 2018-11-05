package cs;

import ihm.TextPanel;

/**
 *
 */
public class RequestThread extends Thread{
    /**
     *
     */
    private TextPanel panel;

    /**
     *
     */
    private Client client;

    /**
     *
     * @param panel
     * @param client
     */
    public RequestThread(TextPanel panel, Client client){
        this.panel = panel;
        this.client = client;
    }

    @Override
    public void run() {
        String request = "";

        while(true){
            request = panel.getOutputText();

            if(request == null){
                request = "";
            }

            System.out.println(request);

            if(request.length() > 0) {
                if (request.endsWith("\n")) {
                    panel.printInputText("Sending :\t " + (request.replace("\n", "")));
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
    }
}
