package com.zakharov.water;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread {

    private  Semaphore hydrogenBarrier;
    private  CyclicBarrier moleculeBarrier;


    public Hydrogen(Semaphore  hydrogenBarrier,CyclicBarrier moleculeBarrier) {
        this.hydrogenBarrier= hydrogenBarrier;
        this.moleculeBarrier=moleculeBarrier;
    }



    public void releaseHydrogen() {
        System.out.print("H");
    }


    @Override
    public void run() {
        try {
            hydrogenBarrier.acquire();
            moleculeBarrier.await();
            releaseHydrogen();
            hydrogenBarrier.release();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}