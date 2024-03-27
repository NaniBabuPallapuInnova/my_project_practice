package com.example;

import com.example.converter.Converter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar dsv-to-jsonl-converter.jar <input_file> <output_file>");
            System.exit(1);
        }

        String input1 = args[0];
        String input2 = args[1];

        try {
            Converter.convertDsvToJSONL(input1, input2);
            System.out.println("Conversion completed successfully.");

        } catch (Exception e) {
            System.err.println("An error occurred during conversion: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
