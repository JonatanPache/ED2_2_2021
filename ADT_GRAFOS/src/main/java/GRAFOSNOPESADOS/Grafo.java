/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GRAFOSNOPESADOS;

import java.util.*;

/**
 *
 * @author Jonathan
 */
public class Grafo {
    protected List<List<Integer>> listaDeAdyacencia;
    
    public Grafo(){
        this.listaDeAdyacencia=new LinkedList<>();
    }
    
    public Grafo(int nroVert) throws ExcepcionNumVertNoValido{
        if(nroVert<=0){
            throw new ExcepcionNumVertNoValido();
        }
        this.listaDeAdyacencia=new LinkedList<>();
        for (int i=0;i<nroVert;i++){
            this.insertarVertice();
        }
    }
    
    public void insertarVertice(){
        List<Integer> adyacenciaVerticeAInsertar=new LinkedList<>();
        this.listaDeAdyacencia.add(adyacenciaVerticeAInsertar);
    }
    
    public int cantidadVertice(){
        return listaDeAdyacencia.size();
    }
    
    public int gradoVertice(int posVertice){
        validarVertice(posVertice);
        List<Integer> adyacenciaVerticeAInsertar=this.listaDeAdyacencia.get(posVertice);
        return adyacenciaVerticeAInsertar.size();
    }
    
    public void validarVertice(int posVertice){
        if(posVertice<0 || posVertice>=this.cantidadVertice()){
            throw new IllegalArgumentException("No existe tal vertice en el grafo");
        }    
    }
    
    public void insertarArista(int posVerticeOrigen,int posVerticeDestino) throws ExcepcionAristaYaExiste{
        if(this.existeAdyacencia(posVerticeDestino, posVerticeDestino)){
            throw new ExcepcionAristaYaExiste();
        }
        List<Integer> adyacentesdelVerticeOrigen=this.listaDeAdyacencia.get(posVerticeOrigen);
        adyacentesdelVerticeOrigen.add(posVerticeDestino);
        Collections.sort(adyacentesdelVerticeOrigen);
        if(posVerticeOrigen!=posVerticeDestino){
            List<Integer> adyacentesdelVerticeDestino=this.listaDeAdyacencia.get(posVerticeDestino);
            adyacentesdelVerticeDestino.add(posVerticeOrigen);
            Collections.sort(adyacentesdelVerticeDestino);
        }
    }
    
    public boolean existeAdyacencia(int posVerticeOrigen,int posVerticeDestino){
        validarVertice(posVerticeOrigen);
        validarVertice(posVerticeDestino);
        List<Integer> adyacenciaVerticeOrigen=this.listaDeAdyacencia.get(posVerticeOrigen);
        return adyacenciaVerticeOrigen.contains(posVerticeDestino);
    }
    
    public Iterable<Integer> adyacentesdeVertice(int posVertice){
        validarVertice(posVertice);
        List<Integer> adyacentesDelVertice=this.listaDeAdyacencia.get(posVertice);
        Iterable<Integer> IterableAdyacentesDeVertice=adyacentesDelVertice;
        return IterableAdyacentesDeVertice;
    }
    
    public int cantidadAristas(){
        int cantDist=0;
        int lazos=0;
        List<Integer> adyacenciaVerticeIte;
        for(int i=0;i<listaDeAdyacencia.size();i++){
            adyacenciaVerticeIte=this.listaDeAdyacencia.get(i);
            for(int j=0;j<adyacenciaVerticeIte.size();j++){
                if(i!=adyacenciaVerticeIte.get(j)){
                    cantDist++;
                }else{
                    lazos++;
                }
            }
        }
        return (cantDist/2)+lazos;
    }
    public void eliminarVertice(int posVertAEliminar){
        validarVertice(posVertAEliminar);
        this.listaDeAdyacencia.remove(posVertAEliminar);
        
    }

    @Override
    public String toString() {
        String S="";
        for(int i=0;i<this.listaDeAdyacencia.size();i++){
            List<Integer> adyVert=this.listaDeAdyacencia.get(i);
            S=S+i+": ";
            String C="";
            for(int j=0;j<adyVert.size();j++){
                C=C+adyVert.get(j)+", ";
            }
            S=S+C+"\n";
        }
        return S;
    }
    
    
}
