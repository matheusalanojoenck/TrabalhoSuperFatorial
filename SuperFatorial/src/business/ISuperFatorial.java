/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exceptions.InputException;
import java.math.BigInteger;

/**
 *
 * @author udesc
 */
public interface ISuperFatorial {
    
    /**
    * Recebe o fatorial do número e retorna o superfatorial dele
    * @param numero para o qual calcularemos o superfatorial
    * @return super fatorial
    * @throws InputException indicando que o valor digitado é inválido
    */
    public BigInteger getSuperFatorial(int numero) throws InputException;

}
