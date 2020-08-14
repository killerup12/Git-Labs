package commands;

import shop_units.Product;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Update extends AbstractCommand {
    public Update(Integer id, Product product) {
        super("update id", "обновить значение элемента коллекции, id которого равен заданному");
        setArgument(String.valueOf(id));
        setProduct(product);
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        long duplicatePassportID = collection.stream().map(Product::getOwner)
                .filter(Objects::nonNull)
                .filter(owner -> owner.getPassportID().equals(getProduct().getOwner().getPassportID()))
                .count();
        if (duplicatePassportID != 0) {
            return "The product has not been added since such a PassportId already exists.";
        }

        getProduct().setId(Integer.parseInt(getArgument()));
        getProduct().setCreationDate(ZonedDateTime.now());

        Product delProduct = collection.stream()
                .filter(product -> product.getId() == Integer.parseInt(getArgument()))
                .findFirst().get();
        collection.remove(delProduct);
        collection.add(getProduct());

        return "Product changed!";

//        setCollection(collection);
//        Integer id = Integer.parseInt(getArgument());
//        getProduct().setId(id);
//        getProduct().setCreationDate(ZonedDateTime.now());
//        if (getProduct().getOwner() != null) {
//            for (Product product : collection) {
//                if (getProduct().getOwner().getPassportID().equals(product.getOwner().getPassportID())) {
//                    return "The values of the Product fields have not been changed since the PassportId entered is not unique.";
//                }
//            }
//        }
//
//        for (Product product : collection) {
//            if (product.getId().equals(id)) {
//                collection.remove(product);
//            }
//        }
//
//        return "null";
    }
}
