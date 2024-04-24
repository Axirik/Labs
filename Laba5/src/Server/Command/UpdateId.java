package Server.Command;

import Person.Person;

import java.io.IOException;

import static Client.Main.client;
import static Server.Server.collectionHashSet;

/**
 * The command updates information about an object in the collection by its id
 */
public class UpdateId extends Command {
    Person element;

    public UpdateId() {
    }

    public void execute(String id) {
        try{
            Long idl = Long.parseLong(id);
            client.printLine(String.valueOf(collectionHashSet.sizeCollection()));
            RemoveById removeById = new RemoveById();
            removeById.execute(id);
            element = checkElement();
            element.setId(idl);
            collectionHashSet.addElement(element);
        } catch (NumberFormatException e) {
            client.printLine("id должен быть long");
        } catch (IOException e) {
            client.printLine("Error");
        }
    }
}
