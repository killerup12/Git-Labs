package commands;

import shop_units.Product;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Show extends AbstractCommand implements Serializable {
    public Show() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    private String answer= "";

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        if (collection.size() == 0) {
            return "Collection os empty";
        }
        collection.stream().forEach(this::addToAnswer);
        return answer;


//        setCollection(collection);
//        String answer = "";
//        if (!getCollection().isEmpty()) {
//            for (Product product : collection) {
//                answer += showProduct(product);
//                answer += "-------------------------\n";
//            }
//        } else {
//            answer = "Collection is empty.";
//        }
//
//        return answer;
    }

    private void addToAnswer(Product product) {
        answer += showProduct(product);
        answer += "-------------------------\n";
    }
}