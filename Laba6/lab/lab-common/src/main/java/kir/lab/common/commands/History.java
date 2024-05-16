package kir.lab.common.commands;

import kir.lab.common.entities.Person;

import java.io.IOException;

/**
 * A command that stores a stack of 13 recent commands
 */

public class History extends Command {
    public History() {
    }

    public void addCommand(String command) {
        if (listHistory.size() >= 12) {
            listHistory.remove(0);
            listHistory.add(command);
        } else {
            listHistory.add(command);
        }
    }
    public String execute(String id, Person element) {
        String list= "";
        for (String command : listHistory) {
            list += command+"\n";
        }
        return list;
    }
    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
