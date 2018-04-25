/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exceptions.InputException;
import exceptions.NegativeValueEnteredException;
import exceptions.ZeroEnteredException;
import java.math.BigInteger;

/**
 * Implementação do super fatorial
 * @author udesc
 */
public class SuperFatorial implements ISuperFatorial{

    @Override
    public BigInteger getSuperFatorial(int numero) throws InputException{
        if( numero == 0 ) 
            throw new ZeroEnteredException();
        else if( numero < 0 ) 
            throw new NegativeValueEnteredException();
        else{
            for(int i=0; i<=numero; i++){
                BigInteger resultado = null;
                resultado.equals(i);
            }
        }

        return null;
    }
    
    protected BigInteger getFatoria( int numero ) {
        return null;
    }
}
