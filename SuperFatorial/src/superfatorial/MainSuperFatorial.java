/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superfatorial;

import business.SuperFatorialCached;
import exceptions.InputException;

/**
 *
 * @author matheus
 */
public class MainSuperFatorial {   
    public static SuperFatorialCached superFatorial;
    public static AppSuperFatorial menu;
    
    public static void main(String[] args) throws InputException {
        //superFatorial = new SuperFatorialCached();
        //System.out.printf("%d \n", superFatorial.getSuperFatorial(30));
        menu = new AppSuperFatorial();
        menu.setVisible(true);
    }
}
