/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author udesc
 */
public class ZeroEnteredException extends InputException{
    private static final String ZERO_EXCEPTION = "Zero não possui fatorial";
    
    /**
     * Construtor da classe
     */
    public ZeroEnteredException() {
        super(ZERO_EXCEPTION);
    }
}
