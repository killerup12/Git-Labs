package commands;

import shop_units.Person;
import shop_units.Product;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Add extends AbstractCommand {
    public Add(Product product) {
        super("add", "добавить новый элемент в коллекцию");
        setProduct(product);
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {
        setCollection(collection);
        setAUniqueId(getProduct());

        getProduct().setCreationDate(ZonedDateTime.now());

        long duplicatePassportID = collection.stream().map(Product::getOwner)
                .filter(Objects::nonNull)
                .filter(owner -> owner.getPassportID().equals(getProduct().getOwner().getPassportID()))
                .count();

        if (duplicatePassportID == 0) {
            collection.add(getProduct());
            return "Product added!\n";
        }
        return "The product has not been added since such a PassportId already exists.\n";


//        getProduct().setCreationDate(ZonedDateTime.now());
//        if (getProduct().getOwner() != null) {
//            for (Product product : collection) {
//                if ((product.getOwner() != null) &&
//                   (getProduct().getOwner().getPassportID().equals(product.getOwner().getPassportID()))) {
//                    return "The product has not been added since such a PassportId already exists.";
//                }
//            }
//        }
//        int countOfElements = collection.size();
//        collection.add(getProduct());
//        if ((!collection.isEmpty()) && (countOfElements < collection.size())) {
//            return "Product added!";
//        }
//        return "The product has not been added because there is already the same;";
    }
}