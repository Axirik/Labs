package kir.lab.common.commands;


import kir.lab.common.entities.Person;

import java.io.IOException;

import static kir.lab.common.util.Util.collectionHashSet;

/**
 * The command outputs the hair colors of all items stored in the collection
 */

public class PrintFieldDescendingHairColor extends Command {

    public PrintFieldDescendingHairColor() {
    }
    public String execute(String id, Person element) {
        spisok = collectionHashSet.getCollection();
        if (spisok.size() < 1){
            return "Collection is empty";
        }else {
            String list ="";
            for (Person person : spisok) {
                list += person.getHairColor().toString() + "\n";
            }
            return list;
        }
    }
    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
