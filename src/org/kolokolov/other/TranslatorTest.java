package org.kolokolov.other;

import com.gtranslate.Language;
import com.gtranslate.Translator;

//Doesn't work. Http code 403 - forbidden
public class TranslatorTest {
    public static void main(String[] args) {
        Translator translator = Translator.getInstance();
        String text = "book";
        
        String translation = translator.translate(text, Language.ENGLISH, Language.RUSSIAN);
        System.out.println(translation);
    }

}
