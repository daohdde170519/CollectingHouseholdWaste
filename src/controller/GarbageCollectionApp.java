/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import common.Library;
import view.Menu;

/**
 *
 * @author DAO
 */

public class GarbageCollectionApp extends Menu<String>{
    Library lb;
    static String[] options = {"Input", "Print", "Exit"};
    public GarbageCollectionApp() {
        super("===== COLLECTING GARBAGE MANAGEMENT =====", options);
        lb = new Library();
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1 -> lb.inputGarbageAtStations();
            case 2 -> lb.displayCost();
            case 3 -> System.exit(0);
        }
    }
  
}
//class GarbageView {

//

//}
//
//
//public class GarbageCollectionApp {
//    public static void main(String[] args) {
//        GarbageModel model = new GarbageModel(new int[0]);
//        GarbageView view = new GarbageView();
//        GarbageController controller = new GarbageController(model, view);
//
//        controller.estimateCost();
//    }
//}








