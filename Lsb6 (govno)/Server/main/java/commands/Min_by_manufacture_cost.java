package commands;

import shop_units.Product;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;

public class Min_by_manufacture_cost extends AbstractCommand {
    public Min_by_manufacture_cost() {
        super("min_by_manufacture_cost", "вывести любой объект из коллекции, значение поля manufactureCost которого является минимальным");
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        Product minProduct = collection.stream()
                .filter(Objects::nonNull)
                .min(Product::compareTo).get();
        return showProduct(minProduct) +"\n";

//        setCollection(collection);
//        Product product;
//        if (collection.isEmpty()) return null;
//        Integer minManufactureCost = null;
//        Product minManufactureCostProduct = null;
//        for (Product productInCollection : collection) {
//            if ((minManufactureCost == null) && (productInCollection.getManufactureCost() != null)) {
//                minManufactureCost = productInCollection.getManufactureCost();
//            } else if ((productInCollection.getManufactureCost() != null) && (minManufactureCost > productInCollection.getManufactureCost())) {
//                minManufactureCost = productInCollection.getManufactureCost();
//                minManufactureCostProduct = productInCollection;
//            }
//        }
//        product = minManufactureCostProduct;
//
//        if (product == null) {
//            return "There are no declared items in this collection!";
//        }
//        return showProduct(product);
    }
}
