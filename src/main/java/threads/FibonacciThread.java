package threads;

import actions_with_file.WritingToFile;
import math.FibonacciByIndex;

public class FibonacciThread extends Thread {
    private Thread fibonacciThread;
    private FibonacciByIndex fibonacciByIndex;
    private int fibonacciIndex;
    private WritingToFile writingToFile;

    public FibonacciThread (WritingToFile writingToFile, int fibonacciIndex) {
        if(fibonacciThread!=null) fibonacciThread = new Thread();
        this.fibonacciByIndex = new FibonacciByIndex();
        this.fibonacciIndex = fibonacciIndex;
        this.writingToFile=writingToFile;
    }

    public Thread getThread() {
        return fibonacciThread;
    }
    @Override
    public void run(){
        writingToFile.writeToFile(fibonacciByIndex.getFibonacciByIndex(fibonacciIndex) );
    }
}

