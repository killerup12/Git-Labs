package commands;

import shop_units.Product;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class Info extends AbstractCommand {
    public Info() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)");
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {
        setCollection(collection);
        String date = LocalDate.now().toString();
        return "Collection type: LinkedHasSet\n"+
                "Initialization date: "+ date +"\n"+
                "Amount of elements: "+ collection.size() +"\n";
    }
}
