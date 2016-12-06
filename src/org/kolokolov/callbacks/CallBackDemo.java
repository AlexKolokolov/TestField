package org.kolokolov.callbacks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class CallBackDemo {
    public static void main(String[] args) {
        Timer logTimer = new Timer();
        Timer timeDisplayTimer = new Timer();
        Timer yetAnotherTimer = new Timer();
        
        String eventMsg = "Alarm!";
        
        logTimer.logOnTimer(5, 3, () -> System.out.println("Its time for logging: " + eventMsg));
        
        
        timeDisplayTimer.logOnTimer(7, 2, () -> {
            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, 
                    DateFormat.MEDIUM, Locale.US);
            Date currentDateAndTime = new Date();
            String msg = "Current time: " + dateFormat.format(currentDateAndTime);
            writeMessageToFile("./logs/callback.log", msg);
            System.out.println(msg);
        });
        
        Logger logger = () -> System.out.println("Yet another log");
        
        yetAnotherTimer.logOnTimer(4, 1, logger);

        System.out.println("Main thread is over!!!");
    }
    
    private static void writeMessageToFile(String filename, String msg) {
        File file = new File(filename);
        try (FileWriter fileWriter = new FileWriter(file, true);
                PrintWriter writer = new PrintWriter(fileWriter, true)) {
            writer.println(msg);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
    }
}
