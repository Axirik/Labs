package kir.lab.server;

import kir.lab.common.util.*;
import kir.lab.common.commands.*;


import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class in which commands are processed and invoked
 */

public final class Server {
    private static int countUsers = 0;
    private static SocketChannel socketChannel;


    private Server() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }


    static History history = new History();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Selector selector = Selector.open();
        DialogServer dialogServer = new DialogServer(selector);
        CommandManager commandManager = new CommandManager();
        boolean running = true;
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (reader.readLine().equals("exit")){
            running = false;
        }
         */
        while (running) { // TODO change to bool variable
            try {
                Request request;
                Response response;
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        accept(key, selector);
                        System.out.println("accept");
                    }
                    if (key.isReadable()) {
                        request = dialogServer.read(key);
                        if (request.getMessage().equals("More than 1 user")) {
                            response = new Response("Server is already working with another user");
                            dialogServer.send(response, key);
                        } else {
                            System.out.println(request.getMessage());
                            String command = request.getMessage();
                            if (commandManager.getMap().containsKey(command)) {
                                history.addCommand(command);
                                String string = commandManager.getMap().get(request.getMessage()).execute(request.getId(), request.getPerson());
                                response = new Response(string);
                                dialogServer.send(response, key);
                            }
                        }
                    }
                    //iterator.remove();
                }
            }catch (IOException | InterruptedException e){
                System.out.println(e);
            }
        }
    }
    private static void accept(SelectionKey key, Selector selector) throws IOException, InterruptedException {
        socketChannel = ((ServerSocketChannel) key.channel()).accept();
        countUsers++;
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
    public static int getcountUsers(){
        return countUsers;
    }


}