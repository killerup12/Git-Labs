package tools;

import shop_units.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWorker {

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
        return success;
    }

    /**
     * В данном методе будет проиходить проверка
     * корректности введенного файла
     * @param arg название файла
     * @return файл, который был найден
     */
    public static File enterFile(String arg) {
        File file;

        if (arg != null) {
            file = new File(arg);
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
                System.out.print("Try entering the file name again:");
            } else {
                System.out.println("The file cannot be nameless!");
            }
        }
    }

    /**
     * Считывает данные из указанного файла
     * @return данные файла в виде String
     * @throws FileNotFoundException когда
     * файл не найден
     */
    public static String read() throws FileNotFoundException {
        Scanner scanner = new Scanner(Storage.getCollectionFile());

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
}
