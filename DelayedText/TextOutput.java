import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class TextOutput {
    static String filePath = System.getProperty("user.dir") + File.separator;
    static ArrayList<String> output = FileConverter(/*filePath + */"input.txt");
    static ArrayList<Integer> delays = DelayConverter(/*filePath + */"delay.txt");

    public static void main(String[] args) {
        clear();
        fileOutput(output);
        delay(delays.get(5));
    } 

    //Copies the contents of input.txt in an ArrayList
    static ArrayList<String> FileConverter(String fileName) {
        ArrayList<String> fileContents = new ArrayList<String>();

        try {
            //Can't remember the exact reason why I chose BufferedReader out of all the other choices.
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            while((line = reader.readLine()) != null) {
                fileContents.add(line);
            }
            reader.close();
            
        } 

        //General exception because I don't need the file not found exception or whatever it's called.
        catch (Exception fileNotFoundException) {
            System.out.println("Enter a file.");
            System.exit(0);
        }
        return fileContents;
    } 

    static ArrayList<Integer> DelayConverter(String delayName) {
        
        //This is here so the program still has values to use for delays if the user doesn't provide them in the delay.txt file
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
        
        //Gets the user defined values if they exist
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

        //Catch is empty because it doesn't need to do anything
        catch (Exception exception) {}
        return delayContents;
    }

    static void clear() {
        //Still have no idea how this works.
        System.out.print("\033[H\033[2J");
        System.out.flush();
        delay(delays.get(0));
    }

    //Thread.sleep() says I should wrap it in a try catch so that's why this function exists - does everything together in the way it should!
    static void delay(int lineDelayInMillis) {
        try {
            Thread.sleep(lineDelayInMillis);
        } 
        catch (Exception General) {
            Thread.currentThread().interrupt();
        }
    }

    /* Simple array printer
       Didn't really need to create a function for it but hey whatever */
    static void fileOutput(ArrayList<String> fileOutputArray) {
        for (int i = 0; i < fileOutputArray.size(); i++) {
            output(fileOutputArray.get(i));
        }
    }

    /* Arguably the most important function for this program and the 
       Prints each line in the array (i.e. each line in the text) individually; thought it'd be more reusable that way. */
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
