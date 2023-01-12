import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class TextOutput {
    static String filePath = System.getProperty("user.dir") + File.separator;
    static ArrayList<String> output = FileConverter(filePath + "input.txt");
    static ArrayList<Integer> delays = DelayConverter(filePath + "delay.txt");

    public static void main(String[] args) {
        clear();
        fileOutput(output);
        delay(delays.get(5));
    } 

    static ArrayList<String> FileConverter(String fileName) {
        ArrayList<String> fileContents = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            while((line = reader.readLine()) != null) {
                fileContents.add(line);
            }
            reader.close();
            
        } 

        catch (Exception exception) {
            System.out.println("Enter a file.");
            System.exit(0);
        }
        return fileContents;
    } 

    static ArrayList<Integer> DelayConverter(String delayName) {
        ArrayList<Integer> delayContents = new ArrayList<Integer>();
        //0
        delayContents.add(2000);
        //1
        delayContents.add(225);
        //2
        delayContents.add(175);
        //3
        delayContents.add(125);
        //4
        delayContents.add(325);
        //5
        delayContents.add(10000);
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(delayName));

            String line;
            for(int i = 0; ((line = reader.readLine()) != null) && delayContents.size() <= 6;) {
                try {
                    delayContents.set(i, Integer.parseInt(line));
                    i++;
                }
                catch (Exception exception) {}
            }
            reader.close();
        } 

        catch (Exception exception) {}
        return delayContents;
    }

    static void clear() {
        //Still have no idea how this works.
        System.out.print("\033[H\033[2J");
        System.out.flush();
        delay(delays.get(0));
    }

    static void delay(int lineDelayInMillis) {
        try {
            Thread.sleep(lineDelayInMillis);
        } 
        catch (Exception General) {
            Thread.currentThread().interrupt();
        }
    }

    static void fileOutput(ArrayList<String> fileOutputArray) {
        for (int i = 0; i < fileOutputArray.size(); i++) {
            output(fileOutputArray.get(i));
        }
    }

    static void output(String message) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i)); 
            if (i != message.length() - 1) {
                if ((message.charAt(i) == '.') || (message.charAt(i) == '!') || (message.charAt(i) == '?')) {
                    delay(delays.get(1));
                }
                else if ((message.charAt(i) == ',') || (message.charAt(i) == ';')) {
                    delay(delays.get(2));
                }

                if (message.charAt(i) != ' ') {
                    delay(delays.get(3));
                }  
            }        
        } 
        //I think it looks better with this
        delay(delays.get(4));
        System.out.println();
    }
}