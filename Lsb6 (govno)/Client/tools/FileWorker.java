package tools;

import commands.AbstractCommand;
import console.CommandListener;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static tools.ClientServerInteraction.readMessage;

public class FileWorker {
    private static CommandListener commandListener = new CommandListener();
    private static LinkedHashSet<String> executeScripts = new LinkedHashSet<>();

    /**
     * Метод проверяет, возможно ли достать данные
     * из файла
     *
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

    public static void executeScript(SelectionKey currentKey, String pathToFile) throws IOException {

        Scanner previousScanner = TextReader.getScanner();
        File file;

        if (pathToFile != null) {
            file = new File(pathToFile); //todo ?

            if (file.canRead()) {
                TextReader.setStream(new FileInputStream(file));
                TextReader.setScannerIsIn(false);

                Scanner scanner = TextReader.getScanner();
                boolean success = false;

                try {
                    executeScripts.stream().filter(path -> path.equals(pathToFile)).findAny().get();
                } catch (NoSuchElementException e) {
                    success = true;
                }
                if (success) {
                    executeScripts.add(pathToFile);
                    while (scanner.hasNext()) {
                        AbstractCommand command = commandListener.readCommand();
                        if (command.getName().equals("execute_script")) {
                            executeScript(currentKey, command.getArgument());
                        } else {
                            ((SocketChannel) currentKey.channel()).write(ByteBuffer.wrap(ClientServerInteraction.serialize(command)));
                        }
                    }
                } else {
                    System.out.println("***");
                    System.out.println("Command \"execute_script " + pathToFile + "\" was ignored because it could cause recursion!");
                    System.out.println("***");
                }
                TextReader.setScanner(previousScanner);
                executeScripts.remove(pathToFile);
                if (executeScripts.isEmpty()) {
                    TextReader.setScannerIsIn(true);
                }
            }
        }
    }
}