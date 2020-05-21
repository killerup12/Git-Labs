import console.CommandListener;
import shop_units.Storage;
import tools.FileWorker;

public class Main {
    public static void main(String[] args) {
        while(!Storage.initCollectionFromFile(FileWorker.enterFile(args.length == 0 ? null : args[0])));



        CommandListener commandListener = new CommandListener();
        commandListener.startListener();
    }
}
