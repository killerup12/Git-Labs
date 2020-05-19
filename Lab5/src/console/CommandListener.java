package console;

import tools.TextReader;

public class CommandListener {
    private String command;

    /**
     * Метод, который считывает консольные команды
     * в бесконечном цыкле,а так же воплощает их в жизнь
     */
    public void startListener() {
        while (true) {
            executeCommand(writeCommand());
        }
    }

    public boolean executeCommand(String command) {
        switch (readCommand(command)) {
            case "help":
                Commands.help();
                break;
            case "info":
                Commands.info();
                break;
            case "show":
                Commands.show();
                break;
            case "add":
                Commands.add();
                break;
            case "update":
                Commands.updateId(integerCheck(readArgument(command)));
                break;
            case "remove_by_id":
                Commands.removeById(integerCheck(readArgument(command)));
                break;
            case "clear":
                Commands.clear();
                break;
            case "save":
                Commands.save();
                break;
            case "execute_script":
                Commands.executeScript(readArgument(command));
                break;
            case "exit":
                Commands.exit();
                break;
            case "add_if_max":
                Commands.addIfMax();
                break;
            case "add_if_min":
                Commands.addIfMin();
                break;
            case "remove_lower":
                Commands.removeLower();
                break;
            case "min_by_manufacture_cost":
                Commands.minByManufactureCost();
                break;
            case "count_greater_than_price":
                Commands.countGreaterThanPrice(longCheck(readArgument(command)));
                break;
            case "print_field_descending_owner":
                Commands.printFieldDescendingOwner();
                break;
            default:
                System.out.println("You entered wrong command!");
                return false;
        }
        return true;
    }

    private String writeCommand() {
        command = TextReader.readText();
        if (command == null) {
            System.out.println("You didn\'t enter a command!");
        }
        return command;
    }

    private String readCommand (String command){
        String answer = "";
        char[] commandToCharArray = command.toCharArray();
        for (int elementNumberInTheArray = 0;
             elementNumberInTheArray < commandToCharArray.length && commandToCharArray[elementNumberInTheArray] != ' ';
             elementNumberInTheArray++) {
            answer += commandToCharArray[elementNumberInTheArray];
        }
        return answer;
    }
    private String readArgument (String command){
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
        private Integer integerCheck(String integer){
        try {
            return Integer.valueOf(integer);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Long longCheck(String price){
        try {
            return Long.valueOf(price);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}