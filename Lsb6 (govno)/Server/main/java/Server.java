import console.CommandListener;
import shop_units.Storage;
import tools.ClientServerInteraction;
import tools.FileWorker;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class Server {

    public static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {

        logger.info("Server started!");

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
        Storage.initCollectionFromFile(FileWorker.enterFile(pathToTheCollectionFile));
        logger.info("Collection introduced!");

        do {
            try {
                ClientServerInteraction.waitForClient();

                CommandListener commandListener = new CommandListener();
                commandListener.startListener();
            } catch (IndexOutOfBoundsException | IOException e) {
                logger.info("Client disconnected.");
            }
        } while (true);
    }
}