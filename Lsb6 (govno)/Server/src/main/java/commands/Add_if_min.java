package commands;

import shop_units.Product;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Add_if_min extends AbstractCommand {
    public Add_if_min(Product product) {
        super("add_if_max", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        setProduct(product);

    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        setCollection(collection);
        setAUniqueId(getProduct());
        getProduct().setCreationDate(ZonedDateTime.now());

        long var = collection.stream().filter(p -> getProduct().compareTo(p) >= 0)
                .count();
        if (var != 0) {
            return "The product has not been added because he is not the smallest.";
        }

        long duplicatePassportID = collection.stream().map(Product::getOwner)
                .filter(Objects::nonNull)
                .filter(owner -> owner.getPassportID().equals(getProduct().getOwner().getPassportID()))
                .count();
        if (duplicatePassportID != 0) {
            return "The product has not been added since such a PassportId already exists.";
        }

        collection.add(getProduct());
        return "Product added!";

//        setCollection(collection);
//        int countOfElements = collection.size();
//        setAUniqueId(getProduct());
//        getProduct().setCreationDate(ZonedDateTime.now());
//        if (getProduct().getOwner() != null) {
//            for (Product product : collection) {
//                if (getProduct().getOwner().getPassportID().equals(product.getOwner().getPassportID())) {
//                    return "The product has not been added since such a PassportId already exists.";
//                }
//            }
//        }
//        boolean success = true;
//        for (Product product : collection) {
//            if (getProduct().compareTo(product) >= 0) {
//                success = false;
//            }
//        }
//
//        if (success) {
//            collection.add(getProduct());
//        }
//        if (countOfElements != collection.size()) {
//            return "Item has been added to collection.";
//        } else {
//            return "The item has not been added since it is not the largest.";
//        }
    }
}
