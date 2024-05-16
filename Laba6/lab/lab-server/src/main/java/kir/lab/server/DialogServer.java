package kir.lab.server;

import kir.lab.common.util.Request;
import kir.lab.common.util.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DialogServer {
    ServerSocket socket;
    public DialogServer() throws IOException {
        this.socket = new ServerSocket(12345);
    }
    Request read() throws IOException, ClassNotFoundException {
        Socket clientSocket = socket.accept();
        ByteArrayInputStream bytes = new ByteArrayInputStream(clientSocket.getInputStream().readAllBytes());
        ObjectInputStream in = new ObjectInputStream(bytes);
        Request request = (Request) in.readObject();
        bytes.close();
        in.close();
        return request;
    }
    public void send(Response request) throws IOException {
        Socket clientSocket = socket.accept();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream serializator = new ObjectOutputStream(bytes);
        serializator.writeObject(request);
        serializator.flush();
        out.println(bytes);
        serializator.close();
        out.close();
        bytes.close();
    }
}

