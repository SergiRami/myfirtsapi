package co.edu.umanizales.myfirtsapi.controller;


import co.edu.umanizales.myfirtsapi.model.Location;
import co.edu.umanizales.myfirtsapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "seller")
public class SellerController {
    @GetMapping
    public List<Seller> getSeller(){
        List<Seller> sellers = new ArrayList<>();
        /// Instanciar 5 sellers
        ///Seller seller = new Seller()
        /// locaciones de donde viven los sellers
        Location manizales = new Location("170001", "Manizales");
        Location pereira = new Location("660002", "Pereira");
        Location chinchina = new Location("176020", "Chinchina");
        /// lista de seller en la store

        Seller alejandro = new Seller("546466788", (byte) 56, "alejandro", "perez", 'm', manizales);
        Seller mariana = new Seller("484848452", (byte) 24, "mariana", "lopez", 'f', pereira);
        Seller santiago = new Seller("48546124", (byte) 27, "santiago", "suarez", 'm', chinchina);
        Seller angelica = new Seller("147845825", (byte) 21, "angelica", "ramirez", 'f', chinchina);
        Seller luz = new Seller("78958873", (byte) 22, "luz", "restrepo", 'f', manizales);

        sellers.add(alejandro);
        sellers.add(mariana);
        sellers.add(santiago);
        sellers.add(angelica);
        sellers.add(luz);
        

        return sellers;
    }
}
