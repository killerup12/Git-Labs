package tools;

import commands.AbstractCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServerInteraction {
    public static final Logger logger = LogManager.getRootLogger();

    private static Socket socket;
    private static ServerSocket server;

    /**
     * Этот метод должен конектить клиент и сервер,
     * но сейчас сырой как море.
     *
     */
    public static void waitForClient() throws IOException {
        try {
            server = new ServerSocket(8000);
            socket = server.accept();
            logger.info("Client connected!");
        } catch (IOException ignored) {
            try {
                socket = server.accept();
                logger.info("Client connected!");
            } catch (NullPointerException e) {
                logger.error("Port and IP are busy");
                logger.error("Try to start server later...");
                System.exit(0);
            }
        }

    }

    public static void writeMessage(String text) throws IOException {
        socket.getOutputStream().write(text.getBytes());
        socket.getOutputStream().flush();
    }

    public static Socket getSocket() {
        return socket;
    }

    public static AbstractCommand deSerialize(byte[] bytes) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            return (AbstractCommand) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        byte[] buffer = new byte[2*1024];
        int len = inputStream.read(buffer);

        os.write(buffer, 0, len);

        byte[] answer = os.toByteArray();
        os.close();

        return answer;
    }
}
