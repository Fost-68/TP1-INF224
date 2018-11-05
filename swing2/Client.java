import java.io.*;
import java.net.Socket;

/**
 *
 */
public class Client {
    private static final long serialVersionUID = 1L;
    static final String DEFAULT_HOST = "localhost";
    static final int DEFAULT_PORT = 3331;
    private Socket sock;
    private BufferedReader input;
    private BufferedWriter output;

    /**
     *
     * @throws IOException
     */
    public Client() throws IOException {
        sock = new Socket(DEFAULT_HOST, DEFAULT_PORT);
        input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    }

    /**
     *
     * @param request
     * @return
     */
    public String send(String request) {
        // Envoyer la requete au serveur
        try {
            output.write(request, 0, request.length());
            output.flush();
        }
        catch (java.io.IOException e) {
            System.err.println("Client: Couldn't send message: " + e);
            return null;
        }

        // Recuperer le resultat envoye par le serveur
        try {
            return input.readLine();
        }
        catch (java.io.IOException e) {
            System.err.println("Client: Couldn't receive message: " + e);
            return null;
        }
    }
}

