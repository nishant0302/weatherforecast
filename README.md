A simple Feign client usage example. Fetches weather data from https://www.yr.no/ and display that on a browser.
This application show weather forecast during morning and lunch time.
Based on the work of:

Requires:

Java 11
Spring Boot 2.5.2
Reactive Web

build the application
`mvn clean install`


run the application
`mvn exec:java -Dexec.mainClass=com.example.weatherforcast.WeatherforcastApplication` or run the main method in intelliJ or IDE

query weather for a particular interval of one hours
`curl -v http://localhost:8080//weather/forecast/by/location/{locationId}?timeInterval={intervalType}`

access application from browser
`http://localhost:8080/`
