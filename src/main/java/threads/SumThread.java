package threads;

import actions_with_file.ReadingFromFile;
import actions_with_file.WritingToFile;

public class SumThread extends Thread {
    private Thread sumThread;
    private ReadingFromFile readingFromFile;
    private String fileForRead;
    private String fileForWrite;
    private int index;

    public SumThread(String fileForRead, String fileForWrite, int index) {
        if(sumThread!=null) sumThread = new Thread();
        readingFromFile = new ReadingFromFile();
        this.fileForRead = fileForRead;
        this.fileForWrite = fileForWrite;
        this.index = index;
    }

    public Thread getSumThread() {
        return sumThread;
    }

    @Override
    public void run(){
        new WritingToFile().writeToFile(fileForWrite,readingFromFile.getSumOfNumbersFromFile(fileForRead,index));
    }
}
