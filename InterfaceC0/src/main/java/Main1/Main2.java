/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main1;

import Code.Bike;

/**
 *
 * @author Jonathan
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bike bike = new Bike();
        bike.cambiarAño(1999);
        bike.speedUp(4);
        bike.applyBrake(3);
        System.out.println("Bike present state :");
        bike.printState();
    }
    
}
