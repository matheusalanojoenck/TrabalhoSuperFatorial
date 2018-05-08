/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public final class DiskCache {
    private FileChannel fileChannel;
    private final String fileName = "SuperFatorialDiskCached.txt";

        public DiskCache() {
            init();
        }
        
        public void init() {
            
            File arqCache = new File(fileName);
            if(!arqCache.exists()){
                try {
                    arqCache.createNewFile();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Falha ao criar o arquivo", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        public void store( int i, BigInteger value) {
            try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fileName, true))) {
                
                String linha = i + " , " + value;
                buffWrite.append(linha);
                buffWrite.newLine();
                buffWrite.flush();
                buffWrite.close();
                
            }catch(IOException e){
                System.out.println("falha store");
            }
        }
        
        public BigInteger read(int i) {
//            Path path = Paths.get(fileName);
//            try {
//                fileChannel = FileChannel.open(path);
//                fileChannel.position(i);
//                fileChannel.close();
//            } catch (IOException e) {
//            }
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                while(br.ready()){
                    String[] splited = br.readLine().split(" ");
                    if(splited[0].equals(Integer.toString(i))){
                        System.out.printf("0: %s | 1: %s | 2: %s%n", splited[0],splited[1],splited[2]);
                        return BigInteger.valueOf(Long.parseLong(splited[2]));
                    }
                }
            } catch (IOException e) {
                System.out.println("erro read");
            }
            return BigInteger.ONE;
        }

        public boolean containsKey(int numero) {
            return numero <= getSize(); 
        }

        public int getSize() {
            Path path = Paths.get(fileName);
            try {
                long lineCount = Files.lines(path).count();
                System.out.println("numero de linhas: "+lineCount);
                return (int) lineCount;
            } catch (IOException e) {
            }
            return -1;
        }    
}
