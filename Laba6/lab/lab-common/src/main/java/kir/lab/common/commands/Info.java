package kir.lab.common.commands;



import kir.lab.common.entities.Person;

import java.io.IOException;

import static kir.lab.common.util.Util.collectionHashSet;

/**
 * The command that provides information about the collection
 */
public class Info extends Command {

    public Info() {
    }

    public String  execute(String id, Person element) {
        return  "Имя коллекции: " + collectionHashSet.getName() + "\n" +
                "Тип коллекции: Common.Entities.Person\n" +
                "Время инициализации: " + collectionHashSet.getTimeInicilization() + "\n" +
                "Колличество элементов: " + collectionHashSet.sizeCollection();
    }
    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}