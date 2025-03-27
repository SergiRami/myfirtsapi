package co.edu.umanizales.myfirtsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/location")
public class LocationController {
    @GetMapping
    public String getlocation(){
        return "Manizales";
    }
}
