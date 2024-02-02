/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author aleks
 */
public class NevalidanTelefonException extends Exception{

    /**
     * Creates a new instance of <code>NevalidanTelefonException</code> without
     * detail message.
     */
    public NevalidanTelefonException() {
    }

    /**
     * Constructs an instance of <code>NevalidanTelefonException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NevalidanTelefonException(String msg) {
        super(msg);
    }
}
