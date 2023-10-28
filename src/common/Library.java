/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.GarbageStation;

/**
 *
 * @author DAO
 */
public class Library {
    private int[] garbageAtStations;
    private GarbageStation gs;
    private int costPerHour = 120000;
    private int dumpCost = 57000;
    private ArrayList<GarbageStation> garbageStations ;
    public Library(){
        garbageStations = new ArrayList<>();
        gs = new GarbageStation();
    }
        public int calculateCost() {
        int total = 0;
        double time = 0.0; // Time in hours
        int cost ;
        int truckCapacity = 10000; // 10 tons in kg
        int count = 0;
        
        for (int garbage : garbageAtStations) {
            time += 8.0 / 60.0; // Convert minutes to hours

            if (total + garbage >= truckCapacity) {
                total = 0;
                time += 30.0 / 60.0; // Convert minutes to hours for the return trip
                count++;
            }
            total=total+garbage;
        }

        // If there's remaining garbage, return to the station and calculate additional cost
        if (total > 0) {
            time += 30.0 / 60.0; // Convert minutes to hours
            count++;
        }

        // Add the dump cost
        cost = count*dumpCost + (int)(time * costPerHour);
        // Round the cost to the nearest 10
        cost = Math.round((cost + 5) / 10) * 10;
        return cost;
    }
    public void inputGarbageAtStations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of garbage at each station (in kg) separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        garbageAtStations = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            garbageAtStations[i] = Integer.parseInt(input[i]);
            gs.setAmount(garbageAtStations[i]);
            garbageStations.add(gs);
        }
    } 
    
    public void displayCost() {
        int cost=calculateCost();
        System.out.println("The total cost is " + cost + " VND");
    }
}

