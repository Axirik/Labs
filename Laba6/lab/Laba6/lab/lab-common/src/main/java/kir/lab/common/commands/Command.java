package kir.lab.common.commands;


import kir.lab.common.entities.Person;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The command class is the ancestor for all commands
 */
public class Command {


    private static ArrayList<String> listHistory = new ArrayList<>();


    public String execute(String id, Person person) throws IOException {
        return null;
    }

    public String executeClient() throws IOException {
        return null;
    }

    public ArrayList<String> getListHistory() {
        return listHistory;
    }
    public void addCommand(String command){

    }

}
