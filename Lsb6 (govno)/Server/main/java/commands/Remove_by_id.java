package commands;

import shop_units.Product;

import java.util.LinkedHashSet;

public class Remove_by_id extends AbstractCommand {
    public Remove_by_id(Integer id) {
        super("remove_by_id id", "удалить элемент из коллекции по его id");
        setArgument(String.valueOf(id));
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        try {
            Product answer = collection.stream()
                    .filter(product -> product.getId() == Integer.parseInt(getArgument()))
                    .findAny().get();
            collection.remove(answer);
            return "Element removed!\n";
        } catch (NullPointerException e) {
            return "No changes to the collection.\n";
        }

//
//        setCollection(collection);
//        Integer id = Integer.parseInt(getArgument());
//        int countOfElements = getCollection().size();
//        for (Product product : getCollection()) {
//            if (product.getId().equals(id)) {
//                getCollection().remove(product);
//                break;
//            }
//        }
//
//        if (getCollection().size() != countOfElements) {
//            return "Element removed!";
//        } else {
//            return "No changes to the collection.";
//        }
    }
}