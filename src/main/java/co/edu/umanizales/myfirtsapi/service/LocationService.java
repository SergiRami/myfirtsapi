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
public class LocationService{

    @Value("${locations_filename}")
    private String locationsFilename;

    private List<Location> locations = new ArrayList<>();

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {

        Path pathfile= Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try(BufferedReader br = new BufferedReader(new FileReader(pathfile.toString()))) { //Buffered reader para encontrar el archivo y leer la información


            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) !=null) {
                if (firstLine) {
                    firstLine = false; //salta la primera linea
                    continue;
                }
                String[] tokens = line.split(",");
                String code = tokens[2];
                String name = tokens[3];
                locations.add(new Location(code,name)); //añadir cada instancia de locations para generar la lista completa

            }

            System.out.println(locations.size());
            System.out.println(locations + "from: " + locationsFilename);

        }catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping(path ="/code/{code}" )
    public Location getLocationByCode(@PathVariable String code){
        return locations.stream().filter(location -> location.getCode().equals(code)).findFirst().orElse(null);
    }
    @GetMapping(path ="/name/{name}")
    public Location getLocationByName(@PathVariable String name){
        return locations.stream().filter(location -> location.getDescription().equals(name)).findFirst().orElse(null);
    }
    @GetMapping(path ="/initialLetter/{initialLetter}")
    public Location getLocationByInitialLetters(@PathVariable String initialLetter){
      return locations.stream().filter(location -> location.getDescription().equals(initialLetter)).findFirst().orElse(null);
    }
    @GetMapping(path ="/stateCode/{stateCode}")
    public Location getLocationByStateCode(@PathVariable String stateCode){
        return locations.stream().filter(location -> location.getDescription().equals(stateCode)).findFirst().orElse(null);
    }@GetMapping(path = "/states")
    public List<Location> getStates(){
        return locations;
    }
    @GetMapping(path ="/StatesCode/{StatesCode}")
    public Location getStatesByCode(@PathVariable String code){
        return locations.stream().filter(location -> location.getCode().equals(code)).findFirst().orElse(null);
    }
    @GetMapping(path = "/capitals")
    public List<String> getCapitals(){
        return locations.stream().filter(location -> location.getDescription().equals("Capitals")).map(location -> location.getDescription()).collect(Collectors.toList());
    }
}