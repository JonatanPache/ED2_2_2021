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
public class ArbolBinarioBusqueda<K extends Comparable<K>,V> implements IArbolBusqueda<K,V>{
    
    protected NodoBinario<K,V> raiz;
    
    @Override
    public void Insertar(K claveaInsertar, V valoraInsertar) throws NullPointerException{
        if (claveaInsertar==null){
            throw new NullPointerException("No se permite datos nulos");
        }
        if (valoraInsertar==null){
            throw new NullPointerException("No se permite datos nulos");
        }
        //arbol vacio
        if(this.esArbolVacio()){
            this.raiz=new NodoBinario<>(claveaInsertar,valoraInsertar);
        }
        NodoBinario<K,V> nodoAnterior=NodoBinario.nodoVacio();
        NodoBinario<K,V> nodoActual=this.raiz;
        while(!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual=nodoActual.getClave();
            nodoAnterior=nodoActual;
            if(claveaInsertar.compareTo(claveActual)<0){
                nodoActual=nodoActual.getHijoIzquierdo();
            }else if(claveaInsertar.compareTo(claveActual)>0){
                nodoActual=nodoActual.getHijoDerecho();
            }else{
                nodoActual.setValor(valoraInsertar);
                return;
            }
        }
        K claveAnterior=nodoAnterior.getClave();
        NodoBinario<K,V> nuevoNodo=new NodoBinario<>(claveaInsertar,valoraInsertar);
        if(claveaInsertar.compareTo(claveAnterior)<0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else{
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }
    }

    @Override
    public V eliminar(K claveaEliminar) throws ExceptionClaveNoExiste {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V buscar(K claveabuscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contiene(K claveabuscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return sizeRec(this.raiz);
    }
    
    private int sizeRec(NodoBinario<K,V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int sizeporIzquierda=sizeRec(nodoActual.getHijoIzquierdo());
        int sizeporDerecha=sizeRec(nodoActual.getHijoDerecho());
        return sizeporIzquierda+sizeporDerecha+1;
    }

    @Override
    public int altura() {
        return alturaIterativo();
    }
    
    protected int altura(NodoBinario<K,V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int alturaPorIzquierda=altura(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha=altura(nodoActual.getHijoDerecho());
        return alturaPorIzquierda>alturaPorDerecha?
                alturaPorIzquierda+1:
                alturaPorDerecha+1;
    } 
        
    public int alturaIterativo(){
        int alturaArbol=0;
        if(!this.esArbolVacio()){
            Queue <NodoBinario<K,V>> coladeNodos= new LinkedList<>();
            coladeNodos.offer(this.raiz);
            while(!coladeNodos.isEmpty()){
                int nroNodosDeNivel=coladeNodos.size();
                int contador=0;
                while(contador<nroNodosDeNivel){
                    NodoBinario<K,V> nodoActual=coladeNodos.poll();
                    if(!nodoActual.esVacioHijoIzquierdo()){
                        coladeNodos.offer(nodoActual.getHijoIzquierdo());
                    }
                    if(!nodoActual.esVacioHijoDerecho()){
                        coladeNodos.offer(nodoActual.getHijoDerecho());
                    }
                    contador++;
                }
                alturaArbol++;
            }
        }
        return alturaArbol;
    }

    @Override
    public void vaciar() {
        this.raiz=NodoBinario.nodoVacio();
    }
    
    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido=new ArrayList<>();
        if(!this.esArbolVacio()){
            Queue <NodoBinario<K,V>> coladeNodos=new LinkedList<>();
            coladeNodos.offer(this.raiz);
            while(!coladeNodos.isEmpty()){
                NodoBinario<K,V> nodoActual=coladeNodos.poll();
                recorrido.add(nodoActual.getClave());
                if(!nodoActual.esVacioHijoIzquierdo()){
                    coladeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if(!nodoActual.esVacioHijoDerecho()){
                    coladeNodos.offer(nodoActual.getHijoDerecho());
                }
            }           
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoPorPreorden() {
        List<K> recorrido=new ArrayList<>();
        if(!this.esArbolVacio()){
            Stack <NodoBinario<K,V>> piladeNodos=new Stack<>();
            piladeNodos.push(this.raiz);
            while(!piladeNodos.isEmpty()){
                NodoBinario<K,V> nodoActual=piladeNodos.pop();
                recorrido.add(nodoActual.getClave());
                if(!nodoActual.esVacioHijoIzquierdo()){
                    piladeNodos.push(nodoActual.getHijoIzquierdo());
                }
                if(!nodoActual.esVacioHijoDerecho()){
                    piladeNodos.push(nodoActual.getHijoDerecho());
                }
            }           
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoPorInorden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoPorPostorden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
