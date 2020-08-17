package commands;

import shop_units.Product;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Remove_lower extends AbstractCommand {
    public Remove_lower(Product product) {
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный");
        setProduct(product);
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        int var = collection.size();
        collection.stream().filter(Objects::nonNull)
                .filter(product -> product.getPrice() < Integer.parseInt(getArgument()))
                .forEach(product -> collection.remove(product));

        if (collection.size() != var) {
            return "Products removed!\n";
        }
        return "There are no products that have a price lower than the specified one\n";

//        setCollection(collection);
//        int numberOfDeletedItems = 0;
//        ArrayList<Product> smallerProducts = new ArrayList<>();
//        for (Product productFromCollection : collection) {
//            if (getProduct().compareTo(productFromCollection) > 0) {
//                smallerProducts.add(productFromCollection);
//            }
//        }
//        for (Product productFromArray : smallerProducts) {
//            System.out.println("Product \""+ productFromArray.getName() +"\" removed!");
//            collection.remove(productFromArray);
//        }
//
//        return "Number of deleted items: "+ numberOfDeletedItems;
    }
    //todo написал хрен знает что. Помолюсь, чтоб заработало
}
