# BirdNestProtectorDroneScanner

Welcome to the BirdNestProtectorDroneScanner project! This project is a submission for Reaktor's PROJECT BIRDNEST 
challenge. It is a Spring application that aims to protect bird nests from drones by detecting and reporting
potential violations on the no-fly zone.

You can see the project live at:

[https://dronescanner.herokuapp.com/](https://dronescanner.herokuapp.com/)

Made with Java, Spring and a little JavaScript.

### Data
You can access a list of the last violators within 10 minutes with the following API call:

    GET dronescanner.herokuapp.com/violations

### Getting started
To run the project locally, you need to have Java 17 and Gradle.

First you have to clone the repository and then

    ./gradlew bootRun

The application should now be running at [localhost:8080/](http://localhost:8080/)