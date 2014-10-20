package com.epam.heap;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Ivan_Spresov
 * Date: 3/3/14
 */
public class MemoryEaterFixed {
    static final Logger logger = Logger.getLogger(MemoryEater.class);

    public static void main(String[] args) {
        
        Set<byte[]> v = new HashSet<byte[]>();
        byte b[] = new byte[1048576];
        
        while (true) {

            v.add(b);
            Runtime rt = Runtime.getRuntime();

            System.out.println("free memory: " + rt.freeMemory());
            /*try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }*/
        }
    }
}