package builders;

import shop_units.Person;
import shop_units.Product;
import shop_units.Storage;
import tools.TextReader;

public class PersonBuilder {
    /**
     * Строитель, что реализует создвние и
     * ввод пользователем значений для полей
     * персонажа
     * @return Продукт с заполенными полями,
     * учитывая требованя по ТЗ
     */
    static public Person buildPerson() {
        Person person = new Person();
        assignName(person);
        assignBirthday(person);
        assignHeight(person);
        assignWeight(person);
        assignPassportId(person);
        return person;
    }

    private static void assignName(Person person) {
        String potentialName;
        do {
            System.out.println("Enter a name of owner:");
            potentialName = TextReader.readText();
            if (potentialName.isEmpty()) {
                System.out.println("The name cannot be empty!");
                System.out.println("Please, try enter a name again:");
            } else {
                person.setName(potentialName);
            }
        } while (potentialName.isEmpty());
        System.out.println();
    }

    private static void assignBirthday(Person person) {
        System.out.println("Enter Birthday (dd.MM.yyyy)");
        person.setBirthday(TextReader.readDate());
        System.out.println();
    }

    private static void assignHeight(Person person) {
        Float height;
        System.out.println("Enter a height:");
        do {
            height = TextReader.readFloatFromConsole();
            if (height <= 0) {
                System.out.println("The height cannot be less or equals 0!");
                System.out.println("Please, try to write height again:");
            } else {
                person.setHeight(height);
            }
        } while (height <= 0);
        System.out.println();
    }

    private static void assignWeight(Person person) {
        double weight;
        System.out.println("Enter a weight:");
        do {
            weight = TextReader.readDoubleFromConsole();
            if (weight <= 0) {
                System.out.println("The weight cannot be less or equals 0!");
                System.out.println("Please, try to write weight again:");
            } else {
                person.setWeight(weight);
            }
        } while (weight <= 0);
        System.out.println();
    }

    private static void assignPassportId(Person person) {
        System.out.println("Do you want to write passport ID?");
        if (TextReader.readYesOrNo()) {
            String passportId;
            System.out.println("Enter a unique id:");
            while (true) {
                passportId = TextReader.readText();
                if (Storage.searchOwnerByPassportId(passportId) != null) {
                    System.out.println("Already there is such a owner with such an id!");
                    System.out.println("Please, try to write another id:");
                } else {
                    person.setPassportID(passportId);
                    break;
                }
            }
        }
        System.out.println();
    }
}
