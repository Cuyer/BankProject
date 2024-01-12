package entity;

public class Person {
    protected String name;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    protected String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
