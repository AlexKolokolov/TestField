package org.kolokolov.logging.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kolokolov.logging.Messenger;

@RunWith(Parameterized.class)
public class MessengerTest {
    
    private static String resourceFileName = "resources/Messages";
   
    private Messenger messenger;
    private String expectegMessage;
    
    public MessengerTest(Messenger messenger, String expectegMessage) {
        this.messenger = messenger;
        this.expectegMessage = expectegMessage;
    }

    @Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
            {new Messenger(resourceFileName, Locale.US, 0), "Good night!"},
            {new Messenger(resourceFileName, Locale.US, 8), "Good morning!"},
            {new Messenger(resourceFileName, Locale.US, 12), "Good afternoon!"},
            {new Messenger(resourceFileName, Locale.US, 19), "Good evening!"},
            {new Messenger(resourceFileName, Locale.forLanguageTag("ru"), 0), "Спокойной ночи!"},
            {new Messenger(resourceFileName, Locale.forLanguageTag("ru"), 7), "Доброе утро!"},
            {new Messenger(resourceFileName, Locale.forLanguageTag("ru"), 11), "Добрый день!"},
            {new Messenger(resourceFileName, Locale.forLanguageTag("ru"), 20), "Добрый вечер!"},
            {new Messenger(resourceFileName, Locale.GERMAN, 0), "Good night!"},
            {new Messenger(resourceFileName, Locale.ITALY, 8), "Good morning!"},
            {new Messenger(resourceFileName, Locale.FRANCE, 12), "Good afternoon!"},
            {new Messenger(resourceFileName, Locale.CHINA, 19), "Good evening!"},
            {new Messenger("resources/WrongFile", Locale.US, 0), "Unable to get message!"}
        });
    }
    
    @Test
    public void testGetMessage() {
        Assert.assertEquals(expectegMessage, messenger.getMessage());
    }
}
