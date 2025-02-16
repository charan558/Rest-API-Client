<<<<<<< HEAD
# Rest-API-Client
=======
Weather API Client in Java – Overview
This Weather API Client is a Java-based REST API client that fetches real-time weather data from OpenWeatherMap using an HTTP request. It processes the JSON response and displays temperature, humidity, and weather conditions in a user-friendly format.

How It Works
User Input – Prompts the user to enter a city name.
API Request – Sends an HTTP GET request to OpenWeatherMap.
Response Handling – Reads and parses the JSON response.
Displays Weather Data – Prints temperature, humidity, and conditions.
Error Handling – Manages incorrect city names, API errors, and network issues.


Key Features
✔ User Input-Based Search – Fetches weather for any city.
✔ Real-Time Weather Data – Retrieves temperature (°C), humidity (%), and conditions (e.g., Clear, Rainy).
✔ JSON Parsing – Extracts data using org.json.JSONObject.
✔ Error Handling – Manages invalid inputs and API failures.
✔ User-Friendly Output – Displays weather details in a structured format.
✔ Lightweight & Fast – Uses HttpURLConnection for quick API requests.
✔ Easily Extensible – Can be enhanced with forecasts, GUI, or data storage.

Example Output
yaml
Copy
Edit
Enter city name: Hyderabad

====== Weather Report for Hyderabad ======
Temperature: 30.5°C
Humidity: 45%
Condition: Clear sky
=================================


Possible Enhancements
✅ Add weather forecast for upcoming days.
✅ Implement GUI (JavaFX, Swing) for better usability.
✅ Use Java 11's HttpClient for better performance.
✅ Store search history in a file or database.

OUTPUT
