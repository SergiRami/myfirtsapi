package co.edu.umanizales.myfirtsapi.controller;

import co.edu.umanizales.myfirtsapi.model.Location;
import co.edu.umanizales.myfirtsapi.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getlocations(){
        return locationService.getLocations();
    }
    @GetMapping(path = "/code/{code}")
    public Location getLocationByCode(String code){
        return locationService.getLocationByCode(code);
    }
    @GetMapping(path = "/name/{name}")
    public Location getLocationByName(String name){
        return locationService.getLocationByName(name);
    }
    @GetMapping(path = "/initialLetter/{initiaLetter}")
    public Location getLocationByInitialLetter(String initialLetter){
        return locationService.getLocationByInitialLetters(initialLetter);
    }
    @GetMapping(path = "/stateCode/{stateCode}")
    public Location getLocationByStateCode(String state){
      return locationService.getLocationByStateCode(state);
    }
    @GetMapping(path = "/states/{states}")
    public List<Location> getLocationsByStateCode(String states){
        return locationService.getStates();
    }
    @GetMapping(path = "/getStateByCode/{stateCode}")
    public Location getStateByCode(String code){
        return locationService.getLocationByCode(code);
    }
    @GetMapping(path ="/getCapitals")
    public List<Location> getLocationsByCapitals(){
        return locationService.getLocations();
    }
}
