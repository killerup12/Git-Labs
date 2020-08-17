package commands;

import shop_units.Product;

import java.util.LinkedHashSet;

public class KostilCommand extends AbstractCommand{
    public KostilCommand() {
        super("kostil'_command", "Этот кусок парашного кода нужен, чтобы на серв отправить команду. Иначе прога ломается.");
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {
        return " ";
    }
}
