/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package GRAFOSNOPESADOS;

/**
 *
 * @author Jonathan
 */
public class ExcepcionNumVertNoValido extends Exception{

    /**
     * Creates a new instance of <code>ExcepcionNumVertNoValido</code> without
     * detail message.
     */
    public ExcepcionNumVertNoValido() {
        super("clave no existe");
    }

    /**
     * Constructs an instance of <code>ExcepcionNumVertNoValido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionNumVertNoValido(String msg) {
        super(msg);
    }
}
