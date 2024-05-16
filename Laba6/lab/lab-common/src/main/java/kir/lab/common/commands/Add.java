package kir.lab.common.commands;


import kir.lab.common.entities.Person;


import java.io.IOException;

import static kir.lab.common.util.Util.collectionHashSet;


/**
 * The command responsible for adding an object of the Common.Entities.Person class to the collection
 */
public class Add extends Command{

    public Add() {

    }

    public String execute(String id, Person element){
        collectionHashSet.addElement(element);
        return "Person добавлен";
    }
    public String executeClient() throws IOException {
        return "person";
    }

}
