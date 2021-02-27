package threads;

import actions_with_file.WritingToFile;
import math.FibonacciByIndex;

public class FibonacciThread extends Thread {
    private Thread fibonacciThread;
    private String file;
    private FibonacciByIndex fibonacciByIndex;
    private int fibonacciIndex;

    public FibonacciThread(String file, int fibonacciIndex) {
        if(fibonacciThread!=null) fibonacciThread = new Thread();
        this.file = file;
        this.fibonacciByIndex = new FibonacciByIndex();
        this.fibonacciIndex = fibonacciIndex;
    }

    public Thread getThread() {
        return fibonacciThread;
    }
    @Override
    public void run(){
        new WritingToFile().writeToFile(file,fibonacciByIndex.getFibonacciByIndex(fibonacciIndex) );
    }
}

