package kir.lab.common.commands;


import kir.lab.common.entities.Person;

import java.io.IOException;
import java.util.Comparator;

import static kir.lab.common.util.Util.collectionHashSet;


/**
 * The command displays a sorted list of objects from the collection
 */
public class Show extends Command {

    public Show() {
    }

    public String execute(String id, Person element) {
        spisok = collectionHashSet.getCollection();
        spisok.sort(Comparator.comparing(Person::getId));
        String list ="";
        for (Person person : spisok) {
            list += "ID: " + person.getId() + " Name: " + person.getName() + " Height: " + person.getHeight() + " Weight: " + person.getWeight() + " Hair's color: " + person.getHairColor() + '\n';
        }
        return list;
    }
    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
