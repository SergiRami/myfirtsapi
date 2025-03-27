package co.edu.umanizales.myfirtsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.stream.Location;
@Getter
@Setter
@AllArgsConstructor
public class Store {
    public byte code;
    public String name;
    public String address;
    public Location city_location;
}
