package kir.lab.common.commands;

import kir.lab.common.entities.Person;

import java.io.IOException;

import static kir.lab.common.util.Util.collectionHashSet;

public class Clear extends Command{
    public Clear() {

    }

    @Override
    public String execute(String id, Person element) throws IOException {
        collectionHashSet.clearCollection();
        return "Collection is clear";
    }

    @Override
    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
