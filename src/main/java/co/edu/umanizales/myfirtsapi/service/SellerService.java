package co.edu.umanizales.myfirtsapi.service;


import co.edu.umanizales.myfirtsapi.model.Location;
import co.edu.umanizales.myfirtsapi.model.Seller;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service

public class SellerService {

    private final LocationService locationService;

    @Value("${sellers_filename}")
    private String sellersFilename;

    List<Seller> sellers;

    public SellerService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void readSellersFromCSV() throws IOException, URISyntaxException {

        Path pathFile = Paths.get(ClassLoader.getSystemResource(sellersFilename).toURI());

        try (BufferedReader br = new BufferedReader(new FileReader(pathFile.toString()))) {


            sellers = new ArrayList<>();


            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] tokens = line.split(",");
                String identification = tokens[0];
                String age = tokens[1];
                String name = tokens[2];
                String lastName = tokens[3];
                String gender = tokens[4];
                String cityCode = tokens[5];

                Location locations = locationService.getLocationByCode(cityCode);

                sellers.add(new Seller(identification, age, name, lastName, gender, locations));

            }

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Seller> getAllSellers() {
        return sellers;
    }
}
