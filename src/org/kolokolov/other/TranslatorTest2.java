package org.kolokolov.other;

import java.util.Locale;

import com.javanetworkframework.rb.com.altavista.AltaVistaTranslatorRB;
import com.javanetworkframework.rb.com.freetranslation.FreeTranslationTranslatorRB;
import com.javanetworkframework.rb.com.google.GoogleTranslatorRB;
import com.javanetworkframework.rb.com.worldlingo.WorldLingoRB;
import com.javanetworkframework.rb.tester.AltaVistaTranslatorTester;

//Doesn't work
public class TranslatorTest2 {
    public static void main(String[] args) {
       AltaVistaTranslatorTester.main(new String[] {"book"});
    }

}
