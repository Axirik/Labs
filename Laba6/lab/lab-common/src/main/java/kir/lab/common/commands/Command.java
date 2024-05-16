package kir.lab.common.commands;



import kir.lab.common.entities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The command class is the ancestor for all commands
 */
public class Command {
    protected ArrayList<Person> spisok;
    public static ArrayList<String> scripts = new ArrayList<>();
    public static ArrayList<String> listHistory = new ArrayList<>();



    public String execute(String id, Person person) throws IOException {
        return null;
    }
    public String executeClient() throws IOException {
        return null;
    }


}
