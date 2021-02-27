package math;

import java.util.LinkedList;

public class FibonacciByIndex {
    private LinkedList<Integer> fibonacciArray = new LinkedList();

    public String getFibonacciByIndex(int index){
        fillFibonacciArray(index);
        return String.format("фибоначи: %s",fibonacciArray.getLast());
    }

    private void fillFibonacciArray (int index){
        fibonacciArray.add(0);
        fibonacciArray.add(1);
        for (int i = 2; i <index+1 ; i++) {
            fibonacciArray.add(fibonacciArray.get(i-2)+fibonacciArray.get(i-1));
        }
    }


}
