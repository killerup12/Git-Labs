package shop_units;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import tools.FileWorker;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Храилище, где будут содержаться коллекции.
 */
public class Storage {
    private static LinkedHashSet<Product> storage = new LinkedHashSet<>();
    private static LocalDate initializationDate = LocalDate.now();
    private static File collectionFile;

    public static File getCollectionFile() { return collectionFile; }
    public static LinkedHashSet<Product> getStorage() { return storage; }
    public static LocalDate getInitializationDate() { return initializationDate; }

    /**
     * Заполняет коллекцию данными из файла
     * @param file файл, откуда будут брать
     *             информацию для записи
     * @return успешно ли проинициализирован
     */
    public static boolean initCollectionFromFile (File file) {
        try {
            Product[] arrayProduct;
            arrayProduct = JSONObject.parseObject(FileWorker.read(file), (Type) Product[].class);
            storage.addAll(Arrays.asList(arrayProduct));
            for (Product product : storage) {
                if (product.getOwner().getName() == null) {
                    product.setOwner(null);
                }
            }
            collectionFile = file;
            return true;

        } catch (FileNotFoundException ignored) {
            System.out.println("File not found!");
            return false;
        } catch (JSONException e) {
            System.out.println("The file is not in json format!");
            return false;
        }
    }

    /**
     * Метод производит поиск объекта по его ID.
     * @param id предпологаемый ID продукта
     * @return если имеется продукт с таким ID, то возвращает
     * этот объект. В ином случаи вернется null
     */
    public static Product searchProductById(Integer id) {
        for (Product product : storage) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Метод производит поиск владельца по его паспортному ID
     * @param passportId предполагаемый паспортный ID
     * @return если имеется владелец с таким паспортным ID, то
     * возвращается этот владелец. В ином случаи вернется null
     */
    public static Person searchOwnerByPassportId(String passportId) {
        for (Product product : storage) {
            if ((product.getOwner() != null) && (product.getOwner().getPassportID().equals(passportId))) {
                return product.getOwner();
            }
        }
        return null;
    }

    /**
     * Метод производит поиск продукта с наименьшей
     * стоймостью производства
     * @return возвращает продукт с наименьшей стоймостью.
     * Если коллекция пуста - возвращает null
     */
    public static Product searchProductByMinManufactureCost() {
        if (storage.isEmpty()) return null;
        Integer minManufactureCost = null;
        Product minManufactureCostProduct = null;
        for (Product product : storage) {
            if ((minManufactureCost == null) && (product.getManufactureCost() != null)) {
                minManufactureCost = product.getManufactureCost();
            } else if ((product.getManufactureCost() != null) && (minManufactureCost > product.getManufactureCost())) {
                minManufactureCost = product.getManufactureCost();
                minManufactureCostProduct = product;
            }
        }
        return minManufactureCostProduct;
    }

    /**
     * Метод удаляет элемент и заменяет его другим
     * @param id ID объекта, который мы хотим заменить
     * @param product Продукт, который мы хотим запихнуть
     *                взамен старого
     */
    public static void replace (Integer id, Product product) {
        storage.remove(searchProductById(id));
        product.setId(id);
        storage.add(product);
    }

    /**
     * Метод позволяет в приемлемом виде вывести данные
     * продукта в консоль
     * @param product продукт, поля которого будут выведены
     */
    public static void showProductInConsole(Product product) {
        System.out.println("ID: "+ product.getId());
        System.out.println("Name: "+ product.getName());
        System.out.println("About coordinates:");
        System.out.println("    Coordinate X: "+ product.getCoordinates().getX());
        System.out.println("    Coordinate Y: "+ product.getCoordinates().getY());
        System.out.println("Creation date: "+ product.getCreationDate().toString());
        if (product.getPrice() != null) {
            System.out.println("Price: "+ product.getPrice());
        } else {
            System.out.println("Price: -");
        }
        if (product.getManufactureCost() != null) {
            System.out.println("Manufacture cost: "+ product.getManufactureCost());
        } else {
            System.out.println("Manufacture cost: -");
        }
        System.out.println("Unit of measure: "+ product.getUnitOfMeasure().toString());
        if (product.getOwner() != null) {
            System.out.println("About owner:");
            System.out.println("    Name: "+ product.getOwner().getName());
            if (product.getOwner().getBirthday() != null) {
                System.out.println("    Birthday: "+ product.getOwner().getBirthday().toString());
            } else {
                System.out.println("    Birthday: -");
            }
            if (product.getOwner().getHeight() != null) {
                System.out.println("    Height: "+ product.getOwner().getHeight());
            } else {
                System.out.println("    Height: -");
            }
            System.out.println("    Weight: "+ product.getOwner().getWeight());
            if (product.getOwner().getPassportID() != null) {
                System.out.println("    Passport ID: "+ product.getOwner().getPassportID());
            } else {
                System.out.println("    Passport ID: -");
            }
        } else {
            System.out.println("Owner: -");
        }
    }
}