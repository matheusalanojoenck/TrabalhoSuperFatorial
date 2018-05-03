/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import exceptions.InputException;
import exceptions.NegativeValueEnteredException;
import exceptions.ZeroEnteredException;
import java.io.File;
import java.math.BigInteger;
import java.nio.channels.FileChannel;

/**
 * Antes de calcular o fatorial busca no cache
 * @author udesc
 */
public class SuperFatorialDiskCached extends SuperFatorial{
    
    /**
     * Controla o cache em disco
     */
    class DiskCache {
        File arqCache = new File("SuperFatorialDiskCached.txt");
        FileChannel channelCache;
        
        public DiskCache() {
            init();
        }
        
        public void init() {
            if(!arqCache.exists()){
                
            }
            
        }
        
        public void store( int i, BigInteger value) {
            
        }
        
        public BigInteger read( int i ) {
            return BigInteger.ONE;
        }

        private boolean containsKey(int numero) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private int size() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    private final DiskCache cache = new DiskCache();

    /**
     *
     * @param numero
     * @return
     * @throws exceptions.InputException
     */
    public BigInteger getFatorial( int numero ) throws InputException{
        if( numero == 0 ){
            cache.store(0, BigInteger.ONE);
            return BigInteger.ONE;
        } else if( numero < 0 ){
            throw new NegativeValueEnteredException();  
        } else if(cache.containsKey(numero)){
            return cache.read(numero);
        }else{
            for(int i=cache.size()+1; i<=numero;i++){
                cache.store(i, super.getSuperFatorial(i));
            }
            return cache.read(numero);
        }
    }

}
