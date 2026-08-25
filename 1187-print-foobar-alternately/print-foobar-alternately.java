class FooBar {
    private int n;
    private int state = 1;
    Lock lock = new ReentrantLock();
    Condition fooDone = lock.newCondition();
    Condition barDone = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try{
            for (int i = 0; i < n; i++) {
                while(state!=1){
                    barDone.await();
                }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
                
        	    printFoo.run();
                state = 2;
                fooDone.signal();

            }
        }finally{
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        lock.lock();
        try{
            for (int i = 0; i < n; i++) {
                while(state!=2){
                    fooDone.await();
                }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
                
        	    printBar.run();
                state = 1;
                barDone.signal();

            }
        }finally{
            lock.unlock();
        }
    }
}