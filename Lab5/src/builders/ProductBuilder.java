package builders;

import enums.UnitOfMeasure;
import shop_units.Product;
import tools.TextReader;

public class ProductBuilder {
    /**
     * Строитель, что реализует создвние и
     * ввод пользователем значений для полей
     * продукта
     * @return Продукт с заполенными полями,
     * учитывая требованя по ТЗ
     */
     static public Product buildProduct () {
        Product product = new Product();
        assignId(product);
        initProduct(product);
        return product;
    }

    /**
     * Метод, позволяющий обновить все
     * значения полей продукта, при это
     * не заменив ID
     * @param id ID, что будет перенесен
     *           в новый продукт
     * @return Продукт с заполенными полями,
     * учитывая требованя по ТЗ
     */
    public static Product updateProduct (Integer id) {
        Product product = new Product();
        product.setId(id);
        initProduct(product);
        return product;
    }

    private static Integer antiRepetitionId = 1;

    private static void initProduct (Product product) {
        assignName(product);
        product.setCoordinates(CoordinatesBuilder.buildCoordinates());
        assignCreationDate(product);
        assignPrice(product);
        assignManufactureCost(product);
        assignUnitOfMeasure(product);
        System.out.println("Do you want to write data about owner? (Y/N)");
        if (TextReader.readYesOrNo()) {
            product.setOwner(PersonBuilder.buildPerson());
        } else {
            product.setOwner(null);
        }
    }

    private static void assignId(Product product) {
        product.setId(antiRepetitionId);
        antiRepetitionId += 1;
    }

    private static void assignName(Product product) {
        String name;
        do {
            System.out.println("Please, enter a name:");
            name = TextReader.readText();
            if (name.isEmpty()) {
                System.out.println("A name cannot be empty!");
            } else {
                product.setName(name);
            }
        } while (name.isEmpty());
        System.out.println();
    }

    private static void assignCreationDate(Product product) {
        product.setCreationDate(java.time.ZonedDateTime.now());
    }

    private static void assignPrice(Product product) {
        System.out.println("Do you want to enter a price? (Y/N)");
        if (TextReader.readYesOrNo()) {
            System.out.println("Please, enter a price:");
            product.setPrice(TextReader.readLongFromConsole());
        }
        System.out.println();
    }

    private static void assignManufactureCost(Product product) {
        System.out.println("Do you want to enter a manufacture cost? (Y/N)");
        if (TextReader.readYesOrNo()) {
            System.out.println("Please, enter a manufacture cost:");
            product.setManufactureCost(TextReader.readIntegerFromConsole());
        }
        System.out.println();
    }

    private static void assignUnitOfMeasure(Product product) {
        System.out.println("Chose the unit of measure:");
        System.out.println(
                "1) KILOGRAMS \n" +
                "2) METERS \n" +
                "3) MILLILITERS \n" +
                "4) MILLIGRAMS"
        );
        Integer answer;
        do {
            answer = TextReader.readIntegerFromConsole();
            if ((answer < 1) || (answer > 4)) {
                System.out.println("There is no such answer option!");
                System.out.println("Please, enter an answer again:");
            }
        } while ((answer < 1) || (answer > 4));
        switch (answer) {
            case 1: product.setUnitOfMeasure(UnitOfMeasure.KILOGRAMS); break;
            case 2: product.setUnitOfMeasure(UnitOfMeasure.METERS); break;
            case 3: product.setUnitOfMeasure(UnitOfMeasure.MILLILITERS); break;
            case 4: product.setUnitOfMeasure(UnitOfMeasure.MILLIGRAMS);
        }
        System.out.println();
    }
}
