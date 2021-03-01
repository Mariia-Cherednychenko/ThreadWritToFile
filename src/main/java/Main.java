import actions_with_file.WritingToFile;
import threads.FibonacciThread;
import threads.PhoneThread;
import threads.SumThread;

public class Main {
    public static void main(String[] args) {
        String readingDigitsFile = "numbers.txt";
        String readingPhoneNumbersFile = "test.txt";
       String writingIntoFile = "out.txt";
        int sumIndex = 10;
        int fibonacciIndex = 15;
        WritingToFile writingToFile = new WritingToFile(writingIntoFile);

        FibonacciThread fibonacciThread = new FibonacciThread(writingToFile,fibonacciIndex);
        SumThread sumThread = new SumThread(readingDigitsFile,writingToFile,sumIndex);
        PhoneThread phoneThread = new PhoneThread(readingPhoneNumbersFile,writingToFile);

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
