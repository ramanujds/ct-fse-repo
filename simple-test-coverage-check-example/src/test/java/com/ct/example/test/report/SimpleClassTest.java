package com.ct.example.test.report;


import org.junit.jupiter.api.Test;

import com.ct.example.test.report.SimpleClass;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for a cool class
 */
public class SimpleClassTest {
    
    @Test
    void greetzUnitTest(){
    	SimpleClass coolClass = new SimpleClass(SimpleClass.TestType.UNIT_TEST);
        String greetz = coolClass.greetz();
        
        assertTrue(greetz.contains("unit test"));
    }

}
