/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author aleks
 */
public class NevalidanNazivException extends Exception{

    /**
     * Creates a new instance of <code>NevalidanNazivException</code> without
     * detail message.
     */
    public NevalidanNazivException() {
    }

    /**
     * Constructs an instance of <code>NevalidanNazivException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NevalidanNazivException(String msg) {
        super(msg);
    }
}
