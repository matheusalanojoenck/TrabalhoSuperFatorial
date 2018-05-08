/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exceptions.InputException;
import java.io.IOException;

/**
 *
 * @author udesc
 */
public class TesteDiscCache {
    private static SuperFatorialDiskCached superDisk;
    public static void main(String[] args) throws InputException, IOException{
        superDisk = new SuperFatorialDiskCached();
        superDisk.getFatorial(5);
        superDisk.getFatorial(7);
    }
    
}
