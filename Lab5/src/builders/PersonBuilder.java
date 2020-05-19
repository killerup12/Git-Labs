package builders;

import shop_units.Person;
import shop_units.Storage;
import tools.TextReader;

class PersonBuilder {
    /**
     * Строитель, что реализует создвние и
     * ввод пользователем значений для полей
     * персонажа
     * @return Продукт с заполенными полями,
     * учитывая требованя по ТЗ
     */
    static Person buildPerson() {
        Person person = new Person();
        assignName(person);
        assignBirthday(person);
        assignHeight(person);
        assignWeight(person);
        assignPassportId(person);
        return person;
    }

    private static void assignName(Person person) {
        String name;
        do {
            System.out.println("Please, enter a name:");
            name = TextReader.readText();
            if (name != null) {
                name = name.trim();
            }
            if (name == null) {
                System.out.println("A name cannot be empty!");
            } else if (name.isEmpty()) {
                System.out.println("The name is empty!");
            } else {
                person.setName(name);
            }
        } while ((name == null) || (name.isEmpty()));
        System.out.println();
    }

    private static void assignBirthday(Person person) {
        System.out.println("Enter a Birthday (dd.MM.yyyy)");
        person.setBirthday(TextReader.readDate());
        System.out.println();
    }

    private static void assignHeight(Person person) {
        Float height;
        System.out.println("Enter a height:");
        do {
            height = TextReader.readFloatFromConsole();
            if (height == null) {
                System.out.println("Height cannot be null!");
            } else if (height <= 0) {
                System.out.println("The height cannot be less or equals 0!");
                System.out.println("Please, try to write height again:");
            } else {
                person.setHeight(height);
            }
        } while ((height == null) || (height <= 0));
        System.out.println();
    }

    private static void assignWeight(Person person) {
        Double weight;
        System.out.println("Enter a weight:");
        do {
            weight = TextReader.readDoubleFromConsole();
            if (weight == null) {
                System.out.println("Weight cannot  be null!");
            } else if (weight <= 0) {
                System.out.println("The weight cannot be less or equals 0!");
                System.out.println("Please, try to write weight again:");
            } else {
                person.setWeight(weight);
            }
        } while ((weight == null) || (weight <= 0));
        System.out.println();
    }

    private static void assignPassportId(Person person) {
        String passportId;
        System.out.println("Enter a unique id:");
        while (true) {
            passportId = TextReader.readText();
            passportId = passportId.trim();
            if (passportId == null) {
                person.setPassportID(null);
                break;
            } else if (passportId.isEmpty()) {
                System.out.println("Passport id is empty!");
            } else if (Storage.searchOwnerByPassportId(passportId) != null) {
                System.out.println("Already there is such a owner with such an id!");
                System.out.println("Please, try to write another id:");
            } else {
                person.setPassportID(passportId);
                break;
            }
        }
        System.out.println();
    }
}
