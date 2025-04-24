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

    @GetMapping(path ="/code/{code}" )// aqui se asigna la ruta del metodo para obtener la localizacion por codigo postal
    public Location getLocationByCode(@PathVariable String code){
        return locations.stream().filter(location -> location.getCode().equals(code)).findFirst().orElse(null);//aqui retorna de manera filtrada para que se genere la locacion segun el codigo postal
    }
    @GetMapping(path ="/name/{name}")// aqui se asigna la ruta del metodo para obtener la localizacion por nombre de la ciudad
    public Location getLocationByName(@PathVariable String name){
        return locations.stream().filter(location -> location.getDescription().equals(name)).findFirst().orElse(null);
    }
    @GetMapping(path ="/initialLetter/{initialLetter}")// aqui se asigna la ruta del metodo para obtener la localizacion por la letra inicial de la ciudad
    public Location getLocationByInitialLetters(@PathVariable String initialLetter){
      return locations.stream().filter(location -> location.getDescription().equals(initialLetter)).findFirst().orElse(null);//aca retorna y filtra los datos para que se busque por medio de la letra ingresada
    }
    @GetMapping(path ="/stateCode/{stateCode}")// aqui se asigna la ruta del metodo para obtener la localizacion por codigo de departamento
    public Location getLocationByStateCode(@PathVariable String stateCode){
        return locations.stream().filter(location -> location.getDescription().equals(stateCode)).findFirst().orElse(null);//aca retorna y filtra los datos para que se busque por medio del codigo de departamento
    }@GetMapping(path = "/states")//aqui se genera la ruta para generar la lista de departamentos
    public List<Location> getStates(){
        return locations; //aqui se retorna a la clase locations para sacar la lista de los departamentos
    }
    @GetMapping(path ="/StatesCode/{StatesCode}")//aqui se genera la ruta para filtrar la localizacion de departamentos por codigo
    public Location getStatesByCode(@PathVariable String code){
        return locations.stream().filter(location -> location.getCode().equals(code)).findFirst().orElse(null);//aqui se hace el filtro para los estados segun el codigo que se ingresa
    }
    @GetMapping(path = "/capitals")//aqui se genera la ruta para generar la lista de capitales
    public List<String> getCapitals(){
        return locations.stream().filter(location -> location.getDescription().equals("Capitals")).map(location -> location.getDescription()).collect(Collectors.toList());//aqui se filtra la informacion de las capitales parafiltrarla y generar la lista de las capitales
    }

}