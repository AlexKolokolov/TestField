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
    
    private int currentHour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY); 
    private Locale locale = Locale.getDefault();
    private String resourceFileName = "resources/Messages";
    
    private static final Logger logger = Logger.getLogger("Messenger logger");
    
    
    
    public Messenger() {
        try {
            LogManager.getLogManager().readConfiguration(Messenger.class.getResourceAsStream("/resources/logging.properties"));
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

    public String getMessage(String resourceFileName, Locale locale, int hour) {
        logger.log(Level.INFO, "Locale: {0}", locale);
        ResourceBundle resource = bundleToResource(resourceFileName, locale);
        if (resource == null) return "Unable to get message!";
        TimeOfDay timeOfDay = defineTimeOfDay(hour);
        logger.log(Level.INFO, "Current hour: {0}, time of day: {1}", new Object[] {hour, timeOfDay});
        return resource.getString(timeOfDay.toString());
    }
    
    public void printCurrentTimeMessage() {
        System.out.println(getMessage(this.resourceFileName, this.locale, this.currentHour));
    }
    
    public static void main(String[] args) {
        new Messenger().printCurrentTimeMessage();
    }
}
