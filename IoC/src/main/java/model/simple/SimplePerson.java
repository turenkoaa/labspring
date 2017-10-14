package model.simple;

import lombok.Value;
import model.Country;
import model.Person;

import java.util.List;

@Value
public class SimplePerson implements Person {
    private int id;
    private String name;
    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<String> contacts;

    private void sayHello(Person person) {
        System.out.printf("Hello, %s, I`m %s!", person.getName(), getName());
    }
}