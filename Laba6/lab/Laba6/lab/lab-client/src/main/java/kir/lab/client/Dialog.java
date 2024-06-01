package kir.lab.client;

import kir.lab.common.util.Request;
import kir.lab.common.util.Response;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Dialog {
    static SocketChannel socketChannel;

    public Dialog(Selector selector) throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 12345));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void send(Request request) throws IOException {
        if (socketChannel.isConnected()){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(request);
            ByteBuffer buffer = ByteBuffer.wrap(bos.toByteArray());
            socketChannel.write(buffer);
            buffer.flip();
        } else {
            System.out.println("Channel lost connection");
        }
    }

    public static Response read(SelectionKey key) throws IOException, ClassNotFoundException {
//        System.out.println("Reading...");
        SocketChannel socketChannel = (SocketChannel) key.channel();
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(socketChannel.socket().getReceiveBufferSize()); // TODO allocate dynamically
        while ((socketChannel.read(buffer) > 0)) {
            buffer.flip();
            buffer.clear();
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(buffer.array());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Response response = (Response) ois.readObject();
        return response;
    }
    public static Response connect(Selector selector) throws IOException, ClassNotFoundException {
        Response response = new Response("");
        selector.select();
        Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
        while (iter.hasNext()) {
            SelectionKey key = iter.next();
            if (key.isReadable()) {
                response = read(key);
            }
            iter.remove();
        }
        return response;
    }
}
