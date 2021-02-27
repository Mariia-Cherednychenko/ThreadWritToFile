import threads.FibonacciThread;
import threads.PhoneThread;
import threads.SumThread;

public class Main {
    public static void main(String[] args) {
        String readingDigitsFile = "numbers.txt";
        String readingPhoneNumbersFile = "test.txt";
        String writingIntoFile ="out.txt";
        int sumIndex = 10;
        int fibonacciIndex = 15;

        FibonacciThread fibonacciThread = new FibonacciThread(writingIntoFile,fibonacciIndex);
        SumThread sumThread = new SumThread(readingDigitsFile,writingIntoFile,sumIndex);
        PhoneThread phoneThread = new PhoneThread(readingPhoneNumbersFile,writingIntoFile);

        fibonacciThread.start();
        sumThread.start();
        phoneThread.start();

        try {
            fibonacciThread.join();
            sumThread.join();
            phoneThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все операции завершены");

    }
}
