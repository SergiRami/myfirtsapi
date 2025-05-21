package co.edu.umanizales.myfirtsapi.controller;


import co.edu.umanizales.myfirtsapi.model.Store;
import co.edu.umanizales.myfirtsapi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @GetMapping
    public List<Store> getStores() {
        return storeService.getStores();
    }
}
