package console;

import builders.ProductBuilder;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import shop_units.Product;
import shop_units.Storage;

import java.io.File;

/**
 * В этом классе содержатся все кончольные команды.
 */
class Commands {
    /**
     * Вывести справку по доступным командам
     */
    static void help(){
        System.out.println(
                "help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" + //?
                "add : добавить новый элемент в коллекцию\n" +
                "update id : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_max : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "add_if_min : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "remove_lower : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "min_by_manufacture_cost : вывести любой объект из коллекции, значение поля manufactureCost которого является минимальным\n" +
                "count_greater_than_price price : вывести количество элементов, значение поля price которых больше заданного\n" +
                "print_field_descending_owner : вывести значения поля owner всех элементов в порядке убывания"
        );
        System.out.println();
    }

    /**
     * Вывести в стандартный поток вывода информацию околлекции
     * (тип, дата инициализации, количество элементов)
     */
    static void info(){
        System.out.println("Collection Type: LinkedHashSet");
        System.out.println("Initialization date: "+ Storage.getInitializationDate());
        System.out.println("Amount of elements: "+ Storage.getStorage().size());
        System.out.println();
    }

    /**
     * Вывести в стандартный поток вывода все элементы коллекции
     * в строковом представлении
     * */
    static void show() {
        for (Product product : Storage.getStorage()) {
            Storage.showProductInConsole(product);
            System.out.println("-------------------------");
        }
        System.out.println();
    }

    /**
     * Добавить новый элемент в коллекцию
     */
    static void add() {
        Product product;
        product = ProductBuilder.buildProduct();
        Storage.getStorage().add(product);
        System.out.println();
    }

    /**
     * Обновить значение элемента коллекции, id которого равен
     * заданному
     * @param id уникалый номер элемента, по  которому будет
     *           происходить поиск
     */
    static void updateId (Integer id) {
        if (id == null) {
            System.out.println("ID has been entered wrong!");
            return;
        }
        if (Storage.searchProductById(id) == null) {
            System.out.println("There is no element with such id!");
            return;
        }
        Storage.replace(id, ProductBuilder.updateProduct(id));
        System.out.println("Operation completed!");
        System.out.println();
    }

    /**
     * удалить элемент из коллекции по его id
     * @param id уникалый номер элемента, по  которому будет
     *           происходить поиск
     */
    static void removeById(Integer id) {
        if (Storage.searchProductById(id) == null) {
            System.out.println("There is no element with such id!");
            return;
        }
        Storage.getStorage().remove(Storage.searchProductById(id));
        System.out.println("Operation completed!");
        System.out.println();
    }

    /**
     * Очистить коллекцию
     */
    static void clear() {
        Storage.getStorage().clear();
        System.out.println("Operation completed!");
        System.out.println();
    }

    /**
     * Сохранить коллекцию в файл
     */
    static void save() {
        //todo
    }

    /**
     * Считать и исполнить скрипт из указанного файла.
     * В скрипте содержатся команды в таком же виде,
     * в котором их вводит пользователь в интерактивном режиме
     * @param file Путь к файлу
     */
    static void executeScript(File file) {
        //todo
    }

    /**
     * Завершить программу (без сохранения в файл)
     */
    static void exit() {
        System.exit(0);
    }

    /**
     * Добавить новый элемент в коллекцию, если его
     * значение превышает значение наибольшего элемента
     * этой коллекции
     */
    static void addIfMax() {
        Product product = ProductBuilder.buildProduct();

        //todo
    }

    /**
     * добавить новый элемент в коллекцию, если его
     * значение меньше, чем у наименьшего элемента
     * этой коллекции
     */
    static void addIfMin() {
        Product product = ProductBuilder.buildProduct();

        //todo
    }

    /**
     * Удалить из коллекции все элементы, меньшие,
     * чем заданный
     */
    static void removeLower() {
        Product product = ProductBuilder.buildProduct();

        //todo
    }

    /**
     * Вывести любой объект из коллекции, значение
     * поля manufactureCost которого является минимальным
     */
    static void minByManufactureCost() {
        Product product = Storage.searchProductByMinManufactureCost();
        if (product == null) {
            System.out.println("There are no declared items in this collection!");
            return;
        }
        Storage.showProductInConsole(product);
        System.out.println();
    }

    /**
     * Вывести количество элементов, значение поля
     * price которых больше заданного
     * @param price Цена. с которой будут сравниваться
     *              другие продукты
     */
    static void countGreaterThanPrice(Long price) {
        int numberOfProductsDisplayed = 0;
        for (Product product : Storage.getStorage()) {
            if (product.getPrice() == null) {
                continue;
            } else if (product.getPrice() < price) {
                Storage.showProductInConsole(product);
                numberOfProductsDisplayed++;
            }
            if (numberOfProductsDisplayed == 0) {
                System.out.println("There are no such elements whose price is more than a given!");
            }
        }
    }

    /**
     * Вывести значения поля owner всех элементов
     * в порядке убывания
     */
    static void printFieldDescendingOwner() {
        //todo
    }
}
