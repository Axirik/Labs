package kir.lab.common.commands;

import kir.lab.common.entities.*;

import java.io.IOException;
import java.util.Comparator;

import static kir.lab.common.util.Util.collectionHashSet;



/**
 * The command outputs an object with the maximum name
 */
public class MaxByName extends Command {
    public MaxByName() {
    }

    public String execute(String id, Person element) {
        spisok = collectionHashSet.getCollection();
        if (spisok.size() < 1) {
            return "Collection is empty";
        } else {
            Comparator compareName = new ComparePerson();
            spisok.sort(compareName);
            Person personMaxName = spisok.get(spisok.size() - 1);
            return "ID: " + personMaxName.getId() + " Name: " + personMaxName.getName() + " Height: " + personMaxName.getHeight() + " Weight: " + personMaxName.getWeight() + " Hair's color: " + personMaxName.getHairColor();
        }
    }
    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
