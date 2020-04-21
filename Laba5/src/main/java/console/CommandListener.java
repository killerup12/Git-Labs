package console;

import tools.TextReader;

public class CommandListener {
    /**
     * Метод, который считывает консольные команды
     * в бесконечном цыкле,а так же воплощает их в жизнь
     */
    public void startListener(){
        String command;

        while (true){
            command = TextReader.readText();
            if (command == null) {
                System.out.println("You didn\'t enter a command!");
                continue;
            }

            switch (readCommand(command)) {
                case "help":
                    Commands.help();
                    continue;
                case "info":
                    Commands.info();
                    continue;
                case "show":
                    Commands.show();
                    continue;
                case "add":
                    Commands.add();
                    continue;
                case "update":
                    Commands.updateId(integerCheck(readArgument(command)));
                    continue;
                case "remove_by_id":
                    Commands.removeById(integerCheck(readArgument(command)));
                case "clear":
                    Commands.clear();
                    continue;
                case "save":
                    Commands.save();
                    continue;
                case "execute_script":
                    Commands.executeScript();
                    continue;
                case "exit":
                    Commands.exit();
                    continue;
                case "add_if_max":
                    Commands.addIfMax();
                    continue;
                case "add_if_min":
                    Commands.addIfMin();
                    continue;
                case "remove_lower":
                    Commands.removeLower();
                    continue;
                case "min_by_manufacture_cost":
                    Commands.minByManufactureCost();
                    continue;
                case "count_greater_than_price":
                    Commands.countGreaterThanPrice(longCheck(readArgument(command)));
                    continue;
                case "print_field_descending_owner":
                    Commands.printFieldDescendingOwner();
                    continue;
            }
            System.out.println("You entered wrong command!");
        }
    }

    private String readCommand(String command) {
        String answer = "";
        char[] commandToCharArray = command.toCharArray();
        for (int elementNumberInTheArray = 0;
             elementNumberInTheArray < commandToCharArray.length && commandToCharArray[elementNumberInTheArray] != ' ';
             elementNumberInTheArray++) {
            answer += commandToCharArray[elementNumberInTheArray];
        }
        return answer;
    }

    private String readArgument(String command) {
        String answer = "";
        int elementNumberInTheArray = 0;
        char[] commandToCharArray = command.toCharArray();
        while (commandToCharArray[elementNumberInTheArray] != ' ') elementNumberInTheArray +=1;
        elementNumberInTheArray++;
        for (;elementNumberInTheArray != commandToCharArray.length; elementNumberInTheArray += 1) {
            answer += commandToCharArray[elementNumberInTheArray];
        }
        return answer;
    }

    private Integer integerCheck (String integer) {
        try {
            return Integer.valueOf(integer);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Long longCheck (String price) {
        try {
            return Long.valueOf(price);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
