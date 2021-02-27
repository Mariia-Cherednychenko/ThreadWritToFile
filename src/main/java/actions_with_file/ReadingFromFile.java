package actions_with_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadingFromFile {

    public String getSumOfNumbersFromFile(String file, int index) {
        List <Integer> array = new ArrayList<>();
        Integer sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split("[\\D]+");

                for (String s : lineArray) {
                    try {
                        Integer number = Integer.valueOf(s);
                        if (array.size() < index) {
                            array.add(number);
                            sum = sum + number;
                        }
                    }
                    catch (Exception e){

                    }
                }
            }
        } catch (IOException e) {e.printStackTrace();}
        return String.format("сумма: %s",sum);

    }

    public  String getPhoneNumbersFromFile(String file) {
        List<String> array = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.replaceAll("[\\s\\+\\-\\(\\),]+", "")
                        .replaceAll("[\\D]+", " ")
                        .split(" ");
                Pattern pattern =Pattern.compile("0\\d{9}");
                Matcher matcher;
                for (int i=0; i<lineArray.length; i++){
                   matcher = pattern.matcher(lineArray[i]);
                   if(matcher.find()) {
                       array.add(String.format("+38%s",lineArray[i]));
                   }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("номера: %s",array);

    }



}
