/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author aleks
 */
public class NevalidanDatumException extends Exception{

    /**
     * Creates a new instance of <code>NevalidanDatumException</code> without
     * detail message.
     */
    public NevalidanDatumException() {
    }

    /**
     * Constructs an instance of <code>NevalidanDatumException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NevalidanDatumException(String msg) {
        super(msg);
    }
}
