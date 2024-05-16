package kir.lab.client;


import kir.lab.common.entities.Color;
import kir.lab.common.entities.Coordinates;
import kir.lab.common.entities.Location;
import kir.lab.common.entities.Person;
import kir.lab.common.util.CommandManager;
import kir.lab.common.util.Request;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CompareCommand {
    //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    protected String elementName; //Поле не может быть null, Строка не может быть пустой
    protected Coordinates elementCoordinates; //Поле не может быть null
    protected java.time.LocalDateTime elementcreationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    protected double elementHeight; //Значение поля должно быть больше 0
    protected java.time.LocalDate elementBirthday; //Поле может быть null
    protected Integer elementWeight; //Поле может быть null, Значение поля должно быть больше 0
    protected Color elementHairColor; //Поле не может быть null
    protected Location elementLocation;

    public CompareCommand() {
    }

    public Request checkCommand(String reader) throws IOException {
        CommandManager commandManager = new CommandManager();
        String id = "0";
        String command;
        String[] read;
        read = reader.split("\\s+");
        if (read.length > 1) {
            command = read[0];
            id = read[1];
        } else {
            command = read[0];
        }
        if (commandManager.getMap().containsKey(command)){
            Person element = null;
            String message = commandManager.getMap().get(command).executeClient();
            if (message.equals("person")){
                element = checkElement();
            }
            System.out.println(command);
            Request request = new Request(command, id, element);
            return request;
        } else {
            SystemIn.printLine("Введите help");
            return null;
        }
    }
    protected Person checkElement() throws IOException {
        while (true) {
            SystemIn.printLine("Введите имя:");
            this.elementName = SystemIn.readLine();
            if ((elementName.isEmpty()) || (elementName.equals(" "))) {
                SystemIn.printLine("Невернный ввод");
            } else {
                break;
            }
        }
        this.elementcreationDate = java.time.LocalDateTime.now();
        while (true) {
            SystemIn.printLine("Введите рост:");
            String red = SystemIn.readLine();
            try {
                this.elementHeight = Double.parseDouble(red);
                if (elementHeight > 0) {
                    break;
                } else {
                    SystemIn.printLine("Error");
                }
            } catch (NumberFormatException e) {
                SystemIn.printLine("Надо ввести значение double!");
            }

        }
        while (true) {
            SystemIn.printLine("Введите вес:");
            String red = SystemIn.readLine();
            try {
                this.elementWeight = Integer.parseInt(red);
                if (elementWeight > 0) {
                    break;
                } else {
                    SystemIn.printLine("Error");
                }
            } catch (NumberFormatException e) {
                SystemIn.printLine("Надо ввести значение long!");
            }
        }
        Long elementCX;
        Long elementCY;
        while (true) {
            SystemIn.printLine("Введите координату х:");
            String red = SystemIn.readLine();
            try {
                elementCX = Long.parseLong(red);
                break;
            } catch (NumberFormatException e) {
                SystemIn.printLine("Надо ввести значение long!");
            }

        }
        while (true) {
            SystemIn.printLine("Введите координату у:");
            String red = SystemIn.readLine();
            try {
                elementCY = Long.parseLong(red);
                if (elementCY > (-867)) {
                    break;
                } else {
                    SystemIn.printLine("Error");
                }
            } catch (NumberFormatException e) {
                SystemIn.printLine("Надо ввести значение long!");
            }

        }
        this.elementCoordinates = new Coordinates(elementCX, elementCY);

        long elementX;
        Long elementY;
        float elementZ;
        while (true) {
            SystemIn.printLine("Введите локацию по х:");
            String red = SystemIn.readLine();
            try {
                elementX = Long.parseLong(red);
                break;
            } catch (NumberFormatException e) {
                SystemIn.printLine("Надо ввести значение long!");
            }
        }
        while (true) {
            SystemIn.printLine("Введите локацию по у:");
            String red = SystemIn.readLine();
            try {
                elementY = Long.parseLong(red);
                break;
            } catch (NumberFormatException e) {
                SystemIn.printLine("Надо ввести значение long!");
            }
        }
        while (true) {
            SystemIn.printLine("Введите локацию по z:");
            String red = SystemIn.readLine();
            try {
                elementZ = Float.parseFloat(red);
                break;
            } catch (NumberFormatException e) {
                SystemIn.printLine("Надо ввести значение float!");
            }
        }
        this.elementLocation = new Location(elementX, elementY, elementZ);

        while (true) {
            int flag = 0;
            SystemIn.printLine("Введите цвет волос: (GREEN, RED, BLUE, YELLOW)");
            String red = SystemIn.readLine().toUpperCase();
            for (Color e : Color.values()) {
                if (e.name().equals(red)) {
                    elementHairColor = e;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            } else {
                SystemIn.printLine("Невернный ввод");
            }
        }
        while (true) {
            SystemIn.printLine("Введите дату рождения: (year-month-day)");
            String red = SystemIn.readLine();
            try {
                String[] date = red.split("-");
                if (date.length == 3) {
                    this.elementBirthday = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                    break;
                } else {
                    SystemIn.printLine("Error");
                }
            } catch (Exception e) {
                SystemIn.printLine("Вы ввели неправильную дату");
            }
        }
        Person person = new Person(this.elementName, this.elementCoordinates, this.elementHeight, this.elementBirthday, this.elementWeight, this.elementHairColor, this.elementLocation);
        return person;
    }

}
