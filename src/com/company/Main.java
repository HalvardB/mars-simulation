package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        try {

            // Phase 1 - U1 rockets
            System.out.println("Preparing U1 simulation..");
            Simulation simulation = new Simulation();
            ArrayList itemArray = simulation.loadItems("phase-1.txt");
            ArrayList u1RocketsPhase1 = simulation.loadU1(itemArray);
            int u1Budget = simulation.runSimulation(u1RocketsPhase1);
            System.out.println("Total budget for U1 rockets in phase 1 was: " + u1Budget);

            // Phase 2 - U1 rockets
            itemArray = simulation.loadItems("phase-2.txt");
            ArrayList u1RocketsPhase2 = simulation.loadU1(itemArray);
            int u1Budget2 = simulation.runSimulation(u1RocketsPhase2);
            System.out.println("Total budget for U1 rockets in phase 2 was: " + u1Budget2);

            // Phase 1 - U2 rockets
            System.out.println("Preparing U2 simulation..");
            itemArray = simulation.loadItems("phase-1.txt");
            ArrayList u2RocketsPhase1 = simulation.loadU2(itemArray);
            int u2Budget = simulation.runSimulation(u2RocketsPhase1);
            System.out.println("Total budget for U2 rockets in phase 1 was: " + u2Budget);

            // Phase 2 - U2 rockets
            itemArray = simulation.loadItems("phase-2.txt");
            ArrayList u2RocketsPhase2 = simulation.loadU2(itemArray);
            int u2Budget2 = simulation.runSimulation(u2RocketsPhase2);
            System.out.println("Total budget for U2 rockets in phase 2 was: " + u2Budget2);

            // Summary
            System.out.println("Summary: ");
            System.out.println("Total budget for U1 rockets was: " + (u1Budget + u1Budget2) + " million.");
            System.out.println("Total budget for U2 rockets was: " + (u2Budget + u2Budget2) + " million.");

        } catch (Exception exception) {
            System.out.println("Error: " + exception);
        }
    }
}
