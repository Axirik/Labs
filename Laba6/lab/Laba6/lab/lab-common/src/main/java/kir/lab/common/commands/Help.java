package kir.lab.common.commands;


import kir.lab.common.entities.Person;

import java.io.IOException;

/**
 * A command that outputs information on all commands
 */
public class Help extends Command {

    public Help() {
    }

    public String execute(String id, Person element) {
        String help = "help - вывести справку по доступным командам\n"
                + "info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"
                + "show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n"
                + "add {element} - добавить новый элемент в коллекцию\n"
                + "update id {element} - обновить значение элемента коллекции, id которого равен заданному\n"
                + "remove_by_id id - удалить элемент из коллекции по его id\n"
                + "clear - очистить коллекцию\n"
                + "save - сохранить коллекцию в файл\n"
                + "execute_script file_name - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n"
                + "exit - завершить программу (без сохранения в файл)\n"
                + "history - вывести последние 13 команд (без их аргументов)\n"
                + "sum_of_weight - вывести сумму значений поля weight для всех элементов коллекции\n"
                + "max_by_name - вывести любой объект из коллекции, значение поля name которого является максимальным\n"
                + "print_field_descending_hair_color - вывести значения поля hairColor всех элементов в порядке убывания";
        return help;
    }

    public String executeClient() throws IOException {
        return super.executeClient();
    }
}
