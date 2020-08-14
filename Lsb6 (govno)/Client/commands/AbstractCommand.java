package commands;

import shop_units.Product;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashSet;

abstract public class AbstractCommand implements Serializable {
    private String name;
    private String info;
    private String argument;
    private Product product;
    private LinkedHashSet<Product> collection;
    private File file;

    AbstractCommand (String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }
    public String getInfo() {
        return info;
    }
    public String getArgument() {
        return argument;
    }
    public Product getProduct() {
        return product;
    }
    public LinkedHashSet<Product> getCollection() {
        return collection;
    }
    public File getFile() {
        return file;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setArgument(String argument) {
        this.argument = argument;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setCollection(LinkedHashSet<Product> collection) {
        this.collection = collection;
    }
    public void setFile(File file) {
        this.file = file;
    }

    void setAUniqueId(Product product) {
        int id = 1;
        boolean success = false;
        while (!success) {
            success = true;
            for (Product productFromCollection : getCollection()) {
                if (productFromCollection.getId() == id) {
                    id++;
                    success = false;
                    break;
                }
            }
            if (success) {
                product.setId(id);
                return;
            }
        }
    }


    String showProduct(Product product) {
        String answer = "";
        answer += "ID: "+ product.getId() + "\n";
        answer += "Name: "+ product.getName() + "\n";
        answer += "About coordinates:" + "\n";
        answer += "    Coordinate X: "+ product.getCoordinates().getX() + "\n";
        answer += "    Coordinate Y: "+ product.getCoordinates().getY() + "\n";
        answer += "Creation date: "+ product.getCreationDate().toString() + "\n";
        if (product.getPrice() != null) {
            answer += "Price: "+ product.getPrice() + "\n";
        } else {
            answer += "Price: -" + "\n";
        }
        if (product.getManufactureCost() != null) {
            answer += "Manufacture cost: "+ product.getManufactureCost() + "\n";
        } else {
            answer += "Manufacture cost: -" + "\n";
        }
        answer += "Unit of measure: "+ product.getUnitOfMeasure().toString() + "\n";
        if (product.getOwner() != null) {
            answer += "About owner:" + "\n";
            answer += "    Name: "+ product.getOwner().getName() + "\n";
            if (product.getOwner().getBirthday() != null) {
                answer += "    Birthday: "+ product.getOwner().getBirthday().toString() + "\n";
            } else {
                answer += "    Birthday: -" + "\n";
            }
            if (product.getOwner().getHeight() != null) {
                answer += "    Height: "+ product.getOwner().getHeight() + "\n";
            } else {
                answer += "    Height: -" + "\n";
            }
            answer += "    Weight: "+ product.getOwner().getWeight() + "\n";
            if (product.getOwner().getPassportID() != null) {
                answer += "    Passport ID: "+ product.getOwner().getPassportID() + "\n";
            } else {
                answer += "    Passport ID: -" + "\n";
            }
        } else {
            answer += "Owner: -" + "\n";
        }
        return answer;
    }

    String showOwner(Product product) {
        String answer = "";
        if (product.getOwner() != null) {
            answer += "About owner:" + "\n";
            answer += "Name: "+ product.getOwner().getName() + "\n";
            if (product.getOwner().getBirthday() != null) {
                answer += "Birthday: "+ product.getOwner().getBirthday().toString() + "\n";
            } else {
                answer += "Birthday: -" + "\n";
            }
            if (product.getOwner().getHeight() != null) {
                answer += "Height: "+ product.getOwner().getHeight() + "\n";
            } else {
                answer += "Height: -" + "\n";
            }
            answer += "Weight: "+ product.getOwner().getWeight() + "\n";
            if (product.getOwner().getPassportID() != null) {
                answer += "Passport ID: "+ product.getOwner().getPassportID() + "\n";
            } else {
                answer += "Passport ID: -" + "\n";
            }
        } else {
            answer += "Owner: -" + "\n";
        }
        return answer;
    }

    abstract public String execute(LinkedHashSet<Product> collection);
}
