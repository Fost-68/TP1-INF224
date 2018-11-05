package cs;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final long serialVersionUID = 1L;
    static final String DEFAULT_HOST = "localhost";
    static final int DEFAULT_PORT = 3331;
    private Socket sock;
    private BufferedReader input;
    private BufferedWriter output;

    public Client() throws IOException {
        sock = new Socket(DEFAULT_HOST, DEFAULT_PORT);
        input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));


    }
}
