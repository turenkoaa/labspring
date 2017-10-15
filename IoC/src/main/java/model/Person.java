package model;

import java.util.List;

public interface Person {
    String getName();
    int getId();
    Country getCountry();
    int getAge();
    float getHeight();
    boolean isProgrammer();
    List<String> getContacts();
    void sayHello(Person person);
}