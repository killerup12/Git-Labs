import console.CommandListener;
import shop_units.Storage;

public class Main {
    public static void main(String[] args) {
        CommandListener commandListener = new CommandListener();
        commandListener.startListener();

        System.out.println("Coordinate X: "+ Storage.searchProductById(1).getCoordinates().getX());
        System.out.println("Coordinate Y: "+ Storage.searchProductById(1).getCoordinates().getY());
    }
}