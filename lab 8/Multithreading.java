class A extends Thread {
    private final Object lock;

    A(Object lock) {
        this.lock = lock;
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            if (i == 1) Thread.yield(); 
            synchronized (lock) {  
                System.out.println("\nFrom thread A: i = " + i);
            }
        }
        System.out.println("Exit from A");
    }
}

class B extends Thread {
    private final Object lock;

    B(Object lock) {
        this.lock = lock;
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            if (i == 1) Thread.yield(); 
            synchronized (lock) {  
                System.out.println("\nFrom thread B: i = " + i);
            }
        }
        System.out.println("Exit from B");
    }
}

class C extends Thread {
    public void run() {
        for (int k = 0; k <= 5; k++) {
            System.out.println("\nFrom thread C: k = " + k);
            if (k == 1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("After Exception: " + e);
                }
            }
        }
        System.out.println("Exit from C");
    }
}

public class Multithreading {
    public static void main(String[] args) {
        Object lock = new Object();

        A threadA = new A(lock);
        B threadB = new B(lock);
        C threadC = new C();

        threadA.start(); 
        threadB.start();  
        threadC.start();  
    }
}
