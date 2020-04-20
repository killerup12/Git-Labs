import console.CommandListener;
import shop_units.Storage;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        CommandListener commandListener = new CommandListener();
        commandListener.startListener();
    }
}