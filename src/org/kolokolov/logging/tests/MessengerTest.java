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
    
    private String resourceFileName;
    private Locale locale;
    private int hour;
    private String expectegMessage;
    
    public MessengerTest(String resourceFileName, Locale locale, int hour, String expectegMessage) {
        this.resourceFileName = resourceFileName;
        this.locale = locale;
        this.hour = hour;
        this.expectegMessage = expectegMessage;
    }

    @Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
            {"resources/Messages", Locale.US, 0, "Good night!"},
            {"resources/Messages", Locale.US, 8, "Good morning!"},
            {"resources/Messages", Locale.US, 12, "Good afternoon!"},
            {"resources/Messages", Locale.US, 19, "Good evening!"},
            {"resources/Messages", Locale.forLanguageTag("ru"), 0, "Спокойной ночи!"},
            {"resources/Messages", Locale.forLanguageTag("ru"), 7, "Доброе утро!"},
            {"resources/Messages", Locale.forLanguageTag("ru"), 11, "Добрый день!"},
            {"resources/Messages", Locale.forLanguageTag("ru"), 20, "Добрый вечер!"},
            {"resources/Messages", Locale.GERMAN, 0, "Good night!"},
            {"resources/Messages", Locale.ITALY, 8, "Good morning!"},
            {"resources/Messages", Locale.FRANCE, 12, "Good afternoon!"},
            {"resources/Messages", Locale.CHINA, 19, "Good evening!"},
            {"resources/WrongFile", Locale.US, 0, "Unable to get message!"}
        });
    }
    
    @Test
    public void testGetMessage() {
        Assert.assertEquals(expectegMessage, new Messenger().getMessage(resourceFileName, locale, hour));
    }
}
