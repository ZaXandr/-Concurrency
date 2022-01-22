package com.zakharov.water;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {
    private static Semaphore hydrogenBarrier = new Semaphore(2);
    private static Semaphore oxygenBarrier = new Semaphore(1);
    private static CyclicBarrier waterBarrier = new CyclicBarrier(3);


    public static void releaseWater(String str) {

        char[] input = str.toCharArray();
        for (char val : input) {
            if (val == 'H') {
                new Hydrogen(hydrogenBarrier, waterBarrier).start();
            } else {
                new Oxygen(oxygenBarrier, waterBarrier).start();
            }
        }
    }


    public static void main(String[] args) {
        String str = "HHHHOO";
        Water.releaseWater(str);
    }
}





