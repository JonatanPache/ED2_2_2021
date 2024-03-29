/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Arboles;

/**
 *
 * @author Jonathan
 */
public class ExceptionClaveNoExiste extends Exception{

    /**
     * Creates a new instance of <code>ExceptionClaveNoExiste</code> without
     * detail message.
     */
    public ExceptionClaveNoExiste() {
        super("clave no existe");
    }

    /**
     * Constructs an instance of <code>ExceptionClaveNoExiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionClaveNoExiste(String msg) {
        super(msg);
    }
}
