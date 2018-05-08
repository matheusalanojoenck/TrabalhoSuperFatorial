/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exceptions.InputException;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matheus
 */
public class SuperFatorialCachedTest {
    
    SuperFatorialCached superFatorial;
    BigInteger bigInt;
    
    @Before
    public void setUp() {
        superFatorial = new SuperFatorialCached();
    }
    
    @Test
    public void testGetFatorialNEGATIVO() throws InputException {
        try {
            assertEquals(null, superFatorial.getFatorialCache(-1));
        } catch (InputException e) {
        }
    }
    
    @Test
    public void testGetFatorialZERO() throws InputException {
        assertEquals(BigInteger.ONE, superFatorial.getFatorial(0));
    }

    @Test
    public void testGetFatorialUM() throws InputException {
        assertEquals(BigInteger.ONE, superFatorial.getFatorial(1));
    }
    
    @Test
    public void testGetFatorialDEZ() throws InputException {
        bigInt = new BigInteger(superFatorial.getFatorial(10).toString());
        assertEquals(bigInt, superFatorial.getFatorial(10));
    }
    
    @Test
    public void testGetFatorialTRINTA() throws InputException {
        bigInt = new BigInteger(superFatorial.getFatorial(30).toString());
        assertEquals(bigInt, superFatorial.getFatorial(30));
    }
    
}
