/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import java.util.*;

/**
 *
 * @author Jonathan
 * @param <K>
 * @param <V>
 */
public class ArbolMViasBusqueda <K extends Comparable<K>,V> implements IArbolBusqueda<K,V>{
    protected NodoMVias<K,V> raiz;
    protected int orden;
    protected static final int POSICION_NO_VALIDA=-1;
    protected static final int ORDEN_MINIMO=4;
    
    public ArbolMViasBusqueda(){
        this.orden=ArbolMViasBusqueda.ORDEN_MINIMO;
    }
    
    public ArbolMViasBusqueda(int OrdenDelArbol) throws ExceptionOrdenNoValido{
        if(OrdenDelArbol<ArbolMViasBusqueda.ORDEN_MINIMO){
            throw new ExceptionOrdenNoValido();
        }
        this.orden=OrdenDelArbol;        
    }
    
    
    
    @Override
    public void Insertar(K claveaInsertar, V valoraInsertar) throws NullPointerException {
        if (claveaInsertar==null){
            throw new NullPointerException("No se permite datos nulos");
        }
        if (valoraInsertar==null){
            throw new NullPointerException("No se permite datos nulos");
        }
        //arbol vacio
        if(this.esArbolVacio()){
            this.raiz=new NodoMVias<>(this.orden,claveaInsertar,valoraInsertar);
            return;
        }
        NodoMVias<K,V> nodoActual=this.raiz;
        while(!NodoMVias.esnodoVacio(nodoActual)){
            int posicionClaveInsertar=this.getPosicionDeClave(nodoActual,claveaInsertar);
            if(posicionClaveInsertar!=ArbolMViasBusqueda.POSICION_NO_VALIDA){
                nodoActual.setValor(posicionClaveInsertar, valoraInsertar);
                return;
            }
            if(nodoActual.esHoja()){
                if(nodoActual.estanClavesLLenas()){
                    NodoMVias<K,V> nuevoHijo=new NodoMVias<>(this.orden,claveaInsertar,valoraInsertar);
                    int posiciondeEnlace=this.getPosicionPorDondeBajar(nodoActual,claveaInsertar);
                    nodoActual.setHijo(posiciondeEnlace, nuevoHijo);
                }else{
                    this.insertarClaveyValor(nodoActual, claveaInsertar, valoraInsertar);
                }
                return;
            }
            int posicionPorDondeBajar=this.getPosicionPorDondeBajar(nodoActual, claveaInsertar);
            if(nodoActual.esHijoVacio(posicionPorDondeBajar)){
                NodoMVias<K,V> nuevoHijo=new NodoMVias<>(this.orden,claveaInsertar,valoraInsertar);
                nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
                return;
            }
            nodoActual=nodoActual.getHijo(posicionPorDondeBajar);
        }
    }
    
    private void insertarClaveyValor(NodoMVias<K,V> nodoActual,K claveaInsertar,V valoraInsertar){
        int j=0;
        boolean sw=false;
        while(j<nodoActual.cantidadDeClavesNoVacios() && sw==false){
            K claveActual=nodoActual.getClave(j);
            if(claveaInsertar.compareTo(claveActual)<0){
                for(int i=nodoActual.cantidadDeClavesNoVacios();i>0 && i>j;i--){
                    nodoActual.setClave(i, nodoActual.getClave(i-1));
                    nodoActual.setValor(i, nodoActual.getValor(i-1));
                }
                nodoActual.setClave(j, claveaInsertar);
                nodoActual.setValor(j, valoraInsertar);
                sw=true;
            }
            j++;
        }
        if(sw==false){
            nodoActual.setClave(j, claveaInsertar);
            nodoActual.setValor(j, valoraInsertar);
        }
    }
    
    private int getPosicionPorDondeBajar(NodoMVias<K,V> nodoActual,K claveaBuscar){
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacios();i++){
            K claveActual=nodoActual.getClave(i);
            if(claveaBuscar.compareTo(claveActual)<0){
                return i;
            }
        }
        return this.orden-1;
    }
    
    private int getPosicionDeClave(NodoMVias<K,V> nodoActual,K claveaBuscar){
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacios();i++){
            K claveActual=nodoActual.getClave(i);
            if(claveaBuscar.compareTo(claveActual)==0){
                return i;
            }
        }
        return ArbolMViasBusqueda.POSICION_NO_VALIDA; 
    }
    @Override
    public V eliminar(K claveaEliminar) throws ExceptionClaveNoExiste {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int cantHojas() {
        int cant=0;
        if(!this.esArbolVacio()){
            Queue <NodoMVias<K,V>> coladeNodos=new LinkedList<>();
            coladeNodos.offer(this.raiz);
            while(!coladeNodos.isEmpty()){
                NodoMVias<K,V> nodoActual=coladeNodos.poll();
                if(nodoActual.esHoja()){
                        cant+=1;
                }  
                for(int i=0;i<nodoActual.cantidadDeClavesNoVacios();i++){  
                    if(!nodoActual.esHijoVacio(i)){
                        coladeNodos.offer(nodoActual.getHijo(i));
                    }
                }
                if(!nodoActual.esHijoVacio(orden-1)){
                    coladeNodos.offer(nodoActual.getHijo(orden-1));
                }
            }           
        }
        return cant;
    }
    
    @Override
    public V buscar(K claveabuscar) {
        if(claveabuscar==NodoMVias.datoVacio()){
            return (V)NodoMVias.datoVacio();
        }
        NodoMVias<K,V> nodoActual=this.raiz;
        while(!NodoMVias.esnodoVacio(nodoActual)){
            boolean hubocambiodeNodo=false;
            for(int i=0;i<nodoActual.cantidadDeClavesNoVacios() && !hubocambiodeNodo;i++){
                K claveActual=nodoActual.getClave(i);
                if(claveabuscar.compareTo(claveActual)==0){
                    return nodoActual.getValor(i);
                }
                if(claveabuscar.compareTo(claveActual)<0){
                    nodoActual=nodoActual.getHijo(i);
                    hubocambiodeNodo=true;
                }
            }
            if(!hubocambiodeNodo){
                nodoActual=nodoActual.getHijo(this.orden-1);
            }
            return (V)NodoMVias.datoVacio();
        }
        return (V)NodoMVias.datoVacio();
    }

    @Override
    public boolean contiene(K claveabuscar) {
        return this.buscar(claveabuscar)!=NodoMVias.datoVacio();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }
    
    private int altura(NodoMVias<K,V> nodoActual){
        if(NodoMVias.esnodoVacio(nodoActual)){
            return 0;
        }
        int alturaMayorDeHijos=0;
        for(int i=0;i<orden;i++){
            int alturaDeHijoEnTurno=altura(nodoActual.getHijo(i));
            if(alturaDeHijoEnTurno>alturaMayorDeHijos){
                alturaMayorDeHijos=alturaDeHijoEnTurno;
            }
        }
        return alturaMayorDeHijos+1;
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esArbolVacio() {
        return NodoMVias.esnodoVacio(this.raiz);
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido=new ArrayList<>();
        if(!this.esArbolVacio()){
            Queue <NodoMVias<K,V>> coladeNodos=new LinkedList<>();
            coladeNodos.offer(this.raiz);
            while(!coladeNodos.isEmpty()){
                NodoMVias<K,V> nodoActual=coladeNodos.poll();
                for(int i=0;i<nodoActual.cantidadDeClavesNoVacios();i++){
                    recorrido.add(nodoActual.getClave(i));
                    if(!nodoActual.esHijoVacio(i)){
                        coladeNodos.offer(nodoActual.getHijo(i));
                    }
                }
                if(!nodoActual.esHijoVacio(orden-1)){
                    coladeNodos.offer(nodoActual.getHijo(orden-1));
                }
            }           
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoPorPreorden() {
        List<K> recorrido=new ArrayList<>();
        this.recorridoPorPreorden(this.raiz,recorrido);
        return recorrido;
    }

    private void recorridoPorPreorden(NodoMVias<K,V> nodoActual,List<K> recorrido){
        if(NodoMVias.esnodoVacio(nodoActual)){
            return;
        }
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacios();i++){
            recorrido.add(nodoActual.getClave(i));
            recorridoPorPreorden(nodoActual.getHijo(i),recorrido);
        }    
        recorridoPorPreorden(nodoActual.getHijo(orden-1),recorrido);
    }
    

    @Override
    public List<K> recorridoPorInorden() {
        List<K> recorrido=new ArrayList<>();
        this.recorridoPorInorden(this.raiz,recorrido);
        return recorrido;
    }

    private void recorridoPorInorden(NodoMVias<K,V> nodoActual,List<K> recorrido){
        if(NodoMVias.esnodoVacio(nodoActual)){
            return;
        }
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacios();i++){
            recorridoPorInorden(nodoActual.getHijo(i),recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        recorridoPorInorden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacios()),recorrido);
    }
    @Override
    public List<K> recorridoPorPostorden() {
        List<K> recorrido=new ArrayList<>();
        this.recorridoPorPostorden(this.raiz,recorrido);
        return recorrido;
    }
    
    private void recorridoPorPostorden(NodoMVias<K,V> nodoActual,List<K> recorrido){
        if(NodoMVias.esnodoVacio(nodoActual)){
            return;
        }
        recorridoPorPostorden(nodoActual.getHijo(0),recorrido);
        for(int i=0;i<nodoActual.cantidadDeClavesNoVacios();i++){
            recorridoPorInorden(nodoActual.getHijo(i+1),recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
    }
    
}
