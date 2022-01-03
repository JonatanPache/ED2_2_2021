/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GRAFOSNOPESADOS;

/**
 *
 * @author Jonathan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws GRAFOSNOPESADOS.ExcepcionNumVertNoValido
     * @throws GRAFOSNOPESADOS.ExcepcionAristaYaExiste
     */
    public static void main(String[] args) throws ExcepcionNumVertNoValido, ExcepcionAristaYaExiste {
        // TODO code application logic here
        Grafo gf1=new Grafo(6);
        gf1.insertarArista(0, 2);
        gf1.insertarArista(0, 4);
        gf1.insertarArista(0, 5);
        gf1.insertarArista(1, 3);
        gf1.insertarArista(1, 4);
        gf1.insertarArista(2, 0);
        gf1.insertarArista(2, 5);
        gf1.insertarArista(3, 1);
        gf1.insertarArista(3, 3);
        gf1.insertarArista(4, 0);
        gf1.insertarArista(4, 1);
        gf1.insertarArista(5, 0);
        gf1.insertarArista(5, 2);
        gf1.insertarArista(5, 5);
        System.out.println(gf1);
    }
    
}
