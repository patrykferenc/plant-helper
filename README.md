# plant-helper

This is a project for 'Azure and AI based solutions' 2022/2023 at Applied Computer Science EE WUT. 

## Goal

The project's main aim was to create a all-in-one encompasing information and analitycs application which could be used by farmers, home garden owners and agricultural sector as a whole. With an easy chat bot interface ( which has become very popular in recent years ), this project strives to combine powerfull computational techniques ( AI, big data etc.) with accesability. 

## Contributors
* <a href ="https://github.com/patrykferenc" targer="_blank">Patryk Ferenc</a>
* <a href ="https://github.com/Jakub-Kar" targer="_blank">Kuba Karpiński</a>
* <a href ="https://github.com/luizalouise" targer="_blank">Luiza Krzepkowska</a>
* <a href ="https://github.com/kutsepka" targer="_blank">Katya Kutsepina</a>
* <a href ="https://github.com/AgataLa" targer="_blank">Agata Lachowiecka</a>
* <a href ="https://github.com/legeof008" targer="_blank">Maciej Michalski</a>

## Features

- Plant recomendation based on soil with AI feedback
- Strategies of which plants could be near each other and which cannot
- Crop impact analisys based on previously mentioned factors
- Weather forecast with feedback loop back into AI-based solution
- QnA about issues related to agriculture

## Services
- Plant Helper Bot as an interface
- Plant Companion DB (Cosmos DB)
- Azure Data Factory
- ML Recomendation Model ( Machine Learning )
- Weather Function ( Function App )
- Plant Companion Function ( Function App)
- Storage Accounts
- Azure Network
- Power BI
- Language Studio
- LUIS

## Architecture diagram
![320982824_1912999922375071_5192715721669556521_n](https://user-images.githubusercontent.com/72550341/211370652-4c44b222-3845-48c4-ac2c-629c87a72c50.png)

## User Guide
At the begining of conversation with PlantHelper bot you have five options from main menu:
1. I want to ask questions about agriculture
2. Show me weather information
3. What can I plant in specific conditions?
4. What plants can I plant next to each other?
5. Show me visualization about plants

After choosing option 1. you will be able to ask bot any question you have regarding to agriculture, e. g. "Which crops are grown in the rainy season?".
Bot will respond with corresponding answer, e. g. "Kharif crops, also known as monsoon crops are grow in the rainy season such as Rice, Maize, Sorghum, Bajra, Soybean, Cotton, and others".
You can ask as many questions as you need.

Option 2. gives you the possibility to find out what the weather will be like in any city. First you will have to provide the location of the weather forecast, and then the number of days ahead. In response bot will give you informations about temperature, humidity and precipitation.

Option 3. helps you choose the right plant depending on the soil parameters. To get the answer you will have to enter values of nitrogen, phosphorus, potassium, temperature, humidity, pH and rainfall.

Option 4. gives you the information about what plants are beneficial to plant next to each other.

Option 5. allows you to display one of the five visualizations about plants.

## Demo on YouTube
https://youtu.be/-rhfQ5SoaaY

<a name="task-list"/></a>
## Task List

1. TODO by **20.12.2022**:
* **Luiza Krzepkowska**:
    * [x] Create a knowledge base for bot and use LUIS service in bot 
* **Agata Lachowiecka**:
    * [x] Create a bot skeleton and connect it to the knowledge base

2. TODO by **8.01.2023**:
* **Kuba Karpiński**:
    * [x] Preparate model in Machine Learning
* **Maciej Michalski**:
    * [x] Create a function app that connects to the weather api
    * [x] Add bot to weather service integration  
* **Katya Kutsepina**:
    * [x] Create a visualization in PowerBI

3. TODO by **9.11.2023**:
* **Luiza Krzepkowska**:
    * [x] Record a demo
    * [x] Integrate the ml model with the bot 
    * [x] Add visualization to bot
* **Agata Lachowiecka**:
    * [x] Edit demo
    * [x] Integrate the ml model with the bot and bot fixes
* **Patryk Ferenc**:
    * [x] Create Cosmos DB
    * [x] Create service for plant recommendation
    * [x] Add bot to companion-service integration 
    * [x] Create Architecture Diagram
    
