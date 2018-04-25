/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * Exceção gerada para quando os dados são entrados de forma errada
 * @author udesc
 */
public abstract class InputException extends Exception {
    /**
     * Mensagem do erro
     * @param msg
     */
    public InputException(String msg) {
        super(msg);
    }
}
