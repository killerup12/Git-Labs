package shop_units;

import java.time.LocalDate;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private LocalDate birthday; //Поле может быть null
    private Float height; //Поле может быть null, Значение поля должно быть больше 0
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Поле может быть null

    public Person() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public java.time.LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday (LocalDate birthday){
        this.birthday = birthday;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
       this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
}