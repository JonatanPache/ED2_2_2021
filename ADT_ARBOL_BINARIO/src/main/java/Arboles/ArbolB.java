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
public class ArbolB<K extends Comparable<K>,V> extends ArbolMViasBusqueda{
    private int nroMaximoDeDatos;
    private int nroMinimoDeDatos;
    private int nroMinimoDeHijos;
    
    public ArbolB(){
        super();
        this.nroMaximoDeDatos=2;
        this.nroMinimoDeHijos=2;
        this.nroMinimoDeDatos=1;
    }
    
    public ArbolB(int orden) throws ExceptionOrdenNoValido{
        super(orden);
        this.nroMaximoDeDatos=this.orden-1;
        this.nroMinimoDeDatos=this.nroMaximoDeDatos/2;
        this.nroMinimoDeHijos=this.nroMinimoDeDatos+1;
    }
    
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException {
        if (claveAInsertar==NodoMVias.datoVacio()){
            throw new NullPointerException("No se permite datos nulos");
        }
        if (valorAInsertar==NodoMVias.nodoVacio()){
            throw new NullPointerException("No se permite datos nulos");
        }
        //arbol vacio
        if(this.esArbolVacio()){
            this.raiz=new NodoMVias<>(this.orden,claveAInsertar,valorAInsertar);
            return;
        }
        Stack <NodoMVias<K,V>> pilaDePadres=new Stack<>();
        NodoMVias<K,V> nodoActual=this.raiz;
        while(!NodoMVias.esnodoVacio(nodoActual)){
            int posicionClaveInsertar=this.getPosicionDeClave(nodoActual,claveAInsertar);
            if(posicionClaveInsertar!=ArbolMViasBusqueda.POSICION_NO_VALIDA){
                nodoActual.setValor(posicionClaveInsertar, valorAInsertar);
                return;
            }
            if(nodoActual.esHoja()){
                insertarClaveyValor(nodoActual, claveAInsertar, valorAInsertar);
                if(nodoActual.cantidadDeClavesNoVacios()>this.nroMaximoDeDatos){
                    this.dividir(nodoActual,pilaDePadres);
                }
                return;
            }
            int posicionPorDondeBajar=this.getPosicionPorDondeBajar(nodoActual, claveAInsertar);
            pilaDePadres.push(nodoActual);
            nodoActual=nodoActual.getHijo(posicionPorDondeBajar);
        }
        
    }
    
    private void dividir(NodoMVias<K,V> nodoActual,Stack <NodoMVias<K,V>> pilaDeAncestros){
        int posicionClaveNuevoPadre=(this.orden/2)-1;
        NodoMVias<K,V> nodoPadre=new NodoMVias<>(this.orden);
        if(pilaDeAncestros.isEmpty()){
            nodoPadre=new NodoMVias<>(this.orden,nodoActual.getClave(posicionClaveNuevoPadre),nodoActual.getValor(posicionClaveNuevoPadre));
        }else{
            nodoPadre=pilaDeAncestros.pop();
            insertarClaveyValor(nodoPadre,nodoActual.getClave(posicionClaveNuevoPadre),nodoActual.getValor(posicionClaveNuevoPadre));
        }
        NodoMVias<K,V> nodoAnt=new NodoMVias<>(this.orden);
        NodoMVias<K,V> nodoSuc=new NodoMVias<>(this.orden);
        for(int i=posicionClaveNuevoPadre-1;i>=0;i--){
            insertarClaveyValor(nodoAnt,nodoActual.getClave(i),nodoActual.getValor(i));
        }
        for(int i=posicionClaveNuevoPadre+1;i<this.orden;i++){
            insertarClaveyValor(nodoSuc,nodoActual.getClave(i),nodoActual.getValor(i));
        }
        this.raiz=nodoPadre;
        //int posicionEleNuevoPadre=this.getPosicionDeClave(nodoPadre,nodoActual.getClave(posicionClaveNuevoPadre));
        nodoPadre.setHijo(0, nodoAnt);
        nodoPadre.setHijo(1, nodoSuc);
        /*if(nodoPadre.cantidadDeClavesNoVacios()>this.nroMaximoDeDatos){
            this.dividir(nodoPadre, pilaDeAncestros);
        }*/
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
}
