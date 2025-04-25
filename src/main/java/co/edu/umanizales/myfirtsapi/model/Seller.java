package co.edu.umanizales.myfirtsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Seller {
    private String identification;
    private String age;
    private String name;
    private String lastName;
    private String gender;
    private Location city;
}
