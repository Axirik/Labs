package kir.lab.common.commands;


import kir.lab.common.entities.Person;


import java.io.IOException;


/**
 * The command responsible for reading commands from the file
 */
public class ExecuteScript extends Command {

    public ExecuteScript() {
    }

    public String execute(String fileName, Person element) throws IOException {
        System.out.println(fileName);
        if (scripts.size() == 0) {
            scripts.add(fileName);
            //ArrayList<String> spisok = DataManager.LoadScript(fileName);
            //for (String command : spisok) {
                //checkCommand(command);
            //}
            return null;

        } else {
            if (fileName.equals(scripts.get(0))) {
                return "Зацикливание скриптов";
            } else {
                scripts.add(fileName);
                //ArrayList<String> spisok = DataManager.LoadScript(fileName);
                //for (String command : spisok) {
                    //checkCommand(command);
                //}
                return null;
            }
        }

    }

}
