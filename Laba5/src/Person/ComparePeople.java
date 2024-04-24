package Person;

import Person.Person;

import java.util.Comparator;

public class ComparePeople implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2){
        return p1.getName().length() - p2.getName().length();
    }
}
