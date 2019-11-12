package com.company;

public class Rocket implements SpaceShip{
    int cost;
    int weight;
    int cargoLimit;
    int cargoCarried;
    boolean launchSuccess;

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    // If the item weight is lower than empty cargo space, then return true
    public boolean canCarry(Item item){
        if(item.weight <= (this.cargoLimit - this.cargoCarried)){
            return true;
        } else {
            return false;
        }
    }

    // Method to add new items to cargoCarried
    public void carry(Item item){
        this.cargoCarried += item.weight;
    }
}