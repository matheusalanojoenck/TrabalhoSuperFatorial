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
public class NegativeValueEnteredException extends InputException{
    private static final String NEGATIVE_EXCEPTION = "Número negativo não possui fatorial";
    
    /**
     * 
     */
    public NegativeValueEnteredException() {
        super(NEGATIVE_EXCEPTION);
    }
}
