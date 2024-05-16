package kir.lab.common.commands;



import kir.lab.common.entities.Person;

import java.io.IOException;

import static kir.lab.common.util.Util.collectionHashSet;

/**
 * The command updates information about an object in the collection by its id
 */
public class UpdateId extends Command {
    Person element;

    public UpdateId() {
    }

    public String execute(String id, Person element) {
        try{
            Long idl = Long.parseLong(id);
            RemoveById removeById = new RemoveById();
            removeById.execute(id,null);
            element.setId(idl);
            collectionHashSet.addElement(element);
            return "Person добавлен";
        } catch (NumberFormatException e) {
            return "id должен быть long";
        }
    }
    @Override
    public String executeClient() throws IOException {
        return "person";
    }
}
