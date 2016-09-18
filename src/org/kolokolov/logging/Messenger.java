package org.kolokolov.logging;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Messenger {
    
    private String resourceFileName;
    private int currentHour; 
    private Locale locale;
    
    private String loggerConfigFileName;
    
    private static final Logger logger = Logger.getLogger("Messenger logger");
    
    public Messenger() {
        this.resourceFileName = "resources/Messages";
        this.currentHour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        this.locale = Locale.getDefault();
        this.loggerConfigFileName = "/resources/logging.properties";
        configureLogger(this.loggerConfigFileName);
    }
    
    public Messenger(String resourceFileName, String loggerConfigFileName, Locale locale, int currentHour) {
        this.resourceFileName = resourceFileName;
        this.loggerConfigFileName = loggerConfigFileName;
        this.locale = locale;
        this.currentHour = currentHour;
        configureLogger(this.loggerConfigFileName);
    }

    private void configureLogger(String loggerConfigFileName) {
        try {
            LogManager.getLogManager().readConfiguration(Messenger.class.getResourceAsStream(loggerConfigFileName));
        } catch (Exception ex) {
            System.err.println("Unable to setup logging configuration");
            ex.printStackTrace();
        }
    }
    
    private ResourceBundle bundleToResource(String resourceFileName, Locale locale) {
        ResourceBundle resource = null;
        try {
            resource = ResourceBundle.getBundle(resourceFileName, locale);
            logger.log(Level.INFO, "Resource from {0} was successfuly bundled", resource.getBaseBundleName());
        } catch(MissingResourceException ex){
            logger.log(Level.WARNING, "Resource {0} was not found!", resourceFileName);
            return null;
        }
        return resource;
    }

    private TimeOfDay defineTimeOfDay(int hour) {
        if (hour > 21 || hour < 6)
            return TimeOfDay.NIGHT;
        if (hour > 6 && hour < 9)
            return TimeOfDay.MORNING;
        if (hour > 9 && hour < 18)
            return TimeOfDay.DAY;
        return TimeOfDay.EVENING;
    }

    public String getMessage() {
        logger.log(Level.INFO, "Locale: {0}", this.locale);
        ResourceBundle resource = bundleToResource(this.resourceFileName, this.locale);
        if (resource == null) return "Unable to get message!";
        TimeOfDay timeOfDay = defineTimeOfDay(this.currentHour);
        logger.log(Level.INFO, "Current hour: {0}, time of day: {1}", new Object[] {currentHour, timeOfDay});
        return resource.getString(timeOfDay.toString());
    }
    
    public void printCurrentTimeMessage() {
        System.out.println(getMessage());
    }
    
    public static void main(String[] args) {
        new Messenger().printCurrentTimeMessage();
    }
}
