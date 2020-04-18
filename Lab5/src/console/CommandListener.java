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

            if (readCommand(command).equals("help")) Commands.help();
            else if (readCommand(command).equals("info")) Commands.info();
            else if (readCommand(command).equals("show")) Commands.show();
            else if (readCommand(command).equals("add")) Commands.add();
            else if (readCommand(command).equals("update")) Commands.updateId(integerCheck(readArgument(command)));
            else if (readCommand(command).equals("remove_by_id")) Commands.removeById(integerCheck(readArgument(command)));
            else if (readCommand(command).equals("clear")) Commands.clear();
            //else if (readCommand(command).equals("save")) Commands.save();
            //else if (readCommand(command).equals("execute_script")) Commands.executeScript();
            else if (readCommand(command).equals("exit")) Commands.exit();
            //else if (readCommand(command).equals("add_if_max")) Commands.addIfMax();
            //else if (readCommand(command).equals("add_if_min")) Commands.addIfMin();
            //else if (readCommand(command).equals("remove_lower")) Commands.removeLower();
            else if (readCommand(command).equals("min_by_manufacture_cost")) Commands.minByManufactureCost();
            else if (readCommand(command).equals("count_greater_than_price")) Commands.countGreaterThanPrice(longCheck(readArgument(command)));
            else if (readCommand(command).equals("print_field_descending_owner")) Commands.printFieldDescendingOwner();
            else System.out.println("You entered wrong command!");
        }
        //todo реализовать оставшиеся команды через switch
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
