/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import java.util.*;

/**
 *
 * @author Jonathan
 */
public class NodoMVias<K,V> {
    private List<K> listadeClaves;
    private List<V> listadeValores;
    private List<NodoMVias<K,V>> listadeHijos;
    
    public NodoMVias(int orden){
        listadeClaves=new LinkedList<>();
        listadeValores=new LinkedList<>();
        listadeHijos=new LinkedList<>();
        for(int i=0;i<orden-1;i++){
            listadeClaves.add(null);
            listadeValores.add(null);
            listadeHijos.add(null);
        }
        listadeHijos.add(null);
    }
    
    public NodoMVias(int orden,K primerClave,V primerValor){
        this(orden); //llama al primer constructor enviando su respectivo parametro
        this.listadeClaves.set(0,primerClave);
        this.listadeValores.set(0,primerValor);
    }
    
    public static NodoMVias nodoVacio(){
        return null;
    }
    
    public static boolean esnodoVacio(NodoMVias nodo){
        return nodo==NodoMVias.nodoVacio();
    }
    
    public static Object datoVacio(){
        return null;
    }

    public K getClave(int posicion) {
        return this.listadeClaves.get(posicion);
    }

    public void setClave(int posicion,K clave) {
        this.listadeClaves.set(posicion, clave);
    }

    public V getValor(int posicion) {
        return this.listadeValores.get(posicion);
    }

    public void setValor(int posicion,V valor) {
        this.listadeValores.set(posicion, valor);
    }

    public NodoMVias<K, V> getHijo(int posicion) {
        return this.listadeHijos.get(posicion);
    }

    public void setHijo(int posicion,NodoMVias<K,V> nodoHijo) {
        this.listadeHijos.set(posicion, nodoHijo);
    }
    
    public boolean esClaveVacio(int posicion){
        return this.listadeClaves.get(posicion)==NodoMVias.datoVacio();
    }
    
    public boolean esHijoVacio(int posicion){
        return NodoMVias.esnodoVacio(this.listadeHijos.get(posicion));
    }
    
    public boolean esHoja(){
        for(int i=0;i<this.listadeHijos.size();i++){
            if(!this.esHijoVacio(i)){
                return false;
            }
        }
        return true;
    }
    
    public boolean estanClavesLLenas(){
        for(int i=0;i<this.listadeClaves.size();i++){
            if(this.esClaveVacio(i)){
                return false;
            }
        }
        return true;
    }
    public int cantidadDeHijosNoVacios(){
        int cant=0;
        for(int i=0;i<this.listadeHijos.size();i++){
            if(!this.esHijoVacio(i)){
                cant++;
            }
        }
        return cant;
    }
    
    public int cantidadDeClavesNoVacios(){
        int cant=0;
        for(int i=0;i<this.listadeClaves.size();i++){
            if(!this.esClaveVacio(i)){
                cant++;
            }
        }
        return cant;
    }
    
    public int cantidadDeHijosVacios(){
        return this.listadeHijos.size()-this.cantidadDeHijosNoVacios();
    }
}
