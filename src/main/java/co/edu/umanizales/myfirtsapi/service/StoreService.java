package co.edu.umanizales.myfirtsapi.service;


import co.edu.umanizales.myfirtsapi.model.Store;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class StoreService {
    private List<Store> stores;

    public String addStore(Store store) {
        stores.add(store);
        return "Tienda adicionada";

    }
}
