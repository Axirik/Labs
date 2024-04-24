package Server.Command;

import Person.Person;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command deletes an object from the collection by id
 */
public class RemoveById extends Command {

    public RemoveById() {

    }
    public void execute(String id) {
        try{
            Long idl = Long.parseLong(id);
            spisok = collectionHashSet.getCollection();
            int flag = 0;
            for (Person person : spisok) {
                if (person.getId() == idl) {
                    collectionHashSet.removeElement(person);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                client.printLine("Person with this id isn't found");
            }
        } catch (NumberFormatException e) {
            client.printLine("id должна быть long");
        }
    }
}
