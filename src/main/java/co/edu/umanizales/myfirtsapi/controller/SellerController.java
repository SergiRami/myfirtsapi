package co.edu.umanizales.myfirtsapi.controller;



import co.edu.umanizales.myfirtsapi.model.Seller;
import co.edu.umanizales.myfirtsapi.service.SellerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<Seller> getSeller(){
        return sellerService.getAllSellers();
    }
}
