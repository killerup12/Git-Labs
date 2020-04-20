package tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import shop_units.Product;
import shop_units.Storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FileWorker {
    public static void completeCollection(String path) throws IOException, ArrayIndexOutOfBoundsException, NullPointerException {
        Path p = Paths.get(path);
        Scanner reader = new Scanner(p);
        //todo перегрузку в TextReader
        int i = 1;
        while (reader.hasNextLine()) {
            String jsonOb = reader.nextLine();
            try {
                Product tmp = JSON.parseObject(jsonOb, Product.class);
                tmp.setId(i);
                tmp.setCreationDate(ZonedDateTime.now());
                Storage.getStorage().add(tmp);
            } catch (JSONException e) {
                System.out.println("Ошибка чтения данных, строка №" + i);
                System.out.println("");
            }
            i++;
        }
    }
    //rework

}
