import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherAPIClient {

    private static final String API_KEY = "1180a524e01019d4709f48d8d56ab231"; // Replace with your OpenWeatherMap API Key
    private static final String URL_TEMPLATE = 
        "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = "";

        // Loop to keep asking for city name
        while (true) {
            System.out.print("Enter city name (or type 'exit' to quit): ");
            city = scanner.nextLine().trim();

            // If the user types 'exit', break the loop
            if (city.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break;
            }

            // Fetch and display weather data for the city
            fetchWeatherData(city);
        }

        scanner.close();
    }

    public static void fetchWeatherData(String city) {
        try {
            String urlString = String.format(URL_TEMPLATE, city, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Error: Unable to fetch weather data. Response Code: " + conn.getResponseCode());
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();

            // Parse JSON Response using Gson
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            String cityName = jsonResponse.get("name").getAsString();
            JsonObject main = jsonResponse.getAsJsonObject("main");
            double temperature = main.get("temp").getAsDouble();
            int humidity = main.get("humidity").getAsInt();
            JsonObject weather = jsonResponse.getAsJsonArray("weather").get(0).getAsJsonObject();
            String description = weather.get("description").getAsString();

            // Display Weather Data
            System.out.println("\n====== Weather Report for " + cityName + " ======");
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Condition: " + description);
            System.out.println("=================================\n");

        } catch (Exception e) {
            System.out.println("Error: Could not retrieve weather data. Please check the city name and try again.");
        }
    }
}
