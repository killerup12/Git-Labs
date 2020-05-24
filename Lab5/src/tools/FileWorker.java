package tools;

import console.CommandListener;
import console.Commands;
import shop_units.Storage;

import javax.xml.soap.Text;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FileWorker {
    private static CommandListener commandListener = new CommandListener();
    private static LinkedHashSet<String> executeScripts = new LinkedHashSet<>();

    /**
     * Метод проверяет, возможно ли достать данные
     * из файла
     * @param file файл, который будет проходить проверку
     * @return возможно ли произвести считывание данных
     */
    public static boolean isReachable(File file) {
        boolean success = true;

        if (!file.exists()) {
            System.out.println("Could not find the file \"" + file.getName() + "\"");
            success = false;
        } else if (!file.canRead()) {
            System.out.println("Could not open the file \"" + file.getName() + "\" for read!");
            success = false;
        } else if (!file.canWrite()) {
            System.out.println("Could not open the file \"" + file.getName() + "\" for write!");
            success = false;
        }
        System.out.println();
        return success;
    }

    /**
     * В данном методе будет проиходить проверка
     * корректности введенного файла
     * @param thePathToTheFile название/путь к файлу
     * @return файл, который был найден
     */
    public static File enterFile(String thePathToTheFile) {
        File file;

        if (thePathToTheFile != null) {
            file = new File(thePathToTheFile);
            if (isReachable(file)) {
                return file;
            }
            System.out.println("Try entering the file name again:");
        } else {
            System.out.println("Enter a file name:");
        }

        while (true) {
            String var = TextReader.readText();
            if (var != null) {
                file = new File(var);
                if (isReachable(file))
                    return file;
                System.out.println("Try entering the file name again:");
            } else {
                System.out.println("The file can not have a name!");
            }
        }
    }

    /**
     * Считывает данные из указанного файла
     * @return данные файла в виде String
     * @throws FileNotFoundException когда
     * файл не найден
     */
    public static String read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        String result = "";
        while (scanner.hasNextLine()) {
            result += scanner.nextLine();
        }
        return result;
    }

    /**
     * Метод позволяет записать данные в файл
     * формата JSON
     * @param obj объект, который будет записан
     */
    public static void write(String obj) throws IOException {
        try (FileWriter fw = new FileWriter(Storage.getCollectionFile())) {
            fw.write(obj);
        }
    }

    public static void readCommandsFromFile(String thePathToTheFile) throws FileNotFoundException {
        Scanner previousScanner = TextReader.getScanner();
        File file;

        try {
            if (thePathToTheFile != null) {
                file = new File(thePathToTheFile);
                if (file.canRead()) {
                    String command = "";
                    TextReader.setStream(new FileInputStream(file));
                    TextReader.setScannerisIn(false);

                    Scanner scanner = TextReader.getScanner();
                    //может быть исключение
                    while (scanner.hasNext()) {
                        boolean success = true;
                        command = TextReader.readText();

                        if (command == null) {
                            commandListener.executeCommand(null);
                        }
                        else if (commandListener.readCommand(command).equals("execute_script")){
                            if (!(executeScripts.isEmpty())) {
                                for (String executeScript : executeScripts) {
                                    if (executeScript.equals(command)) {
                                        success = false;
                                    }
                                }
                            }
                            executeScripts.add(command);
                            if (success) {
                                executeScripts.add(command);
                                Scanner scanner1 = TextReader.getScanner();
                                Commands.executeScript(commandListener.readArgument(command));
                                TextReader.setScanner(scanner1);
                                executeScripts.remove(command);
                            } else {
                                System.out.println("***");
                                System.out.println("Command \"" + command + "\" was ignored because it could cause recursion!");
                                System.out.println("***");
                            }
                        } else {
                            commandListener.executeCommand(command);
                        }
                    }
                }
            }
        } catch (StackOverflowError e) {
            System.out.println("Recursion detected!");
        } finally {
            TextReader.setScanner(previousScanner);
        }
    }
}
// execute_script /Users/killerup12/Desktop/ITMO_University_Activities/Программирование/Лабораторная работа №5/scripts/text.txt
//print_field_descending_owner