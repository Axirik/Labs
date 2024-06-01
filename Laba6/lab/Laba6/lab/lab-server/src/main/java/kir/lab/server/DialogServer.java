package kir.lab.server;

import kir.lab.common.util.Request;
import kir.lab.common.util.Response;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class DialogServer {
    ServerSocketChannel serverSocketChannel;

    public DialogServer(Selector selector) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 12345));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void send(Response response, SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(response);
        ByteBuffer response_buffer = ByteBuffer.wrap(bos.toByteArray());
        socketChannel.write(response_buffer);
        oos.close();
        bos.close();
        response_buffer.clear();
    }

    public Request read(SelectionKey key) throws IOException, ClassNotFoundException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        Request request = null;

        if (Server.getcountUsers() <= 1) {
            ByteBuffer buffer = ByteBuffer.allocate(socketChannel.socket().getReceiveBufferSize());
            while ((socketChannel.read(buffer) > 0)) {
                buffer.flip();
                buffer.clear();
            }
            ByteArrayInputStream bis = new ByteArrayInputStream(buffer.array());
            ObjectInputStream ois = new ObjectInputStream(bis);
            request = (Request) ois.readObject();
            return request;
        } else {
            request.setMessage("More than 1 user");
            return request;
        }



    }
}
