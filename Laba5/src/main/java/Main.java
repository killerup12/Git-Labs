import shop_units.Storage;
import tools.FileWorker;

public class Main {
    public static void main(String[] args) {
        Storage.setCollectionFile(FileWorker.enterFile(args.length == 0 ? null : args[0]));
        Storage.initCollectionFromFile(Storage.getCollectionFile());
    }
}