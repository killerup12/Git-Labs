package tools;

import commands.AbstractCommand;
import console.CommandListener;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.LinkedHashSet;
import java.util.Scanner;

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
            file = new File(pathToFile);

            if (file.canRead()) {
                String executeScriptCommand;
                TextReader.setStream(new FileInputStream(file));
                TextReader.setScannerisIn(false);

                Scanner scanner = TextReader.getScanner();
                boolean success = true;
                for (String commandArg : executeScripts) {
                    if (pathToFile.equals(commandArg)) {
                        success = false;
                    }
                }
                if (success) {
                    while (scanner.hasNext()) {
                        executeScripts.add(pathToFile);
                        AbstractCommand command = commandListener.readCommand();
                        if (command.getName().equals("execute_script")) {
                            executeScript(currentKey, command.getArgument());
                        } else {
                            ((SocketChannel) currentKey.channel()).write(ByteBuffer.wrap(ClientServerInteraction.serialize(command)));
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            executeScripts.add(pathToFile);
                            currentKey.interestOps(SelectionKey.OP_READ);
                        }
                    }
                } else {
                    System.out.println("***");
                    System.out.println("Command \"execute_script " + pathToFile + "\" was ignored because it could cause recursion!");
                    System.out.println("***");
                }
                TextReader.setScanner(previousScanner);
                TextReader.setScannerisIn(true);
            }
        }
    }
}