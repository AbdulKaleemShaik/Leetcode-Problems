import java.util.concurrent.Semaphore;

class Foo {
    volatile int i = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        i = 1;

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (i != 1)
            ;
        printSecond.run();
        i = 2;

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (i != 2)
            ;
        printThird.run();

    }
}

class Fooo {

    Semaphore one;
    Semaphore two;
    Semaphore three;

    public Fooo() {
        this.one = new Semaphore(1);
        this.two = new Semaphore(0);
        this.three = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        one.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        one.release();
    }
}