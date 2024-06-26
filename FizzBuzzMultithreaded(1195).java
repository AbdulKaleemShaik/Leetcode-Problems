import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;

    private Semaphore num;

    private Semaphore fizz;

    private Semaphore buzz;

    private Semaphore fizzbuzz;

    public FizzBuzz(int n) {
        this.n = n;
        num = new Semaphore(1);
        fizz = new Semaphore(0);
        buzz = new Semaphore(0);
        fizzbuzz = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                releaseSemaphore(i + 1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                buzz.acquire();
                printBuzz.run();
                releaseSemaphore(i + 1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                releaseSemaphore(i + 1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                num.acquire();
                printNumber.accept(i);
                releaseSemaphore(i + 1);
            }
        }
    }

    private void releaseSemaphore(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            fizzbuzz.release();
        } else if (value % 3 == 0) {
            fizz.release();
        } else if (value % 5 == 0) {
            buzz.release();
        } else {
            num.release();
        }
    }
}