package com.company;

public class U2 extends Rocket {

    U2(){
        cost = 120;
        weight = 18000;
        cargoLimit = 11000;
        cargoCarried = 0;
        launchSuccess = false;
    }

    // Launch method will return true if the launch was a success
    public boolean launch() {

        // Creating a random number between 1-100
        int randomNumber = (int) (Math.random() * 100) + 1;
        double chanceOfExploding = 4.00 * (this.cargoCarried / this.cargoLimit);

        // If random number is lower than the chances of exploding, it will fail
        if(randomNumber < chanceOfExploding){
            // If it exploded, return false
            return false;
        } else {
            this.launchSuccess = true;
            return true;
        }
    }

    // Landing method will return true if the landing was a success
    public boolean land() {

        // Creating a random number between 1-100
        int randomNumber = (int) (Math.random() * 100) + 1;
        double chanceOfCrashing = 8.00 * ((double) this.cargoCarried / (double) this.cargoLimit);

        // If random number is lower than the chances of crashing, it will fail
        if(randomNumber < chanceOfCrashing){
            // If it crashed, prepare for a new launch
            launchSuccess = false;
            return false;
        } else {
            return true;
        }
    }
}