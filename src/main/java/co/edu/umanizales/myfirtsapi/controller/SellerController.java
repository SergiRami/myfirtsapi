package co.edu.umanizales.myfirtsapi.controller;


import co.edu.umanizales.myfirtsapi.model.Location;
import co.edu.umanizales.myfirtsapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "seller")
public class SellerController {
    @GetMapping
    public Seller getSeller(){

        /// Instanciar 5 sellers
        ///Seller seller = new Seller()
        Location manizales = new Location("17001", "Manizales");
        Seller alejandro = new Seller("546466788", (byte) 56, "alejandro", "perez", 'm', manizales);

        return alejandro;
    }
}
