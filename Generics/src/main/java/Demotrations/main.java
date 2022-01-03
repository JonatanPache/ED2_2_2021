/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Demotrations;

/**
 *
 * @author Jonathan
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Instanciar integer
        Test<Integer> iObj=new Test<Integer>(15);
        System.out.println(iObj.getObj());
        //Instanciando String
        Test<String> sObj=new Test<String>("Hola soy Jonatan ");
        System.out.println(sObj.getObj());
    }
    
}
