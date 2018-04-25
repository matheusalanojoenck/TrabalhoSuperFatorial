/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Antes de calcular o fatorial busca no cache
 * @author udesc
 */
public class SuperFatorialCached extends SuperFatorial{
    private HashMap<Integer,BigInteger> cache = new HashMap();
    protected BigInteger getFatoria( int numero ) {
        // procura no cache primeiro se existir retorna o valor
        // se nao existir calcula e adiciona no cache
        return null;
    }
}
