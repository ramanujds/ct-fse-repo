package com.ct.example.test.report;

/**
 * A cool class
 *
 */
public class SimpleClass {

    public enum TestType {

        UNIT_TEST,
        INTEGRATION_TEST
    }

    private TestType type;

    public SimpleClass(TestType type) {
        this.type = type;
    }

    public String greetz() {
        if (type.equals(TestType.UNIT_TEST)) {
            return "Hey ho, unit test";
        } else if (type.equals(TestType.INTEGRATION_TEST)) {
            return "Howdy, integration test";
        }
        return "Hello World";
    }

}
