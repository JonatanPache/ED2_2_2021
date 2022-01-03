/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package GRAFOSNOPESADOS;

/**
 *
 * @author Jonathan
 */
public class ExcepcionAristaYaExiste extends Exception{

    /**
     * Creates a new instance of <code>ExcepcionAristaYaExiste</code> without
     * detail message.
     */
    public ExcepcionAristaYaExiste() {
        super("Arista existe");
    }

    /**
     * Constructs an instance of <code>ExcepcionAristaYaExiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionAristaYaExiste(String msg) {
        super(msg);
    }
}
