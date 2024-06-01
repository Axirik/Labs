package kir.lab.common.commands;


import kir.lab.common.entities.Person;

import java.io.IOException;
import java.util.ArrayList;
import static kir.lab.common.util.Util.getCollectionHashSet;


/**
 * The command outputs the sum of the masses of all objects in the collection
 */
public class SumOfWeight extends Command {
    private ArrayList<Person> spisok;
    public SumOfWeight() {
    }

    public String execute(String id, Person element) {
        spisok = getCollectionHashSet().getCollection();
        int sum = 0;
        for (Person person : spisok) {
            sum += person.getWeight();
        }
        return String.valueOf(sum);
    }

    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
