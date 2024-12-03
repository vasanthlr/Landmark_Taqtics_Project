## Overview
This project automates:
- Login functionality for the Landmark website.
- API testing for the /generateAuthToken endpoint.

## Tools Used
- Selenium WebDriver
- BDD Cucumber
- Maven (dependency management)
- Rest-Assured (API Testing)


## Directory Structure
- src/test/java: Contains Step Definitions, Test Runner class, Page Object Model, Base Class, Hooks class and Cucumber Report Generation.
- src/test/resources/features: Contains Feature files.

## Setup Instructions
1. Clone the repository.
2. Install Java JDK and Maven.
3. Add the necessary dependencies using pom.xml.
4. Run tests with mvn clean test.

## Reports
- Cucumber Reports are generated in the target/cucumber-reports directory.