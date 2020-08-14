package console;

import builders.ProductBuilder;
import commands.*;
import shop_units.Product;
import tools.FileWorker;
import tools.TextReader;

import java.io.FileNotFoundException;

public class CommandListener {
    private String command;
    public static int numberOfExecuteScript = 0;


    /**
     * Метод, который считывает консольные команды
     * в бесконечном цыкле,а так же воплощает их в жизнь
     */
    public AbstractCommand readCommand() {
        AbstractCommand command = null;
        while(command == null) {
            command = executeCommand(TextReader.readText());
        }
        return command;
    }


    public AbstractCommand executeCommand(String command) {
        Product product;
        if (command == null) {
            System.out.println("No command!");
            return null;
        } else {
            switch (readCommand(command)) {
                case "help":
                    System.out.println(
                            "help : вывести справку по доступным командам\n" +
                            "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)\n" +
                            "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" + //?
                            "add : добавить новый элемент в коллекцию\n" +
                            "update id : обновить значение элемента коллекции, id которого равен заданному\n" +
                            "remove_by_id id : удалить элемент из коллекции по его id\n" +
                            "clear : очистить коллекцию\n" +
                            "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме\n" +
                            "exit : завершить программу (без сохранения в файл)\n" +
                            "add_if_max : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                            "add_if_min : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                            "remove_lower : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                            "min_by_manufacture_cost : вывести любой объект из коллекции, значение поля manufactureCost которого является минимальным\n" +
                            "count_greater_than_price price : вывести количество элементов, значение поля price которых больше заданного\n" +
                            "print_field_descending_owner : вывести значения поля owner всех элементов в порядке убывания"
                    );
                    System.out.println();
                    break;
                case "info":
                    return new Info();
                case "show":
                    return new Show();
                case "add":
                    Product product1 = ProductBuilder.buildProduct();
                    return new Add(product1);
                case "update":
                    try {
                        product = ProductBuilder.buildProduct();
                        return new Update(Integer.parseInt(readArgument(command)), product);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect argument entered.");
                        break;
                    }
                case "remove_by_id":
                    try {
                       return new Remove_by_id(Integer.parseInt(readArgument(command)));
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect argument entered.");
                    }
                    break;
                case "clear":
                    return new Clear();
                case "execute_script":
//                    numberOfExecuteScript++;
//                    try {
//                        FileWorker.readCommandsFromFile(readArgument(command));
//                    } catch (FileNotFoundException e) {
//                        System.out.println("Path to the file was entered wrong!");
//                    } finally {
//                        numberOfExecuteScript--;
//                    }
//
//                    if (numberOfExecuteScript == 0) {
//                        TextReader.setStream(System.in);
//                        TextReader.setScannerisIn(true);
//                    }
//                    break;
                    return new Execute_script(readArgument(command));
                case "exit":

                    return new Exit();
                    //todo пока хрен знает, как это реализвать.
                case "add_if_max":
                    product = ProductBuilder.buildProduct();
                    return new Add_if_max(product);
                case "add_if_min":
                    product = ProductBuilder.buildProduct();
                    return new Add_if_min(product);
                case "remove_lower":
                    product = ProductBuilder.buildProduct();
                    return new Remove_lower(product);
                case "min_by_manufacture_cost":
                    return new Min_by_manufacture_cost();
                case "count_greater_than_price":
                    try {
                        return new Count_greater_than_price(Integer.parseInt(readArgument(command)));
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect argument entered.");
                    }
                    break;
                case "print_field_descending_owner":
                   return new Print_field_descending_owner();
                default:
                    System.out.println("You entered wrong command!");
                    return null;
            }
        }
        return null;
    }

    public String readCommand (String command){
        String answer = "";
        try {
            char[] commandToCharArray = command.toCharArray();
            for (int elementNumberInTheArray = 0;
                 elementNumberInTheArray < commandToCharArray.length && commandToCharArray[elementNumberInTheArray] != ' ';
                 elementNumberInTheArray++) {
                answer += commandToCharArray[elementNumberInTheArray];
            }
            return answer;
        } catch (NullPointerException e) {
            return null;
        }

    }
    public String readArgument (String command){
        String answer = "";
        int elementNumberInTheArray = 0;
        char[] commandToCharArray = command.toCharArray();
        while (commandToCharArray[elementNumberInTheArray] != ' ') {
            if (elementNumberInTheArray + 2 > commandToCharArray.length) {
                return null;
            }
            elementNumberInTheArray++;
        }
        elementNumberInTheArray++;
        for (; elementNumberInTheArray != commandToCharArray.length; elementNumberInTheArray += 1) {
            answer += commandToCharArray[elementNumberInTheArray];
        }
        return answer;
    }
}