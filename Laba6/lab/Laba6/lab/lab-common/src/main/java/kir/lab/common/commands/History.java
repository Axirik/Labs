package kir.lab.common.commands;

import kir.lab.common.entities.Person;

import java.io.IOException;

/**
 * A command that stores a stack of 13 recent commands
 */

public class History extends Command {
    private final int sizeH = 13;
    public History() {
    }

    public void addCommand(String command) {
        if (getListHistory().size() >= sizeH) {
            getListHistory().remove(0);
            getListHistory().add(command);
        } else {
            getListHistory().add(command);
        }
    }

    public String execute(String id, Person element) {
        String list = "";
        for (String command : getListHistory()) {
            list += command + "\n";
        }
        return list;
    }

    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
