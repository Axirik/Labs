package kir.lab.common.commands;


import kir.lab.common.entities.Person;

import java.io.IOException;
import java.util.ArrayList;

import static kir.lab.common.util.Util.getCollectionHashSet;


/**
 * The command deletes an object from the collection by id
 */
public class RemoveById extends Command {
    private ArrayList<Person> spisok;

    public RemoveById() {

    }

    public String execute(String id, Person element) {
        try {
            Long idl = Long.parseLong(id);
            spisok = getCollectionHashSet().getCollection();
            int flag = 0;
            for (Person person : spisok) {
                if (person.getId() == idl) {
                    getCollectionHashSet().removeElement(person);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return "Person with this id isn't found";
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return "id должна быть long";
        }
    }

    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
