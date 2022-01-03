/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Arboles;

import java.util.List;

/**
 *
 * @author Jonathan
 * @param <K>
 * @param <V>
 */
public interface IArbolBusqueda <K extends Comparable <K>,V>{
    void Insertar(K claveaInsertar,V valoraInsertar) throws NullPointerException;
    V eliminar (K claveaEliminar) throws ExceptionClaveNoExiste;
    V buscar(K claveabuscar);
    boolean contiene(K claveabuscar);
    int size();
    int altura();
    int cantHojas();
    void vaciar();
    boolean esArbolVacio();
    List<K> recorridoPorNiveles();
    List<K> recorridoPorPreorden();
    List<K> recorridoPorInorden();
    List<K> recorridoPorPostorden();
}
