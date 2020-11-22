# INTRODUCTION
Weather Reporting Comparator is a test automation solution that compares weather information from web & API sources


# INSTALLATIONS

## To Get Started

### Pre-requisites

- Java 7 or Higher
- Eclipse IDE
- TestNg
- Maven


### Setup Scripts

- Clone or Download the repository into a folder
- Install all Pre-requisites

### How to Run Test Suite

- Go inside the project root folder 
- Right click on testng.xml
- Run as TestNg Suite
- Or run from Command line using Maven command: mvn clean install test

# Structure:


### Helpers: 
Consists functions for getting weather details from UI and API.

### Locators: 
Consists Webelement locators, that tells Selenium IDE which GUI elements ( say Text Box, Buttons, Check Boxes etc) its needs to operate on.

### Properties: 
Contains properties for application data.

### Tests: 
Main test scripts to run the UI flow and connecting to weather API and validating the data

### utils:
Contains classed perform generic actions across the automation execution