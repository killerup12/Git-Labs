package shop_units;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public static final Logger logger = LogManager.getRootLogger();

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
     */
    public static void initCollectionFromFile(File file) {
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

        } catch (FileNotFoundException ignored) {
            logger.error("File not found!");
        } catch (JSONException e) {
            logger.error("The file is not in json format!");
        } catch (NullPointerException e) {
//            System.out.println("File not for reading text!");
            collectionFile = file;  //костыль
            //todo
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

    public static Integer searchUniqueId() {
        Integer antiRepetitionId = 1;
        boolean success = false;
        while (!success) {
            success = true;
            for (Product product2 : Storage.getStorage()) {
                if (antiRepetitionId.equals(product2.getId())) {
                    antiRepetitionId++;
                    success = false;
                }
            }
        }
        return antiRepetitionId;
    }

    public static boolean checkPassportId (String passportId) {
        return Storage.searchOwnerByPassportId(passportId) == null;
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
    public static String showProductInConsole(Product product) {
        String answer = "";
        answer += "ID: "+ product.getId() + "\n";
        answer += "Name: "+ product.getName() + "\n";
        answer += "About coordinates:" + "\n";
        answer += "    Coordinate X: "+ product.getCoordinates().getX() + "\n";
        answer += "    Coordinate Y: "+ product.getCoordinates().getY() + "\n";
        answer += "Creation date: "+ product.getCreationDate().toString() + "\n";
        if (product.getPrice() != null) {
            answer += "Price: "+ product.getPrice() + "\n";
        } else {
            answer += "Price: -" + "\n";
        }
        if (product.getManufactureCost() != null) {
            answer += "Manufacture cost: "+ product.getManufactureCost() + "\n";
        } else {
            answer += "Manufacture cost: -" + "\n";
        }
        answer += "Unit of measure: "+ product.getUnitOfMeasure().toString() + "\n";
        if (product.getOwner() != null) {
            answer += "About owner:" + "\n";
            answer += "    Name: "+ product.getOwner().getName() + "\n";
            if (product.getOwner().getBirthday() != null) {
                answer += "    Birthday: "+ product.getOwner().getBirthday().toString() + "\n";
            } else {
                answer += "    Birthday: -" + "\n";
            }
            if (product.getOwner().getHeight() != null) {
                answer += "    Height: "+ product.getOwner().getHeight() + "\n";
            } else {
                answer += "    Height: -" + "\n";
            }
            answer += "    Weight: "+ product.getOwner().getWeight() + "\n";
            if (product.getOwner().getPassportID() != null) {
                answer += "    Passport ID: "+ product.getOwner().getPassportID() + "\n";
            } else {
                answer += "    Passport ID: -" + "\n";
            }
        } else {
            answer += "Owner: -" + "\n";
        }
        return answer;
    }

    /*
    public static void showOwnerInConsole(Product product) {
        if (product.getOwner() != null) {
            System.out.println("Name: " + product.getOwner().getName());
            if (product.getOwner().getBirthday() != null) {
                System.out.println("Birthday: " + product.getOwner().getBirthday().toString());
            } else {
                System.out.println("Birthday: -");
            }
            if (product.getOwner().getHeight() != null) {
                System.out.println("Height: " + product.getOwner().getHeight());
            } else {
                System.out.println("Height: -");
            }
            System.out.println("Weight: " + product.getOwner().getWeight());
            if (product.getOwner().getPassportID() != null) {
                System.out.println("Passport ID: " + product.getOwner().getPassportID());
            } else {
                System.out.println("Passport ID: -");
            }
        } else {
            System.out.println("Owner is null");
        }
    }

     */

    /*
    public static void showOwnerInConsole(Person owner) {
        if (owner != null) {
            System.out.println("Name: " + owner.getName());
            if (owner.getBirthday() != null) {
                System.out.println("Birthday: " + owner.getBirthday().toString());
            } else {
                System.out.println("Birthday: -");
            }
            if (owner.getHeight() != null) {
                System.out.println("Height: " + owner.getHeight());
            } else {
                System.out.println("Height: -");
            }
            System.out.println("Weight: " + owner.getWeight());
            if (owner.getPassportID() != null) {
                System.out.println("Passport ID: " + owner.getPassportID());
            } else {
                System.out.println("Passport ID: -");
            }
        } else {
            System.out.println("Owner is null");
        }
    }

     */
}