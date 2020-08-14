package commands;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import shop_units.Product;
import tools.FileWorker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

public class Exit extends AbstractCommand {
    public Exit() {
        super("exit", "завершает работу клиента и сохраняет коллекцию в файл");
    }

    public JSONObject toJSON(Product product) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", product.getId());
        jsonObject.put("name", product.getName());
        jsonObject.put("coordinates", product.getCoordinates());
        jsonObject.put("creationDate", product.getCreationDate());
        jsonObject.put("price", product.getPrice());
        jsonObject.put("manufactureCost", product.getManufactureCost());
        jsonObject.put("unitOfMeasure", product.getUnitOfMeasure());
        if (product.getOwner() != null) {
            jsonObject.put("owner", product.getOwner());
        } else {
            jsonObject.put("owner", null);
        }
        return jsonObject;
    }

    @Override
    public String execute(LinkedHashSet<Product> collection) {
        setCollection(collection);
        if (!FileWorker.isReachable(getFile())) {
            return "Changes not saved, or no changes!";
        } else {
            JSONArray jsonArray = new JSONArray();
            for (Product product : getCollection()) {
                jsonArray.add(toJSON(product));
            }
            String jsonOutput = jsonArray.toJSONString();
            try {
                try (FileWriter fw = new FileWriter(getFile())) {
                    fw.write(jsonOutput);
                }
            } catch (IOException ignored) {
            }
            return "Data saved!";
        }
    }
}
