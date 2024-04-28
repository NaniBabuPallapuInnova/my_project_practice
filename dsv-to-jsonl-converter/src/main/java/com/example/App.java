package com.example;

import java.io.*;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Main class for converting DSV (Delimiter Separated Values) to JSONL (JSON Lines) format.
 */

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java -jar dsv-to-jsonl-converter.jar <inputFile> <outputFile> <delimiter>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        String delimiter = args[2];

        try {
            Converter.convertDSVtoJsonl(inputFile, outputFile, delimiter);
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
