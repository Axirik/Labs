package kir.lab.server.data;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kir.lab.common.entities.Person;
import kir.lab.server.LocalDateAdapter;
import kir.lab.server.LocalDateTimeAdapter;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class DataManager {

    /**
     * Saving a collection to a file
     */
    public static void Save(HashSet<Person> collection) {

        try {
            File file = new File("C:\\Users\\kirri\\IdeaProjects\\Laba2j\\Laba5\\CollectionData.json");
            FileOutputStream outputStream = new FileOutputStream(file);
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                    new LocalDateTimeAdapter()).registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            String json = gson.toJson(collection);
            outputStream.write(json.getBytes());
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e);
            //SystemIn.printLine("Нет доступа к файлу");
        }

    }

    /**
     * Load a collection from file
     *
     * @return collection where we store Common.Entities.Person objects
     */
    public static HashSet<Person> Load() {
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                    new LocalDateTimeAdapter()).registerTypeAdapter(LocalDate.class, new LocalDateAdapter ()).create();
            File file = new File("C:\\Users\\kirri\\IdeaProjects\\Laba2j\\Laba5\\CollectionData.json");
            InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
            /*
            HashSet<Person> persons =  gson.fromJson(inputStream, new TypeToken<HashSet<Person>>(){}.getType());
            inputStream.close();
            if (persons.isEmpty()){
                //SystemIn.printLine("Успешно загружено!");
            }
             */
            return null;
        } catch (Exception e) {
            System.out.println(e);
            //SystemIn.printLine("Ошибка!");
            return new HashSet<>();
        }
    }

    /**
     * Load a script from file
     *
     * @param fileName the name of the file from which the script should be loaded
     * @return collection where we store script
     */
    public static ArrayList<String> LoadScript(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(fileName));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            //SystemIn.printLine("К файлу нету доступа или он отсутствует!");
        }
        return list;
    }

}

