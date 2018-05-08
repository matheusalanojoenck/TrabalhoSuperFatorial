/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import exceptions.*;
import java.math.BigInteger;

/**
 * Antes de calcular o fatorial busca no cache
 * @author udesc
 */
public class SuperFatorialDiskCached extends SuperFatorial{
    
    private final DiskCache cache = new DiskCache();

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
        } else if(cache.containsKey(numero)){
            System.out.println("encontrou em contanisKey\n");
            return cache.read(numero);
        }else{
            for(int i=cache.getSize()+1; i<=numero;i++){
                System.out.printf("adicionando sf(%d) ao txt%n",i);
                cache.store(i, super.getSuperFatorial(i));
            }
            return cache.read(numero);
        }
    }
    
    /**
     *
     * @return
     */
    public DiskCache getCache(){
        return cache;
    }
}
