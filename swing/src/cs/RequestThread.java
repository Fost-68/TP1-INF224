package cs;

import ihm.TextPanel;

public class RequestThread extends Thread{

    private TextPanel panel;
    private Client client;

    public RequestThread(TextPanel panel, Client client){
        this.panel = panel;
        this.client = client;
    }
    @Override
    public void run() {
        String request = "";

        while(true){
            request = panel.getOutputText().replace("Command > ", "");

            if(request.length() > 0) {
                if (request.charAt(request.length() - 1) == '\n') {
                    panel.printInputText(("Sending : " + request).replace("\n", ""));
                    panel.clearOutputText();
                    processReply(client.send(request));
                }

            }

        }


    }

    private void processReply(String reply){
        System.out.println(reply);
        reply.replace("|", "\n");
        panel.printInputText("Received : " +reply);
        panel.printInputText("\n");
    }
}
