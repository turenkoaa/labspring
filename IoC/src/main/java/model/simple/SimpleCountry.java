package model.simple;


import lombok.Value;
import model.Country;

@Value
public class SimpleCountry implements Country {
	private int id;
    private String name;
    private String codeName;
}
