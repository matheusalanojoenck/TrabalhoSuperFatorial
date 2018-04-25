/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superfatorial;

import business.SuperFatorial;
import exceptions.InputException;

/**
 *
 * @author matheus
 */
public class AppSuperFatorial {   
    
    public static void main(String[] args) throws InputException {
        SuperFatorial superFatorial = new SuperFatorial();
        System.out.printf("%d \n", superFatorial.getSuperFatorial(-1));
    }
}
