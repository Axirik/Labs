package kir.lab.common.commands;

import kir.lab.common.entities.Person;
import kir.lab.common.entities.ComparePerson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static kir.lab.common.util.Util.getCollectionHashSet;


/**
 * The command outputs an object with the maximum name
 */
public class MaxByName extends Command {
    private ArrayList<Person> spisok;
    public MaxByName() {
    }

    public String execute(String id, Person element) {
        spisok = getCollectionHashSet().getCollection();

        if (spisok.size() < 1) {
            return "Collection is empty";
        } else {
            Comparator compareName = new ComparePerson();
            spisok = (ArrayList<Person>) spisok.stream().sorted(compareName).collect(Collectors.toList());
            Person personMaxName = spisok.get(spisok.size() - 1);
            return "ID: " + personMaxName.getId() + " Name: " + personMaxName.getName() + " Height: " + personMaxName.getHeight() + " Weight: " + personMaxName.getWeight() + " Hair's color: " + personMaxName.getHairColor();
        }
    }

    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
