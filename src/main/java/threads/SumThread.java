package threads;

import actions_with_file.ReadingFromFile;
import actions_with_file.WritingToFile;

public class SumThread extends Thread {
    private Thread sumThread;
    private ReadingFromFile readingFromFile;
    private String fileForRead;
    private WritingToFile writingToFile;
    private int index;

    public SumThread(String fileForRead, WritingToFile writingToFile, int index) {
        if(sumThread!=null) sumThread = new Thread();
        readingFromFile = new ReadingFromFile();
        this.fileForRead = fileForRead;
      this.writingToFile =writingToFile;
        this.index = index;
    }

    public Thread getSumThread() {
        return sumThread;
    }

    @Override
    public void run(){
        writingToFile.writeToFile(readingFromFile.getSumOfNumbersFromFile(fileForRead,index));
    }
}
