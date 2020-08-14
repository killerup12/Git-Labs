package commands;

import shop_units.Product;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static java.util.Collections.swap;

public class Print_field_descending_owner extends AbstractCommand {
    public Print_field_descending_owner() {
        super("print_field_descending_owner", "вывести значения поля owner всех элементов в порядке убывания");
    }

    private String answer = "";

    @Override
    public String execute(LinkedHashSet<Product> collection) {

        collection.stream().sorted().forEach(this::addToAnswer);
        //todo проверить на работоспособность
        return answer;

//        setCollection(collection);
//        ArrayList<Product> arrayProduct = new ArrayList<>();
//        for (Product product : collection) {
//            if (product.getOwner() != null) {
//                arrayProduct.add(product);
//            }
//        }
//        if (arrayProduct.size() > 1) {
//            boolean needIteration = true;
//            while (needIteration) {
//                needIteration = false;
//                for (int i = 1; i < arrayProduct.size(); i++) {
//                    if (arrayProduct.get(i).compareTo(arrayProduct.get(i-1)) < 0) {
//                        swap(arrayProduct, i, i-1);
//                        needIteration = true;
//                    }
//                }
//            }
//
//            for (Product product : arrayProduct) {
//                answer += showOwner(product);
//                answer += "-------------------------\n";
//            }
//        } else if (arrayProduct.size() == 1) {
//            answer += showOwner(arrayProduct.get(0));
//            answer += "-------------------------\n";
//        } else {
//            answer += "Owners do not exist!";
//        }
//        return answer;
//    }
        //todo не факт, что это говно работает
    }
    private void addToAnswer(Product product) {
        answer += showProduct(product);
    }
}
