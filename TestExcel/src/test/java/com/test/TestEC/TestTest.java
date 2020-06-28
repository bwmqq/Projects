package com.test.TestEC;

import org.testng.annotations.Test;

public class TestTest {
    @Test
    public void test() {
        String a = "fshdkjf";
        String[] split = a.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
