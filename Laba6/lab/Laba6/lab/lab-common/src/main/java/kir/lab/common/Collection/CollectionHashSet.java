package kir.lab.common.Collection;

import kir.lab.common.entities.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class CollectionHashSet {
    private String name;
    private int size;
    private LocalDateTime timeInicilization;
    private HashSet<Person> collection;
    private ArrayList<Person> listCollection;


    public CollectionHashSet(String name) {
        this.name = name;
        this.timeInicilization = LocalDateTime.now();
        //this.collection = DataManager.Load();
        if (collection == null) {
            collection = new HashSet<>();
        }
        this.listCollection = new ArrayList<>();
    }

    public LocalDateTime getTimeInicilization() {
        return this.timeInicilization;
    }

    public void clearCollection() {
        collection.clear();
    }

    public String getName() {
        return this.name;
    }

    public void addElement(Person person) {
        this.collection.add(person);
        this.size = collection.size();
    }

    public int sizeCollection() {
        return this.collection.size();
    }

    public void removeElement(Person person) {
        this.collection.remove(person);
        this.size = collection.size();
    }

    public ArrayList getCollection() {
        this.listCollection.clear();
        for (Person person : this.collection) {
            this.listCollection.add(person);
        }

        return this.listCollection;
    }

    public HashSet<Person> getHashsetCollection() {
        return collection;
    }

}
