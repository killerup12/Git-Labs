package commands;

import shop_units.Product;

import java.util.LinkedHashSet;

public class IsConnected extends AbstractCommand {

    public IsConnected() {
        super("IsConnected", "");
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {
        return "Connection to server established!";
    }
}
