package kir.lab.common.util;


import kir.lab.common.commands.*;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    History history = new History();
    Map<String, Command> map = new HashMap<String, Command>(){{
        put("help", new Help());
        put("info", new Info());
        put("show", new Show());
        put("clear", new Clear());
        put("history", history);
        put("sum_of_weight", new SumOfWeight());
        put("max_by_name", new MaxByName());
        put("print_field_descending_hair_color", new PrintFieldDescendingHairColor());
        put("add", new Add());
        put("update", new UpdateId());
        put("remove_by_id", new RemoveById());
        put("execute_script", new ExecuteScript());
    }};
    public CommandManager(){

    }

    public Map<String, Command> getMap(){
        return map;
    }
}
