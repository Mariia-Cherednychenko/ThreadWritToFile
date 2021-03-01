package threads;

import actions_with_file.ReadingFromFile;
import actions_with_file.WritingToFile;

public class PhoneThread extends Thread {
    private Thread phoneThread;
    private ReadingFromFile readingFromFile;
    private String fileForRead;
    private WritingToFile writingToFile;


    public PhoneThread(String fileForRead, WritingToFile writingToFile) {
        if(phoneThread!=null) phoneThread = new Thread();
        this.readingFromFile = new ReadingFromFile();
        this.fileForRead = fileForRead;
        this.writingToFile=writingToFile;
    }

    public Thread getThread() {
        return phoneThread;
    }

    @Override
    public void run(){
        writingToFile.writeToFile(readingFromFile.getPhoneNumbersFromFile(fileForRead));
    }
}
