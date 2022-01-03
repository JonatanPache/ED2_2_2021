/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Demotrations;

/**
 *
 * @author Jonathan
 * Simple´programa que muestrar el uso
 * de interface
 */
public class Test<T> {
    T obj;
    /*Constructor*/
    Test (T obj){
        this.obj=obj;
    }
    public T getObj(){
        return this.obj;
    }
}

