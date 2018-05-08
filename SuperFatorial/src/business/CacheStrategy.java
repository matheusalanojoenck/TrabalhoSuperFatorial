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
 * @author matheus
 */
public abstract class CacheStrategy extends SuperFatorial{
    public abstract BigInteger getFatorialCache( int numero ) throws InputException;
    
}
