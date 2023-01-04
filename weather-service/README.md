# Azure Function App - weather service
## Development
In order to be able to locally debug this service You should follow this guide :
```
https://learn.microsoft.com/en-us/azure/azure-functions/functions-create-maven-intellij
```
The most important thigs to consider are :
 - using Intelij Idea IDE with **Azure Toolkit** plugin 
 - using Java11 with SDKs from Eclipse foundation
 - setting correct enviromental variables 
    - *apiUri* to http://api.weatherapi.com
    - *apiKey* to key obtained from that site
 ## Usage
 Usage of this API will be described by its contract.
 ### Current Weather Report
Request:
```
GET http://localhost:45837/api/getWeather?location=Warsaw
```
Response:
```json
{
  "humidity": "75.0",
  "temperature": "7.7",
  "percip": "0.1"
}
```
### Forecast Weather Report
Request:
```
GET http://localhost:45837/api/getWeather?location=Warsaw&days=3
```
Response:
```json
{
  "humidity": "81",
  "temperature": "4.0",
  "percip": "0.0"
}
```
### Future Weather Report
#### Format
With this one the format is a more complicated as it will go something like this:
```
GET http://localhost:45837/api/getWeather?location=Warsaw&dt=yyyy-mm-dd
```
Request:
```
GET http://localhost:45837/api/getWeather?location=Warsaw&dt=2023-02-02
```
Response:
```json
{
  "humidity": "90.0",
  "temperature": "-0.4",
  "percip": "1.61"
}
```
## Closing words
Keep in mind these are all **averages** of the day.