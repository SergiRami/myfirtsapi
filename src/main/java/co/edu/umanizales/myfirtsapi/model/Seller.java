package co.edu.umanizales.myfirtsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Seller {
    private String identification;
    private byte age;
    private String name;
    private String lastName;
    private char gender;
    private Location city;
}
