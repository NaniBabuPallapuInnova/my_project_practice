package com.example.converter;

import org.testng.annotations.Test;

import java.io.IOException;

import static junit.framework.Assert.fail;

public class ConverterTest {
    @Test
    void testConversion() {
        String inputFile = "src/test/resources/DSV-INPUT1.csv";
        String outputFile = "src/test/resources/output.jsonl";

        try {
            Converter.convertDsvToJSONL(inputFile, outputFile);
        } catch (IOException e) {
            fail("Conversion failed: " + e.getMessage());
        }

        // Add assertions to check the content of the output file if needed
        // You can read the output file and compare its content with expected content
    }
}
