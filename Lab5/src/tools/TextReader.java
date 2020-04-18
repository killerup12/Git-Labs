package tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, позволяющий корректно работать с данными от польхователя,
 * а так же считывать их
 */
public class TextReader {
    public static Scanner scanner = new Scanner(System.in);

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String readText() {
        String var;
        while (true) {
            try {
                System.out.print(">");
                var = scanner.nextLine();
                return var;
            } catch (NoSuchElementException e) {
                System.out.println();
                System.out.println("Гопники из Купчино снова попыались сломать мою прогу!");
                scanner = new Scanner(System.in);
            }
        }
    }

    /**
     * Позволяет проводить проверку корректности введенного целоисленного
     * значения,а так же заменить его, в случаи неправильного ввода
     * @return всегда возвращает тольео данные типа Integer
     */
    public static Integer readIntegerFromConsole() {
        while (true) {
            try {
                return Integer.valueOf(readText());
            } catch (NumberFormatException nfe) {
                System.out.println("This is not an integer!");
                System.out.println("Please, enter a integer:");
            }
        }
    }

    /**
     * Позволяет проводить проверку корректности введенного целоисленного
     * значения,а так же заменить его, в случаи неправильного ввода
     * @return всегда возвращает тольео данные типа Long
     */
    public static Long readLongFromConsole() {
        while (true) {
            try {
                return Long.valueOf(readText());
            } catch (NumberFormatException nfe) {
                System.out.println("This is not an long!");
                System.out.println("Please, enter a long:");
            }
        }
    }

    /**
     * Позволяет проводить проверку корректности введенного не целочисленного
     * значения,а так же заменить его, в случаи неправильного ввода
     * @return всегда возвращает тольео данные типа Double
     */
    public static Double readDoubleFromConsole() {
        while (true) {
            try {
                return Double.valueOf(readText());
            } catch (NumberFormatException e) {
                System.out.println("This is not an double!");
                System.out.println("Please, enter a double:");
            }
        }
    }

    /**
     * Позволяет проводить проверку корректности введенного не целочисленного
     * значения,а так же заменить его, в случаи неправильного ввода
     * @return всегда возвращает тольео данные типа Float
     */
    public static Float readFloatFromConsole() {
        while (true) {
            try {
                return Float.valueOf(readText());
            } catch (NumberFormatException e) {
                System.out.println("This is not an float!");
                System.out.println("Please, enter a float:");
            }
        }
    }

    /**
     * Позволяет проводить проверку корректности введенной даты,
     * а так же заменить ее, в случаи неправильного ввода
     * @return всегда возвращает тольео данные типа LocalDate
     */
    public static LocalDate readDate() {
        while (true) {
            try {
                return LocalDate.parse(TextReader.readText(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Date was entered wrong!");
                System.out.println("Please, enter another date:");
            }
        }
    }

    /**
     * Метод, позволяюший корректно считать ответ пользователя,
     * который заблючается в согласии или несогласии
     * @return возвращает true, если ответ да и наоборот
     */
    public static boolean readYesOrNo() {
        String answer = null;
        while (true) {
            answer = readText();
            if ((answer.equals("y")) || (answer.equals("Y"))) {
                return true;
            } else if ((answer.equals("n")) || (answer.equals("N"))) {
                return false;
            } else {
                System.out.println("Answer has been entered wrong!");
                System.out.println("Please, try write answer correct:");
            }
        }
    }
}