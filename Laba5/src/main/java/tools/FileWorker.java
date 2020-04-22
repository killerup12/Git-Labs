package tools;

import console.CommandListener;
import shop_units.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWorker {
    static CommandListener commandListener = new CommandListener();

    /**
     * Метод проверяет, возможно ли достать данные
     * из файла
     * @param file файл, который будет проходить проверку
     * @return возможно ли произвести считывание данных
     */
    private static boolean isReachable(File file) {
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
        File file;

        if (thePathToTheFile != null) {
            file = new File(thePathToTheFile);
            if (isReachable(file)) {
                String command = "";
                Scanner scanner = new Scanner(file);

                //может быть исключение
                while (scanner.hasNext()) {
                        command = scanner.nextLine();
                        if (command.equals("execute_script "+thePathToTheFile)){
                            continue;
                        }
                        commandListener.executeCommand(command);
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
