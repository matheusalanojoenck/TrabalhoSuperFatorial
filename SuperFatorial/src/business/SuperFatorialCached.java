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
import java.util.HashMap;

/**
 * Antes de calcular o fatorial busca no cache
 * @author udesc
 */
public class SuperFatorialCached extends SuperFatorial{
    private static final HashMap<Integer,BigInteger> cache = new HashMap();

    /**
     *
     * @param numero
     * @return
     * @throws exceptions.InputException
     */
    public BigInteger getFatorial( int numero ) throws InputException{
        if( numero == 0 ){
            throw new ZeroEnteredException();
        } else if( numero < 0 ){
            throw new NegativeValueEnteredException();  
        } else if(cache.containsKey(numero)){
            return cache.get(numero);
        }else{
            for(int i=cache.size()+1; i<=numero;i++){
                cache.put(i, super.getSuperFatorial(i));
            }
            return cache.get(numero);
        }
    }

    public HashMap<Integer, BigInteger> getCache() {
        return cache;
    }
}
