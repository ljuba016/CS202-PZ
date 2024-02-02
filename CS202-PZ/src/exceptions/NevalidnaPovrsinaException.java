/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author aleks
 */
public class NevalidnaPovrsinaException extends Exception{

    /**
     * Creates a new instance of <code>NevalidnaPovrsinaException</code> without
     * detail message.
     */
    public NevalidnaPovrsinaException() {
    }

    /**
     * Constructs an instance of <code>NevalidnaPovrsinaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NevalidnaPovrsinaException(String msg) {
        super(msg);
    }
}
