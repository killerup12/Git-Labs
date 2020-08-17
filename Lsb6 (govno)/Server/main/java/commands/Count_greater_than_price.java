package commands;

import shop_units.Product;

import java.util.LinkedHashSet;

public class Count_greater_than_price extends AbstractCommand {
    public Count_greater_than_price(int price) {
        super("count_greater_than_price price", "вывести количество элементов, значение поля price которых больше заданного");
        setArgument(String.valueOf(price));
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {
        setCollection(collection);

        long var = collection.stream().map(Product::getPrice).filter(price -> price > Integer.parseInt(getArgument())).count();
        return "Number of items whose price is more than "+ getArgument() +": "+ var +"\n";
//        Integer price = Integer.parseInt(getArgument());
//        if (price == null) {
//            System.out.println("Such a price cannot exist!");
//            return "No price.";
//        }
//        int numberOfProductsDisplayed = 0;
//        for (Product product : collection) {
//            if (product.getPrice() == null) {
//                continue;
//            } else if (product.getPrice() > price) {
//                numberOfProductsDisplayed++;
//            }
//        }
//        if (numberOfProductsDisplayed == 0) {
//            return "There are no such elements whose price is more than a given!";
//        } else {
//            return "Number of items whose price is more than "+ price +": "+ numberOfProductsDisplayed;
//        }
    }
}
