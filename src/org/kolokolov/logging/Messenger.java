package org.kolokolov.logging;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Messenger {
    
    private String resourceFileName;
    private int currentHour; 
    private Locale locale;

    private static final Logger logger = LogManager.getLogger(Messenger.class);
    
    public Messenger() {
        this.resourceFileName = "resources/Messages";
        this.currentHour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        this.locale = Locale.getDefault();
    }
    
    public Messenger(String resourceFileName, Locale locale, int currentHour) {
        this.resourceFileName = resourceFileName;
        this.locale = locale;
        this.currentHour = currentHour;
    }
    
    private ResourceBundle bundleToResource(String resourceFileName, Locale locale) {
        ResourceBundle resource = null;
        try {
            resource = ResourceBundle.getBundle(resourceFileName, locale);
            logger.trace("Resource from {} was successfuly bundled", resource.getBaseBundleName());
        } catch(MissingResourceException ex){
            logger.error("Resource {} was not found!", resourceFileName);
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
        logger.trace("=======================================");
        logger.trace("Locale: {}", this.locale);
        ResourceBundle resource = bundleToResource(this.resourceFileName, this.locale);
        if (resource == null) return "Unable to get message!";
        TimeOfDay timeOfDay = defineTimeOfDay(this.currentHour);
        logger.trace("Current hour: {}, time of day: {}", this.currentHour, timeOfDay);
        String message = resource.getString(timeOfDay.toString());
        logger.trace("Message: {}", message);
        return message;
    }
    
    public void printCurrentTimeMessage() {
        System.out.println(getMessage());
    }
    
    public static void main(String[] args) {
        new Messenger().printCurrentTimeMessage();
    }
}
