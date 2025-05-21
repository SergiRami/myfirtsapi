package co.edu.umanizales.myfirtsapi.service;


import co.edu.umanizales.myfirtsapi.model.Store;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Getter
public class StoreService {
    @Autowired
    private List<Store> stores;

    @GetMapping
    public String addStore(Store store) {
        stores.add(store);
        return "Tienda adicionada";

    }



}
