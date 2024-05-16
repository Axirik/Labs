package kir.lab.server;

import kir.lab.common.entities.Person;
import kir.lab.common.util.*;
import kir.lab.common.commands.*;
import kir.lab.common.util.*;

import java.io.IOException;
/**
 * The class in which commands are processed and invoked
 */

public final class Server {


    private Server() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }






    History history = new History();





    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Ожидание подключения клиента
        DialogServer dialogServer = new DialogServer();
        while(true){
            CommandManager commandManager = new CommandManager();
            Request request = dialogServer.read();
            Response response;
            if (commandManager.getMap().containsKey(request.getMessage())){
                String string = commandManager.getMap().get(request.getMessage()).execute(request.getId(),request.getPerson());
                response = new Response(string);
                dialogServer.send(response);
            }


        }
    }
    /*
    public void checkCommand(String reader) throws IOException {
        try {
            String id = "0";
            String command;
            String[] read;
            read = reader.split("\\s+");
            if (read.length > 1) {
                command = read[0];
                id = read[1];
            } else {
                command = read[0];
            }
            if (map.containsKey(command)) {
                //map.get(command).execute(id,null);
                history.addCommand(command);
            } else {
                System.out.println("Введите help");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

}