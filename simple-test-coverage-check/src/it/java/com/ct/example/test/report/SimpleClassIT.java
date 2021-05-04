package com.ct.example.test.report;


import org.junit.jupiter.api.Test;

import com.ct.example.test.report.SimpleClass;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleClassIT {
    
    @Test
    void greetzIntegrationTest(){
    	SimpleClass coolClass = new SimpleClass(SimpleClass.TestType.INTEGRATION_TEST);
        String greetz = coolClass.greetz();
        
        assertTrue(greetz.contains("integration test"));
    }
}
