package shop_units;

import com.alibaba.fastjson.JSONObject;
import enums.UnitOfMeasure;
import tools.Coordinates;

import java.time.ZonedDateTime;

public class Product implements Comparable<Product>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Пол не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long price; //Поле может быть null, Значение поля должно быть больше 0
    private Integer manufactureCost; //Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле может быть null

    public Product() {
        coordinates = new Coordinates();
        owner = new Person();
        //костыль. Испровить!
    }

    /**
     * Метод, позволяющий преобразовать объект
     * для хранения в JSON
     * @return объект JSON
     */
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", name);
        jsonObject.put("coordinates", coordinates);
        jsonObject.put("creationDate", creationDate);
        jsonObject.put("price", price);
        jsonObject.put("manufactureCost", manufactureCost);
        jsonObject.put("unitOfMeasure", unitOfMeasure);
        if (owner != null) {
            jsonObject.put("owner", owner);
        } else {
            jsonObject.put("owner", null);
        }
        return jsonObject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    Integer getManufactureCost() {
        return manufactureCost;
    }

    public void setManufactureCost(Integer manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    //Сравнение продуктов происходит по цене
    @Override
    public int compareTo(Product o) {
        if (o == null) {
            return 1;
        } else if ((o.price == null) && (price != null)) {
            return 1;
        } else if (o.price == null) {
            return 0;
        } else if (price == null) {
            return -1;
        }
        return (int) (this.price - o.price);
    }
}