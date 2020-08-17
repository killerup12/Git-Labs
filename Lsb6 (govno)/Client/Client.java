import Exeptions_shit.ServerIsBusyException;
import tools.ClientServerInteraction;
import tools.TextReader;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            try {
                ClientServerInteraction.startClient();
                break;
            } catch (IOException | RuntimeException e) {
                System.out.println("Server is not available now!");
                System.out.println("Attempt to reconnect after:");
                for (int i = 10; i > 0; i--) {
                    System.out.print(i +"...");
                    Thread.sleep(1000);
                }
                System.out.println();
            } catch (ServerIsBusyException e) {
                System.out.println("Server is busy now!");
                System.out.println("Closing application...");
                System.exit(0);
            }
        }
    }
}
/*
execute_script /Users/killerup12/Desktop/ITMO_University_Activities/Программирование/Лабораторная работа №6/text.txt

execute_script /Users/killerup12/Desktop/ITMO_University_Activities/Программирование/Лабораторная работа №6/text — копия.txt

execute_script /Users/killerup12/Desktop/ITMO_University_Activities/Программирование/Лабораторная работа №6/text — копия 2.txt
 */