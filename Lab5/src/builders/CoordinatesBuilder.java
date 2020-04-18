package builders;

import tools.Coordinates;
import tools.TextReader;

public class CoordinatesBuilder extends Coordinates{
    public static Coordinates buildCoordinates() {
        Coordinates coordinates = new Coordinates();
        assignX(coordinates);
        assignY(coordinates);
        return coordinates;
    }

    private static void assignX(Coordinates coordinates) {
        long var;
        do {
            System.out.println("Please, enter a coordinate X (> -622):");
            var = TextReader.readLongFromConsole();
            if (var > -622) {
                coordinates.setX(var);
            } else {
                System.out.println("The coordinate cannot be less -622!");
            }
        } while (var <= -622);
        System.out.println();
    }

    private static void assignY(Coordinates coordinates) {
        long var;
        do {
            System.out.println("Please, enter a coordinate Y (<= 625):");
            var = TextReader.readLongFromConsole();
            if (var <= 625) {
                coordinates.setY(var);
            } else {
                System.out.println("The coordinate cannot be more ерут 625!");
            }
        }while (var > 625);
        System.out.println();
    }
}
