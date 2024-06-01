package kir.lab.common.util;


import kir.lab.common.commands.Command;
import kir.lab.common.commands.History;
import kir.lab.common.commands.MaxByName;
import kir.lab.common.commands.Help;
import kir.lab.common.commands.Add;
import kir.lab.common.commands.Info;
import kir.lab.common.commands.RemoveById;
import kir.lab.common.commands.UpdateId;
import kir.lab.common.commands.PrintFieldDescendingHairColor;
import kir.lab.common.commands.Clear;
import kir.lab.common.commands.Show;
import kir.lab.common.commands.SumOfWeight;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public History history = new History();
    private Map<String, Command> map = new HashMap<String, Command>() {{
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
    }};

    public CommandManager() {

    }

    public Map<String, Command> getMap() {
        return map;
    }
}
