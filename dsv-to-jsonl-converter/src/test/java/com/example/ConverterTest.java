package com.example;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ConverterTest {

    @Test
    public void testConversionInput1() throws IOException {
//        String inputFile = "input1.txt";
        String inputFile = "src//main//resources//input1.txt";
//        String outputFile = "output_test1.jsonl";
        String outputFile = "src//main//resources//output_test1.jsonl";

        Converter.convertDSVtoJsonl(inputFile, outputFile, ",");

        assertTrue(Files.exists(Path.of(outputFile)));

        String expected = Files.readString(Path.of("src/main/resources/output.jsonl"));
        String actual = Files.readString(Path.of(outputFile));

        assertEquals(expected, actual);

        Files.deleteIfExists(Path.of(outputFile));
    }
/*
    @Test
    public void testConversionInput2() throws IOException {
        String inputFile = "input2.txt";
        String outputFile = "output_test2.jsonl";

        Converter.convertDSVtoJsonl(inputFile, outputFile, "\\|");

        assertTrue(Files.exists(Path.of(outputFile)));

        String expected = Files.readString(Path.of("output.jsonl"));
        String actual = Files.readString(Path.of(outputFile));

        assertEquals(expected, actual);

        Files.deleteIfExists(Path.of(outputFile));
    }*/
}