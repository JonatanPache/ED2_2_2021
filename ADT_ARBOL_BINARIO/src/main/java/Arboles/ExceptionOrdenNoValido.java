/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Arboles;

/**
 *
 * @author Jonathan
 */
public class ExceptionOrdenNoValido extends Exception{

    /**
     * Creates a new instance of <code>ExceptionOrdenNoValido</code> without
     * detail message.
     */
    public ExceptionOrdenNoValido() {
        super("ORDEN NO VALIDO");
    }

    /**
     * Constructs an instance of <code>ExceptionOrdenNoValido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionOrdenNoValido(String msg) {
        super(msg);
    }
}
