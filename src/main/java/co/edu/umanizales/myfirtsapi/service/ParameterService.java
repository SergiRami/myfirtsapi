package co.edu.umanizales.myfirtsapi.service;


import co.edu.umanizales.myfirtsapi.model.Parameter;
import co.edu.umanizales.myfirtsapi.model.Product;
import co.edu.umanizales.myfirtsapi.model.TypeDocuments;
import co.edu.umanizales.myfirtsapi.model.TypeProduct;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class ParameterService {
    private List<Parameter> parameters;


    @PostConstruct
    private void loadParameters() {
        parameters = new ArrayList<Parameter>();

        parameters.add(new TypeDocuments("CC", "Cedula de ciudadania"));
        parameters.add(new TypeDocuments("NIT", "Numero Identificacion Tributaria"));

         //TypeProduct
        TypeProduct pcs = new TypeProduct("1","Pantallas");
        parameters.add(pcs);
        parameters.add(new TypeProduct("2","Portatiles"));
        parameters.add(new TypeProduct("3","Tarjetas Graficas"));
        parameters.add(new TypeProduct("4","Memoria Ram"));
        parameters.add(new TypeProduct("5","Tarjeta Madre"));
        parameters.add(new TypeProduct("6","Fuente de Poder"));
        parameters.add(new TypeProduct("7","Chasis"));

        ///Products
        parameters.add(new Product("1","Lenovo",1400000,40, pcs));
        parameters.add(new Product("2","HPS",4000000,400, pcs));
        parameters.add(new Product("3","Nvidia",7000000,100, pcs));
        parameters.add(new Product("4","Kigstom",200000,1000, pcs));
        parameters.add(new Product("5","TUF",600000,500, pcs));
        parameters.add(new Product("6","Cooler Master",400000,700, pcs));
        parameters.add(new Product("7","Gamdias",500000,800, pcs));

    }
   public List<Parameter> getParametersByType(int type) {
       List<Parameter> result =new ArrayList<>();
       for (Parameter p : parameters) {
           switch (type) {
               case 1:
                   if(p instanceof TypeDocuments){
                       result.add(p);
                   }

                   break;
               case 2:
                  if(p instanceof TypeProduct){
                      result.add(p);
                  }
                   break;
               case 3:
                   if(p instanceof Product){
                       result.add(p);
                   }

                   break;
           }
       }
       return result;
   }




}
