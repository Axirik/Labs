package kir.lab.common.commands;


import kir.lab.common.entities.Person;

import java.io.IOException;

import static kir.lab.common.util.Util.collectionHashSet;


/**
 * The command outputs the sum of the masses of all objects in the collection
 */
public class SumOfWeight extends Command {
    public SumOfWeight() {
    }

    public String  execute(String id, Person element) {
        spisok = collectionHashSet.getCollection();
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
