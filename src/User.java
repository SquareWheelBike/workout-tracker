package src;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private double weight, height;
    private int age;

    public User(String name, int age, double height, double weight) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public User(String name, int age, double height) {
        this(name, age, height, 0.0);
    }

    public User(String name, int age) {
        this(name, age, 0.0, 0.0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
    }
}
