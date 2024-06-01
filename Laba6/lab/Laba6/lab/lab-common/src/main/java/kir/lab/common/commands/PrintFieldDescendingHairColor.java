package kir.lab.common.commands;


import kir.lab.common.entities.Color;
import kir.lab.common.entities.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static kir.lab.common.util.Util.getCollectionHashSet;

/**
 * The command outputs the hair colors of all items stored in the collection
 */

public class PrintFieldDescendingHairColor extends Command {
    private ArrayList<Person> spisok;

    public PrintFieldDescendingHairColor() {
    }

    public String execute(String id, Person element) {
        spisok = getCollectionHashSet().getCollection();
        if (spisok.size() < 1) {
            return "Collection is empty";
        } else {
            String list = "";
            list = spisok.stream().map(Person:: getHairColor).map(Color::toString).collect(Collectors.joining());
            return list;
        }
    }

    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
