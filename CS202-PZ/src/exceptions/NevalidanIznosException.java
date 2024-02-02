/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author aleks
 */
public class NevalidanIznosException extends Exception{

    /**
     * Creates a new instance of <code>NevalidanIznosException</code> without
     * detail message.
     */
    public NevalidanIznosException() {
    }

    /**
     * Constructs an instance of <code>NevalidanIznosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NevalidanIznosException(String msg) {
        super(msg);
    }
}
