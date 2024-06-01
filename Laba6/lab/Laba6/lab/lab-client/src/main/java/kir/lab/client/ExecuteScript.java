package kir.lab.client;


import kir.lab.common.commands.Command;
import kir.lab.common.entities.Person;
import kir.lab.common.util.Response;


import java.io.IOException;
import java.util.ArrayList;


/**
 * The command responsible for reading commands from the file
 */
public class ExecuteScript extends Command {

    public ExecuteScript() {
    }

    public void execute(ArrayList<String> list) throws IOException {
        System.out.println(list);
        CompareCommand compare = new CompareCommand();
        for (String command : list) {
            compare.checkCommand(command);
        }
    }
}