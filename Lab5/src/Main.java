import console.CommandListener;
import shop_units.Storage;
import tools.FileWorker;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        char[] chars;
        String pathToTheCollectionFile = null;
        if (args != null) {
            pathToTheCollectionFile = "";
            for (String word : args) {
                pathToTheCollectionFile += word;
                pathToTheCollectionFile += " ";
            }
            chars = pathToTheCollectionFile.toCharArray();
            pathToTheCollectionFile = "";
            for (int i = 0; i < chars.length - 1; i++) {
                pathToTheCollectionFile += chars[i];
            }
        }

        while(!Storage.initCollectionFromFile(FileWorker.enterFile(pathToTheCollectionFile)));

        CommandListener commandListener = new CommandListener();
        commandListener.startListener();
    }
}
