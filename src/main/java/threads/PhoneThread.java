package threads;

import actions_with_file.ReadingFromFile;
import actions_with_file.WritingToFile;

public class PhoneThread extends Thread {
    private Thread phoneThread;
    private ReadingFromFile readingFromFile;
    private String fileForRead;
    private String fileForWrite;


    public PhoneThread(String fileForRead, String fileForWrite) {
        if(phoneThread!=null) phoneThread = new Thread();
        this.readingFromFile = new ReadingFromFile();
        this.fileForRead = fileForRead;
        this.fileForWrite = fileForWrite;
    }

    public Thread getThread() {
        return phoneThread;
    }

    @Override
    public void run(){
        new WritingToFile().writeToFile(fileForWrite,readingFromFile.getPhoneNumbersFromFile(fileForRead));
    }
}
