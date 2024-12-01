import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    public List<Car> generateCars() throws IOException {
        List<Car> cars = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();  // Jackson ObjectMapper

        // Path to the directory where your JSON files are located
        String directoryPath = "C:/Users/chris/OneDrive/Desktop/oop_labs/lab3/demo/queue/";

        // Loop through the files (Car1.json, Car2.json, etc.)
        for (int i = 1; i <= 10; i++) {
            File jsonFile = new File(directoryPath + "Car" + i + ".json");

            // Deserialize JSON file into Car object
            Car car = objectMapper.readValue(jsonFile, Car.class);
            cars.add(car);
        }
        return cars;
    }
}
