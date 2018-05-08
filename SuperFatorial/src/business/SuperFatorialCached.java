/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import exceptions.*;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Antes de calcular o fatorial busca no CACHE
 * @author udesc
 */
public class SuperFatorialCached extends SuperFatorial{
    private static final HashMap<Integer,BigInteger> CACHE = new HashMap();

    /**
     *
     * @param numero
     * @return
     * @throws exceptions.InputException
     */
    public BigInteger getFatorialCache( int numero ) throws InputException{
        if(numero == 0) {
            return BigInteger.ONE;
        }else if( numero < 0 ){
            throw new NegativeValueEnteredException();  
        } else if(CACHE.containsKey(numero)){
            return CACHE.get(numero);
        }else{
            for(int i=CACHE.size()+1; i<=numero;i++){
                CACHE.put(i, super.getSuperFatorial(i));
            }
            return CACHE.get(numero);
        }
    }

    public HashMap<Integer, BigInteger> getCache() {
        return CACHE;
    }
}
