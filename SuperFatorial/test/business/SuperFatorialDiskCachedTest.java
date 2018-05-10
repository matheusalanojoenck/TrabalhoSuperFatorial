/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exceptions.InputException;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author matheus
 */
public class SuperFatorialDiskCachedTest {
    SuperFatorialDiskCached superFatorialDisk;
    BigInteger bigInt;
    
    @Before
    public void setUp() {
        superFatorialDisk = new SuperFatorialDiskCached();
    }
    
    @Test
    public void testGetFatorialNEGATIVO() throws InputException {
        try {
            bigInt = superFatorialDisk.getFatorialCache(-1);
        } catch (InputException e) {
            assertEquals("Número negativo não possui fatorial", e.getMessage());
        }
    }
    
    @Test
    public void testGetFatorialZERO() throws InputException {
        assertEquals(BigInteger.ONE, superFatorialDisk.getFatorial(0));
    }

    @Test
    public void testGetFatorialUM() throws InputException {
        assertEquals(BigInteger.ONE, superFatorialDisk.getFatorial(1));
    }
    
    @Test
    public void testGetFatorialDEZ() throws InputException {
        bigInt = new BigInteger(superFatorialDisk.getFatorial(10).toString());
        assertEquals(bigInt, superFatorialDisk.getFatorial(10));
    }
    
    @Test
    public void testGetFatorialTRINTA() throws InputException {
        bigInt = new BigInteger(superFatorialDisk.getFatorial(30).toString());
        assertEquals(bigInt, superFatorialDisk.getFatorial(30));
    }
    
}
