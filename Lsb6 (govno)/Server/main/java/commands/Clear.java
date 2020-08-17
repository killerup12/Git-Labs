package commands;

import shop_units.Product;

import java.util.LinkedHashSet;

public class Clear extends AbstractCommand {
    public Clear() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {
        setCollection(collection);
        int countOfElementsInCollection = collection.size();
        collection.clear();
        if (countOfElementsInCollection != collection.size()) {
            return "Collection cleaned.\n";
        }
        return "No changes to the collection.\n";
    }
}
