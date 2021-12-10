package hw_1;

import java.util.concurrent.BrokenBarrierException;

import java.util.concurrent.CyclicBarrier;

public class Water {


    public static void main(String[] args) {
        var waterBarrier = new CyclicBarrier(3);

        new HydrogenThread(waterBarrier).start();
        new HydrogenThread(waterBarrier).start();
        new OxygenThread(waterBarrier).start();

// "HOH","HHO", "OHH"
    }
}

class HydrogenThread extends Thread {
    private CyclicBarrier cyclicBarrier;

    public HydrogenThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void releaseHydrogen() {
        System.out.print("H");
    }

    @Override
    public void run() {
        while(true) {

            {
                try {
                    cyclicBarrier.await();
                    releaseHydrogen();
                  //  Thread.sleep(1000);
                    int await = cyclicBarrier.await();
                    if (await == 0) {
                        System.out.println();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class OxygenThread extends Thread {
    private CyclicBarrier cyclicBarrier;

    public void releaseOxygen() {
        System.out.print("O");
    }

    public OxygenThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        while(true) {

            {
                try {
                    cyclicBarrier.await();
                    releaseOxygen();
                 //   Thread.sleep(100);
                    if (cyclicBarrier.await() == 0) {
                        System.out.println();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



