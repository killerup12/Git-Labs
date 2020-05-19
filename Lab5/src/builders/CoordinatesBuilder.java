package builders;

import tools.Coordinates;
import tools.TextReader;

class CoordinatesBuilder extends Coordinates {
    /**
     * Строитель, что реализует создвние и
     * ввод пользователем значений для полей
     * координат
     * @return Продукт с заполенными полями,
     * учитывая требованя по ТЗ
     */
    static Coordinates buildCoordinates() {
        Coordinates coordinates = new Coordinates();
        assignX(coordinates);
        assignY(coordinates);
        return coordinates;
    }

    private static void assignX(Coordinates coordinates) {
        Long number;
        do {
            System.out.println("Please, enter a coordinate X (> -622):");
            number = TextReader.readLongFromConsole();
            if (number == null) {
                System.out.println("A coordinate cannot be null!");
            } else if (number > -622) {
                coordinates.setX(number);
            } else {
                System.out.println("The coordinate cannot be less -622!");
            }
        } while ((number == null) || (number <= -622));
        System.out.println();
    }

    private static void assignY(Coordinates coordinates) {
        Long number;
        do {
            System.out.println("Please, enter a coordinate Y (<= 625):");
            number = TextReader.readLongFromConsole();
            if (number == null) {
                System.out.println("A coordinate cannot be null!");
            } else if (number <= 625) {
                coordinates.setY(number);
            } else {
                System.out.println("The coordinate cannot be more ерут 625!");
            }
        }while ((number == null) || (number > 625));
        System.out.println();
    }
}
