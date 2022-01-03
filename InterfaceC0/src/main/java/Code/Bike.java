/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;
import java.io.*;
import Code.Vehicle;
/**
 *
 * @author Jonathan
 */
public class Bike implements Vehicle {
    int speed;
    int gear;
    
    @Override
    public void cambiarAño(int newAge){
        gear=newAge;
    }
    
    @Override
    public void speedUp(int inc){
        speed+=inc;
    }
    @Override
    public void applyBrake(int dec){
        speed-=dec;
    }
    public void printState(){
        System.out.println("speed" +speed
                
                +"gear"+gear);
    }
}
