package org.kolokolov.unittests;

import org.junit.Test;

import org.junit.Assert;

public class TestJUnit {
    
    @Test
    public void testJUnit() {
        String str = "JUnit is working fine";
        Assert.assertEquals("JUnit is working fine", str);
    }
}
