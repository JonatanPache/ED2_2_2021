/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Arboles;

/**
 *
 * @author Jonathan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionOrdenNoValido {
        // TODO code application logic here
        /*IArbolBusqueda<Integer,String> arbol= new ArbolBinarioBusqueda<>();
        
        arbol.Insertar(20, "JUAN");
        arbol.Insertar(30, "JUANA");
        arbol.Insertar(10, "HERIBERTO");
        arbol.Insertar(5, "HERIBERTO peres");
        arbol.Insertar(15, "HERIBERTO");
        System.out.println(arbol);
        System.out.println("RECORRIDO INORDEN: "+arbol.recorridoPorNiveles());
        System.out.println("RECORRIDO PREORDEN: "+arbol.recorridoPorPreorden());
        System.out.println("SIZE : "+arbol.size());
        //System.out.println("ALTURA RECURSIVO: " +arbol.altura());
        System.out.println("ALTURA ITERATIVO: " +arbol.altura());*/
        //testeando NODOMVIAS
        /*NodoMVias<Integer,String> nuevoNodo=new NodoMVias<>(4);
        nuevoNodo.setClave(0, 5);
        nuevoNodo.setValor(0, "juancho");
        System.out.println(nuevoNodo.cantidadDeClavesNoVacios());*/
        
        IArbolBusqueda<Integer,String> arbolm = new ArbolMViasBusqueda<>();
        arbolm.Insertar(40, "comido");
        arbolm.Insertar(70, "comido");
        arbolm.Insertar(30, "comido");
        arbolm.Insertar(8, "comido");
        arbolm.Insertar(10, "comido");
        arbolm.Insertar(20, "comido");
        arbolm.Insertar(9, "comido");
        arbolm.Insertar(100, "comido");
        System.out.println("RECORRIDO POR INORDEN: "+ arbolm.recorridoPorInorden());
        System.out.println("RECORRIDO POR POSTORDEN: "+ arbolm.recorridoPorPostorden());
        System.out.println("RECORRIDO POR NIVELES: "+ arbolm.recorridoPorNiveles());
        System.out.println("RECORRIDO POR PREORDEN: "+ arbolm.recorridoPorPreorden());
        System.out.println("CONTIENE 80? : "+ arbolm.contiene(80));
        System.out.println("Altura : "+ arbolm.altura());
        System.out.println("HOJAS : "+ arbolm.cantHojas());
          
        /*IArbolBusqueda<Integer,String> arbolB = new ArbolB<>(4);
        arbolB.Insertar(90, "comido");
        arbolB.Insertar(100, "comido");
        arbolB.Insertar(120, "comido");
        arbolB.Insertar(50, "comido");
        arbolB.Insertar(200, "comido");
        arbolB.Insertar(300, "comido");
        System.out.println("RECORRIDO POR NIVELES: "+ arbolB.recorridoPorNiveles());
        System.out.println("RECORRIDO POR INORDEN: "+ arbolB.recorridoPorInorden());
        System.out.println("Altura : "+ arbolB.altura());*/
        
    }
    
}
