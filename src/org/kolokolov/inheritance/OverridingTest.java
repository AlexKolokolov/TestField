package org.kolokolov.inheritance;

import java.io.FileNotFoundException;

public abstract class OverridingTest {
    
    abstract Number sum(Integer a, Integer b) throws Exception;

}

class Inheritor extends OverridingTest {
    @Override
    public Integer sum(Integer aa, Integer bb) throws ClassCastException, FileNotFoundException {
        return aa + bb;
    }
}
