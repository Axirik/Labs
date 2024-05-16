package kir.lab.client;

import kir.lab.common.util.Request;
import kir.lab.common.util.Response;


import java.io.*;
import java.net.Socket;

public class Dialog {
    static Socket socket;
    public Dialog() throws IOException {
        this.socket = new Socket("localhost", 12345);
    }
    public static void send(Request request) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream serializator = new ObjectOutputStream(bytes);
        serializator.writeObject(request);
        serializator.flush();
        out.println(bytes);
        serializator.close();
        out.close();
        bytes.close();
    }
    public static Response read() throws IOException, ClassNotFoundException {
        /*ByteArrayInputStream bytes = new ByteArrayInputStream(socket.getInputStream());
        ObjectInputStream in = new ObjectInputStream(bytes);
        Request request = (Request) in.readObject();
        bytes.close();
        in.close();
         */
        return null;
    }
}
