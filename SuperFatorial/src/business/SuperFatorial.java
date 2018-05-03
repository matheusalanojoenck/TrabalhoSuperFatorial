/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exceptions.InputException;
import java.math.BigInteger;

/**
 * Implementação do super fatorial
 * @author udesc
 */
public class SuperFatorial implements ISuperFatorial{
    @Override
    public BigInteger getSuperFatorial(int numero) throws InputException{
        BigInteger superFatorial = BigInteger.ONE;
        for(int i = 1; i <= numero; i++){
            superFatorial = superFatorial.multiply(getFatoria(i));
        }
        return superFatorial;
    }
    
    protected BigInteger getFatoria( int numero ){
        BigInteger fatorial = BigInteger.ONE;
        for(int i = 1; i <= numero; i++){
            fatorial = fatorial.multiply(BigInteger.valueOf(i));       
        }
        return fatorial;
    }

}
