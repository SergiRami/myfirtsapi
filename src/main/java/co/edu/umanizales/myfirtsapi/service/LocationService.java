package co.edu.umanizales.myfirtsapi.service;

import co.edu.umanizales.myfirtsapi.model.Location;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@ToString
public class LocationService {

    @Value("${locations_filename}")
    private String locationsFilename;

    private List<Location> locations = new ArrayList<>();

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {

        Path pathfile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (BufferedReader br = new BufferedReader(new FileReader(pathfile.toString()))) { //Buffered reader para encontrar el archivo y leer la información


            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; //salta la primera linea
                    continue;
                }
                String[] tokens = line.split(",");
                String code = tokens[2];
                String name = tokens[3];
                locations.add(new Location(code, name)); //añadir cada instancia de locations para generar la lista completa

            }

            System.out.println(locations.size());
            System.out.println(locations + "from: " + locationsFilename);

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }


// aqui se asigna la ruta del metodo para obtener la localizacion por codigo postal
    public Location getLocationByCode(@PathVariable String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }



    public Location getLocationByName(@PathVariable String name) {
          for (Location location : locations) {
              if(location.getDescription().equals(name)){
                  return location;
              }
          }
          return null;
    }


// aqui se asigna la ruta del metodo para obtener la localizacion por la letra inicial de la ciudad
    public Location getLocationByInitialLetters(@PathVariable String initialLetter) {
        List<Location> InitialLettersArray = new ArrayList<>();
        for (Location location : locations) {
            if(location.getDescription().equals(initialLetter)){
                InitialLettersArray.add(location);
            }
        }
        return InitialLettersArray.get(0);
    }


// aqui se asigna la ruta del metodo para obtener la localizacion por codigo de departamento
    public Location getLocationByStateCode(@PathVariable String stateCode) {
        for (Location location : locations) {
            if(location.getCode().equals(stateCode)){
                return location;
            }
        }
        return null;
    }

    //aqui se genera la ruta para generar la lista de departamentos
    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
       for (Location location : locations) {
           if(location.getCode().length() ==2){
               states.add(location);
           }
       }
       return states;
    }

    public Location getStatesByCode(@PathVariable String code) {
      for (Location location : locations) {
          if(location.getCode().equals(code)){
              return location;
          }
      }
      return null;
    }


    public List<String> getCapitals() {
      List<String> capitals = new ArrayList<>();
      for (Location location : locations) {
          if(location.getDescription().length()>0){
              capitals.add(location.getDescription());
          }
      }
      return capitals;
    }


    public List<Location> getLocationsByLenght(@PathVariable int length) {
        List<Location> results = new ArrayList<>();
        for (Location location : locations) {
            if (location.getDescription().length() >=length) {
                results.add(location);
            }
        }
        return results;
    }
}