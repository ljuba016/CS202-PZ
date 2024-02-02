/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author aleks
 */
public class NevalidanBrojGodinaException extends Exception{

    /**
     * Creates a new instance of <code>NevalidanBrojGodinaException</code>
     * without detail message.
     */
    public NevalidanBrojGodinaException() {
    }

    /**
     * Constructs an instance of <code>NevalidanBrojGodinaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NevalidanBrojGodinaException(String msg) {
        super(msg);
    }
}
