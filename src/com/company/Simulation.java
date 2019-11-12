package com.company;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // Creating an arraylist from a file with a list of items
    public ArrayList <Item> loadItems(String fileName) throws Exception{
        ArrayList <Item> itemList = new ArrayList();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Looping through the file each row at the time
            while (scanner.hasNextLine()) {
                String currentItem = scanner.nextLine();

                // Extract name and weight from file
                int index = currentItem.indexOf("=");
                String itemName = currentItem.substring(0, index);
                String itemWeight = currentItem.substring(index + 1);

                // Populating item and adding to item list
                Item item = new Item();
                item.weight = Integer.parseInt(itemWeight);
                item.name = itemName;
                itemList.add(item);

            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
        }
        return itemList;
    }

    // Creating an arraylist of U1 rockets
    public ArrayList loadU1(ArrayList <Item> items){
        U1 currentRocket = new U1();
        ArrayList <U1> u1Rockets = new ArrayList();

        // Looping through all items and adding them to a rocket
        for(int i = 0; i < items.size() -1; i++){
            if(currentRocket.canCarry(items.get(i))){
                currentRocket.carry(items.get(i));
            } else {

                // If the rocket is full -> not enought cargo space left
                // Add the rocket to the array and create a new rocket
                u1Rockets.add(currentRocket);
                currentRocket = new U1();
                currentRocket.carry(items.get(i));
            }
        }

        // Adding the last rocket to the array
        u1Rockets.add(currentRocket);
        return u1Rockets;
    }

    // Creating an arraylist of U2 rockets
    public ArrayList loadU2(ArrayList <Item> items){
        U2 currentRocket = new U2();
        ArrayList u2Rockets = new ArrayList();

        // Looping through all items and adding them to a rocket
        for(int i = 0; i < items.size() -1; i++){
            if(currentRocket.canCarry(items.get(i))){
                currentRocket.carry(items.get(i));
            } else {

                // If the rocket is full -> not enought cargo space left
                // Add the rocket to the array and create a new rocket
                u2Rockets.add(currentRocket);
                currentRocket = new U2();
                currentRocket.carry(items.get(i));
            }
        }

        // Adding the last rocket to the array
        u2Rockets.add(currentRocket);
        return u2Rockets;
    }

    // Simulate launching and landing of each rocket
    public int runSimulation(ArrayList rockets){
        int budget = 0;

        // Loop through each rocket in the arraylist
        for(int i = 0; i < rockets.size(); i++){
            Rocket currentRocket = (Rocket) rockets.get(i);

            // Launch a new rocket until launch is a success
            while(!currentRocket.launchSuccess){
                budget += currentRocket.cost;

                if(!currentRocket.launch()){
                    // Go back and launch the same rocket again
                    i--;
                    break;

                // If the launch was a success, see if the landing is a success
                } else {

                    // If the landing was not a success
                    if(!currentRocket.land()){
                        // Go back and launch the same rocket again
                        i--;
                        break;
                    }
                }
            }
        }
        return budget;
    }
}
