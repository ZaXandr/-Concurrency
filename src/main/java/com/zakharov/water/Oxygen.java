package com.zakharov.water;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Oxygen extends Thread {

    private  Semaphore oxygenBarrier;
    private  CyclicBarrier moleculeBarrier;


    public Oxygen(Semaphore oxygenBarrier, CyclicBarrier moleculeBarrier) {
        this.oxygenBarrier = oxygenBarrier;
        this.moleculeBarrier = moleculeBarrier;

    }

    public void releaseOxygen() {
        System.out.print("O");
    }


    @Override
    public void run() {
        try {
            oxygenBarrier.acquire();
            moleculeBarrier.await();
            releaseOxygen();
            oxygenBarrier.release();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}