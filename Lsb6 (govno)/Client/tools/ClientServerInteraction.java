package tools;

import Exeptions_shit.ServerIsBusyException;
import commands.AbstractCommand;
import commands.IsConnected;
import console.CommandListener;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClientServerInteraction {
    private static Integer numberOfActiveCommands = 0;
    private static CommandListener commandListener = new CommandListener();
    private static LinkedHashSet<String> executeScriptCollection = new LinkedHashSet<>();
    private static SocketChannel socketChannel;
    private static boolean isConnected;
    private static Selector selector;
    private static SocketChannel channel;

    static byte[] serialize(AbstractCommand command) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(byteOut)) {
            out.writeObject(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteOut.toByteArray();
    }

    public static void sendAMessage() throws IOException {
        channel.write(ByteBuffer.wrap(serialize(new IsConnected())));
    }
    //todo тут проблема
    private static String readMessage(SocketChannel in) {
        ByteBuffer buffer = ByteBuffer.allocate(40 * 1024);

        try (ByteArrayOutputStream byteOutput = new ByteArrayOutputStream()) {
            boolean n = true;
            while ((in.read(buffer) != -1 || buffer.position() < buffer.array().length) && n) {
                n = false;
                buffer.flip();
                byteOutput.write(buffer.array(), buffer.position(), buffer.limit());
                buffer.compact();
            }
            String answer = new String(byteOutput.toByteArray());
            System.out.println(answer);
            return answer;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static void establishConnection() throws IOException {
        socketChannel = SocketChannel.open();
        selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        socketChannel.connect(new InetSocketAddress("localhost", 8000));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        socketChannel.finishConnect();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String answer = "";         //ответ от сервера
        channel = socketChannel;

//        channel.finishConnect();

        channel.write(ByteBuffer.wrap(serialize(new IsConnected())));
//            answer = readMessage(channel);
//            System.out.println("I connected to the server! (NO)");
//            System.out.println(answer);
//            if (answer.isEmpty()) {
//                System.out.println("Cannot get a response from the server! Retrying through:");
//                for (int i = 10; i > 0; i--) {
//                    System.out.print(i + "...");
//                    Thread.sleep(1000);
//                }
//                System.out.println();
//            }
        //todo delite

    }

    //Хрен знает, как это говно работает
    public static void startClient() throws IOException, ConnectException, InterruptedException, ServerIsBusyException {
//        SocketChannel socketChannel = SocketChannel.open();
//        Selector selector = Selector.open();
//        socketChannel.configureBlocking(false);
//        socketChannel.register(selector, SelectionKey.OP_CONNECT);
//        socketChannel.connect(new InetSocketAddress("localhost", 8000));
        establishConnection();
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                throw new ServerIsBusyException();
            }

            //todo разобрать
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keySet.iterator();


            while (keyIterator.hasNext()) {
                SelectionKey currentKey = keyIterator.next();
                keyIterator.remove();

                if (!currentKey.isValid()) {
                    continue;
                }
                /*
                    if (currentKey.isConnectable()) {
                    S≠ystem.out.println("1!");
                    String answer = "";         //ответ от сервера
                    SocketChannel channel = (SocketChannel) currentKey.channel();
                    System.out.println("2!");
                    channel.finishConnect();
                    System.out.println("3!");
                    do {
                        ((SocketChannel) currentKey.channel()).write(ByteBuffer.wrap(serialize(new IsConnected())));
                        answer = readMessage((SocketChannel) currentKey.channel());
                        System.out.println(answer);
                        if (answer.isEmpty()) {
                            System.out.println("Cannot get a response from the server! Retrying through:");
                            for (int i = 10; i > 0; i--) {
                                System.out.print(i + "...");
                                Thread.sleep(1000);
                            }
                            System.out.println();
                        }
                    } while (answer.isEmpty());
                    currentKey.interestOps(SelectionKey.OP_WRITE);
                    System.out.println("I connected to the server! (NO)");//todo delite

                } */
                /*
                else if (currentKey.isWritable()) {
                    if (isConnected) {
                        AbstractCommand command = commandListener.readCommand();
                        if (command.getName().equals("exit")) {
                            ((SocketChannel) currentKey.channel()).write(ByteBuffer.wrap(serialize(command)));
                            System.out.println("The program ends its work...");
                            System.exit(0);
                        } else if (command.getName().equals("execute_script")) {
                            FileWorker.executeScript(currentKey, command.getArgument());
                            Thread.sleep(1100);
                        } else {
                            ((SocketChannel) currentKey.channel()).write(ByteBuffer.wrap(serialize(command)));
                            currentKey.interestOps(SelectionKey.OP_READ);
                        }
                    } else {

                    }

                 */
                if (currentKey.isReadable()) {
                    String answer = readMessage(socketChannel);

                    if (!isConnected) {
                        if (!answer.isEmpty()) {
                            isConnected = true;
                        } else {
                            throw new IOException();
                        }
                    }
                    AbstractCommand command = commandListener.readCommand();
                    if (command.getName().equals("exit")) {
                        ((SocketChannel) currentKey.channel()).write(ByteBuffer.wrap(serialize(command)));
                        System.out.println("The program ends its work...");
                        System.exit(0);
                    } else if (command.getName().equals("execute_script")) {
                        FileWorker.executeScript(currentKey, command.getArgument());
                        Thread.sleep(1100);
                    } else {
                        ((SocketChannel) currentKey.channel()).write(ByteBuffer.wrap(serialize(command)));
                    }

                }
            }
        }
    }
}