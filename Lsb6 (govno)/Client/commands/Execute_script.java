package commands;

import shop_units.Product;
import tools.FileWorker;
import tools.TextReader;

import java.io.FileNotFoundException;
import java.util.LinkedHashSet;

public class Execute_script extends AbstractCommand {
    public Execute_script(String argument) {
        super("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        this.argument = argument;
    }

    private String argument;

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public static int numberOfExecuteScript = 0;
    public static void execute(String thePathToTheFile) {
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        return null;
    }
}
