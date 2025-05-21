package co.edu.umanizales.myfirtsapi.controller;


import co.edu.umanizales.myfirtsapi.model.Parameter;
import co.edu.umanizales.myfirtsapi.model.Product;
import co.edu.umanizales.myfirtsapi.model.TypeDocuments;
import co.edu.umanizales.myfirtsapi.model.TypeProduct;
import co.edu.umanizales.myfirtsapi.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path= "/parameter")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping(path="/typedocuments")
    public List<Parameter> getTypesDocuments(){
        return parameterService.getParametersByType(1);
    }
    @GetMapping(path="/typeproducts")
    public List<Parameter> getTypesProducts(){
        return parameterService.getParametersByType(2);
    }
    @GetMapping(path="/products")
    public List<Parameter> getProduct(){
        return parameterService.getParametersByType(3);
    }
}
