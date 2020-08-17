package console;

import commands.AbstractCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shop_units.Storage;
import tools.ClientServerInteraction;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;


public class CommandListener {
    public static final Logger logger = LogManager.getRootLogger();


    private AbstractCommand abstractCommand;

    public void startListener() throws IOException {
        while (true) {
            try {
//                Thread.sleep(1000);
                logger.info("Server is waiting command!");
                InputStream inputStream = ClientServerInteraction.getSocket().getInputStream();
                abstractCommand = ClientServerInteraction.deSerialize(
                        ClientServerInteraction.readBytes(inputStream));
                //Thread.sleep(100);
                abstractCommand.setFile(Storage.getCollectionFile());
                logger.info("Bytes have been read!");
            } catch (EOFException | StreamCorruptedException e) {
                logger.info("Waiting for commands");
                continue;
            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//                continue;
//            }
            executeCommand(abstractCommand);

        }
    }

    private void executeCommand(AbstractCommand command) {
        logger.info("Server is executing command!");
        try {
            String message = command.execute(Storage.getStorage());

            ClientServerInteraction.writeMessage(
                    message
            );
            logger.info("Server sent a massage! \n"+ message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}