package builders;

import enums.UnitOfMeasure;
import shop_units.Product;
import shop_units.Storage;
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
            System.out.println();
            product.setOwner(PersonBuilder.buildPerson());
        } else {
            product.setOwner(null);
        }
        System.out.println("Product was build!");
    }

    private static void assignId(Product product) {
        boolean success = false;
        while (!success) {
            success = true;
            for (Product product2 : Storage.getStorage()) {
                if (antiRepetitionId.equals(product2.getId())) {
                    antiRepetitionId ++;
                    success = false;
                }
            }
        }
        product.setId(antiRepetitionId);
    }

    private static void assignName(Product product) {
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
                product.setName(name);
            }
        } while ((name == null) || (name.isEmpty()));
        System.out.println();
    }

    private static void assignCreationDate(Product product) {
        product.setCreationDate(java.time.ZonedDateTime.now());
    }

    private static void assignPrice(Product product) {
        Long price;
        do {
            System.out.println("Please, enter a price:");
            price = TextReader.readLongFromConsole();
            if (price == null) {
                product.setPrice(null);
                System.out.println();
                return;
            }
        } while (price <= 0);
        product.setPrice(price);
        System.out.println();
    }

    private static void assignManufactureCost(Product product) {
        System.out.println("Please, enter a manufacture cost:");
        product.setManufactureCost(TextReader.readIntegerFromConsole());
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
        String answer;
        do {
            answer = TextReader.readText();
            if (answer == null)
            {
                System.out.println("Unit of measure cannot be null!");
                continue;
            }
            switch (answer) {
                case "KILOGRAMS": product.setUnitOfMeasure(UnitOfMeasure.KILOGRAMS); break;
                case "METERS": product.setUnitOfMeasure(UnitOfMeasure.METERS); break;
                case "MILLILITERS": product.setUnitOfMeasure(UnitOfMeasure.MILLILITERS); break;
                case "MILLIGRAMS": product.setUnitOfMeasure(UnitOfMeasure.MILLIGRAMS); break;
                default:
                    System.out.println("Non-existent unit!");
            }
        } while (product.getUnitOfMeasure() == null);
        System.out.println();
    }
}
